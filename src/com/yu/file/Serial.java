package com.yu.file;

import java.io.*;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 21:26 2022/2/23
 * @Modified By:
 */
public class Serial implements Serializable {
    private int x;
    private String y;
    Serial(int x, String y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "x = " + x + " " + "y = " + y;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Serial a = new Serial(123, "abc");
        String objectFile = "d:/2.txt";

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(objectFile));
        objectOutputStream.writeObject(a);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(objectFile));
        Serial b = (Serial) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(b);
    }
}
