package programmers;

import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution answer = new Solution();
		
		System.out.println(answer.solution("FRANCE", "french"));
		
	}
	
}

class Solution {
	  public int solution(String str1, String str2) {
	      int answer = 0;
	      String temp = new String();
	      
	      str1 = str1.toLowerCase();
	      str2 = str2.toLowerCase();
	      
	      ArrayList<String> str1Set = new ArrayList<String>();
	      ArrayList<String> str2Set = new ArrayList<String>();
	      HashMap<String, Integer> str1Map = new HashMap<>();
	      HashMap<String, Integer> str2Map = new HashMap<>();
	      
	      // str1 ÆÄ½Ì
	      for(int i = 0; i < str1.length()-1; i++) {
	    	  temp = str1.substring(i,i+2);
	    	  if(temp.charAt(0)>='a' && temp.charAt(0)<='z' && temp.charAt(1)>='a' && temp.charAt(1)<='z') {
	    		  str1Set.add(temp);
	    	  }
	      }
	      
	      for(int i = 0; i < str1Set.size(); i++) {
	    	  if(str1Map.containsKey(str1Set.get(i))){
	    		  str1Map.put(str1Set.get(i),str1Map.get(str1Set.get(i))+1);
	    	  }
	    	  else {
	    		  str1Map.put(str1Set.get(i),1);
	    	  }
	      }

	      // str2 ÆÄ½Ì
	      for(int i = 0; i < str2.length()-1; i++) {
	    	  temp = str2.substring(i,i+2);
	    	  if(temp.charAt(0)>='a' && temp.charAt(0)<='z' && temp.charAt(1)>='a' && temp.charAt(1)<='z') {
	    		  str2Set.add(temp);
	    	  }
	      }
	      
	      for(int i = 0; i < str2Set.size(); i++) {
	    	  if(str2Map.containsKey(str2Set.get(i))){
	    		  str2Map.put(str2Set.get(i),str2Map.get(str2Set.get(i))+1);
	    	  }
	    	  else {
	    		  str2Map.put(str2Set.get(i),1);
	    	  }
	      }
	      
	      Set<String> str1Key = str1Map.keySet();
	      Set<String> str2Key = str2Map.keySet();
	      
	      int union = 0;
	      int plus = 0;
	      // ±³ÁýÇÕ
	      for(String key: str1Key) {
	    	  if(str2Map.containsKey(key)) {
	    		  if(str1Map.get(key)<str2Map.get(key)) {
	    			  union += str1Map.get(key);
	    		  }
	    		  else {
	    			  union += str2Map.get(key);
	    		  }
	    	  }
	      }
	      
	      // ÇÕÁýÇÕ
	      for(String key: str1Key) {
	    	  if(str2Map.containsKey(key)) {
	    		  if(str1Map.get(key)<str2Map.get(key)) {
	    			  plus += str2Map.get(key);
	    		  }
	    		  else {
	    			  plus += str1Map.get(key);
	    		  }
	    		  str2Map.remove(key);
	    	  }
	    	  else {
	    		  plus += str1Map.get(key);
	    	  }
	      }
	      
	      for(String key: str2Key) {
	    	  plus += str2Map.get(key);
	      }
	      
	      double rate = (double) union/plus * 65536;
	      answer = (int)rate;
	      
	      return answer;
	  }
}