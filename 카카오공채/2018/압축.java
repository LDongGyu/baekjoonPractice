package programmers;
import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		int[] answer;
		answer = test.solution("KAKAO");
		System.out.println(answer);
	}
}

class Solution {
	  public int[] solution(String msg) {
	      int[] answer = {};
	      ArrayList<Integer> answerList = new ArrayList<>();
	      HashMap<String,Integer> dict = new HashMap<>();
	      int index = 27;
	      
	      for(int i = 0; i < 26; i++) {
	    	  dict.put(String.valueOf((char)(65+i)), i+1);
	      }
	      
	      int top = 0;
	      while(top < msg.length()) {
	    	  for(int i = msg.length(); i > 0; i--) {
	    		  if(dict.containsKey(msg.substring(top, i))) {
	    			  answerList.add(dict.get(msg.substring(top, i)));
	    			  if(i+1 <= msg.length()) {
	    				  dict.put(msg.substring(top, i+1),index);
	    			  }
	    	    	  top += msg.substring(top,i).length();
	    			  index++;
	    			  break;
	    		  }
	    	  }
	      }
	      
	      answer = new int[answerList.size()];
	      for(int i = 0; i < answer.length; i++) {
	    	  answer[i] = answerList.get(i);
	      }
	      return answer;
	  }
	}