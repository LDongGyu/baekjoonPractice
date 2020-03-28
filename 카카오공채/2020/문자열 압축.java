package programmers;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		int answer;

		answer = test.solution("a");
				
		System.out.println(answer);
	}
}

class Solution {
    public int solution(String s) {
        int answer = 10000;
        int length = s.length();
        String before = new String();
        String after = new String();
        String temp = new String();
        int top = 0;
        int count = 0;
        
        for(int i = 1; i <= length/2+1 ; i++) {
        	before = s.substring(0,i);

        	while(true) {
        		// 다음을 볼 수 있다면
        		if(top+i <= length) {
	        		after = s.substring(top,top+i);
	        		// 같으면 ++
	        		if(before.equals(after)) {
	        			count++;
	        		}
	        		// 다르면 바꾸기
	        		else {
	        			if(count > 1) {
	        				temp = temp + count + before;
	        			}
	        			else {
	        				temp += before;
	        			}
	        			before = after;
	        			count = 1;
	        		}
	        		top += i;
        		}
        		else {
        			if(count > 1) {
        				temp = temp + count + before + s.substring(top);
        			}
        			else {
        				temp += s.substring(top-i);
        			}
        			break;
        		}
        	}
        	if(answer > temp.length()) {
        		answer = temp.length();
        	}
        	count = 1;
        	top = 0;
        	temp = "";
        }
                
        return answer;
    }
}