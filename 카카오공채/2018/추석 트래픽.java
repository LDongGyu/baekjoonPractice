package programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String[] lines = new String[] {
				"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"
		};
		System.out.println(sol.solution(lines));
	}	
}

class Solution {
	
	public int solution(String[] lines) {
		int answer = 0;
		int max = 0;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date tempDate = new Date();
		Time[] parsingTime = new Time[lines.length];
		
		for(int i = 0; i < lines.length; i++) {
			parsingTime[i] = new Time();
			String[] line = lines[i].split(" ");
			String date = line[0] + " " + line[1];
			String during = line[2].replaceAll("s","");
			try {
				tempDate = format.parse(date);
				parsingTime[i].end = tempDate.getTime();
				parsingTime[i].start =  (long) (tempDate.getTime() - (Double.parseDouble(during)*1000)+1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		int countStart = 0;
		int countEnd = 0;
		for(int i = 0; i < lines.length; i++) {
			for(int j = 0; j < lines.length; j++) {
				if(parsingTime[i].start <= parsingTime[j].end && parsingTime[i].start + 999 >= parsingTime[j].start) {
					countStart++;
				}
				if(parsingTime[i].end <= parsingTime[j].end && parsingTime[i].end + 999 >= parsingTime[j].start) {
					countEnd++;
				}
			}
			
			if(max < countStart) max =countStart;
			if(max < countEnd) max = countEnd;
			countStart = 0;
			countEnd =0;
		}
		
		answer = max;
		
	    return answer;
	}
}

class Time{
	long start;
	long end;	
}