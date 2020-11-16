package com.self.code.algorithm.sliderwindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: gaobo07
 * @Date: 2020/8/28 4:22 下午
 */
public class SlidingWindow {

    public static void main(String[] args) {
        //检测字符串中最常子串的长度,使用滑动窗口实现
//        String test = "123dddsafdwfdsafdsfdascew";
//        slidingWindow1(test);

        //给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
        int[] array = {1,3,4,2,6,3,4,4,3,5,2};
        int target = 9;
        int result = slidingWidonw2(array, target);
        System.out.println(result);

    }

    /**
     * 检测字符串中最常子串的长度,使用滑动窗口实现
     * @param test
     */
    private static void slidingWindow1(String test){
        int n = test.length();
        Set set = new HashSet();
        int max = 0, i = 0 , j = 0;
        while(i < n && j < n){
            if(!set.contains(test.charAt(i))){
                set.add(test.charAt(i++));
            } else {
                set.remove(test.charAt(j++));
            }

            if(set.size() >= max){
                max = set.size();
            }
        }
        System.out.println(max);
    }

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
     */
    private static int slidingWidonw2(int[] array, int target){
        int n = array.length;
        int left = 0, right = 0;
        int temp = 0, min = n;
        while(left < n && right < n){
            if(target > temp){
                temp = temp + array[right];
                right ++;
            } else if(target <= temp){
                temp = temp - array[left];
                if(right - left < min){
                    min = right - left;
                    System.out.println("right:"+right+" left:"+left);
                }
                left ++;
            }
        }

        return min;
    }

}
