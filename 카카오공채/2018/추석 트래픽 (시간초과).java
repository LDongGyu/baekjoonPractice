class Solution {
	
	public int solution(String[] lines) {
		int answer = 0;
		int max = 0;
		
	    Transaction[] parsing = new Transaction[lines.length];
	    
	    for(int line = 0; line < lines.length; line++) {
	    	parsing[line] = new Transaction();
	    	parsing[line].parsing(lines[line]);
	    }

	    Transaction standard = new Transaction();
	    Time start = new Time();
	    start.hour = 0;
	    start.min = 0;
	    start.second = 0;
	    Time end = new Time();
	    end.hour = 0;
	    end.min = 0;
	    end.second = 1.0;
	    standard.start = start;
	    standard.end = end;
	    
	    while(true) {
	    	// Å»Ãâ Á¶°Ç 
	    	if(Time.compare(standard.start, parsing[lines.length-1].end)) {
	    		break;
	    	}
	    	
	    	for(int num = 0; num < lines.length; num++) {
	    		if(parsing[num].isBetween(standard)) {
	    			answer++;
	    		}
	    	}
	    	if(max < answer) {
	    		max = answer;
	    	}
	    	standard.add();
	    	answer = 0;
	    }
	    
	    answer = max;
	    		
	    return answer;
	}
}

class Transaction{
	
	Time start;
	Time end;
	double during;
	
	public Transaction(){
		start = new Time();
		end = new Time();
	}
	
	void parsing(String time) {
		String[] parsingStr = time.split(" ");
		String dummyTime = parsingStr[1];
		String dummyDuring = parsingStr[2];
		
		dummyDuring = dummyDuring.replaceAll("s", "");
		during = Double.parseDouble(dummyDuring);
		
		String[] parsingTime = dummyTime.split(":");
		end.hour = Integer.parseInt(parsingTime[0]);
		end.min = Integer.parseInt(parsingTime[1]);
		end.second = Double.parseDouble(parsingTime[2]);
		
		if((end.second - during + 0.001) >= 0) {
			start.hour = end.hour;
			start.min = end.min;
			start.second = end.second - during + 0.001;
		}
		else {
			if(end.min > 0) { // ²Ü ¼ö ÀÖ´Ù¸é
				start.hour = end.hour;
				start.min = end.min - 1;
				start.second = end.second - during + 60.001;
				start.second = Double.parseDouble(String.format("%.3f", start.second));
			}
			else { // ²Ü ¼ö ¾ø´Ù¸é
				start.hour = end.hour - 1;
				start.min = 59;
				start.second = end.second - during + 60.001;
				start.second = Double.parseDouble(String.format("%.3f", start.second));
			}
		}
	}
	
	void add() {
		if(start.second + 0.001 >= 60) {
			if(start.min + 1 >= 60) {
				start.hour++;
				start.min = 0;
				start.second = start.second + 0.001 - 60;
			}
			else {
				start.min++;
				start.second = start.second + 0.001 - 60;
			}
		}
		else {
			start.second += 0.001;
		}
		
		if(end.second + 0.001 >= 60) {
			if(end.min + 1 >= 60) {
				end.hour++;
				end.min = 0;
				end.second = end.second + 0.001 - 60;
			}
			else {
				end.min++;
				end.second = end.second + 0.001 - 60;
			}
		}
		else {
			end.second += 0.001;
		}
	}
	
	boolean isBetween(Transaction standard) {
		if((!Time.compare(standard.start,this.end))&&(!Time.compare(this.start, standard.end))) {
			return true;
		}
		else {
			return false;
		}
	}
}

class Time {
	int hour;
	int min;
	double second;
	
	static boolean compare(Time one, Time two) {
		if(one.hour > two.hour) {
			return true;
		}
		else if(one.hour == two.hour) {
			if(one.min > two.min) {
				return true;
			}
			else if(one.min == two.min){
				if(one.second > two.second) {
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