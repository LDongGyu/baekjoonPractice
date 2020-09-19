package samsung_sw;

import java.util.*;

public class Main {

	
	
	public static void main(String args[]) throws Exception
	{
		
		System.out.println(solution(new int[][]{{2,1}}));
	}
    public static int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        
        for(int i = 0; i<triangle.length-1;i++) {
        	for(int j = 0;j<triangle[i].length;j++) {
        		if(dp[i][j]<triangle[i][j]) {
        			dp[i][j] = triangle[i][j];
        		}
        		if(dp[i+1][j]<dp[i][j]+triangle[i+1][j]) {
        			dp[i+1][j] = dp[i][j]+triangle[i+1][j];
        		}
        		if(dp[i+1][j+1]<dp[i][j]+triangle[i+1][j+1]) {
        			dp[i+1][j+1] = dp[i][j]+triangle[i+1][j+1];
        		}
        	}
        }
        int max = 0;
        
        for(int i = 0; i< triangle[triangle.length-1].length;i++) { // 맨 마지막 줄 탐색
        	if(max < dp[triangle.length-1][i]) {
        		max = dp[triangle.length-1][i];
        	}
        }
        answer = max;
        return answer;
    }
}