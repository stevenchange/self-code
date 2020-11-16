package com.self.code.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: gaobo07
 * @Date: 2020/9/12 11:44 上午
 */
public class LexicalOrder {
    /**
     * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
     * 例如，给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9]
     */
    void myTreemap(){
        int n = 4289384;
        int k = 1922239;
        TreeMap<String, String> treeMap = new TreeMap<>();
        for(int i = 1; i <= n; i++){
            treeMap.put(String.valueOf(i), String.valueOf(i));
        }

        int count = 1;
        for(Map.Entry<String, String> entry : treeMap.entrySet()){
            if(count == k){
                System.out.println(Integer.valueOf(entry.getKey()));
                break;
            } else {
                count++;
            }
        }
    }

    List<Integer> result = new ArrayList<>();
    void myDFS(int n, int lastNum){
        //把上一次的结果按照权，前移一位
        int nowNum = lastNum * 10;
        //刚刚空出来的位，穷举[0, 9],但是当lastNum == 0，时，这一位不能放置0
        //特殊情况，比如100,1000,这种第一位可以放置0
        if (nowNum != 0 && nowNum <= n){
            result.add(nowNum);
            myDFS(n, nowNum);
        }
        //在即将放入的位放置[lastNum * 10 + 1,lastNum * 10 + 9]
        for (int index = 1; index < 10 && nowNum + index <= n; ++index){
            //放入结果
            result.add(nowNum + index);
            //放入之后得继续递归放置， [1,10,11,12,13,2,3,4,5,6,7,8,9] 。放置1后需要继续放置[10,11,12....]
            //放置[(nowNum + index) * 10, (nowNum + index) * 10 + 9]
            myDFS(n, nowNum + index);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        LexicalOrder order = new LexicalOrder();
        order.myDFS(n, 0);
        for(int i = 0; i < order.result.size(); i++){
            System.out.println(order.result.get(i));
        }
    }
}
