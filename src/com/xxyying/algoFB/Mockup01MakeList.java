package com.xxyying.algoFB;

public class Mockup01MakeList {
	public DoublyLinkedListNode makeList(TreeNode root) {
		if(root == null) {
			return null;
		}
		DoublyLinkedListNode[] array = new DoublyLinkedListNode[2];
		array = helper(root, array);
		return array[0]; 
	}
	
	private DoublyLinkedListNode[] helper(TreeNode root, DoublyLinkedListNode[] array) {
		
		DoublyLinkedListNode head = null;
		DoublyLinkedListNode tail = null;
		DoublyLinkedListNode cur = new DoublyLinkedListNode(root.val);
		
		DoublyLinkedListNode[] arrayL = new DoublyLinkedListNode[2];
		DoublyLinkedListNode[] arrayR = new DoublyLinkedListNode[2];

	
		// Single node
		if(root.left == null && root.right == null) {
			head = cur;
			tail = cur;
			head.next = tail;
			tail.prev = head;
//			head.prev = tail;
//			tail.next = head;
			return new DoublyLinkedListNode[]{head, tail};
		}
		
		if(root.left != null) {
			arrayL = helper(root.left, array); // return left sub-tree head & tail
			head = arrayL[0];
			tail = arrayL[1];
			tail.next = cur;
			cur.prev = tail;
//			head.prev = cur;
//			cur.next = head;
			}
		array[0] = arrayL[0];
		array[1] = cur;		
			
		if(root.right != null) {
			arrayR = helper(root.right, array); // return left sub-tree head & tail
			head = arrayR[0];
			tail = arrayR[1];
			cur.next = head;
			head.prev = cur;			
			}
		array[0] = arrayL[0];
		array[1] = arrayR[1];

		return array;
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
		 *     
		 * Output = 1 <-> 2 <-> 3 <-> 4 <-> 5
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
		System.out.println("Tail value : " + res.next.val);
		
		System.out.println("");		
		System.out.println("3 Nodes : ");
		res = test.makeList(root2);
		System.out.println("Head value : " + res.val);
		System.out.println("3rd value : " + res.prev.val);
		System.out.println("2nd value : " + res.next.val);
		System.out.println("3rd value : " + res.next.next.val);
		System.out.println("2n value : " + res.next.next.prev.val);
		System.out.println("1st value : " + res.next.next.next.val);

		System.out.println("");		
		System.out.println("5 Nodes : ");
		res = test.makeList(root1);
		System.out.println("Head value : " + res.val);
		System.out.println("2nd value : " + res.next.val);
		System.out.println("3rd value : " + res.next.next.val);
		System.out.println("4th value : " + res.next.next.next.val);
		System.out.println("5th value : " + res.next.next.next.next.val);
		System.out.println("----- REVERSE -----");		
		System.out.println("4th value : " + res.next.next.next.next.prev.val);
		System.out.println("3th value : " + res.next.next.next.next.prev.prev.val);
		System.out.println("2nd value : " + res.next.next.next.next.prev.prev.prev.val);
		System.out.println("1nd value : " + res.next.next.next.next.prev.prev.prev.prev.val);
	
	}

}
