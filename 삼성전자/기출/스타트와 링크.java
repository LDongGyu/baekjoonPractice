package samsung_sw;

import java.util.*;

public class Main {
	
	static int answer = Integer.MAX_VALUE;
	static int N = 0;
	static int[][] arr;
	static boolean[] selected;
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		arr = new int[N][N];
		selected = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			String[] string = sc.nextLine().split(" ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(string[j]);
			}
		}
		
		permutation(0,0);
		
		System.out.println(answer);
	}
	
	public static void permutation(int index, int count) {
		
		if(count == N/2) {
			int[] first = new int[N/2];
			int[] second = new int[N/2];
			int t = 0;
			int f = 0;
			
			for(int i = 0; i < N; i++) {
				if(selected[i]) {
					first[t] = i;
					t++;
				}
				else {
					second[f] = i;
					f++;
				}
			}
			
			t = combination(first);
			f = combination(second);
			
			if(answer > Math.abs(t-f)) answer = Math.abs(t-f);
			return;
		}
		
		for(int i = index; i < N; i++) {
			selected[i] = true;
			permutation(i+1, count+1);
			selected[i] = false;
		}
	}
	
	public static int combination(int[] com) {
		int result = 0;
		
		for(int i = 0; i < com.length; i++) {
			for(int j = i+1; j < com.length; j++) {
				result += arr[com[i]][com[j]];
				result += arr[com[j]][com[i]];
			}
		}
		
		return result;
	}
}