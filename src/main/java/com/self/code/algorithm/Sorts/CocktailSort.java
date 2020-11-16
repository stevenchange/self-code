package com.self.code.algorithm.Sorts;


import static com.self.code.algorithm.Sorts.SortUtils.print;

/**
 * @Author gaobo
 * @Description
 * @Date 2020/11/17 1:26
 * @Version 1.0
 */
public class CocktailSort implements SortAlgorithm {

    <T> void swap(T[] arrays, int m, int n){
        T temp = arrays[m];
        arrays[m] = arrays[n];
        arrays[n] = temp;
    }

    public <T extends Comparable<T>> T[] sort(T[] unsorted){
        int left = 0;
        int right = unsorted.length - 1;
        while(left < right){
            for (int i = left; i < unsorted.length - 1; i ++) {
                if(unsorted[i].compareTo(unsorted[i+1]) > 0){
                    swap(unsorted, i, i+1);
                }
            }
            right --;
            for (int j = right; j > 0; j --) {
                if(unsorted[j - 1].compareTo(unsorted[j]) > 0){
                    swap(unsorted, j - 1, j);
                }
            }
            left ++;
        }
        return unsorted;
    }

    public static void main(String[] args) {
        Integer[] arrays = {232,122,22,44,51,26,7,23};
        CocktailSort cocktailSort = new CocktailSort();
        print(cocktailSort.sort(arrays));
    }
}
