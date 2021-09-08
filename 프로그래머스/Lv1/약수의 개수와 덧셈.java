package samsung_sw;

import java.util.*;

class Main {
  public static void main(String[] args) throws Exception {
	  Solution answer = new Solution();
	  int result = answer.solution(13,17);
	  System.out.print(result);
  }
}

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++) {
        	if(Math.sqrt(i)-(int)Math.sqrt(i) == 0) {
        		answer -= i;
        	}
        	else {
        		answer += i;
        	}
        }
        
        return answer;
    }
}