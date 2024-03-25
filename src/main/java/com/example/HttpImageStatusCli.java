package com.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public static void askStatus(){
        try(Scanner scanner=new Scanner(System.in);)
        {
            System.out.println("Enter HTTP status code: ");
            HttpStatusImageDownloader.downloadStatusImage(scanner.nextInt());
        }
        catch (InvalidStatusCodeException e){
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("Please enter valid number");
        }

    }
}
