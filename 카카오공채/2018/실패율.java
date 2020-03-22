package programmers;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		int[] answer;

		answer = test.solution(5, new int[] {2,1,2,6,2,4,3,3});
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Score[] scoreArr = new Score[N];
        int allClearPlayer = 0;
        double[] rate = new double[N];
        boolean[] check = new boolean[N];

        Arrays.fill(check, false);
        for(int i = 0; i < N; i++) {
        	scoreArr[i] = new Score();
        }
    	/* 현재 플레이어 위치 카운팅 */
        for(int i = 0; i < stages.length; i++){
            if(stages[i]<N+1){
                scoreArr[stages[i]-1].nowPlayer++;
            }
            else{
                allClearPlayer++;
            }
        }
        
        /* 스테이지에 도달한 플레이어 저장 */
        for(int i = 0; i < N; i++) {
        	for(int j = i; j < N; j++) {
        		scoreArr[i].endPlayer += scoreArr[j].nowPlayer;
        	}
        	scoreArr[i].endPlayer += allClearPlayer;
        	if(scoreArr[i].endPlayer == 0) {
        		rate[i] = 0;
        	}
        	else {
        		rate[i] = (double)scoreArr[i].nowPlayer / scoreArr[i].endPlayer;
        	}
        }
        
        double biggestRate = 0;
        int index = 0;
        
        for(int i = 0; i < N; i++) {
        	biggestRate = -1;
    		index = -1;
        	for(int j = 0; j < N; j++) {
        		if(check[j] == false && biggestRate < rate[j]) {
        			biggestRate = rate[j];
        			index = j;
        		}
        	}
        	answer[i] = index+1;
        	check[index] = true;
        }
        
        return answer;
    }
}

class Score {
    int endPlayer;
    int nowPlayer;
    
    Score(){
        endPlayer = 0;
        nowPlayer = 0;
    }
}