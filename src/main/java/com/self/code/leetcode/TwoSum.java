package com.self.code.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @program: self-code
 * @description: 两数之和
 * 给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * @author: GaoBo
 * @create: 2019/10/26
 **/
public class TwoSum {

	/**
	 * 暴力解法
	 * @param nums
	 * @param target
	 * @return 两数的下表
	 */
	public static int[] twoSum(int[] nums, int target){
		int[] result = new int[2];

		for(int i = 0; i < nums.length; i++){
			int temp = target - nums[i];
			for(int j = 0; j < nums.length; j++){
				if(temp == nums[j] && i != j){
					result[0] = i;
					result[1] = j;
				}
			}
		}

		return result;
	}

	/**
	 * 优化解法, 使用hashmap方式处理
	 * @param nums
	 * @param target
	 * @return 两数的
	 */
	public static int[] twoSumMap(int[] nums, int target){
		Map<Integer, Integer> map = new HashMap<>(nums.length);
		for(int sub = 0; sub < nums.length; sub++){
			map.put(nums[sub], sub);
		}

		int[] result = new int[2];

		for(int i = 0; i < nums.length; i++){
			int temp = target - nums[i];
			if(map.get(temp) != null && map.get(temp) != i){
				result[0] = i;
				result[1] = map.get(temp);
				break;
			}
		}

		return result;
	}

	/**
	 * 两数之和，数组有序，双指针法解答
	 * @param numbers
	 * @param target
	 * @return
	 */
	public static int[] twoSumByTwoIndex(int[] numbers, int target){
		int[] result = new int[2];
		int left = 0;
		int right = numbers.length - 1;
		while(left < right){
			if(numbers[left] + numbers[right] == target){
				result[0] = left + 1;
				result[1] = right + 1;
				break;
			} else if(numbers[left] + numbers[right] < target){
				left ++;
			} else {
				right --;
			}
		}

		return result;
	}

	/**
	 * 二叉数，求两数之和
	 * @param root
	 * @param k
	 * @return 若存在，返回true，不存在返回false
	 */
	public static boolean findTarget(TreeNode root, int k) {
		HashSet<Integer> hashSet = new HashSet<>();
		return traversingItem(root, hashSet, k);
	}

	private static boolean traversingItem(TreeNode node, HashSet<Integer> hashSet, int k){
		if(node == null){
			return false;
		}

		if(hashSet.contains(node.val)){
			return true;
		}

		int temp = k - node.val;
		hashSet.add(temp);

		return traversingItem(node.left, hashSet, k) || traversingItem(node.right, hashSet, k);
	}

	public static void main(String[] args) {
		//两数之和，数组无序
//		int[] nums = {2,5,5,11};
//		int target = 10;
//		int[] result = twoSumMap(nums, target);
//		for (int i = 0; i < 2; i++){
//			System.out.println(result[i]);
//		}

		//两数之和，数组有序
//		int[] nums = {2,7,11,15};
//		int target = 9;
//		int[] result = twoSumByTwoIndex(nums, target);
//		for (int i = 0; i < 2; i++){
//			System.out.println(result[i]);
//		}

		//BST中，搜索两数之和
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		int targetTree = 12;

		System.out.println(findTarget(root, targetTree));

	}
}


/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

