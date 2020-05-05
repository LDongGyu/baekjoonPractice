package programmers;
import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		String answer;
		answer = test.solution("()))((()");
		System.out.println(answer);
	}
}

class Solution {
    public String solution(String p) {
        String answer = "";
        
        answer = change(p);
        
        return answer;
    }
    
    public String change(String str) {
    	String result = "";
    	
    	int open = 0;
    	int close = 0;
    	int pivot = 0;
    	boolean correct = true;
    	
    	// 1단계
    	if(str.equals("")) {
    		return "";
    	}
    	
    	// 2단계
    	for(int i = 0; i < str.length(); i++) {
    		if(str.charAt(i)=='(') {
    			open++;
    		}
    		else {
    			close++;
    		}
    		
    		if(open == close) {
    			pivot = i;
    			break;
    		}
    		
    		if(open < close) {
    			correct = false;
    		}
    	}
    	
    	// 3단계
    	if(correct == true) {
    		result += str.substring(0,pivot+1);
        	if(pivot+1 < str.length()) {
        		String newV = change(str.substring(pivot+1));
        		result += newV;
        	}
    	}
    	// 4단계
    	else {
    		String newStr = "(";
    		if(pivot+1 < str.length()) {
    			newStr += change(str.substring(pivot+1));
    		}
    		newStr += ")";
    		
    		for(int i = 1; i < pivot; i++) {
    			if(str.charAt(i)=='(') {
    				newStr += ')';
    			}
    			else {
    				newStr += '(';
    			}
    		}
    		result += newStr;
    	}
    	

    	
    	return result;
    }
}