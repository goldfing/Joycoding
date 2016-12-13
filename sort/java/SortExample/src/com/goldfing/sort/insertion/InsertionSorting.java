package com.goldfing.sort.insertion;

import com.goldfing.sort.utils.ArrayUtils;

public class InsertionSorting {
    public static void main(String[] args) {
        int[] list = {1, 7, 4, 3, 8, 23};
        int j, key;

        for (int i = 1; i < list.length ; i++) {
            key = list[i];
            for(j = i-1 ; j >= 0 && list[j] > key ; j--) {
                list[j+1] = list[j];
            }
            list[j+1] = key;
        }

        ArrayUtils.printArray(list);
    }
}
