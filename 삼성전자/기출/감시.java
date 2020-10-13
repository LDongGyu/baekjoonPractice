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
		int[][] map = new int[N][M];
		ArrayList<Cctv> cctv = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			String[] line = sc.nextLine().split(" ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(line[j]);
				if(map[i][j]!=0 && map[i][j]!=6) {
					Cctv temp = new Cctv(j,i,map[i][j]);
					cctv.add(temp);
				}
			}
		}
		int[][] newMap = new int[N][M];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) newMap[i][j] = map[i][j];
		}
		dfs(newMap,0,cctv);
		System.out.println(answer);
	}
	
	public static void right(int[][] map, int index, ArrayList<Cctv> cctv) {
		for(int i = cctv.get(index).x+1; i < map[0].length; i++) {
			if(map[cctv.get(index).y][i] == 6) break;
			if(map[cctv.get(index).y][i] == 0) map[cctv.get(index).y][i] = -1; 
		}
	}
	
	public static void left(int[][] map, int index, ArrayList<Cctv> cctv) {
		for(int i = cctv.get(index).x-1; i >= 0; i--) {
			if(map[cctv.get(index).y][i] == 6) break;
			if(map[cctv.get(index).y][i] == 0) map[cctv.get(index).y][i] = -1; 
		}
	}
	
	public static void up(int[][] map, int index, ArrayList<Cctv> cctv) {
		for(int i = cctv.get(index).y-1; i >= 0; i--) {
			if(map[i][cctv.get(index).x] == 6) break;
			if(map[i][cctv.get(index).x] == 0) map[i][cctv.get(index).x] = -1; 
		}
	}
	
	public static void down(int[][] map, int index, ArrayList<Cctv> cctv) {
		for(int i = cctv.get(index).y+1; i < map.length; i++) {
			if(map[i][cctv.get(index).x] == 6) break;
			if(map[i][cctv.get(index).x] == 0) map[i][cctv.get(index).x] = -1; 
		}
	}
	
	public static int[][] cloneMap(int[][] map){
		int[][] cloneMap = new int[map.length][map[0].length];
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) cloneMap[i][j] = map[i][j];
		}
		
		return cloneMap;
	}
	
	public static void dfs(int[][] map, int index, ArrayList<Cctv> cctv) {
		if(index == cctv.size()) {
			int count = 0;
			for(int i = 0; i < map.length; i++) {
				for(int j = 0; j < map[i].length; j++) {
					if(map[i][j]==0) count++;
				}
			}
			if(answer > count) {
				answer = count;
			}
			return;
		}
		
		int[][] cloneMap = new int[map.length][map[0].length];

		switch(cctv.get(index).kind) {
		case 1:
			cloneMap = cloneMap(map);
			left(cloneMap,index,cctv);
			dfs(cloneMap,index+1,cctv);
			
			cloneMap = cloneMap(map);
			right(cloneMap,index,cctv);
			dfs(cloneMap,index+1,cctv);
			
			cloneMap = cloneMap(map);
			up(cloneMap,index,cctv);
			dfs(cloneMap,index+1,cctv);
			
			cloneMap = cloneMap(map);
			down(cloneMap,index,cctv);
			dfs(cloneMap,index+1,cctv);
			break;
			
		case 2:
			cloneMap = cloneMap(map);
			left(cloneMap,index,cctv);
			right(cloneMap,index,cctv);
			dfs(cloneMap,index+1,cctv);

			cloneMap = cloneMap(map);
			up(cloneMap,index,cctv);
			down(cloneMap,index,cctv);
			dfs(cloneMap,index+1,cctv);
			break;
		case 3:
			cloneMap = cloneMap(map);
			up(cloneMap,index,cctv);
			right(cloneMap,index,cctv);
			dfs(cloneMap,index+1,cctv);

			cloneMap = cloneMap(map);
			right(cloneMap,index,cctv);
			down(cloneMap,index,cctv);
			dfs(cloneMap,index+1,cctv);

			cloneMap = cloneMap(map);
			down(cloneMap,index,cctv);
			left(cloneMap,index,cctv);
			dfs(cloneMap,index+1,cctv);
			
			cloneMap = cloneMap(map);
			left(cloneMap,index,cctv);
			up(cloneMap,index,cctv);
			dfs(cloneMap,index+1,cctv);
			break;
		case 4:
			cloneMap = cloneMap(map);
			left(cloneMap,index,cctv);
			up(cloneMap,index,cctv);
			right(cloneMap,index,cctv);
			dfs(cloneMap,index+1,cctv);
			
			cloneMap = cloneMap(map);
			up(cloneMap,index,cctv);
			left(cloneMap,index,cctv);
			down(cloneMap,index,cctv);
			dfs(cloneMap,index+1,cctv);
			
			cloneMap = cloneMap(map);
			right(cloneMap,index,cctv);
			down(cloneMap,index,cctv);
			left(cloneMap,index,cctv);
			dfs(cloneMap,index+1,cctv);
			
			cloneMap = cloneMap(map);
			down(cloneMap,index,cctv);
			right(cloneMap,index,cctv);
			up(cloneMap,index,cctv);
			dfs(cloneMap,index+1,cctv);
			break;
		case 5:
			cloneMap = cloneMap(map);
			left(cloneMap,index,cctv);
			down(cloneMap,index,cctv);
			right(cloneMap,index,cctv);
			up(cloneMap,index,cctv);
			dfs(cloneMap,index+1,cctv);
			break;
		}
	}
}

class Cctv {
	int x;
	int y;
	int kind;
	
	Cctv(int x, int y, int kind){
		this.x = x;
		this.y = y;
		this.kind = kind;
	}
}