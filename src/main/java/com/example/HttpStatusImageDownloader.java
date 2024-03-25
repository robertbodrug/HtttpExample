package com.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusImageDownloader {
    public static final String pathForImg = "src/main/resources/image/%d.jpeg";
    public static void downloadStatusImage(int code) throws InvalidStatusCodeException {
        try {
            Connection.Response resultImageResponse = Jsoup.connect(HttpStatusChecker.getStatusImage(code)).ignoreContentType(true).execute();
            FileOutputStream out = new FileOutputStream(pathForImg.formatted(code));
            out.write(resultImageResponse.bodyAsBytes());
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
