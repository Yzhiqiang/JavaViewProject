package com.yu.file;

import java.io.*;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 21:10 2022/2/23
 * @Modified By:
 */
public class ReaderAndWriter {
    public static void main(String[] args) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("d://1.txt"));
//            FileReader fileReader = new FileReader("d://1.txt");
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);   //提供缓存功能
            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
