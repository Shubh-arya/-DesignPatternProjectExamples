package practice;

import data_strucuture_and_algorithms.stack.LLNode;

public class ReverseStringUsingRecursionLLNode {

	// Given an string array
	static String[] values = { "aa", "bb", "cc", "dd" };

	static <T> LLNode<T> insertAtEnd(LLNode<T> list, T value) {
		if (list != null) {
			list.setLink(insertAtEnd(list.getLink(), value));
		} else {
			list = new LLNode<T>(value);
		}
		return list;
	}

	static void reversePrintLinkedList(LLNode<String> node) {
		if (node != null) {
			reversePrintLinkedList(node.getLink());
			System.out.println(node.getInfo());
		}
	}

	public static void main(String[] args) {
		LLNode<String> list = null;
		for (String value : values) {
			list = insertAtEnd(list, value);
		}
		reversePrintLinkedList(list);
	}
}
