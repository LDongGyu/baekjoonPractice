package codingTest;

import java.io.*;
import java.util.*;

public class Main {
	
	public static int N; // 배열 크기
	public static int M; // 나무 개수
	public static int K; // K년이 지난 후
	public static int[][] A; // 양분 배열
	public static int[][] field;
	public static ArrayList<int[]> tree = new ArrayList<>(); // 나무
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/* 인풋 */
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String temp = bf.readLine();
		st = new StringTokenizer(temp," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new int[N][N];
		field = new int[N][N];
		for(int i = 0; i < N; i++) {
			Arrays.fill(field[i], 5);
		}
		for(int i = 0; i < N; i++) {
			temp = bf.readLine();
			st = new StringTokenizer(temp," ");
			
			for(int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < M; i++) {
			temp = bf.readLine();
			st = new StringTokenizer(temp," ");
			int[] tree_temp = new int[3];
			
			tree_temp[0] = Integer.parseInt(st.nextToken())-1;
			tree_temp[1] = Integer.parseInt(st.nextToken())-1;
			tree_temp[2] = Integer.parseInt(st.nextToken());
			
			tree.add(tree_temp);
		}
		
		growing(0);
		
		System.out.print(tree.size());
	}
	
	public static void growing(int year) {
		
		if(year==K) {
			return;
		}
		
		ArrayList<Integer> remove_list = new ArrayList<>();
		int[] new_tree;
		
		// 봄
		// 소팅
		tree.sort(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				int a = o1[2];
				int b = o2[2];
				if(a==b) return 0;
				else if(a>b) return 1;
				else return -1;
			}
			
		});
		for(int i = 0; i < tree.size(); i++) {
			for(int j = i+1; j < tree.size(); j++) {
				if(tree.get(i)[0] == tree.get(j)[0] && tree.get(i)[1] == tree.get(j)[1]) {
					
				}
			}
		}
		
		for(int i = 0; i < tree.size(); i++) {
			// 양분이 부족한 경우
			if(field[tree.get(i)[0]][tree.get(i)[1]] < (int)tree.get(i)[2]) {
				remove_list.add(i);
			}
			// 양분이 충분하다면
			else {
				field[tree.get(i)[0]][tree.get(i)[1]] -= (int)tree.get(i)[2];
				new_tree = new int[3];
				new_tree[0] = tree.get(i)[0];
				new_tree[1] = tree.get(i)[1];
				new_tree[2] = tree.get(i)[2] + 1;
				tree.set(i, new_tree);
			}
		}
		
		// 여름
		for(int i = 0; i < remove_list.size(); i++) {
			field[tree.get(remove_list.get(i)-i)[0]][tree.get(remove_list.get(i)-i)[1]] += (int)tree.get(remove_list.get(i)-i)[2]/2;
			tree.remove(remove_list.get(i)-i);
		}
		
		// 가을
		for(int i = 0; i < tree.size(); i++) {
			if(tree.get(i)[2]%5==0) {
				int x = tree.get(i)[0];
				int y = tree.get(i)[1];
				
				int[] new_tree1 = new int[3];
				int[] new_tree2 = new int[3];
				int[] new_tree3 = new int[3];
				int[] new_tree4 = new int[3];
				int[] new_tree5 = new int[3];
				int[] new_tree6 = new int[3];
				int[] new_tree7 = new int[3];
				int[] new_tree8 = new int[3];
				
				if(x-1 >= 0 && y-1 >= 0) {
					new_tree1[0] = x-1;
					new_tree1[1] = y-1;
					new_tree1[2] = 1;
					tree.add(new_tree1);
				}
				
				if(x-1 >= 0) {
					new_tree2[0] = x-1;
					new_tree2[1] = y;
					new_tree2[2] = 1;
				
					new_tree3[0] = x-1;
					new_tree3[1] = y+1;
					new_tree3[2] = 1;
					
					tree.add(new_tree2);
					tree.add(new_tree3);
				}
				
				if(y-1 >= 0) {
					new_tree4[0] = x;
					new_tree4[1] = y-1;
					new_tree4[2] = 1;
					
					
					new_tree6[0] = x+1;
					new_tree6[1] = y-1;
					new_tree6[2] = 1;
					
					tree.add(new_tree4);
					tree.add(new_tree6);
				}
				
				new_tree5[0] = x;
				new_tree5[1] = y+1;
				new_tree5[2] = 1;
				
				new_tree7[0] = x+1;
				new_tree7[1] = y;
				new_tree7[2] = 1;
				
				new_tree8[0] = x+1;
				new_tree8[1] = y+1;
				new_tree8[2] = 1;
				
				tree.add(new_tree5);
				tree.add(new_tree7);
				tree.add(new_tree8);
			}
		}
		
		// 겨울
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				field[i][j] += A[i][j];
			}
		}
		
		growing(year+1);
	}
}