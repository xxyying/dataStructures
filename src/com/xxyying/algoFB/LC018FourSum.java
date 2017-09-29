package com.xxyying.algoFB;

import java.util.*;

public class LC018FourSum {
	int len = 0;
	
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 3; i++) {
            if(i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for(int j = nums.length-1; j >= i + 3; j--) {
                if(j != nums.length - 1 && nums[j] == nums[j+1]) {
                    continue;
                }   
                int sum = target - nums[i] - nums[j];
                int m = i+1;
                int n = j-1;
                while(m < n) {
                    if(m != i+1 && nums[m] == nums[m-1]) {
                        m++;
                    } else if(n != j-1 && nums[n] == nums[n+1]) {
                        n--;
                    } else if(nums[m] + nums[n] == sum) {
                        result.add(Arrays.asList(nums[i], nums[m], nums[n], nums[j]));
                        m++;
                        n--;
                    } else if (nums[m] + nums[n] < sum){
                        m++;
                    } else {
                        n--;
                    }
                }
            }
        }
        return result;
    }
	
	
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }
   private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(index >= len) {
            return res;
        }
        if(k == 2) {
        	int i = index, j = len - 1;
        	while(i < j) {
                //find a pair
        	    if(target - nums[i] == nums[j]) {
        	    	List<Integer> temp = new ArrayList<>();
                	temp.add(nums[i]);
                	temp.add(target-nums[i]);
                    res.add(temp);
                    //skip duplication
                    while(i<j && nums[i]==nums[i+1]) i++;
                    while(i<j && nums[j-1]==nums[j]) j--;
                    i++;
                    j--;
                //move left bound
        	    } else if (target - nums[i] > nums[j]) {
        	        i++;
                //move right bound
        	    } else {
        	        j--;
        	    }
        	}
        } else{
            for (int i = index; i < len - k + 1; i++) {
                //use current number to reduce ksum into k-1sum
                ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k-1, i+1);
                if(temp != null){
                    //add previous results
                    for (List<Integer> t : temp) {
                        t.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
                while (i < len-1 && nums[i] == nums[i+1]) {
                    //skip duplicated numbers
                    i++;
                }
            }
        }
        return res;
    }

	 
	public static void main(String[] args) {
		LC018FourSum test = new LC018FourSum();
		int[] nums = new int[]{1, 0, -1, 0, -2, 2};
		int target = 0;
		List<List<Integer>> result = test.fourSum(nums, target);
		System.out.println(result);
		
		
		nums = new int[]{-1,0,1,2,-1,-4};
		target = -1;
		result = test.fourSum(nums, target);
		System.out.println(result);
		
		nums = new int[]{-1,0,1,2,-1,-4};
		target = -1;
		result = test.fourSum2(nums, target);
		System.out.println("Solu 2 : \n" + result);
	}

}
