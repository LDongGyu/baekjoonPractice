package programmers;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        
        // ������ ī����
        for(String startPlayer : participant){
            hashMap.put(startPlayer,hashMap.getOrDefault(startPlayer, 0)+1);    
        }
        
        // ������ ī����
        for(String endPlayer : completion){
            hashMap.put(endPlayer,hashMap.get(endPlayer)-1);
        }
        
        // ���� ���� ��� ã��
        for(Map.Entry<String, Integer> entry : hashMap.entrySet()){
            if(entry.getValue() != 0){
                answer = entry.getKey();
                break;
            }
        }
        
        return answer;
    }
}