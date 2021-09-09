package samsung_sw;

import java.util.*;

class Main {
  public static void main(String[] args) throws Exception {
	  Solution answer = new Solution();
//	  String result = answer.solution(3,20,4);
//	  System.out.print(result);
  }
}

class Solution {
    public String solution(int[][] scores) {
        String answer = "";
        
        int sum;
        int max;
        int min;
        int maxIndex;
        int minIndex;
        
        for(int i = 0; i < scores.length; i++) {
        	sum = 0;
        	max = -1;
        	min = 101;
        	for(int j = 0; j < scores.length; j++) {
        		sum += scores[j][i];
        		if(max < scores[j][i] && i != j) {
        			max = scores[j][i];
        		}
        		if(min > scores[j][i] && i != j) {
        			min = scores[j][i];
        		}
        	}
        	
        	double avg = 0.0;
        	if(max < scores[i][i] || min > scores[i][i]) {
        		sum -= scores[i][i];
        		avg = sum/(scores.length-1);
        	}
        	else {
        		avg = sum/scores.length;
        	}
        	
        	if(avg >= 90) {
        		answer += "A";
        	}
        	else if(avg >= 80 && avg < 90) {
        		answer += "B";
        	}
        	else if(avg >= 70 && avg < 80) {
        		answer += "C";
        	}
        	else if(avg >= 50 && avg < 70) {
        		answer += "D";
        	}
        	else {
        		answer += "F";
        	}
        }
        return answer;
    }
}