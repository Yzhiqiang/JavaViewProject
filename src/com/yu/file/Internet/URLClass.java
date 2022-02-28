package com.yu.file.Internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 22:07 2022/2/23
 * @Modified By:
 */
public class URLClass {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com");
        InputStream in = url.openStream();
        InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");

        BufferedReader br = new BufferedReader(inputStreamReader);
        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br .close();
    }
}
