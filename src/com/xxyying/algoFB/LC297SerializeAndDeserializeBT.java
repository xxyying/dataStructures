package com.xxyying.algoFB;

import java.util.*;

public class LC297SerializeAndDeserializeBT {
	private String splitter = ",";
	private String nn = "null";

	public String serialize(TreeNode root) {
        // Pre-order traverse
		StringBuilder sb = new StringBuilder();
        preOrder(sb, root);
		
		return sb.toString();
    }
	
	private void preOrder(StringBuilder sb, TreeNode root) {
		if(root == null) {
			sb.append(nn).append(splitter);
		} else {
			sb.append(root.val).append(splitter);
			preOrder(sb, root.left);
			preOrder(sb, root.right);
		}
	}

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.equals("")) {
        	return null;
        }
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(splitter)));
        return deserializeHelper(queue);
    	
    }
      
	private TreeNode deserializeHelper(Queue<String> queue) {
		String val = queue.poll();
		if(val.equals("null")) {
			return null;
		} else {
			TreeNode root = new TreeNode(Integer.valueOf(val));
			root.left = deserializeHelper(queue);
			root.right = deserializeHelper(queue);
			return root;
		}
	}

	/* Example Tree:
	 * 			1
	 * 		  /   \
	 * 		 2     3
	 * 			 /   \
	 * 			4     5
	 * 
	 * serialize output: 1,2,null,null,3,4,5,null,null
	 * deserialize root: 1
	 */
	
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		
		root1.left = root2;
		root1.right = root3;
		root3.left = new TreeNode(4);
		root3.right = new TreeNode(5);
			
		LC297SerializeAndDeserializeBT test = new LC297SerializeAndDeserializeBT();
		String res1 = test.serialize(root1);
		System.out.println(res1);
			
		TreeNode resRoot = test.deserialize(res1);
		System.out.println(resRoot.val);
	}

}
