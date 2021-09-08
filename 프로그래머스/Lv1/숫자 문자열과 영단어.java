package samsung_sw;

import java.util.*;

class Main {
  public static void main(String[] args) throws Exception {
	  Solution answer = new Solution();
	  int result = answer.solution("2three45sixseven");
	  System.out.print(result);
  }
}

class Solution {
	public String[] number = {"ze", "on", "tw", "th", "fo", "fi", "si", "se", "ei", "ni"};
	public int[] length = {4,3,3,5,4,4,3,5,5,4};
	
    public int solution(String s) {
        String answer = "";
        
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
        		answer = answer + s.charAt(i);
        	}
        	else {
        		for(int j = 0; j < 10; j++) {
        			if(number[j].equals(s.substring(i, i+2))) {
        				answer = answer + Integer.toString(j);
        				i += length[j] -1;
        				break;
        			}
        		}
        	}
        }
        
        return Integer.parseInt(answer);
    }
}

//import java.util.*;
//
//class Solution {
//    public int solution(String s) {
//        int answer = 0;
//        StringBuilder sb = new StringBuilder("");
//        int len = s.length();
//        String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
//        String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};
//
//        for(int i=0; i<10; i++){
//            s = s.replaceAll(alphabets[i],digits[i]);
//        }
//
//        return Integer.parseInt(s);
//    }
//}