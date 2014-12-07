package com.dracowf.file;

import java.util.ArrayList;

/**
 * Created by Draco_000 on 05-Dec-14.
 */
public class SashaTable extends ArrayList {

    private String extension;
    private String title;
    private String name;

    public String getExtension() {

        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        SashaTable newTable = new SashaTable();
        System.out.println("");
    }

}
