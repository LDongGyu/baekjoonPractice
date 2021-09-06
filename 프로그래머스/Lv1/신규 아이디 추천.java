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
        String answer = new_id.toLowerCase(); // <1�ܰ�>

        answer = answer.replaceAll("[^-_.a-z0-9]",""); // <2�ܰ�>
        answer = answer.replaceAll("[.]{2,}","."); // <3�ܰ�>
        answer = answer.replaceAll("^[.]|[.]$",""); // <4�ܰ�>
        if(answer.equals("")) answer += "a"; // <5�ܰ�>
        if(answer.length() >=16){ // <6�ܰ�>
            answer = answer.substring(0,15);
            answer = answer.replaceAll("^[.]|[.]$",""); // �� �������� .�� ���
        }
        if(answer.length()<=2){ // <7�ܰ�>
            while(answer.length()<3)
            	answer += answer.charAt(answer.length()-1);
	}
        return answer;
    }
}