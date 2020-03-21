package programmers;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		int answer;

		answer = test.solution("1S2D*3T");
		System.out.println(answer);
	}
}

class Solution {
	  public int solution(String dartResult) {
	      int answer = 0;
	      int top = 0;
	      ArrayList<Score> scoreList = new ArrayList<>();
	      Score score;
	    
	      while(top < dartResult.length()) {
	    	  score = new Score();
	    	  score.score = getScore(top,dartResult);
	    	  if(score.score == 10) {
	    		  top += 2;
	    	  }
	    	  else {
	    		  top++;
	    	  }
	    	  score.bonus = dartResult.charAt(top);
	    	  top++;
	    	  
	    	  /* 옵션이 있다면 */
	    	  if(top < dartResult.length()) {
		    	  if(dartResult.charAt(top)-'0'<0 || dartResult.charAt(top)-'0'>9) {
		    		  score.opt = dartResult.charAt(top);
		    		  top++;	    		  
		    	  }
	    	  }
	    	  scoreList.add(score);
    	  }
	      
	      int[] scoreArr = new int[scoreList.size()];
	      
//	      for(int i = 0; i < scoreArr.length; i++) {
//	    	  scoreArr[i] = scoreList.get(i).score;
//	      }
	      
	      for(int i = 0; i < scoreArr.length; i++) {
	    	  // bonus
	    	  if(scoreList.get(i).bonus == 'S') {
	    		  scoreArr[i] = scoreList.get(i).score; 
	    	  }
	    	  else if(scoreList.get(i).bonus == 'D') {
	    		  scoreArr[i] = scoreList.get(i).score * scoreList.get(i).score;
	    	  }
	    	  else {
	    		  scoreArr[i] = scoreList.get(i).score * scoreList.get(i).score * scoreList.get(i).score;
	    	  }
	    	  //option
	    	  if(scoreList.get(i).opt == '*') {
	    		  scoreArr[i] *= 2;
	    		  if(i != 0) {
	    			  scoreArr[i-1] *= 2;
	    		  }
	    	  }
	    	  else if(scoreList.get(i).opt == '#') {
	    		  scoreArr[i] *= -1;
	    	  }
	    	  else {
	    		  continue;
	    	  }
	      }
	      
	      for(int i = 0; i < scoreArr.length; i++) {
	    	  answer += scoreArr[i];
	      }
	      
	      return answer;
	  }
	  
	  public int getScore(int start, String str) {
		  int score=0;
		  
		  if(str.charAt(start) == '1') {
			  if(start+1 < str.length()) {
				  if(str.charAt(start+1) == '0') { // 10
					  score = 10;
				  }
				  else {
					  score = 1;
				  }
			  }
			  else {
				  score = 1;
			  }
		  }
		  else {
			  score = str.charAt(start) - '0';
		  }
		  
		  return score;
	  }
}

class Score {
	int score;
	char bonus;
	char opt;
	
	Score(){
		score = 0;
		bonus = 'S';
		opt = 'N';
	}
}