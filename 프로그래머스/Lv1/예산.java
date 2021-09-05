package samsung_sw;

import java.util.*;

class Main {
  public static void main(String[] args) throws Exception {
	  Solution answer = new Solution();
	  int result = answer.solution(new int[] {1,3,2,5,4},9);
	  System.out.print(result);
  }
}

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int i = 0; i < d.length; i++) {
        	if(budget-d[i] >= 0) {
        		answer++;
        		budget -= d[i];
        	}
        }
        return answer;
    }
}