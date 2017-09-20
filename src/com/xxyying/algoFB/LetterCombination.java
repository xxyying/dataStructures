package com.xxyying.algoFB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LetterCombination {
	public List<String> letterCombinations(String digits) {
        //dfs problem
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() < 1) {
            return result;
        }
        
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "");
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        
        StringBuilder sb = new StringBuilder();
        combine(digits, 0, sb, map, result);
        return result;
    }
    
    private void combine(String digits, int idx, StringBuilder sb, 
                         HashMap<Integer, String> map, List<String> result) {
        if(sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String s = map.get(digits.charAt(idx) - '0');
        for(int i = 0; i < s.length(); i++) {
            //System.out.println(s);
            sb.append(s.charAt(i));
            combine(digits, idx + 1, sb, map, result);
            sb.deleteCharAt(sb.length() -1);
        }      
    }
    
    
    public List<String> letterCombinations2(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }
    
    
    public List<String> letterCombinations3(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() <= 0) {
            return result;
        }
        
        String[] letters = new String[]{"0", "1", "abc", "def", "ghi", 
                                        "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        combine3(digits, 0, letters, sb, result);
        return result;
    }
    
    private void combine3(String digits, int idx, String[] letters, 
                         StringBuilder sb, List<String> result) {
        if(sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        
        String s = letters[digits.charAt(idx) - '0'];
        for(int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            combine3(digits, idx+1, letters, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    
	public static void main(String[] args) {
		LetterCombination test = new LetterCombination();
		String digits = "23";
		System.out.println("Solu 1 : " + test.letterCombinations(digits));
		
		digits = "23";
		System.out.println("Solu 2 : " + test.letterCombinations2(digits));
		
		digits = "23";
		System.out.println("Solu 3 : " + test.letterCombinations3(digits));
	}

}
