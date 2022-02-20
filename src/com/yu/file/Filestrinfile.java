package com.yu.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 15:04 2022/2/16
 * @Modified By:
 */
public class Filestrinfile {
    public static void main(String[] args) {
        String filename = "d:/1.txt";
        String str = "hello";
        int counter = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = null;
            while((line = br.readLine()) != null) {
                int index = -1;
                while(line.length() >= str.length() && (index = line.indexOf(str)) >= 0) {
                    counter++;
                    line = line.substring(index + str.length());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(counter);
    }
}
