package com.self.code.datastruct.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: self-code
 * @description:
 * @author: GaoBo
 * @create: 2019/12/22
 **/
public class Solution {

	public String reversalStr(String s){
		char[] chars = s.toCharArray();
		for(int i = 0, j = chars.length - 1; i <= j; i++, j--){
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
		}

		return new String(chars);
	}

	public boolean isAnagram(String s, String t) {
		Map<String, Integer> map = new HashMap<>();
		char[] source = s.toCharArray();
		for(int i = 0; i < source.length; i++){
			String temp = String.valueOf(source[i]);
			if(map.get(temp) != null){
				map.put(temp, map.get(temp) + 1);
			} else {
				map.put(temp, 1);
			}
		}

		char[] target = t.toCharArray();
		for(int j = 0; j < target.length; j++){
			String temp = String.valueOf(target[j]);
			if(map.get(temp) != null){
				map.put(temp, map.get(temp) - 1);
			} else {
				map.put(temp, 1);
			}
		}

		for(Map.Entry<String, Integer> entry : map.entrySet()){
			if(entry.getValue() > 0){
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.reversalStr("abcdefg"));

		String s = "cat";
		String t = "rat";
		System.out.println(solution.isAnagram(s, t));
	}

}
