package com.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusImageDownloader {
    public static String path = "src/main/resources/image/%d.jpeg";
    public static void downloadStatusImage(int code)  {
        try(FileOutputStream out = new FileOutputStream(path.formatted(code));)
        {
            Connection.Response resultImageResponse = Jsoup.connect(HttpStatusChecker.getStatusImage(code)).ignoreContentType(true).execute();
            out.write(resultImageResponse.bodyAsBytes());

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
