package samsung_sw;

class Main {
  public static void main(String[] args) throws Exception {
	  Solution answer = new Solution();
	  int[] result = answer.solution("110010101001");
	  
	  System.out.print(result[0]+" "+result[1]);
  }
}

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        String standard = s;
        int count = 0;
        int round = 0;
        
        while(!standard.equals("1")) {
            String newString = "";
            for(int i = 0; i < standard.length(); i++) {
            	if(standard.charAt(i) == '1') {
            		newString += "1";
            	}
            	else {
            		count++;
            	}
            }       
            standard = toBinary(newString.length());
            round++;
        }
        
        answer[0] = round;
        answer[1] = count;
        
        return answer;
    }
    
    public String toBinary(int num) {
    	String result = "";
    	
    	while(num > 1) {
    		if(num%2 == 1) {
    			result = "1" + result;
    			num--;
    		}
    		else {
    			result = "0" + result;
    		}
    		num /= 2;
    	}
    	result = "1" + result;
    	return result;
    }
}