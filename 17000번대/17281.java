package codingTest;

import java.io.*;
import java.util.*;

public class Main {
	
	static int answer = 0;
	static int N;
	static int[][] point;
	static int[] order;
	static boolean[] selected = new boolean[9];
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
	/* 인풋 */
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	N = Integer.parseInt(bf.readLine());
	point = new int[N][9];
	order = new int[9];
	
	order[3] = 0;
	selected[0] = true;
	
	StringTokenizer st;
	
	for(int i = 0; i < N; i++) {
		st = new StringTokenizer(bf.readLine()," ");
		for(int j = 0; j < 9; j++) {
			point[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	order(0);
	System.out.println(answer);
	}
	
	public static void order(int num) { // num 번째로 칠 선수
		
		if(num == 3) { // 4번 타자는 지정함
			order(num+1);
			return;
		}
		if(num == 9) { // 선수 배치가 끝났으면
			play();
			return;
		}
		
		for(int i = 1; i<9; i++) {
			if(selected[i]==true) {
				continue;
			}
			else {
				order[num] = i;
				selected[i] = true;
				order(num+1);
				selected[i] = false;
			}
		}
	}
	
	public static void play() {
		int score = 0;
		boolean[] base = new boolean[3];
		int hitter = 0;
		int out = 0;
		
		for(int i = 0; i < N; i++) { // N 이닝
			out = 0;
			base = new boolean[3];
			
			for(int j = 0; j <3;j++) {
				base[j] = false;
			}
			

			
			
			while(true) { // 아웃이 3이 될때까지
				int state = point[i][order[hitter]];
				hitter++; // 다음타자
				hitter %= 9;
				if(state == 1) { // 안타
					if(base[2] == true) { // 3루에 사람이 있었다면
						score++;
						base[2] = false;
					}
					for(int j = 1; j >= 0; j--) {
						if(base[j]==true) {
							base[j+1] = true;
							base[j] = false;
						}
					}
					base[0] = true; // 타자 전진
				}
				else if(state == 2) { // 2루타
					if(base[2] == true) {
						score++;
						base[2] = false;	
					}
					if(base[1] == true) {
						score++;
						base[1] = false;
					}
					if(base[0] == true) {
						base[2] = true;
						base[0] = false;
					}
					base[1] = true;
				}
				else if(state == 3) { // 3루타
					for(int j = 0; j <3; j++) { // 출루한 인원들 다 들어옴
						if(base[j]==true) {
							score++;
							base[j] = false;
						}
					}
					base[2] = true;
				}
				else if(state == 4) { // 홈런
					for(int j = 0; j<3; j++) {
						if(base[j]==true) {
							score++;
							base[j] = false;
						}
					}
					score++;
				}
				else {
					out++;
					if(out >= 3) {
						break;
					}
				}
			}
		}
		if(answer < score) {
			answer = score;
		}
	}
}