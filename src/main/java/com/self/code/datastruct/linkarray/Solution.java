package com.self.code.datastruct.linkarray;

import com.self.code.datastruct.linkarray.model.ListNode;

/**
 * @program: self-code
 * @description:
 * @author: GaoBo
 * @create: 2019/12/22
 **/
public class Solution {

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode pre = dummy;
		ListNode end = dummy;

		while (end.next != null) {
			for (int i = 0; i < k && end != null; i++) end = end.next;
			if (end == null) break;
			ListNode start = pre.next;
			ListNode next = end.next;
			end.next = null;
			pre.next = reverse(start);
			start.next = next;
			pre = start;

			end = pre;
		}
		return dummy.next;
	}

	private ListNode reverse(ListNode head) {
		ListNode pre = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		return pre;
	}

	private static void addListNode(ListNode listNode, int n, int k){
		if(n > k){
			return;
		}
		if(listNode != null){
			listNode.next = new ListNode(n);
		}
		n++;
		addListNode(listNode.next, n, k);
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		addListNode(head, 2, 9);

		ListNode temp = head;
		while(temp != null){
			System.out.println(temp.val);
			temp = temp.next;
		}

		System.out.println("");

		Solution solution = new Solution();
		ListNode result = solution.reverseKGroup(head, 2);

		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}

	}

}
