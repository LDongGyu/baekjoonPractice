package samsung_sw;

import java.util.*;


public class Main {
	
	public static int N;
	public static int[][] curve;
	public static ArrayList<int[]> pointSet = new ArrayList<>();
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		curve = new int[N][4];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 4; j++) {
				curve[i][j] = sc.nextInt();
			}
		}
		
		ArrayList<int[]> curveList;
		ArrayList<int[]> temp;
		ArrayList<int[]> allPoint = new ArrayList<>();
		// 전개
		for(int i = 0; i < N; i++) {
			curveList = new ArrayList<int[]>();
			int[] firstPoint = {curve[i][0],curve[i][1]}; 
			curveList.add(firstPoint);
			int[] secondPoint;
			if(curve[i][2] == 0) {
				secondPoint = new int[]{curve[i][0]+1, curve[i][1]};
			}
			else if(curve[i][2] == 1) {
				secondPoint = new int[]{curve[i][0], curve[i][1]-1};
			}
			else if(curve[i][2] == 2) {
				secondPoint = new int[]{curve[i][0]-1, curve[i][1]};
			}
			else {
				secondPoint = new int[]{curve[i][0], curve[i][1]+1};
			}
			curveList.add(secondPoint);
			
			for(int j = 0; j < curve[i][3]; j++) {
				temp = new ArrayList<>();
				for(int h = 0; h < curveList.size()-1; h++) {
					temp.add(rotateTransform(curveList.get(curveList.size()-1),curveList.get(h)));
				}
				Collections.reverse(temp);
				curveList.addAll(temp);
			}
			allPoint.addAll(curveList);
		}
		// 중복 점 제거
		ArrayList<Integer> deleteIndex = new ArrayList<>();
		for(int i = 0; i < allPoint.size(); i++) {
			for(int j = i+1; j < allPoint.size(); j++) {
				if(allPoint.get(i)[0] == allPoint.get(j)[0] && allPoint.get(i)[1] == allPoint.get(j)[1] && !deleteIndex.contains(j)) {
					deleteIndex.add(j);
				}
			}
		}
		Collections.sort(deleteIndex);
		for(int i = 0; i < deleteIndex.size();i++) {
			allPoint.remove(deleteIndex.get(i)-i);
		}
		
		int answer = 0;
		for(int i = 0; i < allPoint.size(); i++) {
			int count = 0;
			for(int j = 0; j < allPoint.size(); j++) {
				if(allPoint.get(i)[0]+1 == allPoint.get(j)[0] && allPoint.get(i)[1] == allPoint.get(j)[1]) {
					count++;
				}
				else if(allPoint.get(i)[0] == allPoint.get(j)[0] && allPoint.get(i)[1]+1 == allPoint.get(j)[1]) {
					count++;
				}
				else if(allPoint.get(i)[0]+1 == allPoint.get(j)[0] && allPoint.get(i)[1]+1 == allPoint.get(j)[1]) {
					count++;
				}
				else {
					continue;
				}
			}
			if(count == 3) {
				answer++;
			}
			count = 0;
		}
		System.out.println(answer);
	}
	
	public static int[] rotateTransform(int[] standard, int[] point) {
		double radian = Math.toRadians(90.0);
		
		int beforeRotationX = point[0]-standard[0];
		int beforeRotationY = point[1]-standard[1];
		
		double RotationX = Math.cos(radian) * beforeRotationX - Math.sin(radian) * beforeRotationY;
		double RotationY = Math.sin(radian) * beforeRotationX - Math.cos(radian) * beforeRotationY;
		
		int newX = (int)Math.round(RotationX) + standard[0];
		int newY = (int)Math.round(RotationY) + standard[1];
		
		int[] result = {newX,newY};
		
		return result;
	}
}