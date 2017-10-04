package com.xxyying.algoFB;

public class LC043MultiplyString {
	public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "0";
        }
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
   
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }  

        StringBuilder sb = new StringBuilder();
        for(int p : pos) {
        	if(!(sb.length() == 0 && p == 0)) sb.append(p);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
	public static void main(String[] args) {
		LC043MultiplyString test = new LC043MultiplyString();
		String num1 = "12";
		String num2 = "23";
		String res = test.multiply(num1, num2);
		System.out.println(res);
		
	}

}
