package com.self.code.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * @Author: gaobo07
 * @Date: 2020/8/27 1:58 上午
 */
public class LongestStr {

    /**
     * 检测字符串中最常子串的长度,使用滑动窗口实现
     * @param test
     */
    private static void sliderWindow(String test){
        int n = test.length();
        Set set = new HashSet();
        Integer max = 0, i = 0 , j = 0;
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
     * 删除链表的倒数第 N 个节点
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head, second = head;
        for(int i = 0; i < n; i++){
            second = second.next;
        }

        while(second != null){
            if(second.next == null){
                first.next = first.next.next;
            }
            first = first.next;
            second = second.next;
        }


        return head;
    }

    public static void main(String[] args){
//        String test = "123dddsafdwfdsafdsfdascew";
//        sliderWindow(test);

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode temp = removeNthFromEnd(head, 3);
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
