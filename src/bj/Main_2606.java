package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 2606번 바이러스(1004)
public class Main_2606 {

	static int N;
	static int[][] adjMatrix;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine()); //컴퓨터 수
		int connect = Integer.parseInt(br.readLine()); //직접 연결된 컴퓨터 쌍의 수
		
		adjMatrix = new int[N+1][N+1]; //인접행렬
		for(int i=0; i < connect; i++) {
			st = new StringTokenizer(br.readLine());
			int cp1 = Integer.parseInt(st.nextToken());
			int cp2 = Integer.parseInt(st.nextToken());
			adjMatrix[cp1][cp2] = adjMatrix[cp2][cp1] = 1; //직접 연결됨을 나타냄
		}
		
		boolean[] visited = new boolean[N+1]; //컴퓨터 확인 여부
		visited[1] = true;
		dfs(1, visited);
		
		System.out.println(adjMatrix[1][0]); //감염된 컴퓨터 수 출력
	}
	
	private static void dfs(int cnt, boolean[] visited) {
		for(int i=1; i<=N; i++) {
			if(adjMatrix[cnt][i] == 1 && !visited[i]) {
				visited[i] = true;
				++adjMatrix[1][0]; //1번 컴퓨터 직/간접적으로 연결되어 바이러스에 감열될 컴퓨터 수 증가
				dfs(i, visited);
			}
		}
	}

}
