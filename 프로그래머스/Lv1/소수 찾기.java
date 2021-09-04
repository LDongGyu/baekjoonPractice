package samsung_sw;

class Main {
  public static void main(String[] args) throws Exception {
	  Solution answer = new Solution();
	  int result = answer.solution(5);
	  System.out.print(result);
  }
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        boolean[] map = new boolean[n+1];
        
        for(int i = 2; i <= Math.sqrt(n); i++) {
        	for(int j = 2; j*i <= n; j++) {
        		map[j*i] = true;
        	}
        }
        
        for(int i = 2; i <= n; i++) {
        	if(!map[i]) answer++;
        }
        
        return answer;
    }
}