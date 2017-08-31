package easyLintcode._423ValidParenthese;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
	public boolean isValidParentheses(String s) {
        // write your code here
		if (s.length() % 2 != 0) {
			return false;
		}
        Stack<Character> bracketStack = new Stack<>();
        Map<Character, Character> pair = new HashMap<>();
        pair.put('{', '}');
        pair.put('[', ']');
        pair.put('(', ')');
        for (int i = 0; i < s.length(); i++) {
        	char curr = s.charAt(i);
        	if (curr == '{' || curr == '[' || curr == '(') {
        		bracketStack.push(curr);
        	} 
        	if (curr == '}' || curr == ']' || curr == ')') {
        		if (bracketStack.isEmpty()) {
        			return false;
        		}
        		char top = bracketStack.peek();
        		if(pair.get(top).equals(curr)) {
        			bracketStack.pop();
        		} else {
        			return false;
        		}
        	}
        }
        if (bracketStack.isEmpty()) {
        	return true;
        }
        return false;
    }
}
