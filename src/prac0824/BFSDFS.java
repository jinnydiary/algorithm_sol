package prac0824;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs와 dfs
public class BFSDFS {

	static int V, E;//정점의 개수, 간선의 개수
	static boolean[] visited;
	static boolean[][] matrix;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/prac0824/bfsdfs.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		matrix = new boolean[V][V];
		
		for(int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			matrix[n1][n2] = matrix[n2][n1] = true;
		}
		
		visited = new boolean[V];
		System.out.println("너비우선 탐색(bfs)");
		bfs();
		
		visited = new boolean[V];
		System.out.println("깊이우선 탐색(dfs)");
		dfs(0);
		

	}


	//너비 우선 탐색(BFS)
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(0);
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			System.out.print((char)(num+65) + " ");
			for(int v = 0; v < V; v++) {
				if(!visited[v] && matrix[num][v]) {
					queue.offer(v);
					visited[v] = true;
				}
			}
		}
		System.out.println();
		
	}
	
	private static void dfs(int v) {
		
		visited[v] = true;
		System.out.print((char)(v+65) + " ");
		
		for(int i = 0; i<V; i++) {
			if(!visited[i] && matrix[v][i])
				dfs(i);
		}
		
	}

}
