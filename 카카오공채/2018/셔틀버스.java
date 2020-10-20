package samsung_sw;

import java.util.*;

public class Main {

	public static void main(String args[])
	{
		Solution sol = new Solution();
		System.out.println(sol.solution(1, 1, 5, new String[]{"08:00","08:01","08:02","08:03"}));
		System.out.println(sol.solution(2, 10, 2, new String[]{"09:10","09:09","08:00"}));
		System.out.println(sol.solution(2, 1, 2, new String[]{"09:00","09:00","09:00","09:00"}));
		System.out.println(sol.solution(1, 1, 5, new String[]{"00:01","00:01","00:01","00:01","00:01"}));
		System.out.println(sol.solution(1, 1, 1, new String[]{"23:59"}));
		System.out.println(sol.solution(10, 60, 45, new String[]{"23:59","23:59","23:59","23:59","23:59","23:59","23:59",
		                                                          "23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59"}));
	}
	
}

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int time = 540;
        ArrayList<Integer> timeTable = new ArrayList<>();
        for(int i = 0; i < timetable.length; i++) {
        	timeTable.add(Integer.parseInt(timetable[i].split(":")[0]) * 60 + Integer.parseInt(timetable[i].split(":")[1]));
        }
        
        Collections.sort(timeTable);
        int nowTime = 540;
        int answerTime = 540;
        int bus = 0;
        int people = 0;
        int lastPeople = 0;
        boolean center = false;

        for(int i = 0; i < n-1; i++) {
        	for(int j = 0; j < m; j++) {
        		if(timeTable.get(0) <= nowTime) timeTable.remove(0);
        	}
        	nowTime += t;
        }
        
        // 남은 사람들이 버스를 다 채울 수 있을 때 마지막보다 1분 빠르게
        if(timeTable.size() >= m) {
        	if(timeTable.get(m-1) <= nowTime) answerTime = timeTable.get(m-1) -1;
        	else answerTime = nowTime;
        }
        // 마지막 버스가 자리가 남으면
        if(timeTable.size() > 0 && timeTable.size() < m) {
        	answerTime = nowTime;
        }
//        
//        
//        for(int i = 0; i < timetable.length; i++) {
//    		if(i == n*m-1) {
//    			center = true;
//    			break;
//    		}
//    		if(timeTable.get(0) <= nowTime) {
//    			timeTable.remove(0);
//    			people++;
//    		}
//    		else {
//    			i--;
//    			nowTime += t;
//    			bus++;
//    			people = 0;
//    		}
//    		// 다 태웠으면
//    		if(people == m) {
//    			nowTime += t;
//    			bus++;
//    			people = 0;
//    		}
//    	}
//    	
//        if(center) answerTime = timeTable.get(0)-1;
//        
//    	
        // 정답 출력
        int hour = (answerTime - answerTime%60)/60;
        int min = answerTime%60;
        
        if(hour < 10) answer += String.format("0%d:", hour);
        else answer += String.format("%d:", hour);
        
        if(min < 10) answer += String.format("0%d", min);
        else answer += String.format("%d", min);
        
        return answer;
    }
}