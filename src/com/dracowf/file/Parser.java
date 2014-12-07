package com.dracowf.file;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by Draco_000 on 03-Dec-14.
 */
public class Parser {
    public static AuthorBook getAuthorBook (String search) throws IOException {
        AuthorBook obj = null;
        String sigurniv = "http://sigurniv.comuf.com/search_book.php?q=";
        String charset = "UTF-8";
        Elements doc = Jsoup.connect(sigurniv + URLEncoder.encode(search, charset)).userAgent("Chrome").get().body().select("*");
        for (Element d : doc) {
            Gson gson = new GsonBuilder().create();
            String json = d.ownText();
            obj = gson.fromJson(json, AuthorBook.class);
        }
        return obj;
    }
}
