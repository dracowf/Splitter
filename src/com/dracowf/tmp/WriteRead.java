package com.dracowf.tmp;

import java.io.*;

/**
 * Created by Draco_000 on 30-Nov-14.
 */
public class WriteRead {
    public static void main(String args[]){
        try{
            FileInputStream input = new FileInputStream("input.txt");
            FileOutputStream output = new FileOutputStream("output.txt");
            int i;
            while((i=input.read())!=-1)
                   output.write((char)i);
            input.close();
            output.close();
            System.out.println("success...");
        } catch(Exception e){System.out.println(e);}
    }
}
