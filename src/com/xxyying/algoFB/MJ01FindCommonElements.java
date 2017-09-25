package com.xxyying.algoFB;

import java.util.*;

/*
 * Given two sorted array, find common elements.
 */

public class MJ01FindCommonElements {
	public List<Integer> findCom(int[] arr1, int[] arr2) {
		List<Integer> res = new ArrayList<>();
		if(arr1 == null || arr2 == null) {
			return res;
		}
		int j = 0;
		int i = 0;
		while(i < arr1.length && j < arr2.length) {
			if(arr1[i] < arr2[j]) {
				i++;
			} else if(arr1[i] > arr2[j]){
				j++;
			} else{
				res.add(arr1[i]);
				i++;
			}
			
		}
		
		return res;
	}
	public static void main(String[] args) {
		MJ01FindCommonElements test = new MJ01FindCommonElements();
		int[] arr1 = new int[]{2,5,7,8,10};
		int[] arr2 = new int[]{3,5,7};
		List<Integer> res = test.findCom(arr1, arr2);
		for(Integer i : res) {
			System.out.println(i);
		}

	}
//	static void printIntersection(int arr1[], int arr2[], int m, int n)
//    {
//      int i = 0, j = 0;
//      while (i < m && j < n)
//      {
//        if (arr1[i] < arr2[j])
//          i++;
//        else if (arr2[j] < arr1[i])
//          j++;
//        else
//        {
//          System.out.print(arr2[j++]+" ");
//          i++;
//        }
//      }
//    }
//     
//    public static void main(String args[])
//    {
//        int arr1[] = {1, 2, 4, 5, 6};
//        int arr2[] = {2, 3, 5, 7};
//        int m = arr1.length;
//        int n = arr2.length;
//        printIntersection(arr1, arr2, m, n);
//    }

}
