package com.xxyying.algoFB;

import java.util.HashMap;

public class LC012IntegerToRoman {
	public String intToRoman1(int num) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        
        int[] digits = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String result = "";
        
        for(int i = 0; i < digits.length; i++) {
            if (num >= digits[i]) {
                int cnt = num/digits[i];
                num %= digits[i];
                for(int j = 0; j < cnt; j++) {
                    result += map.get(digits[i]);
                }
            }
        }
        return result;
        
    }
	
	public String intToRoman2(int num) {
		String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] digits = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String result = "";
        
        for(int i = 0; i < digits.length; i++) {
            if (num >= digits[i]) {
                int cnt = num/digits[i];
                num %= digits[i];
                for(int j = 0; j < cnt; j++) {
                    result += roman[i];
                }
            }
        }
        return result;
        

	}
	
	
	public static void main(String[] args) {
		LC012IntegerToRoman test = new LC012IntegerToRoman();
		int num = 3000;
		System.out.println("S1 : " + test.intToRoman1(num));
		System.out.println("S2 : " + test.intToRoman2(num));

		num = 1;
		System.out.println("S1 : " + test.intToRoman1(num));
		System.out.println("S2 : " + test.intToRoman2(num));
		
		num = 50;
		System.out.println("S1 : " + test.intToRoman1(num));
		System.out.println("S2 : " + test.intToRoman2(num));
		
		num = 461;
		System.out.println("S1 : " + test.intToRoman1(num));
		System.out.println("S2 : " + test.intToRoman2(num));
	}

}
