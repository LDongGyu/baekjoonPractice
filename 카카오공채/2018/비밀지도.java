package programmers;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		String[] answer;
//		answer = test.solution(5, new int[] {9,20,28,18,11}, new int[]{30,1,21,17,28});
		answer = test.solution(6, new int[] {46,33,33,22,31,50}, new int[]{27,56,19,14,14,10});
//		for(int i =0; i<5; i++) {
//			System.out.println(answer[i]);
//		}
//		
	}
}

class Solution {
	  public String[] solution(int n, int[] arr1, int[] arr2) {
	      String[] answer = new String[n];
	      String[] binArr1 = new String[n];
	      String[] binArr2 = new String[n];
	      
	      for(int i = 0; i < n; i++){
	          binArr1[i] = dexToBin(arr1[i], n);
	          binArr2[i] = dexToBin(arr2[i], n);
	      }
	      
	      for(int i = 0; i < n; i++){
	    	  answer[i] = "";
	          for(int j = 0; j < n; j++){
	              if(binArr1[i].charAt(j) == '#' || binArr2[i].charAt(j) == '#'){
	                  answer[i] += "#";
	              }
	              else {
	            	  answer[i] += " ";
	              }
	          }
	          System.out.println(answer[i]);
	      }
	      
	      return answer;
	  }
	  
	  public String dexToBin(int dex, int n){
	      
	      String bin = "";
	      
	      while(dex>0){
	          if(dex%2 == 1){
	              bin = "#" + bin;
	          }
	          else{
	              bin = " " + bin;
	          }
	          dex /= 2;
	      }
	      
	      while(bin.length() < n) {
	    	  bin = " " + bin;
	      }
	      
//	      System.out.println(bin);
	      return bin;
	  }
	}