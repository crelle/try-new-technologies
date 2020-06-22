package com.crelle.start.common;

import com.crelle.start.dto.PathPrefix;

import java.io.*;
import java.lang.String;

import com.sun.istack.internal.NotNull;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

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


    public static Properties buildProperties(){
        Properties properties = new Properties();
        InputStream inputStream = PathPrefix.class.getClassLoader().getResourceAsStream("com/crelle/start/config/config.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
            return properties;
    }



    public static String connectServer(String ip ,int port,String user,String password,String path,FTPClient ftpClient) throws IOException {
        ftpClient.connect(java.lang.String.valueOf(ip),port);
        //用于记录连接服务器的返回日志
        StringBuffer ftpReply = new StringBuffer();
        String replys[] = ftpClient.getReplyStrings();
        for (int i = 0; i < replys.length; i++) {
            ftpReply.append(replys[i]);
        }
        ftpClient.login(user,password);
        return ftpReply.toString();
    }

    public static void closeServer( FTPClient ftpClient) throws  IOException{
        if(ftpClient.isConnected()){
            ftpClient.disconnect();
        }
    }

    public static boolean existDirectory(String path,FTPClient ftpClient) throws IOException{
        boolean flag = false;
        FTPFile[] ftpFileArr = ftpClient.listFiles();
        for (int i = 0; i < ftpFileArr.length; i++) {
            FTPFile ftpFile = ftpFileArr[i];
            if(null!=ftpFile && ftpFile.isDirectory() && ftpFile.getName().equalsIgnoreCase(path)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static boolean download(String ftpFileName,String localFileName,String basePath, FTPClient ftpClient) throws Exception {
        boolean flag = false;
        String pathName =converterFilePathToWinPath(basePath+localFileName,"/");
        File tempFile = new File(pathName);
        File outFile = null;
        String fileName = tempFile.getName();
        if(null==fileName || "".equals(fileName)){
            throw new Exception("无法获取文件名！");
        }
        String suffix = fileName.substring(fileName.indexOf(".")+1,fileName.length());
        //创建父目录
        File parentFile = tempFile.getParentFile();
        if(!parentFile.exists()){
            parentFile.mkdirs();
        }

        if(suffix.equals("java")){
            outFile = tempFile;
        }else{
            outFile = tempFile;
        }
        OutputStream outputStream = null;
        try{
         outputStream =  new FileOutputStream(outFile);
        flag = ftpClient.retrieveFile(ftpFileName,outputStream);
        }catch (Exception e){

        }
        finally {
            outputStream.close();
        }
        return flag;
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
