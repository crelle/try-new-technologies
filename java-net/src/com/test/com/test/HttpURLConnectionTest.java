package com.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionTest {
    public static void main(String[] args) throws IOException {
        Test1();
    }


    public static void Test1() throws IOException {
        URL url = new URL("http:www.baidu.com");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.connect();
    }
}
