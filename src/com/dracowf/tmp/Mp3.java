package com.dracowf.tmp;

import java.util.List;

/**
 * Created by Draco_000 on 02-Dec-14.
 */
public class Mp3 {



    public List<String> getOnlyMp3(List<String> list){
        list.removeIf(s -> !s.contains(".mp3"));
        for (String l : list) {
            System.out.println(l);
        }
        return list;
    }
}
