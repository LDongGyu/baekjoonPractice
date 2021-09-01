package samsung_sw;

class Main {
  public static void main(String[] args) throws Exception {
	  Solution answer = new Solution();
	  int result = answer.solution("}]()[{");
	  
	  System.out.print(result);
  }
}

class Solution {
    public int solution(String s) {
        int answer = 0;
        String standard = s;
        
        for(int i = 0; i < s.length(); i++) {
        	if(isCorrect(standard)) {
        		answer++;
        	}
        	standard = standard.substring(1) + standard.charAt(0);
        }
        
        return answer;
    }
    
    public boolean isCorrect(String s) {
    	char[] stack = new char[s.length()+1];
    	int top = 0;
    	if(s.charAt(0) == ']' || s.charAt(0) == '}' || s.charAt(0) == ')') {
    		return false;
    	}
    	stack[0] = s.charAt(0);
    	
    	for(int i = 1; i < s.length(); i++) {
    		if(top < 0) {
    			if(s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
    				top++;
    				stack[top] = s.charAt(i);
    			}
    			else {
    				return false;
    			}
    		}
    		else if(stack[top] == '[') {
    			if(s.charAt(i) == '}' || s.charAt(i) == ')') {
    				return false;
    			}
    			else if(s.charAt(i) == ']') {
    				top--;
    			}
    			else {
    				top++;
    				stack[top] = s.charAt(i);
    			}
    		}
    		else if(stack[top] == '(') {
    			if(s.charAt(i) == '}' || s.charAt(i) == ']') {
    				return false;
    			}
    			else if(s.charAt(i) == ')') {
    				top--;
    			}
    			else {
    				top++;
    				stack[top] = s.charAt(i);
    			}
    		}
    		else if(stack[top] == '{') {
    			if(s.charAt(i) == ']' || s.charAt(i) == ')') {
    				return false;
    			}
    			else if(s.charAt(i) == '}') {
    				top--;
    			}
    			else {
    				top++;
    				stack[top] = s.charAt(i);
    			}
    		}
    		else {
    			top++;
				stack[top] = s.charAt(i);
    		}
    	}
    	
    	if(top >= 0) return false;
    	
    	return true;
    }
}