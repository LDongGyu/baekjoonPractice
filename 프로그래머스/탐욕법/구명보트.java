package samsung_sw;

import java.util.*;

public class Main {

	
	
	public static void main(String args[]) throws Exception
	{
		
		System.out.println(solution(new int[]{40,40,40},100));
	}
	
    public static int solution(int[] people, int limit) {
        int answer = 0;
        int i = 0;
        int j = 0;
        Arrays.sort(people);

        for(j = people.length-1; i <= j; j--) {
        	if(people[i] + people[j] <= limit) {
        		answer++;
        		i++;
        	}
        	else {
        		answer++;
        	}
        }

        return answer;
    }
}