package com.xxyying.algoFB;

import java.util.*;

public class LC001TwoSum {
	public int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if(nums == null) {
            return result;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int sum = target - nums[i];
            if(map.containsKey(sum)) {
                result[0] = map.get(sum);
                result[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		LC001TwoSum test = new LC001TwoSum();
		int[] nums = new int[]{2, 7, 11, 15};
		int target = 9;
		int[] res = test.twoSum(nums, target);
		System.out.println(Arrays.toString(res));
		
		nums = new int[]{2, 7, 11, 15};
		target = 26;
		res = test.twoSum(nums, target);
		System.out.println(Arrays.toString(res));
		
		nums = new int[]{2, 7, 11, 15};
		target = 0;
		res = test.twoSum(nums, target);
		System.out.println(Arrays.toString(res));	
	}

}
