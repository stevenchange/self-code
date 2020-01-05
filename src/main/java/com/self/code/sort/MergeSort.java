package com.self.code.sort;

/**
 * @program: self-code
 * @description: 归并排序，以及对应的leetcode题
 * @author: GaoBo
 * @create: 2019/12/29
 **/
public class MergeSort {

	void sort(int[] array, int low, int high){
		// 判断是否只剩下最后一个元素
		if(low >= high){
			return;
		}
		// 从中间将数组分成两个部分
		int mid = low + (high-low) / 2;
		// 分别递归地将左右两半排好序
		sort(array, low, mid);
		sort(array, mid + 1, high);
		// 将排好序的左右两半合并
		merge(array, low, mid, high);
	}

	void merge(int[] array, int low, int mid, int high){
		int[] copy = array.clone();
		// 定义一个 k 指针表示从什么位置开始修改原来的数组，i 指针表示左半边的起始位置，j 表示右半边的起始位置
		int k = low, i = low, j = mid + 1;

		while (k <= high) {
			if (i > mid) {
				array[k++] = copy[j++];
			} else if (j > high) {
				array[k++] = copy[i++];
			} else if (copy[j] < copy[i]) {
				array[k++] = copy[j++];
			} else {
				array[k++] = copy[i++];
			}
		}
	}

	public static void main(String[] args) {
		int[] array = {2,1,3,7,9,5,6};

		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(array, 0, array.length - 1);

		for (int temp: array) {
			System.out.println(temp);
		}
	}
}
