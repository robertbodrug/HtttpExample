package com.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.List;

public class HttpStatusChecker  {
   // private static final List<Integer> CODES = List.of(100,101,102,103,200,201,202,203,204,205,206,207,208,226,300,301,302,303,304,305,307,308,400,401,402,403,404,405,406,407,408,409,410,411,412,413,414,415,416,417,418,420,421,422,423,424,425,426,428,429,431,444,450,451,497,498,499,500,501,502,503,504,506,507,508,509,510,511,521,522,523,525,530,599);
    public static String getStatusImage(int code) throws InvalidStatusCodeException {
        final String URL ="https://http.cat/%d.jpg".formatted(code);
        try {
            Jsoup.connect(URL).ignoreContentType(true).execute();
        } catch (IOException e) {
            throw new InvalidStatusCodeException("There is not image for HTTP status "+code);
        }
        return URL;
    }


}
