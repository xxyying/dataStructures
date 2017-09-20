package com.xxyying.algoFB;

import java.util.*;

public class ValidParentheses {
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        
        for(char c : ch) {
            if (c == '(' || c == '[' || c =='{') {
                stack.push(c);
            } else if(!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                stack.pop();
            } else if(!stack.isEmpty() && stack.peek() == '[' && c == ']') {
                stack.pop();
            } else if(!stack.isEmpty() && stack.peek() == '{' && c == '}') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
	
	public boolean isValid2(String s) {
		Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for(char c: ch) {
        	if(c == '(') {
        		stack.push(')');
        	} else if (c == '[') {
        		stack.push(']');
        	} else if (c == '{') {
        		stack.push('}');
        	} else if (stack.isEmpty() || c != stack.pop()) {
        		return false;
        	}
        }
        return stack.isEmpty();
	}
	
	
	public static void main(String[] args) {
		ValidParentheses test = new ValidParentheses();
		String s = "()";
		boolean res = test.isValid(s);
		System.out.println(res);
		assert res == true;
		
		s = "()[]{}";
		res = test.isValid(s);
		System.out.println(res);
		assert res == true;
		
		s = "(]";
		res = test.isValid(s);
		System.out.println(res);
		assert res == false;
		
		s = "([)]";
		res = test.isValid(s);
		System.out.println(res);
		assert res == false;
		
		s = "()";
		res = test.isValid2(s);
		System.out.println("Solu 2: " + res);
		assert res == true;
		
		s = "()[]{}";
		res = test.isValid2(s);
		System.out.println("Solu 2: " + res);
		assert res == true;
		
		s = "(]";
		res = test.isValid2(s);
		System.out.println("Solu 2: " + res);
		assert res == false;
		
		s = "([)]";
		res = test.isValid2(s);
		System.out.println("Solu 2: " + res);
		assert res == false;
	}

}
