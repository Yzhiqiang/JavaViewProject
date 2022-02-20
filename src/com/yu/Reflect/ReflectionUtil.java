package com.yu.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 22:39 2022/2/16
 * @Modified By:
 */
public class ReflectionUtil {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String str = "hello";
        Method method = str.getClass().getMethod("toUpperCase");
        System.out.println(method.invoke(str));
    }

}