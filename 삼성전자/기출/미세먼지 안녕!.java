package programmers;

import java.util.*;

public class Main {

	public static int[][] map;
	public static int[] airfresher = new int[2];
	public static int R,C,T;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		
		map = new int[R][C];
		airfresher[0] = -1;
		airfresher[1] = -1;
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == -1) {
					if(airfresher[0] == -1) {
						airfresher[0] = i;
					}
					else {
						airfresher[1] = i;
					}
				}
			}
		}
		
		for(int second = 0; second < T; second++) {
			spread();
			refresh();
		}
		int answer = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] > 0) {
					answer += map[i][j];
				}
			}
		}
		System.out.println(answer);
	}
	
	public static void spread() {
		
		int[][] addArr = new int[R][C];
		int[][] coordinate = {{0,1},{1,0},{0,-1},{-1,0}};
		int spreadPoint = 0;
		int spreadCount = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				spreadPoint = map[i][j]/5;
				spreadCount = 0;
				for(int h = 0; h < 4; h++) {
					if(i+coordinate[h][0]>=0 && j+coordinate[h][1]>=0 && i+coordinate[h][0]<R && j+coordinate[h][1]<C) {
						if(!(i+coordinate[h][0] == airfresher[0] && j+coordinate[h][1] == 0) && !(i+coordinate[h][0] == airfresher[1] && j+coordinate[h][1] ==0)) {
							addArr[i+coordinate[h][0]][j+coordinate[h][1]] += spreadPoint;
							spreadCount++;
						}
					}
				}
				map[i][j] -= spreadPoint * spreadCount;
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				map[i][j] += addArr[i][j];
			}
		}
	}
	
	public static void refresh() {
		/*윗 공기청정기*/
		// 왼쪽 라인
		for(int i = airfresher[0]-2; i >= 0;i--) {
			map[i+1][0] = map[i][0];
		}
		// 윗 라인
		for(int i = 0; i < C-1; i++) {
			map[0][i] = map[0][i+1];
		}
		// 오른쪽 라인
		for(int i = 1; i <= airfresher[0];i++) {
			map[i-1][C-1] = map[i][C-1];
		}
		// 아래 라인
		for(int i = C-2; i > 0; i--) {
			map[airfresher[0]][i+1] = map[airfresher[0]][i];
		}
		map[airfresher[0]][1] = 0;
		
		/*아래 공기청정기*/
		// 왼쪽 라인
		for(int i = airfresher[1]+1; i < R-1; i++) {
			map[i][0] = map[i+1][0];
		}
		// 아래 라인
		for(int i = 0; i < C-1; i++) {
			map[R-1][i] = map[R-1][i+1];
		}
		// 오른쪽 라인
		for(int i = R-1; i > airfresher[1]; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		// 윗 라인
		for(int i = C-1; i >=2; i--) {
			map[airfresher[1]][i] = map[airfresher[1]][i-1]; 
		}
		map[airfresher[1]][1] = 0;
	}
}