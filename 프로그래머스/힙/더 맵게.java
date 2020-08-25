import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> scovilleQueue = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++){
            scovilleQueue.offer(scoville[i]);
        }
        
        while(scovilleQueue.peek() < K){
            if(scovilleQueue.size() == 1){
                return -1;
            }
            int first = scovilleQueue.poll();
            int second = scovilleQueue.poll();
            
            scovilleQueue.offer(first+second*2);
            answer++;
        }
        
        return answer;
    }
}