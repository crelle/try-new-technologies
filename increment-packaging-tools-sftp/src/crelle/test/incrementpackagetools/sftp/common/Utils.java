package crelle.test.incrementpackagetools.sftp.common;

import crelle.test.incrementpackagetools.sftp.dto.PathPrefix;

import java.io.*;
import java.lang.String;
import com.jcraft.jsch.*;

import java.util.Properties;

/**
 * @ProjectName try-new-technologies
 * @ClassName Utils
 * @Description 抽象工具类
 * @Author crelle
 * @Date 2020/5/30 18:41
 * @Version 1.0
 **/
public abstract class Utils {

    private static Session sshSession = null;

    public static Properties buildProperties(){
        Properties properties = new Properties();
        InputStream inputStream = PathPrefix.class.getClassLoader().getResourceAsStream("crelle/test/incrementpackagetools/sftp/config/config.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
            return properties;
    }



    public static ChannelSftp connectServer(String ip , int port, String user, String password, String path, ChannelSftp channelSftp) throws IOException {
        JSch jsch = new JSch();
        try {
            jsch.getSession(user, ip, port);
            sshSession = jsch.getSession(user, ip, port);
            sshSession.setPassword(password);
            Properties properties = new Properties();
            properties.put("StrictHostKeyChecking", "no");
            properties.put("kex","diffie-hellman-group14-sha1");
            sshSession.setConfig(properties);
            sshSession.connect();
            Channel channel = sshSession.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp) channel;
        } catch (JSchException e) {
            throw new RuntimeException("sftp连接失败", e);
        }
        return channelSftp;
    }

    public static void closeServer( ChannelSftp channelSftp) throws  IOException{
        if(channelSftp.isConnected()){
            channelSftp.disconnect();
        }
    }

    public static int download(String ftpFileName,String localFileName,String basePath, ChannelSftp channelSftp) throws Exception {
        boolean flag = false;
        String remoteFileName = "";
        String ftpDir = "";
        int newFileNum = 0;
        String pathName =converterFilePathToWinPath(basePath+localFileName,"/");
        File tempFile = new File(pathName);
        String fileName = tempFile.getName();
        String suffix = fileName.substring(fileName.indexOf(".")+1,fileName.length());
        if(suffix.equals("java")){
            tempFile = new File(pathName.replace("java","class"));
        }
        File outFile = tempFile;
        if(null==fileName || "".equals(fileName)){
            throw new Exception("无法获取文件名！");
        }
        //创建本地父目录
        File parentFile = tempFile.getParentFile();
        if(!parentFile.exists()){
            parentFile.mkdirs();
        }
        OutputStream outputStream = null;

        try{
         outputStream =  new FileOutputStream(outFile);
            String rFileSeparator = "/";
            int rDirNameSepIndex = ftpFileName.lastIndexOf(rFileSeparator) + 1;
            // 获取ftp文件的父路径,并切换目录
            ftpDir = ftpFileName.substring(0, rDirNameSepIndex);
            channelSftp.cd(ftpDir);
            remoteFileName = ftpFileName.substring(rDirNameSepIndex);
            //获取文件名后缀
            if(suffix.equals("java")){
                remoteFileName = remoteFileName.replace("java","class");
            }
            channelSftp.get(remoteFileName,outputStream);
        }catch (Exception e){
                outputStream.close();
                System.out.println("需要回滚的文件没有找到，工具判定为新增文件:"+ftpDir+remoteFileName);
                if(tempFile.exists()){
                   tempFile.delete();
                    newFileNum++;
                }

        }
        finally {
            outputStream.close();
        }
        return newFileNum;
    }

    /**
     * 根据操作文件系统确定目录分隔符
     * @param inputPath
     * @return 目标文件系统目录分隔符
     * @throws Exception
     */
    public static String converterFilePathToWinPath(String inputPath,String replaceStr) throws Exception {
        if(null==inputPath){
            throw new Exception("输入待发布的路径文件错误，请确认!");
        }
        inputPath = inputPath.replace(replaceStr,File.separator);
        return inputPath;
    }


}
