package com.xxyying.algoFB;

import java.util.*;

public class LC215KthLargestElementinArray {
	public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i< nums.length; i++) {
            if(pq.size() < k) {
                pq.offer(nums[i]);
            } else {
                if(nums[i] > pq.peek()) {
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }
        return pq.poll();
    }
	
	public int findKthLargest2(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }
        return helper(nums, 0, nums.length - 1, nums.length - k);
    }
    
    public int helper(int[] nums, int start, int end, int k) {
        if (start > end) {
            return Integer.MAX_VALUE;
        }
        int left = start;
        int pivot = nums[end];
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                swap(nums, left++, i);
            }
        }
        swap(nums, left, end);
        
        if (left == k) {
            return nums[left];
        } else if (left < k) {
            return helper(nums, left + 1, end, k);
        } else {
            return helper(nums, start, left - 1, k);
        }
    }
    
    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
	
	
	public static void main(String[] args) {
		LC215KthLargestElementinArray test = new LC215KthLargestElementinArray();
		int[] nums = new int[]{2,6,8,4,7};
		int k = 2;
		int res = test.findKthLargest(nums, k);
		System.out.println("Solu 1: " + res);
		assert res == 7;
		
		
		nums = new int[]{2,6,8,4,7};
		k = 2;
		res = test.findKthLargest2(nums, k);
		System.out.println("Solu 2: " + res);
		assert res == 7;
	}

}
