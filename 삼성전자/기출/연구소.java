package programmers;

import java.util.*;

public class Main {

	public static int N,M;
	public static int nonVirus;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		nonVirus = 0;
		int[][] map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		dfs(map,0,0,0);
		System.out.println(nonVirus);
	}
	
	public static void spread(int[][] map, int row, int col) {
		
		int[][] coor = {{0,1},{1,0},{-1,0},{0,-1}};
		
		map[row][col] = 2;
		
		for(int i = 0; i < 4; i++) {
			if(row+coor[i][0] >= 0 && row+coor[i][0] < N && col+coor[i][1] >= 0 && col+coor[i][1] < M) {
				if(map[row+coor[i][0]][col+coor[i][1]] == 0) {
					spread(map,row+coor[i][0],col+coor[i][1]);
				}
			}
		}
	}
	
	public static void dfs(int[][] map, int wallCnt, int row, int col) {
		if(wallCnt == 3) {
			int[][] coor = {{0,1},{1,0},{-1,0},{0,-1}};
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 2) {
						spread(map,i,j);
					}
				}
			}
			
			int count = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 0) {
						count++;
					}
				}
			}
			if(nonVirus < count) {
				nonVirus = count;
			}
			return;
		}
		boolean first = true;
		
		for(int i = row; i < N; i++) {
			if(first == false) {
				col = 0;
			}
			first = false;
			for(int j = col; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					int[][] newMap = new int[N][M];
					for(int h = 0; h < newMap.length; h++) {
						newMap[h] = map[h].clone();
					}
					dfs(newMap,wallCnt+1, i,j+1);
					map[i][j] = 0;
				}
			}
		}
	}
}