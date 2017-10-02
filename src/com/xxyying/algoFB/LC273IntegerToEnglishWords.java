package com.xxyying.algoFB;

public class LC273IntegerToEnglishWords {
	private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
	
	public String numberToWords(int num) {
		if(num == 0) {
			return "Zero";
		}
		int i = 0;
		String result = "";
		
		while(num > 0) {
			if(num%1000 != 0) {
				result = helper(num%1000) + THOUSANDS[i] + " " + result;
				num/=1000;
				i++;
			}
		}
		return result.trim();
	}

	
	private String helper(int n) {
		if(n == 0) {
			return "";
		} else if(n < 20) {
			return LESS_THAN_20[n] + " ";
		} else if(n < 100) {
			return TENS[n/10] + " " + helper(n%10);
		} else {
			return LESS_THAN_20[n/100] + " Hundred " + helper(n%100);
		}
	}

	public static void main(String[] args) {
		LC273IntegerToEnglishWords test = new LC273IntegerToEnglishWords();
		int num = 123;
		String res = test.numberToWords(num);
		System.out.println(res);
		
		num = 1000;
		res = test.numberToWords(num);
		System.out.println(res);
	}

}
