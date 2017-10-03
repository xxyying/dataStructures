package com.xxyying.algoFB;

public class LC500SubarraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        for(int i =0; i < nums.length; i++) {
            int sum = nums[i];
            if(sum == k) {
                cnt++;
            }
            for(int j = i+1; j < nums.length; j++) {
                sum += nums[j];
                if(sum == k) {
                    cnt++;
                }
            }
        }
        return cnt;
        
    }
	public static void main(String[] args) {
		LC500SubarraySumEqualsK test = new LC500SubarraySumEqualsK();
		int[] nums = new int[]{1,3,2,5,5};
		int k = 10;
		int res = test.subarraySum(nums, k);
		System.out.println(res);
		assert res == 2;
	}

}
