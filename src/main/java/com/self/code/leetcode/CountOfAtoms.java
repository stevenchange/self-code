package com.self.code.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @Author: gaobo07
 * @Date: 2020/9/13 11:11 下午
 */
public class CountOfAtoms {

    /**
     * 输入:
     * formula = "K4(ON(SO3)2)2"
     * 输出: "K4N2O14S4"
     * 解释:
     * 原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}
     * @param formula
     * @return
     */
    public void countOfAtoms(String formula) {
        StringBuilder sb = new StringBuilder();
        int n = formula.length();
        Stack<Map<String, Integer>> stackMap = new Stack<>();
        stackMap.push(new TreeMap<>());
        //Ki4(ON(CaO3)2)2
        for(int i = 0; i < n;){
            if(formula.charAt(i) == '('){
                stackMap.push(new TreeMap<>());
                i++;
            } else if(formula.charAt(i) == ')') {
                Map<String, Integer> top = stackMap.pop();
                int iStart = ++i, count = 1;
                while (i < n && isNumber(formula.charAt(i))){
                    i++;
                }
                if (i > iStart){
                    count = Integer.parseInt(formula.substring(iStart, i));
                }
                for (String c: top.keySet()) {
                    int v = top.get(c);
                    stackMap.peek().put(c, stackMap.peek().getOrDefault(c, 0) + v * count);
                }
            } else {
                //处理正常字符串
                int iStart = i++;
                while(i < n && isLow(formula.charAt(i))){
                    i++;
                }
                String key = formula.substring(iStart, i);
                iStart = i;
                while(i < n && isNumber(formula.charAt(i))){
                    i++;
                }
                Integer count = i > iStart ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                stackMap.peek().put(key, count);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (String name: stackMap.peek().keySet()) {
            ans.append(name);
            int multiplicity = stackMap.peek().get(name);
            if (multiplicity > 1) ans.append("" + multiplicity);
        }
        System.out.println(ans.toString());
    }

    private boolean isNumber(char str){
        if(str >= '0' && str <= '9'){
            return true;
        }
        return false;
    }

    private boolean isLow(char str){
        if(str >= 'a' && str <= 'z'){
            return true;
        }
        return false;
    }

    private boolean isUpper(char str){
        if(str >= 'A' && str <= 'Z'){
            return true;
        }
        return false;
    }



    public static void main(String[] args) {
        String formula = "Ki4(ON(CaO3)2)2";
        CountOfAtoms atoms = new CountOfAtoms();
        atoms.countOfAtoms(formula);
    }


}
