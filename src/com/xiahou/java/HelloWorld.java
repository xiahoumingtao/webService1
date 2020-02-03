package com.xiahou.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class HelloWorld {





    private String id;

    public static void main(String[] args) {
        System.out.println("HelloWorld");

        ArrayList list = new ArrayList();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
            simpleDateFormat.format(new Date());
            Date date = new Date();

        try {
            System.out.println();
            FileInputStream fileInputStream = new FileInputStream(new File("D:\\java"));
        } catch (FileNotFoundException e) {

        }


    }
}
