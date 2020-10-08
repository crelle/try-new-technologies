package crelle.test.incrementpackagetools.dto;

import crelle.test.incrementpackagetools.common.Utils;

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
            this.setLocalWebPath(properties.getProperty("localWebPath"));
            this.setLocalClassPath(properties.getProperty("localClassPath"));
            this.setFtpClassPath(properties.getProperty("ftpClassPath"));
            this.setFtpWebPath(properties.getProperty("ftpWebPath"));
            this.setFtpRollBackClassPath(properties.getProperty("ftpRollBackClassPath"));
            this.setFtpRollBackWebPath(properties.getProperty("ftpRollBackWebPath"));
    }

    private String localClassPath;

    private String localWebPath;

    private String ftpClassPath;

    private String ftpWebPath;

    private String ftpRollBackClassPath;

    private String ftpRollBackWebPath;

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

    public String getFtpRollBackClassPath() {
        return ftpRollBackClassPath;
    }

    public void setFtpRollBackClassPath(String ftpRollBackClassPath) {
        this.ftpRollBackClassPath = ftpRollBackClassPath;
    }

    public String getFtpRollBackWebPath() {
        return ftpRollBackWebPath;
    }

    public void setFtpRollBackWebPath(String ftpRollBackWebPath) {
        this.ftpRollBackWebPath = ftpRollBackWebPath;
    }

    @Override
    public String toString() {
        return "PathPrefix{" +
                "localClassPath='" + localClassPath + '\'' +
                ", localWebPath='" + localWebPath + '\'' +
                ", ftpClassPath='" + ftpClassPath + '\'' +
                ", ftpWebPath='" + ftpWebPath + '\'' +
                ", ftpRollBackClassPath='" + ftpRollBackClassPath + '\'' +
                ", ftpRollBackWebPath='" + ftpRollBackWebPath + '\'' +
                '}';
    }
}
