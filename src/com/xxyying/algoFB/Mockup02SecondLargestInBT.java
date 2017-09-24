package com.xxyying.algoFB;

public class Mockup02SecondLargestInBT {
	public int findSecondLargest(TreeNode root) {
		if(root == null) {
			return -1;
		}
		
		int[] res = new int[]{-1, -1};
		helper(root, res);
		return Math.min(res[0], res[1]);
	}
	
	private void helper(TreeNode root, int[] res) {
		int min = Math.min(res[0], res[1]);
		
		if(root.left == null && root.right == null) {
			if(res[0] == -1 || (res[0] == min && root.val > res[0])) {
				res[0] = root.val;
			} else if(res[1] == -1 || (res[1] == min && root.val > res[1])) {
				res[1] = root.val;
			}
			
			return;
		}
		
		// check left subtree
		if(root.left != null) {
			helper(root.left, res);
			if(res[0] == min && root.val > res[0]) {
				res[0] = root.val;
			} else if (res[1] == min && root.val > res[1]) {
				res[1] = root.val;
			}
		}
		
		if(root.right != null) {
			helper(root.right, res);
			if(root.val > res[0] && root.val != res[1]) {
				res[0] = root.val;
			} else if (root.val > res[1] && root.val != res[0]) {
				res[1] = root.val;
			}
		}
		
		return;
	}
	
	
	public static void main(String[] args) {
		/*
		 * Tree 1:
		 * 			5
		 * 		  /	  \
		 * 		 7	   8
		 *      / \   / \
		 *     1   3 9   10
		 *     
		 * Output = 7
		 */
		
		TreeNode root1 = new TreeNode(5);
		TreeNode root2 = new TreeNode(7);
		TreeNode root3 = new TreeNode(8);
		TreeNode root4 = new TreeNode(10);

		
		root1.left = root2;
		root1.right = root3;
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(3);
		root3.left = new TreeNode(9);
		root3.right = root4;

			
		Mockup02SecondLargestInBT test = new Mockup02SecondLargestInBT();
		
		int res = test.findSecondLargest(root1);
		System.out.println(res);
		assert res == 9;
		
		res = test.findSecondLargest(root2);
		System.out.println(res);
		assert res == 3;
		
		res = test.findSecondLargest(root3);
		System.out.println(res);
		assert res == 9;
		
		res = test.findSecondLargest(root4);
		System.out.println(res);
		assert res == -1;
	}

}
