package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution s = new Solution();
        System.out.print(s.solution("()()"));
    }
}

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(stack.empty()) return false;
                else if(stack.peek() == '('){
                    stack.pop();
                }
                else{
                    stack.add(')');
                }
            }
            else{
                stack.add('(');
            }

        }

        if(stack.empty()){
            return true;
        }
        else{
            return false;
        }
    }
}