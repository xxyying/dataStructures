package com.xxyying.algoFB;

public class LC072EditDistance {
	public int minDistance(String word1, String word2) {
		if(word1 == null && word2 == null) {
        	return 0;
        }
        
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i <= m; i++) {
            dp[i][0] = i;
        }
        for(int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        
        for(int i =1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
                }
            }
        }
        return dp[m][n];
    }
	
	public static void main(String[] args) {
		LC072EditDistance test = new LC072EditDistance();
		
		String word1 = "apple";
		String word2 = "app";
		int res = test.minDistance(word1, word2);
		System.out.println(res);
		assert res == 2;
		
		
		word1 = "";
		word2 = "app";
		res = test.minDistance(word1, word2);
		System.out.println(res);
		assert res == 3;
	}

}
