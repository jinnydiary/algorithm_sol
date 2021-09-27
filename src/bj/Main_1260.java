package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 1260번 DFS와 BFS(0927)
public class Main_1260 {

	static int N, M, V;
	static int[][] adjMatrix;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //정점의 개수
		M = Integer.parseInt(st.nextToken()); //간선의 개수
		V = Integer.parseInt(st.nextToken()); //시작 정점
		
		adjMatrix = new int[N+1][N+1]; //인접행렬
		
		for(int m = 0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			adjMatrix[v1][v2] = adjMatrix[v2][v1] = 1;
		}
		
		dfs(V, new boolean[N+1]);
		System.out.println();
		bfs();

	}

	//깊이우선탐색(DFS)
	private static void dfs(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		
		for(int n=1; n<=N; n++) {
			if(!visited[n] && adjMatrix[v][n] == 1) {
				visited[n] = true;
				dfs(n, visited);
			}
		}
	}

	//너비우선탐색(BFS)
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(V);
		boolean[] visited = new boolean[N+1];
		visited[V] = true;
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			System.out.print(num + " ");
			for(int n=1; n<=N; n++) {
				if(!visited[n] && adjMatrix[num][n] == 1) {
					visited[n] = true;
					queue.offer(n);
				}
			}
		}
	}

}
