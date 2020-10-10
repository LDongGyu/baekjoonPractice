package samsung_sw;

import java.util.*;

public class Main {

	static int N = 0;
	static int[][] list;
	static int answer = 0;
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		list = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			String[] in = sc.nextLine().split(" ");
			list[i][0] = Integer.parseInt(in[0]);
			list[i][1] = Integer.parseInt(in[1]);
		}
		
		dfs(0,0);
		
		System.out.println(answer);
	}
	
	
	public static void dfs(int index, int total) {
		if(index >= N) {
			if(answer < total) answer = total;
			return;
		}
		
		//이번꺼 담고 넘기고
		if(index+list[index][0] > N) {
			if(answer < total) answer = total;
			return;
		}
		else {
			dfs(index+list[index][0], total+list[index][1]);	
		}
		//이번꺼 안 담고 넘기고
		dfs(index+1,total);
		
	}
}