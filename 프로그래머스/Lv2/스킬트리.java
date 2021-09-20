package com.company;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.print(s.solution("CBD",new String[]{"BACDE", "CBADF", "AECB", "BDA","CB"}));
    }
}

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        System.out.println(skill.indexOf("CB"));
        System.out.print(skill.indexOf("BD"));

        for(int i = 0; i < skill_trees.length; i++){
            if(skill.indexOf(skill_trees[i].replaceAll("[^"+skill+"]",""))!=0){
                answer--;
            }
        }

        return answer;
    }
}

//
//class Solution {
//    public int solution(String skill, String[] skill_trees) {
//        int answer = 0;
//        int[] skillIdx = new int[skill.length()];
//        for(int i = 0; i < skill_trees.length; i++){
//            for(int j = 0; j < skill.length(); j++){
//                skillIdx[j] = skill_trees[i].indexOf(skill.charAt(j));
//            }
//            boolean isAnswer = true;
//            for(int j = 0; j < skill.length()-1; j++){
//                if(skillIdx[j+1] == -1){
//                    continue;
//                }
//                if(skillIdx[j] > skillIdx[j+1]){
//                    isAnswer = false;
//                    break;
//                }
//                if(skillIdx[j] == -1 && skillIdx[j+1] != -1){
//                    isAnswer = false;
//                    break;
//                }
//            }
//            if(isAnswer) answer++;
//        }
//        return answer;
//    }
//}