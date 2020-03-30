package programmers;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		int answer;

		answer = test.solution(3,new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"});
				
		System.out.println(answer);
	}
}

class Solution {
	  public int solution(int cacheSize, String[] cities) {

		  int answer = 0;
	      String[] cache = new String[cacheSize];
	      int top = -1;
	      boolean check = false;
	      
	      if(cacheSize == 0) {
	    	  answer = cities.length * 5;
	    	  return answer;
	      }
	      
	      for(int i = 0; i < cities.length; i++) {
	    	  check = false;
	    	  for(int j = 0; j <= top; j++) {
	    		  // 캐시에 있다면
	    		  if(cache[j].equals(cities[i].toLowerCase())) {
	    			  check = true;
	    			  answer += 1;
	    			  for(int h = j-1; h >= 0; h--) {
	    				  if(h+1 < cacheSize) {
	    					  cache[h+1] = cache[h];
	    				  }
	    			  }
	    			  cache[0] = cities[i].toLowerCase();
	    			  break;
	    		  }
	    	  }
	    	  // 캐시에 없다면
	    	  if(check == false) {
	    		  answer += 5;
	    		  for(int h = top; h >= 0; h--) {
	    			  if(h+1 < cacheSize) {
	    				  cache[h+1] = cache[h];
	    			  }
    			  }
    			  cache[0] = cities[i].toLowerCase();
    			  if(top < cacheSize-1) {
    				  top++;
    			  }
	    	  }
	      }
	      
	      return answer;
	 }
} 