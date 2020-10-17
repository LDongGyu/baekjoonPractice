package samsung_sw;

import java.util.*;

public class Main {

	static int answer = 0;
	static int[][] move = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
	static int[][] fishPosition = new int[16][2];
	static int[][] map = new int[4][4];
	static int[] direct = new int[16];
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 4; i++) {
			String[] line = sc.nextLine().split(" ");
			for(int j = 0; j < 8; j++) {
				if(j%2==0) {
					map[i][j/2] = Integer.parseInt(line[j])-1;
					fishPosition[map[i][j/2]][0] = i;
					fishPosition[map[i][j/2]][1] = j/2;
				}
				else direct[map[i][j/2]] = Integer.parseInt(line[j])-1;
			}
		}

		int[] shock = {0,0};
		int shockDirect = direct[map[0][0]];
		int total = map[0][0];
		fishPosition[map[0][0]][0] = -10;
		fishPosition[map[0][0]][1] = -10;
		map[0][0] = -1;
		dfs(shock, shockDirect, map, total);
		System.out.println(answer);
	}
	
	public static void fishMove(int[][] map) {
		for(int i = 0; i < 16; i++) {
			// 벽이 아니라면
			for(int j = 0; j < 8; j++) {
				if(fishPosition[i][0]+move[direct[i]][0] >= 0 && fishPosition[i][1]+move[direct[i]][1] >= 0 && fishPosition[i][0]+move[direct[i]][0] < 4 && fishPosition[i][1]+move[direct[i]][1] < 4) {
					// 이동하려는 곳이 빈칸이나 물고기라면 
					if(map[fishPosition[i][0]+move[direct[i]][0]][fishPosition[i][1]+move[direct[i]][1]] != -1) {
						// map에서 바꾸기
						int indexTemp = map[fishPosition[i][0]+move[direct[i]][0]][fishPosition[i][1]+move[direct[i]][1]];
						map[fishPosition[i][0]+move[direct[i]][0]][fishPosition[i][1]+move[direct[i]][1]] = map[fishPosition[i][0]][fishPosition[i][1]];
						map[fishPosition[i][0]][fishPosition[i][1]] = indexTemp;
						if(indexTemp >= 0) {	
							//fishPosition 변경
							int tempX = fishPosition[indexTemp][0];
							int tempY = fishPosition[indexTemp][1];
							fishPosition[indexTemp][0] = fishPosition[i][0];
							fishPosition[indexTemp][1] = fishPosition[i][1];
							fishPosition[i][0] = tempX;
							fishPosition[i][1] = tempY;
						}
						break;
					}
					else {
						direct[i] = (direct[i]+1)%8;
					}
				}
				else {
					direct[i] = (direct[i]+1)%8;
				}
			}
		}
	}
	
	public static void dfs(int[] shock, int shockDirect, int[][] map, int total) {
		int num = 1;
		fishMove(map);
		while(true) {
			// 먹을 물고기가 있다면
			if(shock[0]+move[shockDirect][0]*num >= 0 && shock[1]+move[shockDirect][1]*num >= 0 && shock[0]+move[shockDirect][0]*num < 4 && shock[1]+move[shockDirect][1]*num < 4) {
				if(map[shock[0]+move[shockDirect][0]*num][shock[1]+move[shockDirect][1]*num] >= 0) {
					fishPosition[map[shock[0]+move[shockDirect][0]*num][shock[1]+move[shockDirect][1]*num]][0] = -10;
					fishPosition[map[shock[0]+move[shockDirect][0]*num][shock[1]+move[shockDirect][1]*num]][1] = -10;
					int newTotal = total + map[shock[0]+move[shockDirect][0]*num][shock[1]+move[shockDirect][1]*num]+1;
					int[] newShock = {shock[0]+move[shockDirect][0]*num, shock[1]+move[shockDirect][1]*num};
					int newShockDirect = direct[map[shock[0]+move[shockDirect][0]*num][shock[1]+move[shockDirect][1]*num]];
					int[][] newMap = new int[4][4];
					for(int i = 0; i < 4; i++) {
						System.arraycopy(map[i], 0, newMap[i], 0, map[i].length);
					}
					newMap[newShock[0]][newShock[1]] = -1;
					newMap[shock[0]][shock[1]] = -2;
					dfs(newShock, newShockDirect, newMap, newTotal);
				}
				num++;
			}
			else {
				break;				
			}
		}
		
		if(answer < total) answer = total;
	}
}