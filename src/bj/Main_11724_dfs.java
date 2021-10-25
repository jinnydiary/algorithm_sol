package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 11724번 연결 요소의 개수(1025) - dfs
public class Main_11724_dfs {

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
				dfs(i);
				++cnt;
			}
		}
		System.out.println(cnt);
		
	}
	
	private static void dfs(int n) {
		
		check[n] = true;
		
		for(int i=1; i<=N; i++) {
			if(!check[i] && matrix[n][i] == 1)
				dfs(i);
		}
		
	}

}
