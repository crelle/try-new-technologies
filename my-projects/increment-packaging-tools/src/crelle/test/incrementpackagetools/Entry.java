package crelle.test.incrementpackagetools;

import crelle.test.incrementpackagetools.common.Utils;
import crelle.test.incrementpackagetools.dto.PathPrefix;
import org.apache.commons.net.ftp.FTPClient;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class  Entry{

    private String[] arges;
    //带打包文件数量
    private int fabuFileNum;
    //打包成功个数
    private int packageSuccessNum;
    //回滚包成功个数
    private int rollBackpackageSuccessNum;

    public Entry(String[] arges) throws IOException,Exception{
        this.arges = arges;
        start();
    }

    private void start() throws IOException,Exception {
        PathPrefix pathPrefix = new PathPrefix();
        //获取打包文件列表
        String[] paths =  getPaths(arges[0]);
        //日志打印
        printFabuFile(paths);
        //构建打包文件信息
        List<Map<String,String>> pathsList =  getPathLists(pathPrefix, paths);
        //打包
        System.out.println("#####################################正式包#######################################");
        buildFabuFiles(pathsList,pathPrefix);
        System.out.println("#####################################回滚包#######################################");
        buildRollBackFiles(pathsList,pathPrefix);
        System.out.println("#####################################结果#######################################");
        System.out.println("本次待打包文件数量为："+fabuFileNum);
        System.out.println("打包完成数量为："+packageSuccessNum);
        System.out.println("回滚包完成数量为："+rollBackpackageSuccessNum);
        if(fabuFileNum == packageSuccessNum && fabuFileNum== rollBackpackageSuccessNum){
            System.out.println("打包成功！");
        }else{
            System.out.println("打包失败！");
        }

    }

    private void printFabuFile(String[] lists){
        if(null!=lists && lists.length>=1){
            this.fabuFileNum = lists.length;
            System.out.println("以下"+lists.length+"个文件需要打包:");
            for (int i = 0; i < lists.length; i++)  {
                System.out.println(i+1+":"+lists[i]);
            }
        }
    }

    /**
     * 获取要发布的文件列表
     * @param pathPrefix
     * @param paths
     * @return
     */
    private List<Map<String,String>> getPathLists(PathPrefix pathPrefix, String[] paths) {
        List<Map<String,String>> pathsList = new ArrayList<Map<String,String>>();
        String localClassPath = pathPrefix.getLocalClassPath();
        String localWebPath = pathPrefix.getLocalWebPath();
        for (String path :  paths) {
            Map<String,String> map = new HashMap<String,String>();
            if(path.contains(localClassPath)){
                map.put(localClassPath,path.replace(localClassPath,""));
                pathsList.add(map);
            }
            if(path.contains(localWebPath)){
                map.put(localWebPath,path.replace(localWebPath,""));
                pathsList.add(map);
            }
        }
        return pathsList;
    }


    /**
     * 获取发布的文件名
     * @param filePath
     * @return文件名数组
     */
    private String[] getPaths(String filePath)  throws Exception {
        FileReader fileReader = null;
        String[] paths = null;
        StringBuffer stringBuffer = new StringBuffer();
        try{
            fileReader = new FileReader(Utils.converterFilePathToWinPath(filePath,"\\"));
            char[] chars = new char[1024];;
            while (fileReader.read(chars)!=-1){
                fileReader.read(chars);
                stringBuffer.append(chars);
            }
            //替换掉回车和换行
            String localString = stringBuffer.toString().replace("\r\n","");
            if("".equals(localString)){
                throw new Exception("路径为空！");
            }
            paths = localString.split(";");
            //有个bug,会多出一行空行
            paths = Arrays.copyOf(paths,paths.length-1);
        }
        finally {
            try{
                fileReader.close();
            }catch (Exception e){
            }
        }
        return paths;
    }



    /**
     * 构建发布文件
     * @param lists
     */
    private void buildFabuFiles(List<Map<String,String>> lists,PathPrefix pathPrefix) throws Exception {
        FTPClient ftpClient = new FTPClient();
        String localClassPath = pathPrefix.getLocalClassPath();
        String localWebPath = pathPrefix.getLocalWebPath();
        String ftpClassPath = pathPrefix.getFtpClassPath();
        String ftpWebPath = pathPrefix.getFtpWebPath();
        Properties properties = Utils.buildProperties();
        String username = properties.getProperty("ftp.username");
        String password = properties.getProperty("ftp.password");
        String ip = properties.getProperty("ftp.ip");
        int port = Integer.valueOf(properties.getProperty("ftp.port"));
        String basePath = properties.getProperty("basePath");
        System.out.println("localClassPath："+localClassPath+"\r\n"+"localWebPath:"+localWebPath+"\r\n"+"ftpClassPath:"+ftpClassPath+"\r\n"+
           "ftpWebPath:"+ftpWebPath+"\r\n"+"ftp IP地址："+ip+"\r\n"+ "port:"+port+"\r\n"+"username:"+username+"\r\n"+"password:"+password+"\r\n"+"basePath:"+basePath );
        //连接ftp服务
        System.out.println("开始连接ftp服务器...");
        String ftpReply= Utils.connectServer(ip,port,username,password,null,ftpClient);
        System.out.println("ftp服务器返回信息："+ftpReply);
        System.out.println("开始打包...");
        for (Map<String, String> map : lists){
            if(map.containsKey(localClassPath)){
                Utils.download(ftpClassPath+map.get(localClassPath),ftpClassPath+map.get(localClassPath),basePath,ftpClient);
            }

            if(map.containsKey(localWebPath)){
                Utils.download(ftpWebPath+map.get(localWebPath),ftpWebPath+map.get(localWebPath),basePath,ftpClient);
            }
            packageSuccessNum++;
        }
        System.out.println("打包结束");
    }


    /**
     * 构建回滚文件
     * @param lists
     */
    private void buildRollBackFiles(List<Map<String,String>> lists,PathPrefix pathPrefix) throws Exception {
        FTPClient ftpClient = new FTPClient();
        String localClassPath = pathPrefix.getLocalClassPath();
        String localWebPath = pathPrefix.getLocalWebPath();
        String ftpRollBackClassPath = pathPrefix.getFtpRollBackClassPath();
        String ftpRollBackWebPath = pathPrefix.getFtpRollBackWebPath();
        Properties properties = Utils.buildProperties();
        String username = properties.getProperty("ftp.username");
        String password = properties.getProperty("ftp.password");
        String ip = properties.getProperty("ftp.ip");
        int port = Integer.valueOf(properties.getProperty("ftp.port"));
        String basePath = properties.getProperty("basePath");
        System.out.println("localClassPath："+localClassPath+"\r\n"+"localWebPath:"+localWebPath+"\r\n"+"ftpRollBackClassPath:"+ftpRollBackClassPath+"\r\n"+
                "ftpRollBackWebPath:"+ftpRollBackWebPath+"\r\n"+"ftp IP地址："+ip+"\r\n"+ "port:"+port+"\r\n"+"username:"+username+"\r\n"+"password:"+password+"\r\n"+"basePath:"+basePath );
        //连接ftp服务
        System.out.println("开始连接ftp服务器...");
        String ftpReply= Utils.connectServer(ip,port,username,password,null,ftpClient);
        System.out.println("ftp服务器返回信息："+ftpReply);
        System.out.println("开始打包...");
        for (Map<String, String> map : lists){
            if(map.containsKey(localClassPath)){
                Utils.download(ftpRollBackClassPath+map.get(localClassPath),ftpRollBackClassPath+map.get(localClassPath),basePath,ftpClient);
            }

            if(map.containsKey(localWebPath)){
                Utils.download(ftpRollBackWebPath+map.get(localWebPath),ftpRollBackWebPath+map.get(localWebPath),basePath,ftpClient);
            }
            rollBackpackageSuccessNum++;
        }
        System.out.println("打包结束");
    }
}