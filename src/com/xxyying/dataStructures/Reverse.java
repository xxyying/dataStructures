package com.xxyying.dataStructures;

public class Reverse{
	  
	  public static String reverseString(String input) {
	    String[] words = input.trim().split("\\s+");
	    String output = "";
	    
	    for(int i = words.length - 1; i > 0; i--) {
	      output += words[i] + " "; 
	    }
	    
	    return output + words[0];

	  }
	  
	  
	  
	  public static void main(String[] args) {
	    Reverse test = new Reverse();
	    String input = "How are you";
	    
	    System.out.println(reverseString(input));
	    
	    
	  }
	  
	}