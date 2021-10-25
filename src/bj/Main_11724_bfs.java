package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 11724번 연결 요소의 개수(1025) - bfs
public class Main_11724_bfs {

	static int N, M;
	static int[][] matrix;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		matrix = new int[N+1][N+1];
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			matrix[u][v] = matrix[v][u] = 1;
		}
		
		check = new boolean[N+1];
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			if(!check[i]) {
				bfs(i);
				++cnt;
			}
		}
		System.out.println(cnt);
		
	}
	
	private static void bfs(int n) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n);
		check[n] = true;
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			for(int i=1; i<=N; i++) {
				if(!check[i] && matrix[num][i] == 1) {
					check[i] = true;
					bfs(i);
				}
			}
		}
		
	}

}
