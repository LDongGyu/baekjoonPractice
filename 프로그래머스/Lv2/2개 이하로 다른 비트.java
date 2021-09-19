package com.company;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.print(s.solution(new long[]{2L})[0]);
    }
}

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            String s = "0" + Long.toBinaryString(numbers[i]);
            char[] standard = s.toCharArray();
            for(int j = standard.length-1; j > 0; j--){
                if(standard[j] == '0'){
                    standard[j] = '1';
                    break;
                }
                else if(standard[j] == '1' && standard[j-1] == '0'){
                    standard[j] = '0';
                    standard[j-1] = '1';
                    break;
                }
            }
            answer[i] = toDec(standard);
        }

        return answer;
    }

    public long toDec(char[] c){
        long result = 0;

        for(int i = c.length-1; i >= 0; i--){
            if(c[i] == '1') result += Math.pow(2,c.length-1 -i);
        }

        return result;
    }
}

//class Solution {
//    public long[] solution(long[] numbers) {
//        long[] answer = new long[numbers.length];
//
//        for(int i = 0; i < numbers.length; i++){
//            String standard = Long.toBinaryString(numbers[i]);
//            int index = 1;
//            while(true){
//                String next = Long.toBinaryString(numbers[i]+index);
//                int count = 0;
//                for(int j = 0; j < standard.length(); j++){
//                    if(standard.charAt(standard.length()-1-j) != next.charAt(next.length()-1-j)) count++;
//                    if(count > 2) break;
//                }
//                if(next.length() - standard.length() + count <= 2){
//                    answer[i] = numbers[i]+index;
//                    break;
//                }
//                index++;
//            }
//        }
//
//        return answer;
//    }
//}