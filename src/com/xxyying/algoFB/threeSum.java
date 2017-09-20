package com.xxyying.algoFB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++) {
            int left = i+1;
            int right = nums.length - 1;
            int target = 0 - nums[i];
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])){
	            while(left < right) {
	                if (nums[left] + nums[right] == target) {
	                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
	                    while(left < right && nums[left + 1] == nums[left]) {
	                        left++;
	                    }
	                    while(left < right && nums[right - 1] == nums[right]) {
	                        right--;
	                    }
	                    left++;
	                    right--;
	                }else if(nums[left] + nums[right] < target) {
	                    left++;
	                } else {
	                    right--;
	                }
	            }
            }
        }
        return result;
        
    }
	public static void main(String[] args) {
		threeSum test = new threeSum();
		int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
		System.out.println(test.threeSum(nums));
		
		// time complexity: O(n*n)
	}

}
