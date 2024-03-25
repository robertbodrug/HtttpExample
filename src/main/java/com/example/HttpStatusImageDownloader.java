package com.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusImageDownloader {
    public static String pathForImg = "src/main/resources/image/%d.jpeg";
    public static String url = "";
    public static void downloadStatusImage(int code)  {
        try
        {
            Connection.Response resultImageResponse = Jsoup.connect(HttpStatusChecker.getStatusImage(code)).ignoreContentType(true).execute();
            FileOutputStream out = new FileOutputStream(pathForImg.formatted(code));
            out.write(resultImageResponse.bodyAsBytes());
            out.close();
            System.out.println("Successfully wrote to the file.");
        } catch (Exception e) {
            System.out.println("There is not image for HTTP status "+code);
        }

    }
}
