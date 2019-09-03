package codingTest2;

import java.util.*;

public class Main {

	static int size = 0;
	
	static int answer = 0;
	static int[][] map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* input */
		Scanner sc = new Scanner(System.in);
		
		size = Integer.parseInt(sc.nextLine());
		map = new int[size][size];
		
		for(int i = 0; i < size; i++) {
			String temp = sc.nextLine();
			temp = temp.replaceAll(" ","");
			
			for(int j = 0; j < size; j++) {
				map[i][j] = temp.charAt(j)-'0';
			}
		}
		
		int[] front = new int[2];
		int[] back = new int[2];
		
		front[0] = 0;
		front[1] = 1;
		back[0] = 0;
		back[1] = 0;
		
		going(front,back);
//		going(2);
		
		System.out.println(answer);
	}
	
	// status = 가로 0, 세로 1, 대각선 2 미는 경우
	public static void going(int[] newFront, int[] newBack) {
		
		int[] front = newFront.clone();
		int[] back = newBack.clone();
		
		// 끝에 도달했으면 종료
		if(front[0] == size-1 && front[1] == size-1) {
			answer++;
			return;
		}
		
		// 봉의 현재 상태 계산, 가로인가 세로인가?
		if(front[0] == back[0] && (front[1]+1) < size) { // 가로
			if(map[front[0]][front[1]+1] == 0) { // 가로로 미는 경우
				int[] nextFront = front.clone();
				int[] nextBack = back.clone();
	
				nextFront[1]++;
				nextBack[1]++;
				going(nextFront,nextBack);
			}
			if((front[0]+1)<size && (front[1]+1)<size) {
				if(map[front[0]+1][front[1]]==0) { // 대각선으로 미는 경우
					if(map[front[0]][front[1]+1]==0) {
						if(map[front[0]+1][front[1]+1]==0) {
							int[] nextFront = front.clone();
							int[] nextBack = back.clone();

							nextFront[0]++;
							nextFront[1]++;
							nextBack[1]++;
							going(nextFront,nextBack);
						}
					}
				}
			}
		}
		
		if(front[1] == back[1] && (front[0]+1) < size) { // 세로
			if(map[front[0]+1][front[1]] == 0) { // 세로로 미는 경우
				int[] nextFront = front.clone();
				int[] nextBack = back.clone();

				nextFront[0]++;
				nextBack[0]++;
				going(nextFront,nextBack);
			}
			
			if((front[0]+1)<size && (front[1]+1)<size) {
				if(map[front[0]+1][front[1]]==0) { // 대각선으로 미는 경우
					if(map[front[0]][front[1]+1]==0) {
						if(map[front[0]+1][front[1]+1]==0) {
							int[] nextFront = front.clone();
							int[] nextBack = back.clone();

							nextFront[0]++;
							nextFront[1]++;
							nextBack[0]++;
							going(nextFront,nextBack);
						}
					}
				}
			}
		}

		if(front[0]-back[0] == front[1]-back[1]){ // 대각선
			if((front[1]+1) < size) {
				if(map[front[0]][front[1]+1] == 0) { // 가로로 미는 경우
					int[] nextFront = front.clone();
					int[] nextBack = back.clone();

					nextFront[1]++;
					nextBack[0]++;
					nextBack[1]++;
					going(nextFront,nextBack);
				}
			}
			
			if((front[0]+1) < size) {
				if(map[front[0]+1][front[1]] == 0) { // 세로로 미는 경우
					int[] nextFront = front.clone();
					int[] nextBack = back.clone();

					nextFront[0]++;
					nextBack[0]++;
					nextBack[1]++;
					going(nextFront,nextBack);
				}
			}
			if((front[0]+1)<size && (front[1]+1)<size) {
				if(map[front[0]+1][front[1]]==0) { // 대각선으로 미는 경우
					if(map[front[0]][front[1]+1]==0) {
						if(map[front[0]+1][front[1]+1]==0) {
							int[] nextFront = front.clone();
							int[] nextBack = back.clone();

							nextFront[0]++;
							nextFront[1]++;
							nextBack[0]++;
							nextBack[1]++;
							going(nextFront,nextBack);
						}
					}
				}
			}
		}
		
		return;
	}

}
