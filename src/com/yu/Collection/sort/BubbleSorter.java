package com.yu.Collection.sort;

import java.util.Comparator;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 16:33 2022/2/17
 * @Modified By:
 */
public class BubbleSorter implements Sorter{
    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        boolean flag = true;
        for(int i = 0; i < list.length && flag; i++) {
            flag = false;
            for(int j = 0; j < list.length - i - 1; j++) {
                if(list[j].compareTo(list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    flag = true;
                }
            }
        }
    }

    @Override
    public <T> void sort(T[] list, Comparator<T> comp) {
        boolean flag = true;
        for(int i = 0; i < list.length && flag; i++) {
            flag = false;
            for(int j = 0; j < list.length - i - 1; j++) {
                if(comp.compare(list[j], list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    flag = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 3, 5, 0, 2, 8, 1};
        Sorter sorter = new BubbleSorter();
//        sorter.sort(arr);
        sorter.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (Integer v : arr) {
            System.out.println(v);
        }
    }
}
