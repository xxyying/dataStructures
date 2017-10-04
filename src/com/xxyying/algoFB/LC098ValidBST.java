package com.xxyying.algoFB;

public class LC098ValidBST {
	public boolean isValidBST(TreeNode root) {
        return helper(root, (long)Integer.MIN_VALUE-1, (long)Integer.MAX_VALUE+1); 
    }
    
    private boolean helper(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }
        if(root.val >= max || root.val <= min) {
            return false;
        }
        return helper(root.left, min, root.val) 
            && helper(root.right, root.val, max);
    }
    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		
		LC098ValidBST test = new LC098ValidBST();
		boolean result = test.isValidBST(root);
		System.out.println(result);
	}

}
