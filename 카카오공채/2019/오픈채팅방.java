package programmers;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		String[] answer;

		answer = test.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        String[][] recordParsing = new String[record.length][3];
        HashMap<String, String> idMap = new HashMap<>();
        int count = 0;
        
        for(int i = 0; i < record.length; i++) {
        	recordParsing[i] = record[i].split(" ");
        	if(recordParsing[i][0].equals("Enter")) {
        		idMap.put(recordParsing[i][1], recordParsing[i][2]);
        		count++;
        	}
        	else if(recordParsing[i][0].equals("Change")) {
        		idMap.put(recordParsing[i][1], recordParsing[i][2]);
        	}
        	else {
        		count++;
        	}
        }
        
        answer = new String[count];
        int j = 0;
        for(int i = 0; i < recordParsing.length; i++) {
        	if(recordParsing[i][0].equals("Enter")) {
        		answer[j] = idMap.get(recordParsing[i][1])+"´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.";
        		j++;
        	}
        	else if(recordParsing[i][0].equals("Leave")) {
        		answer[j] = idMap.get(recordParsing[i][1])+"´ÔÀÌ ³ª°¬½À´Ï´Ù.";
        		j++;
        	}
        	else {
        		
        	}
        }
        
        return answer;
    }
}