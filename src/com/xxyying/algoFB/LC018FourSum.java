package com.xxyying.algoFB;

import java.util.*;

public class LC018FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 4){
			return res;
		}
		Arrays.sort(nums);
		int 
		
		
		
		return res;
	}

	public static void main(String[] args) {
		LC018FourSum test = new LC018FourSum();
		int[] nums = new int[]{1, 0, -1, 0, -2, 2};
		int target = 0;
		List<List<Integer>> result = test.fourSum(nums, target);
		System.out.println(result);
	}

}
