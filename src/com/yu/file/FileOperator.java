package com.yu.file;

import java.io.*;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 14:55 2022/2/16
 * @Modified By:
 */
public class FileOperator {
    public static void main(String[] args) {
        String source = "d:/1.txt";
        String target = "d:/2.txt";
        try{
            InputStream in = new FileInputStream(source);
            OutputStream out = new FileOutputStream((target));
            byte[] buffer = new byte[4096];
            int bytesToRead;
            while((bytesToRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesToRead);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
