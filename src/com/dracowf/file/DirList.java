package com.dracowf.file;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


/**
 * Created by Draco_000 on 30-Nov-14.
 */

public class DirList {

    ArrayList<String> list = new ArrayList<String>();

    public ArrayList<String> getList(String nameFolder) {
        try (DirectoryStream<Path> dir = Files.newDirectoryStream(FileSystems.getDefault().getPath(nameFolder))) {
            for (Path p : dir) {
                list.add(String.valueOf(p.getFileName()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
