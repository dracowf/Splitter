package com.dracowf.file;

import com.dracowf.tmp.AudioParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Draco_000 on 02-Dec-14.
 */
public class Manipulator {

    List<String> list = new ArrayList<String>();
    SashaTable newTable = new SashaTable();

    public void makeTxt(String[] inputFolder, String[] outputFolder, ArrayList<String> dirList) {

        ArrayList<String> txtDirList = (ArrayList<String>) dirList.clone();
        ArrayList<String> mp3DirList = (ArrayList<String>) dirList.clone();
        txtDirList.removeIf(s -> !s.contains(".txt"));
        mp3DirList.removeIf(s -> !s.contains(".mp3"));
        for (String name : txtDirList) {
            System.out.println(inputFolder[0] + "\\" + name);
            try{
                BufferedReader  in = new BufferedReader(new InputStreamReader(new FileInputStream(inputFolder[0] + "\\" + name), "windows-1251"));
                String str = "";
                while ((str.length() < 40) || (str.length() > 75) || str.contains(":")) {
                    str = in.readLine();
                }
                in.close();
                AuthorBook authorBook = new Parser().getAuthorBook(str);
                new File(outputFolder[0]+ "\\" + authorBook.author).mkdirs();
                File file = new File(inputFolder[0] + "\\" + name);
                Path from = file.toPath();
                Path to = Paths.get(outputFolder[0]+ "\\" + authorBook.author + "\\" + authorBook.book);
                Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            } catch(Exception e) {System.out.println(e);}
        }
        for (String name : mp3DirList) {
            System.out.println(inputFolder[0] + "\\" + name);
            try{
                String artistName = "etc";
                artistName = AudioParser.getAuthorName(inputFolder[0] + "\\" + name);
                if (artistName == null) {
                    artistName = "etc";
                } else
                    if (artistName.isEmpty())
                        artistName = "etc";
                new File(outputFolder[0]+ "\\" + artistName).mkdirs();
                File file = new File(inputFolder[0] + "\\" + name);
                Path from = file.toPath();
                Path to = Paths.get(outputFolder[0]+ "\\" + artistName + "\\" + name);
                Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            } catch(Exception e) {System.out.println(e);}
        }
    }
}
