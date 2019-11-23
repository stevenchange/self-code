package com.self.code.leetcode;

/**
 * @program: self-code
 * @description: 包含int型数反转，回溯
 * @author: GaoBo
 * @create: 2019/10/28
 **/
public class DigtialProcess {

	/**
	 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
	 * @param x
	 * @return
	 */
	public static int reverse(int x) {
		long rs = 0;
		while(x != 0){
			rs = rs * 10 + x % 10;
			x /= 10;
		}

		return rs > Integer.MAX_VALUE || rs < Integer.MIN_VALUE ? 0 : (int) rs;
	}

	public static void main(String[] args) {
		int number = 4321;
		System.out.println(reverse(number));

		number = -654321;
		System.out.println(reverse(number));
	}

}
