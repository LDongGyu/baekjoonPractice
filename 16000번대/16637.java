package samsung_sw;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int answer = -999999999;
	static int[] num = new int[10];
	static char[] op = new char[10];
	static int op_count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int length;
		String input;
		
		length = Integer.parseInt(sc.nextLine());
		input = sc.nextLine();
		
		/* 숫자랑 연산자 분리 */
		for(int i = 0; i < length/2; i++) {
			num[i] = input.charAt(i*2)-'0';
			op[i] = input.charAt(i*2+1);
		}
		num[length/2] = input.charAt(input.length()-1)-'0';
		
		if(length == 1) {
			System.out.println(num[0]);
		}
		else if(length == 3) {
			System.out.println(calc(num[0],num[1],op[0]));
		}
		else {
			op_count = length/2;
			dfs(0,num[0]);
			System.out.println(answer);
		}
	}
	
	public static void dfs(int count, int result) {
		
		int temp = 0;
		
		if(count >= op_count) {
			answer = Math.max(answer,result);
			return;
		}
		
		temp = calc(result, num[count+1],op[count]);
		dfs(count+1,temp);
		
		if(count+1 < op_count) {
			temp = calc(num[count+1],num[count+2],op[count+1]);
			temp = calc(result,temp,op[count]);
			dfs(count+2,temp);
		}
	}

	public static int calc(int a, int b, char x) {
		int ans = 0;
		
		if(x == '+') {
			ans = a+b;
		}
		else if(x == '-') {
			ans = a-b;
		}
		else if(x == '*') {
			ans = a*b;
		}
		else {
			ans = a/b;
		}
		return ans;
	}
}
