package samsung_sw;

import java.util.*;

public class Main {

	static int answer = Integer.MAX_VALUE;
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String[] first = sc.nextLine().split(" ");
		int N = Integer.parseInt(first[0]);
		int M = Integer.parseInt(first[1]);
		int[][] map = new int[N][N];
		ArrayList<Integer> house = new ArrayList<>();
		ArrayList<int[]> chicken = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			String[] line = sc.nextLine().split(" ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(line[j]);
				int[] position = {i,j}; 
				if(map[i][j] == 1) house.add(i*N+j);
				if(map[i][j] == 2) chicken.add(position);
			}
		}
		
		int[][] distanceMap = new int[house.size()][chicken.size()];
		
		for(int i = 0; i < house.size(); i++) {
			for(int j = 0; j < chicken.size(); j++) {
				int houseX = house.get(i)%N;
				int houseY = (house.get(i)-houseX)/N;
				
				distanceMap[i][j] = Math.abs(houseX - chicken.get(j)[1]) + Math.abs(houseY - chicken.get(j)[0]);
			}
		}

		boolean[] checked = new boolean[chicken.size()];
		permutation(0,0,checked,distanceMap,M);
		
		System.out.println(answer);
	}
	
	public static void permutation(int count, int index, boolean[] checked, int[][] distanceMap, int M) {
		if(count == M) {
			// distance °è»ê
			int result = 0;
			int min = Integer.MAX_VALUE;
			
			for(int h = 0; h < distanceMap.length; h++) {
				for(int i = 0; i < checked.length; i++) {
					if(checked[i]) {
						if(min > distanceMap[h][i]) min = distanceMap[h][i];
					}
				}
				result += min;
				min = Integer.MAX_VALUE;
			}			
			if(answer > result) answer = result;
		}
		
		for(int i = index; i < distanceMap[0].length; i++) {
			checked[i] = true;
			permutation(count+1, i+1, checked, distanceMap, M);
			checked[i] = false;
		}
	}
}