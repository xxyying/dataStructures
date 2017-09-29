package com.xxyying.algoFB;

import java.util.Arrays;

public class LC283MoveZeroes {
	public void moveZeroes(int[] nums) {
		int j = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != 0) {
				swap(nums,i,j);
				j++;
			}
		}
	}
	
	private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
	
	public void moveZeroes2(int[] nums) {
	    if (nums == null || nums.length == 0) return;        

	    int insertPos = 0;
	    for (int num: nums) {
	        if (num != 0) nums[insertPos++] = num;
	    }        

	    while (insertPos < nums.length) {
	        nums[insertPos++] = 0;
	    }
	}
	
	public static void main(String[] args) {
		LC283MoveZeroes test = new LC283MoveZeroes();
		int[] nums = new int[]{0,1,0,3,12};
		test.moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
		
		nums = new int[]{0,1,0,3,12};
		test.moveZeroes2(nums);
		System.out.println("Solu 2 : " + Arrays.toString(nums));
	}

}
