package com.yu.file.NIO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 9:25 2022/2/24
 * @Modified By:
 */
public class FastCopy {
    public static void copyFile(String fromfile, String tofile) {
        try {
            FileInputStream fin = new FileInputStream(fromfile);
            FileChannel fcin = fin.getChannel();
            FileOutputStream fout = new FileOutputStream(tofile);
            FileChannel fcout = fout.getChannel();
            ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
            int filecnt;
            while((filecnt = fcin.read(buffer)) != -1) {
                buffer.flip();

                fcout.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        String fromfile = "d://1.txt";
        String tofile = "d://2.txt";
        copyFile(fromfile, tofile);
    }
}
