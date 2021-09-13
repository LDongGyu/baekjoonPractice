package samsung_sw;

import java.util.*;

class Main {
  public static void main(String[] args) throws Exception {
	  Solution answer = new Solution();
	  int[] result = answer.solution(new int[]{145,92,86}, new String[]{"NLW","WNL","LWN"});
	  System.out.print(result);
  }
}

class Solution {
    public int solution(int[] numbers) {
        int answer = 45;
        for(int i = 0; i < numbers.length; i++){
            answer -= numbers[i];
        }
        return answer;
    }
}