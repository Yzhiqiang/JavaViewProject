package com.yu.Collection.sort;

import java.util.Comparator;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 16:31 2022/2/17
 * @Modified By:
 */
public interface Sorter {
    public <T extends Comparable<T>> void sort(T[] list);

    public <T> void sort(T[] list, Comparator<T> comp);
}
