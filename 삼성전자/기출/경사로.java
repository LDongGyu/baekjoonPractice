package programmers;

import java.util.*;

public class Main {
	
	public static int N, L;
	public static int[][] map;
	public static boolean[][] stair1;
	public static boolean[][] stair2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		map = new int[N][N];
		stair1 = new boolean[N][N];
		stair2 = new boolean[N][N];
		
		int answer = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 가로 먼저보기
		boolean ok = true;
		boolean finish = true;
		
		int stairCnt = 0;
		
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N-1; col++) {
				if(map[row][col]+1 == map[row][col+1]) { // 오르막이라면
					if(col >= L-1) {
						for(int stair = col-L+1; stair <= col; stair++) {
							if(map[row][stair] != map[row][col] || stair1[row][stair] == true) {
								ok = false;
								break;
							}
							ok = true;
						}
						if(ok == false) {
							finish = false;
							break;
						}
						else {
							for(int stair = col-L+1; stair <= col; stair++) {
								stair1[row][stair] = true;
							}
						}
					}
					else {
						finish = false;
						break;
					}
				}
				else if(map[row][col]-1 == map[row][col+1]) { // 내리막이라면
					if(col+L < N) {
						for(int stair = col+1; stair <= col+L; stair++) {
							if(map[row][stair] != map[row][col]-1 || stair1[row][stair] == true) {
								ok = false;
								break;
							}
							ok = true;
						}
						if(ok == false) {
							finish = false;
							break;
						}
						else {
							for(int stair = col+1; stair <= col+L; stair++) {
								stair1[row][stair] = true;
							}
						}
					}
					else {
						finish = false;
						break;
					}
				}
				else if(map[row][col] == map[row][col+1]) { // 평지라면
					continue;
				}
				else { // 못 가는 길
					finish = false;
					break;
				}
			}
			if(finish == true) {
				answer++;
			}
			finish = true;
		}
		
		// 세로 보기
		for(int col = 0; col < N; col++) {
			for(int row = 0; row < N-1; row++) {
				if(map[row][col]+1 == map[row+1][col]) { // 오르막이라면
					if(row >= L-1) {
						for(int stair = row-L+1; stair <= row; stair++) {
							if(map[stair][col] != map[row][col] || stair2[stair][col] == true) {
								ok = false;
								break;
							}
							ok = true;
						}
						if(ok == false) {
							finish = false;
							break;
						}
						else {
							for(int stair = row-L+1; stair <= row; stair++) {
								stair2[stair][col] = true;
							}
						}
					}
					else {
						finish = false;
						break;
					}
				}
				else if(map[row][col]-1 == map[row+1][col]) { // 내리막이라면
					if(row+L < N) {
						for(int stair = row+1; stair <= row+L; stair++) {
							if(map[stair][col] != map[row][col]-1 || stair2[stair][col] == true) {
								ok = false;
								break;
							}
							ok = true;
						}
						if(ok == false) {
							finish = false;
							break;
						}
						else {
							for(int stair = row+1; stair <= row+L; stair++) {
								stair2[stair][col] = true;
							}
						}
					}
					else {
						finish = false;
						break;
					}
				}
				else if(map[row][col] == map[row+1][col]) { // 평지라면
					continue;
				}
				else { // 못 가는 길
					finish = false;
					break;
				}
			}
			if(finish == true) {
				answer++;
			}
			finish = true;
		}
		System.out.println(answer);
	}
	
}