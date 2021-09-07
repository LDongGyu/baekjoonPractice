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
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i = 0; i < absolutes.length; i++){
            if(signs[i]){
                answer += absolutes[i];
            }
            else{
                answer -= absolutes[i];
            }
        }
        
        return answer;
    }
}