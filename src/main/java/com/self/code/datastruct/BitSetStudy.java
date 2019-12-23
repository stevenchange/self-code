package com.self.code.datastruct;

import java.util.BitSet;

/**
 * @program: self-code
 * @description: 学习bitset数据结构
 * @author: GaoBo
 * @create: 2019/12/16
 **/
public class BitSetStudy {

	public static void main(String[] args) {
		BitSet bitSet = new BitSet(10);
		bitSet.set(1);
		bitSet.set(3);
		bitSet.set(6);
		bitSet.set(7);
		bitSet.set(8);
		bitSet.set(2);
		bitSet.set(5);
		bitSet.set(9);


		System.out.println(bitSet.size());
	}

}
