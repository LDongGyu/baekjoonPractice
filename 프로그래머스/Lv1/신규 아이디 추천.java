package samsung_sw;

import java.util.*;

class Main {
  public static void main(String[] args) throws Exception {
	  Solution answer = new Solution();
	  String result = answer.solution("=.=");
	  System.out.print(result);
  }
}

class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase(); // <1단계>

        answer = answer.replaceAll("[^-_.a-z0-9]",""); // <2단계>
        answer = answer.replaceAll("[.]{2,}","."); // <3단계>
        answer = answer.replaceAll("^[.]|[.]$",""); // <4단계>
        if(answer.equals("")) answer += "a"; // <5단계>
        if(answer.length() >=16){ // <6단계>
            answer = answer.substring(0,15);
            answer = answer.replaceAll("^[.]|[.]$",""); // 맨 마지막이 .인 경우
        }
        if(answer.length()<=2){ // <7단계>
            while(answer.length()<3)
            	answer += answer.charAt(answer.length()-1);
	}
        return answer;
    }
}