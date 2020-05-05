package programmers;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String[] lines = new String[] {
			"2016-09-15 20:59:57.421 0.351s",
			"2016-09-15 20:59:58.233 1.181s",
			"2016-09-15 20:59:58.299 0.8s",
			"2016-09-15 20:59:58.688 1.041s",
			"2016-09-15 20:59:59.591 1.412s",
			"2016-09-15 21:00:00.464 1.466s",
			"2016-09-15 21:00:00.741 1.581s",
			"2016-09-15 21:00:00.748 2.31s",
			"2016-09-15 21:00:00.966 0.381s",
			"2016-09-15 21:00:02.066 2.62s"
		};
		System.out.println(sol.solution(lines));
	}	
}

class Solution {
	
	public int solution(String[] lines) {
		int answer = 1;
		int max = 0;
		
	    Time[] parsing = new Time[lines.length];
	    
	    for(int line = 0; line < lines.length; line++) {
	    	parsing[line] = new Time();
	    	parsing[line].parsing(lines[line]);
	    }
	    
	    // ���۽ð� �������� �˻�
	    for(int num = 0; num < lines.length; num++) {
	    	for(int comp = num+1; comp < lines.length; comp++) {
	    		if(Time.between(parsing[num], parsing[comp],1)) {
	    			answer++;
	    		}
	    	}
	    	if(max < answer) {
	    		max = answer;
	    	}
	    	answer = 1;
	    }
	    
	    // ����ð� �������� �˻�
	    
	    answer = max;
	    		
	    return answer;
	}
}

class Time{
	int startHour;
	int startMin;
	double startSecond;
	int endHour;
	int endMin;
	double endSecond;
	double during;
	
	public Time(){
	}
	
	void parsing(String time) {
		String[] parsingStr = time.split(" ");
		String dummyTime = parsingStr[1];
		String dummyDuring = parsingStr[2];
		
		dummyDuring = dummyDuring.replaceAll("s", "");
		during = Double.parseDouble(dummyDuring);
		
		String[] parsingTime = dummyTime.split(":");
		endHour = Integer.parseInt(parsingTime[0]);
		endMin = Integer.parseInt(parsingTime[1]);
		endSecond = Double.parseDouble(parsingTime[2]);
		
		if((endSecond - during + 0.001) >= 0) {
			startHour = endHour;
			startMin = endMin;
			startSecond = endSecond - during + 0.001;
		}
		else {
			if(endMin > 0) { // �� �� �ִٸ�
				startHour = endHour;
				startMin = endMin - 1;
				startSecond = endSecond - during + 60.001;
				startSecond = Double.parseDouble(String.format("%.3f", startSecond));
			}
			else { // �� �� ���ٸ�
				startHour = endHour - 1;
				startMin = 59;
				startSecond = endSecond - during + 60.001;
				startSecond = Double.parseDouble(String.format("%.3f", startSecond));
			}
		}
	}
	
	static boolean between(Time first, Time second, int mode) {
		// mode�� 1�̸� ���� ����, 2�� ������ �ð� ����
		Time standard = new Time();
		if(mode == 1) {
			standard.startHour = first.startHour;
			standard.startMin = first.startMin;
			standard.startSecond = first.startSecond;
			
			if(first.startSecond < 59) {
				standard.endHour = first.startHour;
				standard.endMin = first.startMin; 
				standard.endSecond = first.startSecond + 1;
			}
			else {
				if(first.startMin < 59) {
					standard.endHour = first.startHour;
					standard.endMin = first.startMin + 1;
					standard.endSecond = first.startSecond + 1 - 60;
				}
				else {
					standard.endHour = first.startHour + 1;
					standard.endMin = 0;
					standard.endSecond = first.startSecond + 1 - 60;
				}
			}
		}
		else {
			standard.startHour = first.endHour;
			standard.startMin = first.endMin;
			standard.startSecond = first.endSecond;
			
			if(first.endSecond < 59) {
				standard.endHour = first.endHour;
				standard.endMin = first.endMin; 
				standard.endSecond = first.endSecond + 1;
			}
			else {
				if(first.endMin < 59) {
					standard.endHour = first.endHour;
					standard.endMin = first.endMin + 1;
					standard.endSecond = first.endSecond + 1 - 60;
				}
				else {
					standard.endHour = first.endHour + 1;
					standard.endMin = 0;
					standard.endSecond = first.endSecond + 1 - 60;
				}
			}
		}
		
		// ���� �ð��� �������� ������?
			// ������ �ð��� ���� ���� �ð����� ������?
		// ���� �ð��� ���� ���̿� �ִ°�?
		// ���� �ð��� �������� ������?
		if(standard.startHour > second.startHour) {

			// ������ �������� ������ �ϰ� ���� ���ۺ��� �ʰ� ����
			if(standard.startHour < second.endHour) {
				return true;
			}
			else if(standard.startHour == second.endHour) {
				if(standard.startMin <= second.endHour) {
					return true;
				}
				else {
					return false;
				}
			}
			return true;
		}
		else if(standard.startHour == second.startHour){ // �ð��� ���� ��
			if(standard.startMin > second.startMin) {
				if(standard.startHour < second.endHour) {
					return true;
				}
				else if(standard.startHour == second.endHour) {
					if(standard.startMin <= second.endHour) {
						return true;
					}
					else {
						return false;
					}
				}
				return true;
			}
			else if(standard.startMin == second.startMin){ // �е� ���� ��
				if(standard.startSecond >= second.startSecond) {
					if(standard.startHour < second.endHour) {
						return true;
					}
					else if(standard.startHour == second.endHour) {
						if(standard.startMin <= second.endHour) {
							return true;
						}
						else {
							return false;
						}
					}
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}

	}
}