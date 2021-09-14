package samsung_sw;

import java.util.*;

class Main {
  public static void main(String[] args) throws Exception {
	  Solution answer = new Solution();
	  int result = answer.solution(78);
	  System.out.print(result);
  }
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = 0;
        String bin = Integer.toBinaryString(n);
        for(int i = 0; i < bin.length(); i++) {
        	if(bin.charAt(i) == '1') count++;
        }
        
        boolean isFind = false;
        int idx = 1;
        while(!isFind) {
        	String next = Integer.toBinaryString(n+idx);
        	int cnt = 0;
        	for(int i = 0; i < next.length(); i++) {
            	if(next.charAt(i) == '1') cnt++;
            }
        	if(count == cnt) {
        		answer = n+idx;
        		isFind = true;
        	}
        	idx++;
        }
        return answer;
    }
}

//int a = Integer.bitCount(n);
//int compare = n+1;
//
//while(true) {
//  if(Integer.bitCount(compare)==a)
//    break;
//  compare++;
//}
