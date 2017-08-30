package com.xxyying.dataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC211WordDictionarys2 {
	
	Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
	
    // Adds a word into the data structure.
    public void addWord(String word) {
        int index = word.length();
        if(!map.containsKey(index)){
            List<String> list = new ArrayList<String>();
            list.add(word);
            map.put(index, list);
        }else{
            map.get(index).add(word);
        }
        
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        int index = word.length();
        if(!map.containsKey(index)){
            return false;
        }
        List<String> list = map.get(index);
        if(isWords(word)){
            return list.contains(word);
        }
        for(String s : list){
            if(isSame(s, word)){
                return true;
            }
        }
        return false;
    }
    
    boolean isWords(String s){
        for(int i = 0; i < s.length(); i++){
            if(!Character.isLetter(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    boolean isSame(String a, String search){
        if(a.length() != search.length()){
            return false;
        }
        for(int i = 0; i < a.length(); i++){
            if(search.charAt(i) != '.' && search.charAt(i) != a.charAt(i)){
                return false;
            }
        }
        return true;
    }
    
    
    

	public static void main(String[] args) {
		LC211WordDictionarys2 test = new LC211WordDictionarys2();
    	test.addWord("bad");
    	test.addWord("dad");
    	test.addWord("mad");
  
    	System.out.println(test.search("pad"));
    	System.out.println(test.search("bad"));
    	System.out.println(test.search(".ad"));
    	System.out.println(test.search("b.."));
    }
	
}
