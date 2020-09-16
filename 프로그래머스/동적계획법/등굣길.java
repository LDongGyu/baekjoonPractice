package samsung_sw;

import java.util.*;

public class Main {

	
	
	public static void main(String args[]) throws Exception
	{
		
		System.out.println(solution(3,1,new int[][]{{2,1}}));
	}
    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n][m];

        map[0][0] = 1;
        
        for(int[] puddle : puddles) {
        		map[puddle[1]-1][puddle[0]-1] = -1;
        }
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < m; j++) {
        		if(map[i][j] != -1) {
        			if(i > 0) map[i][j] += map[i-1][j]%1000000007;
        			if(j > 0) map[i][j] += map[i][j-1]%1000000007;
        		}
        		else{
        			map[i][j] = 0;
        		}
        		
        	}
        }
        
        answer = map[n-1][m-1]%1000000007;
        return answer;
    }
}