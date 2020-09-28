package samsung_sw;

import java.util.*;

public class Main {

	public static void main(String args[]) throws Exception
	{
		
		System.out.println(solution(new int[]{1,2,3,4}));
	}
	
    public static int solution(int[] nums) {
        int answer = 0;

        for(int i = 0; i < nums.length; i++) {
        	for(int j = i+1; j < nums.length; j++) {
        		for(int h = j+1; h < nums.length; h++) {
        			if(isPrime(nums[i] + nums[j] + nums[h])) answer++;
        		}
        	}
        }

        return answer;
    }
    
    public static boolean isPrime(int num) {
    	for(int i = 2; i < num; i++) {
    		if(num%i == 0) return false;
    	}
    	return true;
    }
}