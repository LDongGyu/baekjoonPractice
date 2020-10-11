package samsung_sw;

import java.util.*;

public class Main {

	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String[] first = sc.nextLine().split(" ");
		int N = Integer.parseInt(first[0]);
		int M = Integer.parseInt(first[1]);
		int[] position = {Integer.parseInt(first[2]),Integer.parseInt(first[3])};
		int moveNum = Integer.parseInt(first[4]);
		int[][] map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String[] str = sc.nextLine().split(" ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		int[] move = new int[moveNum];
		String[] last = sc.nextLine().split(" ");
		
		for(int i = 0; i < moveNum; i++) {
			move[i] = Integer.parseInt(last[i]);
		}
		
		int[][] dice = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};
		
		/*
		 * N, M, position, map, move
		 */
		for(int i = 0; i < moveNum; i++) {
			switch(move[i]) {
				case 1: // 동쪽
					if(position[1]+1 < M) {
						int temp = dice[1][2];
						dice[1][2] = dice[1][1];
						dice[1][1] = dice[1][0];
						dice[1][0] = dice[3][1];
						dice[3][1] = temp;
						position[1]++;

						if(map[position[0]][position[1]] == 0) {
							map[position[0]][position[1]] = dice[3][1];
						}
						else {
							dice[3][1] = map[position[0]][position[1]];
							map[position[0]][position[1]] = 0;
						}
						System.out.println(dice[1][1]);
						// 주사위 돌리기
					}
					break;
				case 2: // 서쪽
					if(position[1]-1 >= 0) {
						int temp = dice[1][0];
						dice[1][0] = dice[1][1];
						dice[1][1] = dice[1][2];
						dice[1][2] = dice[3][1];
						dice[3][1] = temp;
						position[1]--;

						if(map[position[0]][position[1]] == 0) {
							map[position[0]][position[1]] = dice[3][1];
						}
						else {
							dice[3][1] = map[position[0]][position[1]];
							map[position[0]][position[1]] = 0;
						}
						System.out.println(dice[1][1]);
						// 주사위 돌리기

					}
					break;
				case 3: // 북쪽
					if(position[0]-1 >= 0) {
						int temp = dice[0][1];
						dice[0][1] = dice[1][1];
						dice[1][1] = dice[2][1];
						dice[2][1] = dice[3][1];
						dice[3][1] = temp;
						position[0]--;

						if(map[position[0]][position[1]] == 0) {
							map[position[0]][position[1]] = dice[3][1];
						}
						else {
							dice[3][1] = map[position[0]][position[1]];
							map[position[0]][position[1]] = 0;
						}
						System.out.println(dice[1][1]);

					}
					break;
				case 4:
					if(position[0]+1 < N) {
						int temp = dice[3][1];
						dice[3][1] = dice[2][1];
						dice[2][1] = dice[1][1];
						dice[1][1] = dice[0][1];
						dice[0][1] = temp;
						position[0]++;

						if(map[position[0]][position[1]] == 0) {
							map[position[0]][position[1]] = dice[3][1];
						}
						else {
							dice[3][1] = map[position[0]][position[1]];
							map[position[0]][position[1]] = 0;
						}
						System.out.println(dice[1][1]);

					}
					break;
			}
		}
	}
}