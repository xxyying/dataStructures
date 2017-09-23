package com.xxyying.algoFB;

public class Mockup01MakeList {
	public DoublyLinkedListNode makeList(TreeNode root) {
		if(root == null) {
			return null;
		}
		DoublyLinkedListNode[] array = new DoublyLinkedListNode[2];
		array = helper(root);
		return array[0]; 
	}
	
	private DoublyLinkedListNode[] helper(TreeNode root) {
		DoublyLinkedListNode head = new DoublyLinkedListNode(0);
		DoublyLinkedListNode tail = new DoublyLinkedListNode(0);
		
		DoublyLinkedListNode headL = new DoublyLinkedListNode(0);
		DoublyLinkedListNode tailL = new DoublyLinkedListNode(0);
		DoublyLinkedListNode headR = new DoublyLinkedListNode(0);
		DoublyLinkedListNode tailR = new DoublyLinkedListNode(0);
		
		DoublyLinkedListNode[] array = new DoublyLinkedListNode[2];
		DoublyLinkedListNode[] leftArr = new DoublyLinkedListNode[2];
		DoublyLinkedListNode[] rightArr = new DoublyLinkedListNode[2];

		DoublyLinkedListNode cur = new DoublyLinkedListNode(root.val);

		
		if(root.left == null && root.right == null) {
			head = cur;
			tail = cur;
			head.prev = tail;
			tail.next = head;
			array[0] = head;
			array[1] = tail;
			return array;
		}
		
		if(root.left != null) {
			helper(root.left);
			headL = leftArr[0];
			tailL = leftArr[1];
			tailL.next = head;
			head.prev = tailL;
			tailL.next = cur;
			cur.prev = tailL;
			}
		
		if(root.right != null) {
			helper(root.right);
			headR = rightArr[0];
			tailR = rightArr[1];
			head.prev = tailR;
			tailR.next = head;
			cur.next = headR;
			headR.prev = cur;
			}
		
		return new DoublyLinkedListNode[]{leftArr[0], rightArr[1]};
	}
		
	public static void main(String[] args) {
		Mockup01MakeList test = new Mockup01MakeList();
		/*
		 * Tree 1:
		 * 			4
		 * 		  /	  \
		 * 		 2	   5
		 *      / \
		 *     1   3
		 */
		
		TreeNode root1 = new TreeNode(4);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(5);
		
		root1.left = root2;
		root1.right = root3;
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(3);
		
		DoublyLinkedListNode res = test.makeList(root3);
		System.out.println("One Node Only : ");
		System.out.println("Head value : " + res.val);
		System.out.println("head.prev value : " + res.prev.val);
		System.out.println("tail.next value : " + res.prev.next.val);

		
		System.out.println("");		
		System.out.println("5 Nodes : ");
		res = test.makeList(root1);
		System.out.println("Head value : " + res.val);
		System.out.println("head.prev value : " + res.prev.val);
		System.out.println("head.prev.prev value : " + res.prev.next.val);


//		System.out.println("");
//		
//		System.out.println("3 Nodes : ");
//		res = test.makeList(root2);
//		System.out.println("Head value : " + res.val);
//		System.out.println("head.prev value : " + res.prev.val);
//		//System.out.println("head.prev.prev value : " + res.prev.prev.val);
		
	}

}
