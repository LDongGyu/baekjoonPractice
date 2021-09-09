package samsung_sw;

import java.util.*;

class Main {
  public static void main(String[] args) throws Exception {
	  Solution answer = new Solution();
	  long result = answer.solution(3,20,4);
	  System.out.print(result);
  }
}

class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long sum = 0;
        for(int i = 1; i <= count; i++) {
        	sum += price*i;
        }
        
        if(money >= sum) {
        	answer = 0;
        }
        else {
        	answer = sum - money;
        }
        
        return answer;
    }
}