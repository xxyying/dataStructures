package com.xxyying.algoFB;

import java.util.*;

public class LC257BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        helper(root, sb, res);
        return res;
        
    }
    
    private void helper(TreeNode root, StringBuilder sb, List<String> res) {
        int tmp = sb.length();

        if(root.left == null && root.right == null) {
            sb.append(root.val);
            res.add(sb.toString());
            return;
        }
        
        if(root.left != null) {
            sb.append(root.val + "->");
            helper(root.left, sb, res);
            sb.delete(tmp, sb.length());
        }
        
        if(root.right != null) {
            sb.append(root.val + "->");
            helper(root.right, sb, res);
            sb.delete(tmp, sb.length());

        }
    }
    
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        helper2(root, "", result);
        return result;
        
    }
    
    
    private void helper2(TreeNode root, String path, List<String> result) {
        if(root.left == null && root.right == null) {
            result.add(path + root.val);
        }
        if(root.left != null) {
            helper2(root.left, path + root.val + "->", result);
        }
        if(root.right != null) {
            helper2(root.right, path + root.val + "->", result);
        }
    }
    
    
    /* Example Tree:
	 * 			1
	 * 		  /   \
	 * 		 2     3
	 * 			 /   \
	 * 			4     5
	 * 
	 * output = ["1->2", "1->3->4", "1->3->5"]
	 */
	
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		
		root1.left = root2;
		root1.right = root3;
		root3.left = new TreeNode(4);
		root3.right = new TreeNode(5);
		
		LC257BinaryTreePaths test = new LC257BinaryTreePaths();
		System.out.println("Solu 1: " + test.binaryTreePaths(root1));
		System.out.println("Solu 2: " + test.binaryTreePaths2(root1));

		
	}

}
