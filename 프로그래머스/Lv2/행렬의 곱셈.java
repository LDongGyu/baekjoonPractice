package samsung_sw;

import java.util.*;

public class Main {

	public static void main(String args[]) throws Exception
	{
		Solution solution = new Solution();
		System.out.println(solution.solution(new int[][]{{1,4},{3,2},{4,1}},new int[][]{{3,3},{3,3}}));
	}
	
}

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int i = 0; i < answer.length; i++) {
        	for(int j = 0; j < answer[i].length; j++) {
        		for(int h = 0; h < arr1[i].length; h++) {
        			answer[i][j] += arr1[i][h] * arr2[h][j]; 
        		}
        	}
        }
        return answer;
    }
}