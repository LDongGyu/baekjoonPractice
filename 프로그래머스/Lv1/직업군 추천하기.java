package samsung_sw;

import java.util.*;

class Main {
  public static void main(String[] args) throws Exception {
	  Solution answer = new Solution();
//	  String result = answer.solution(3,20,4);
//	  System.out.print(result);
  }
}

class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int max = 0;

        for(int i = 0; i < table.length; i++){
            String[] row = table[i].split(" ");
            int sum = 0;
            for(int j = 1; j < row.length; j++){
                for(int h = 0; h < languages.length; h++){
                    if(row[j].equals(languages[h])){
                        sum += preference[h] * (6-j);
                    }
                }
            }
            if(max < sum){
                max = sum;
                answer = row[0];
            }
            if(max == sum){
                if(answer.compareTo(row[0]) > 0){
                    answer = row[0];
                }
            }
        }
            return answer;
    }
}