package com.yu.file.Byte;

import java.io.UnsupportedEncodingException;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 20:58 2022/2/23
 * @Modified By:
 */
public class MyByter {
    public static void main(String[] args) {
        String str1 = "中文";
        try {
            byte[] bytes = str1.getBytes("UTF-8");
            String str2 = new String(bytes, "UTF-8");
            System.out.println(str2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
