package samsung_sw;

import java.util.*;

class Main {
  public static void main(String[] args) throws Exception {
	  Solution answer = new Solution();
	  int result = answer.solution(45);
	  System.out.print(result);
  }
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        String temp = "";
        
        while(n > 2) {
        	temp = n%3 + temp;
        	n = (n - n%3)/3;
        }
        
        if(n != 0) {
        	temp = n + temp;
        }
        
        for(int i = 0; i < temp.length(); i++) {
        	answer += (temp.charAt(i) - '0') * Math.pow(3, i);
        }
        
        return answer;
    }
}

//class Solution {
//    public int solution(int n) {
//        String a = "";
//
//        while(n > 0){
//            a = (n % 3) + a;
//            n /= 3;
//        }
//        a = new StringBuilder(a).reverse().toString();
//
//
//        return Integer.parseInt(a,3);
//    }
//}