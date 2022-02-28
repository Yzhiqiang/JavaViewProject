package com.yu.ClassLoader;

import java.io.*;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 17:37 2022/2/23
 * @Modified By:
 */
public class MyClassLoader extends ClassLoader{
    private String rootDir;
    public MyClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classDate = getClassData(name);
        if(classDate == null) {
            throw new ClassNotFoundException();
        }else {
            return defineClass(name, classDate, 0, classDate.length);
        }
    }
    public byte[] getClassData(String classname) {
        String path = classNameToPath(classname);
        try {
            InputStream in = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesNumRead;
            while((bytesNumRead = in.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String classNameToPath(String classname) {
        return rootDir + File.separatorChar + classname.replace('.',File.separatorChar)+".class";
    }
}
