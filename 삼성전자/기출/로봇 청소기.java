package samsung_sw;

import java.util.*;

public class Main {
	
	static int N = 0;
	static int M = 0;
	static int[][] map;
	static int[] position;
	static int direction;
	static boolean[][] check;
	static int[] newDirection = {3,0,1,2};
	
	public static void main(String args[])
	{
		int answer = 0;
		Scanner sc = new Scanner(System.in);
		String[] nm = sc.nextLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		map = new int[N][M];
		check = new boolean[N][M];
		String[] pos = sc.nextLine().split(" ");
		position = new int[2];
		position[0] = Integer.parseInt(pos[0]);
		position[1] = Integer.parseInt(pos[1]);
		direction = Integer.parseInt(pos[2]);
		
		for(int i = 0; i < N; i++) {
			String[] read = sc.nextLine().split(" ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(read[j]);
			}
		}
	
		int count = 0;
		boolean canBack = false;
		while(true) {
			// 1. 현재 위치 청소
			clear();
			if(count == 4) {
				switch(direction) {
					case 0 : if(position[0]+1 < N) {
						if(map[position[0]+1][position[1]]==0) {
							canBack=true; position[0]++;	
						}
						 break;
					}
					case 1 : if(position[1]-1 >= 0) {
						if(map[position[0]][position[1]-1]==0) {
							canBack=true; position[1]--;	
						}
						 break;
					}
					case 2 : if(position[0]-1 >= 0) {
						if(map[position[0]-1][position[1]]==0) {
							canBack=true; position[0]--;
						}
						break;
					}
					case 3 : if(position[1]+1 < M) {
						if(map[position[0]][position[1]+1]==0) {
							canBack=true; position[1]++;
						}
						break;
					}
				}
				if(canBack) {
					canBack = false;
					count = 0;
					continue;
				}
				break;
			}
			// 2. 왼쪽 청소 할 수 있다면
			if(canClear()) { // a. 횐전하고 한 칸 전진
				direction = newDirection[direction];
				switch(direction) {
					case 0 : position[0]--; break;
					case 1 : position[1]++; break;
					case 2 : position[0]++; break;
					case 3 : position[1]--; break;
				}
				count = 0;
				continue;
			}
			else {
				direction = newDirection[direction];
				count++;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(check[i][j]) answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	public static void clear() {
		check[position[0]][position[1]] = true;
	}
	
	public static boolean canClear() {
		
		switch(direction) {
			case 0 : // 북, 서쪽 검사
				if(position[1]-1 >= 0) {
					if(map[position[0]][position[1]-1]==0 && check[position[0]][position[1]-1] == false) {
						return true;
					}
				}
				break;
			case 1 : // 동, 북쪽 검사
				if(position[0]-1 >= 0) {
					if(map[position[0]-1][position[1]]==0 && check[position[0]-1][position[1]] == false) {
						return true;
					}
				}
				break;
			case 2 : // 남, 동쪽 검사
				if(position[1]+1 < M) {
					if(map[position[0]][position[1]+1]==0 && check[position[0]][position[1]+1] == false) {
						return true;
					}
				}
				break;
			case 3 : // 서, 남쪽 검사
				if(position[0]+1 < N) {
					if(map[position[0]+1][position[1]]==0 && check[position[0]+1][position[1]] == false) {
						return true;
					}
				}
				break;
		}
		
		return false;
	}
	
}