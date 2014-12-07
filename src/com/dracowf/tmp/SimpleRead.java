package com.dracowf.tmp;
import java.io.*;

class SimpleRead{

    public static void main(String args[]){
        try{
            BufferedReader  in = new BufferedReader(new InputStreamReader(new FileInputStream("2019 Повелитель Марса 2.txt"),  "windows-1251"));
            int i;
            while((i=in.read())!=-1) {
                System.out.print((char) i);
            }
            in.close();
        }catch(Exception e){System.out.println(e);}
    }
}