package programmers;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> clothMap = new HashMap<>();
        
        for(String[] cloth : clothes){
            clothMap.put(cloth[1],clothMap.getOrDefault(cloth[1],0)+1);
        }
        
        for(Map.Entry<String, Integer> entry : clothMap.entrySet()){
            answer *= (entry.getValue()+1);
        }
        
        answer--;
        
        return answer;
    }
}