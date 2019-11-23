package com.self.code.datastruct;

import java.util.Arrays;

/**
 * @program: self-code
 * @description: 二维数组，数据查找
 * @author: GaoBo
 * @create: 2019/10/21
 **/
public class TwoDimensionalArrayFind {

	public static void main(String[] args) {
		int[][] arrays = {{1,2,3,4,5}};
		int target = 50;
		TwoDimensionalArrayFind twoDimensionalArrayFind = new TwoDimensionalArrayFind();
		System.out.println(twoDimensionalArrayFind.findData(arrays, target));
		System.out.println(" ");
		int[][] reversal = twoDimensionalArrayFind.reversalTwoArrays(arrays);
		twoDimensionalArrayFind.findData(reversal, 50);

	}

	/**
	 * 暴力解法
	 * @param arrays 二维数组
	 * @param target 需要查找的数据
	 * @return 找到返回true，找不到返回false
	 */
	private boolean findData(int[][] arrays, int target){
		for(int i = 0; i < arrays.length; i++){
			for(int j = 0; j < arrays[i].length; j++){
				System.out.println(arrays[i][j]);
				if(arrays[i][j] == target){
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * 反转二维数据
	 * @param arrays
	 * @return
	 */
	private int[][] reversalTwoArrays(int[][] arrays){
		for(int start = 0, end = arrays.length - 1; start < end; start++, end--){
			int[] temp = arrays[start];
			arrays[start] = arrays[end];
			arrays[end] = temp;
			arrays[start] = this.reversalOneArrays(arrays[start]);
			arrays[end] = this.reversalOneArrays(arrays[end]);
			if(arrays.length % 2 == 1 && start == arrays.length / 2 - 1){
				arrays[start+1] = this.reversalOneArrays(arrays[start+1]);
			}
		}

		if(arrays.length == 1){
			arrays[0] = this.reversalOneArrays(arrays[0]);
		}

		return arrays;
	}

	private int[] reversalOneArrays(int[] subArray){
		for(int i = 0, j = subArray.length - 1; i < j; i++, j--){
			int subTemp = subArray[i];
			subArray[i] = subArray[j];
			subArray[j] = subTemp;
		}
		return subArray;
	}

}
