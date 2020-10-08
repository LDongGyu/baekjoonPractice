package samsung_sw;

import java.util.*;

public class Main {
	
	static int answer = Integer.MIN_VALUE;
	static int length = 0;
	static int[] num;
	static char[] oper;
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		length = Integer.parseInt(sc.nextLine());
		String string = sc.nextLine();
		
		num = new int[length/2+1];
		oper = new char[length/2];
		
		for(int i = 0; i < length; i++) {
			if(i%2==0) num[i/2] = Integer.parseInt(String.valueOf(string.charAt(i)));
			else oper[i/2] = string.charAt(i);
		}
		
		dfs(0,num[0]);
		
		System.out.println(answer);
	}
	
	public static void dfs(int index, int sum) {
		if(index >= length/2) {
			answer = Math.max(answer, sum);
			return;
		}
		
		// 괄호가 없는 경우
		int first = calc(sum,num[index+1],oper[index]);
		dfs(index+1, first);
		
		// 괄호가 있는 경우
		if(index + 1 < length/2) {
			int second = calc(num[index+1],num[index+2],oper[index+1]);
			dfs(index+2,calc(sum,second,oper[index]));
		}
	}
	
	public static int calc(int first, int second, char oper) {
		int result = 0;
		
		switch(oper) {
			case '+' :
				result = first + second;
				break;
			case '-' :
				result = first - second;
				break;
			case '*' :
				result = first * second;
		}
		
		return result;
	}
}