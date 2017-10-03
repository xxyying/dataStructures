package com.xxyying.algoFB;

public class MJ03MaxSumOfSizeK {
	public int maxSum(int[] arr, int n, int k) {
		int res = 0;
		for(int i = 0; i < k; i++) {
			res += arr[i];
		}
		
		int curMax = res;
		for(int i = k; i < n; i++) {
			curMax += arr[i] - arr[i-k];
			res = Math.max(curMax, res);
		}
		return res;
	}
	public static void main(String[] args) {
		MJ03MaxSumOfSizeK test = new MJ03MaxSumOfSizeK();
		int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        int n = arr.length;
        System.out.println(test.maxSum(arr, n, k));
	}

}
