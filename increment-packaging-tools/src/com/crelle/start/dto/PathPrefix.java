package com.crelle.start.dto;

import com.crelle.start.common.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ProjectName try-new-technologies
 * @ClassName PathPrefix
 * @Description 路径前缀
 * @Author crelle
 * @Date 2020/5/30 18:07
 * @Version 1.0
 **/
public class PathPrefix {

    {
            Properties properties = Utils.buildProperties();
            this.setFtpWebPath("localWebPath");
            this.setLocalClassPath(properties.getProperty("localClassPath"));
            this.setFtpClassPath(properties.getProperty("ftpClassPath"));
    }

    private String localClassPath;

    private String localWebPath;

    private String ftpClassPath;

    private String ftpWebPath;

    public String getLocalClassPath() {
        return localClassPath;
    }

    public void setLocalClassPath(String localClassPath) {
        this.localClassPath = localClassPath;
    }

    public String getLocalWebPath() {
        return localWebPath;
    }

    public void setLocalWebPath(String localWebPath) {
        this.localWebPath = localWebPath;
    }

    public String getFtpClassPath() {
        return ftpClassPath;
    }

    public void setFtpClassPath(String ftpClassPath) {
        this.ftpClassPath = ftpClassPath;
    }

    public String getFtpWebPath() {
        return ftpWebPath;
    }

    public void setFtpWebPath(String ftpWebPath) {
        this.ftpWebPath = ftpWebPath;
    }

    @Override
    public String toString() {
        return "PathPrefix{" +
                "localClassPath='" + localClassPath + '\'' +
                ", localWebPath='" + localWebPath + '\'' +
                ", ftpClassPath='" + ftpClassPath + '\'' +
                ", ftpWebPath='" + ftpWebPath + '\'' +
                '}';
    }
}
