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
	}

}
