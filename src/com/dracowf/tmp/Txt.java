package com.dracowf.tmp;

import java.util.List;

/**
 * Created by Draco_000 on 02-Dec-14.
 */
public class Txt {

    public void getAuthor(){


    }
    public List<String> getOnlyTxt(List<String> list){
        list.removeIf(s -> !s.contains(".txt"));
        return list;
    }
}
