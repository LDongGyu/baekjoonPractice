package programmers;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		
		int answer;
		//String[][] relation;// = new String[6][4];
		
		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};

		
		answer = test.solution(relation);
		System.out.println(answer);

	}
}

class Solution {
    
    int tuple_num = 0;
    int attr_num = 0;
    boolean[] coor;
    int answer = 0;
    String[][] table;
    ArrayList<boolean[]> answer_hubo = new ArrayList<boolean[]>();
    ArrayList<boolean[]> coor_hubo = new ArrayList<boolean[]>();
    
    public int solution(String[][] relation) {
        
        tuple_num = relation.length;
        attr_num = relation[0].length;
        coor = new boolean[attr_num];
        table = relation;
        
        search(0);
        except();
        answer = coor_hubo.size();
        return answer;
    }
    
    public void search(int len){
        if(len == attr_num){
        	check();
            return;
        }
        
        coor[len] = false;
        search(len+1);
        coor[len] = true;
        search(len+1);
    }
    
    public void check() {
    	int count = 0;
    	int coor_len = 0;
    	boolean flag = true;
    	
    	String[] new_data = new String[tuple_num];
    	
    	for(int i = 0; i < tuple_num; i++) {
    		for(int j = 0; j < attr_num; j++) {
    			if(coor[j]==true) {
    				count++;
    				new_data[i] += table[i][j];  
    			}
    		}
    		if(count==0) {
    			return;
    		}
    	}
    	
    	for(int i = 0; i < tuple_num; i++) {
    		for(int j = i+1; j < tuple_num; j++) {
    			if(new_data[i].equals(new_data[j])) {
    				return;
    			}
    		}
    	}
    	

    	answer_hubo.add(coor.clone());
    	answer++;
    	return;
    }
    
    public void except() {
    	
    	int count = 0;
    	int true_cnt = 0;
    	int temp_cnt = 0;
    	boolean no = false;
    	
    	for(int i = 0; i < attr_num; i++) {
    		for(int j = 0; j < answer_hubo.size();j++) {
    			for(int h = 0; h <attr_num; h++) {
    				if(answer_hubo.get(j)[h] == true) {
    					count++;
    				}
    			}
    			if(count-1 == i) {
    				for(int l = 0; l < coor_hubo.size(); l++) { // ºñ±³
    					for(int h=0; h < attr_num; h++) {
    						if(coor_hubo.get(l)[h]==true && answer_hubo.get(j)[h]==true) {
    							true_cnt++;
    						}
    					}
    					for(int h =0; h < attr_num; h++) {
    						if(coor_hubo.get(l)[h]==true) {
    							temp_cnt++;
    						}
    					}
    					if(true_cnt==temp_cnt) {
    						no = true;
    						break;
    					}
    					true_cnt = 0;
    					temp_cnt = 0;
    				}
    				if(!no) {
    					coor_hubo.add(answer_hubo.get(j));
    				}
    				no=false;
    			}
    			count = 0;
    		}
    	}
    }
}
	