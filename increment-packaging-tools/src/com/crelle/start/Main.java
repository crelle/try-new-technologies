package com.crelle.start;

import com.crelle.start.common.Utils;
import com.crelle.start.dto.PathPrefix;
import org.apache.commons.net.ftp.FTPClient;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.io.*;
import java.time.Period;
import java.util.*;

/**
 * @ProjectName try-new-technologies
 * @ClassName Main
 * @Description 增量打包工具
 * @Author crelle
 * @Date 2020/5/30 17:59
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) throws IOException, Exception {
        new Entry(args);
    }
}

