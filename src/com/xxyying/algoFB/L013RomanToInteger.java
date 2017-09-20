package com.xxyying.algoFB;

import java.util.HashMap;

public class L013RomanToInteger {
	public int romanToInt(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        
        int sum = 0;
        
        for(int i = 0; i < s.length()-1; i++) {
            int cur = map.get(s.charAt(i));
            int next = map.get(s.charAt(i+1));
            if (cur < next) {
                sum -= cur;        
            } else {
                sum += cur;
            }
        }
        sum += map.get(s.charAt(s.length()-1));
        
        
        return sum;
	}
	
	public int romanToInt2(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        
        int sum = 0;
        char pre = '#';
        
        for(int i = s.length() - 1; i >= 0; i--) {
        	char cur = s.charAt(i);
        	int curValue = map.get(cur);
            if(pre == '#') {
            	sum += curValue;
            } else if(curValue >= map.get(pre)) {
            	sum += curValue;
            } else if(curValue < map.get(pre)) {
            	sum -= curValue;
            }
            pre = cur;
        }
        
        return sum;
        
	}
	
	
	
	
	public static void main(String[] args) {
		L013RomanToInteger test = new L013RomanToInteger();
		String s = "DCXXI";
		System.out.println(test.romanToInt(s));
		
		s = "CLXXXI";
		System.out.println(test.romanToInt(s));
		
		s = "DCXXI";
		System.out.println(test.romanToInt2(s));
		
		s = "CLXXXI";
		System.out.println(test.romanToInt2(s));
		
		
		// Time complexity: O(n) --> walk through the string once
	}

}
