package com.self.code.datastruct;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: self-code
 * @description: 倒序输出链表
 * @author: GaoBo
 * @create: 2019/10/21
 **/
public class PrintLinkList {

	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("1");
		linkedList.add("2");
		linkedList.add("3");
		linkedList.add("4");

		PrintLinkList printLinkList = new PrintLinkList();
		printLinkList.printLinkListByStack(linkedList);
	}

	private void printLinkListByStack(LinkedList<String> linkedList){
		Stack stack = new Stack();

		for (String s : linkedList) {
			stack.push(s);
		}

		for (int i = 0, max = stack.size(); i < max; i++) {
			System.out.println(stack.pop());
		}
	}

}
