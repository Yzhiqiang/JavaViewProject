package com.yu.serch;

import java.util.Comparator;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 22:40 2022/2/18
 * @Modified By:
 */
public class Myutil {
    public static <T extends Comparable<T>> int binarySearch(T[] x, T key) {
        return binarySearch(x, 0, x.length - 1, key);
    }
    public static <T extends Comparable<T>> int binarySearch(T[] x, int low, int high, T key) {
        if(low >= high) return low;
        int mid = low + high >> 1;
        if(x[mid].compareTo(key) >= 0) {
            return binarySearch(x, low, mid, key);
        }
        else return binarySearch(x, mid + 1, high , key);
    }

    public static <T> int binarySearch(T[] x, T key, Comparator<T> com) {
        int low = 0, high = x.length - 1;
//        while(low < high) {
//            int mid = low + high + 1 >> 1;
//            if(com.compare(x[mid], key) <=0) {
//                low = mid;
//            }
//            else high = mid - 1;
//        }
        while(low <= high) {
            int mid = low + high  >>> 1;
            if(com.compare(x[mid], key) > 0) {
                high = mid - 1;
            }
            else if(com.compare(x[mid], key) < 0) {
                low = mid + 1;
            }
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7,8};
        System.out.println(binarySearch(arr, 5, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }));
//        System.out.println(binarySearch(arr, 5));
    }
}
