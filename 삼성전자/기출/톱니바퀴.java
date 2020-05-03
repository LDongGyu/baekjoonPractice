package programmers;

import java.util.*;

public class Main {
	
	public static int N;
	public static ArrayList<Integer>[] gear;
	public static int[][] cycle;
	public static boolean firstAndSecond;
	public static boolean secondAndThird;
	public static boolean thirdAndFourth; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		gear = new ArrayList[4];
		
		for(int i = 0; i < 4; i++) {
			gear[i] = new ArrayList<Integer>();
			String temp = sc.nextLine();
			for(int j = 0; j < 8; j++) {
				gear[i].add(temp.charAt(j)-'0');
			}
		}
		N = sc.nextInt();
		sc.nextLine();
		cycle = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			String[] temp = sc.nextLine().split(" ");
			
			cycle[i][0] = Integer.parseInt(temp[0]);
			cycle[i][1] = Integer.parseInt(temp[1]);
		}
		
		for(int round = 0; round < N; round++) {
			firstAndSecond = (gear[0].get(2)==gear[1].get(6))? true : false;
			secondAndThird = (gear[1].get(2)==gear[2].get(6))? true : false;
			thirdAndFourth = (gear[2].get(2)==gear[3].get(6))? true : false;
			
			switch(cycle[round][0]) {
				case 1:
					firstGear(cycle[round][1]);
					break;
				case 2:
					secondGear(cycle[round][1]);
					break;
				case 3:
					thirdGear(cycle[round][1]);
					break;
				case 4:
					fourthGear(cycle[round][1]);
					break;
			}
		}
		
		int answer = 0;
		
		if(gear[0].get(0)==1) answer += 1;
		if(gear[1].get(0)==1) answer += 2;
		if(gear[2].get(0)==1) answer += 4;
		if(gear[3].get(0)==1) answer += 8;
		
		System.out.println(answer);
	}
	
	public static void firstGear(int dirc) {
		
		turn(gear[0],dirc); // 1번 돌리고
		
		if(!firstAndSecond) {
			turn(gear[1], dirc * -1); // 2번 돌리고
			
			if(!secondAndThird) {
				turn(gear[2], dirc); // 3번 돌리고
			
				if(!thirdAndFourth) {
					turn(gear[3], dirc * -1);
				}
			}
		}
	}
	
	public static void secondGear(int dirc) {
		turn(gear[1],dirc);
		
		if(!firstAndSecond) {
			turn(gear[0], dirc * -1);
		}
		
		if(!secondAndThird) {
			turn(gear[2], dirc * -1);
			
			if(!thirdAndFourth) {
				turn(gear[3], dirc);
			}
		}
	}
	
	public static void thirdGear(int dirc) {
		turn(gear[2],dirc);
		
		if(!secondAndThird) {
			turn(gear[1], dirc * -1);
			
			if(!firstAndSecond) {
				turn(gear[0], dirc);
			}
		}
		
		if(!thirdAndFourth) {
			turn(gear[3], dirc * -1);
		}	
	}
	
	public static void fourthGear(int dirc) {
		turn(gear[3],dirc);
		
		if(!thirdAndFourth) {
			turn(gear[2],dirc * -1);
			
			if(!secondAndThird) {
				turn(gear[1],dirc);
				
				if(!firstAndSecond) {
					turn(gear[0],dirc * -1);
				}
			}
		}
	}
	
	public static void turn(ArrayList<Integer> turnGear, int dirc) {
		if(dirc == 1) { // 시계 방향
			int temp = turnGear.get(7);
			turnGear.remove(7);
			turnGear.add(0,temp);
		}
		else { // 반시계 방향
			int temp = turnGear.get(0);
			turnGear.remove(0);
			turnGear.add(temp);
		}
	}
}