package com.yu.file;

import java.io.File;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 15:15 2022/2/16
 * @Modified By:
 */
public class ListFile {
    public static void main(String[] args) {
        File f = new File("e:/ofen");
        System.out.println(f.isDirectory());
        System.out.println(f.isFile());
        for(File temp:f.listFiles()) {
            System.out.println(temp.getName());
        }
    }
}
