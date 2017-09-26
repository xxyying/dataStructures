package com.xxyying.algoFB;

public class LC091DecodeWays {
	public int numDecodings(String s) {
		if(s == null || s.length() == 0) {
            return 0;
        }
        
        int[] res = new int[s.length()+1];
        res[0] = 1;
        res[1] = s.charAt(0) == '0'? 0:1;
        
        for(int i = 2; i <= s.length(); i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            
            if(first >= 1 && first <=9) {
                res[i] += res[i-1];
            }
            if(second >=10 && second <= 26) {
                res[i] += res[i-2];
            }
        }
        return res[s.length()];
	}
	
	
	public static void main(String[] args) {
		LC091DecodeWays test = new LC091DecodeWays();
		String s = "12";
		int res = test.numDecodings(s);
		System.out.println(res);
		assert res == 2;
		
		s = "1";
		res = test.numDecodings(s);
		System.out.println(res);
		assert res == 1;
	}

}
