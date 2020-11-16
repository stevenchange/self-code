package com.self.code.algorithm.Sorts;


import static com.self.code.algorithm.Sorts.SortUtils.print;

/**
 * 冒泡排序
 */
public class BubbleSort2 implements SortAlgorithm {

    <T> void swap(T[] arrays, int m, int n){
        T temp = arrays[m];
        arrays[m] = arrays[n];
        arrays[n] = temp;
    }

    public <T extends Comparable<T>> T[] sort(T[] unsorted){
        T temp;
        for(int i = 0; i < unsorted.length - 1; i++){
            boolean isSwap = false;

            for(int j = 0; j < unsorted.length - 1 - i; j++){
                if(unsorted[j].compareTo(unsorted[j+1]) > 0){
                    swap(unsorted, j, j+1);
                    isSwap = true;
                }
            }

            if(!isSwap){
                break;
            }
        }
        return unsorted;
    }

    public static void main(String[] args){
        long old = System.nanoTime();
        System.out.println(old);
        Integer[] arrays = {3,2,5,6,8,4};
        BubbleSort2 sort2 = new BubbleSort2();
        sort2.sort(arrays);

        print(arrays);

        String[] stringArray = {"c","e","a","b","f"};
        sort2.sort(stringArray);
        print(stringArray);

        long now = System.nanoTime();
        System.out.println(now - old);

    }
}
