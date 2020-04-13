package samsung_sw;

import java.io.*;
import java.util.*;


public class Main {
	
	static int max = -1000000000;
	static int min = 1000000000;
	static int num;
	static int[] numArr;
	static int[] operator;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		num = sc.nextInt();
		numArr = new int[num];
		operator = new int[4];
		
		for(int i = 0; i < num; i++) {
			numArr[i] = sc.nextInt();
		}
		for(int i = 0; i < 4; i++) {
			operator[i] = sc.nextInt();
		}
		dfs(0,numArr[0]);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void dfs(int top, int result) {
		if(top == num-1) { // 다 선정했다면
			if(max < result) {
				max = result;
			}
			if(min > result) {
				min = result;
			}
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(operator[i] > 0) {
				operator[i]--;
				if(i == 0) {
					dfs(top+1, result + numArr[top+1]);
				}
				else if(i == 1) {
					dfs(top+1, result - numArr[top+1]);
				}
				else if(i == 2) {
					dfs(top+1, result * numArr[top+1]);
				}
				else {
					dfs(top+1, result / numArr[top+1]);
				}
				operator[i]++;
			}
		}
	}
}