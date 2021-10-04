package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 9372번 상근이의 여행(1004)
public class Main_9372 {

	static int N, M, res; //국가 수, 비행기 수
	static int fly[][]; //국가 연결 관계 배열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			fly = new int[N+1][N+1];
			
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				fly[a][b] = fly[b][a] = 1; //a와 b를 왕복하는 비행기가 있음을 1로 표시
			}
			
			res = 0;
			boolean[] visited = new boolean[N+1];
			visited[1] = true;
			dfs(1, visited);
			
			sb.append(res + "\n");
		}
		System.out.print(sb);

	}

	private static void dfs(int country, boolean[] visited) {
		
		for(int c=1; c<=N; c++) {
			if(country != c && fly[country][c] == 1 && !visited[c]) {
				visited[c] = true;
				res++;
				dfs(c, visited);
			}
		}
	}

}
