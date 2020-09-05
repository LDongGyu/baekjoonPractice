package samsung_sw;

import java.util.*;

public class Main {

	
	
	public static void main(String args[]) throws Exception
	{
		
		System.out.println(solution(new int[][]{{-20,15},{-14,-5},{-18,-13},{-5,-3}}));
	}
	
    public static int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        int standard = Integer.MIN_VALUE;
        
        for(int[] item : routes) {
        	if(item[0] > standard) {
        		answer++;
        		standard = item[1];
        	}
        }
        
        return answer;
    }
}