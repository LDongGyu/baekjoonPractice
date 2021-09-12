package samsung_sw;

import java.util.*;

class Main {
  public static void main(String[] args) throws Exception {
	  Solution answer = new Solution();
	  int[] result = answer.solution(new int[]{145,92,86}, new String[]{"NLW","WNL","LWN"});
	  System.out.print(result);
  }
}

class Solution {
    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        List<Boxer> list = new ArrayList<Boxer>();
        
        int win;
        int lose;
        int more;
        
        for(int i = 0; i < weights.length; i++) {
        	win = 0;
        	lose = 0;
        	more = 0;
        	for(int j = 0; j < head2head[i].length(); j++) {
        		if(head2head[i].charAt(j)=='W') {
        			win++;
        			if(weights[i] < weights[j]) more++;
        		}
        		else if(head2head[i].charAt(j)=='L') {
        			lose++;
        		}
        	}
        	list.add(new Boxer(win,lose,more,weights[i],i+1));
        }
        
        Collections.sort(list);
        for(int i = 0; i < weights.length; i++) {
        	answer[i] = list.get(i).number;
        }
        return answer;
    }
}

class Boxer implements Comparable<Boxer> {
	int win;
	int lose;
	int moreWeightWin;
	int weight;
	int number;
	
	Boxer(int win, int lose, int moreWeightWin, int weight, int number){
		this.win = win;
		this.lose = lose;
		this.moreWeightWin = moreWeightWin;
		this.weight = weight;
		this.number = number;
	}
	
	double getVictory() {
		if(win+lose == 0)
			return 0;
		return (double)win/(win+lose);
	}

	@Override
	public int compareTo(Boxer arg0) {
		if(this.getVictory() > arg0.getVictory()) {
			return -1;
		}
		else if(this.getVictory() == arg0.getVictory()) {
			if(this.moreWeightWin > arg0.moreWeightWin) {
				return -1;
			}
			else if(this.moreWeightWin == arg0.moreWeightWin) {
				if(this.weight > arg0.weight) {
					return -1; 
				}
				else if(this.weight == arg0.weight) {
					if(this.number < arg0.number) {
						return -1;
					}
					else {
						return 1;
					}
				}
				else {
					return 1;
				}
			}
			else {
				return 1;
			}
		}
		else {
			return 1;
		}
	}
}