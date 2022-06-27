import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, V, D[][];
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //정점의 개수
		M = Integer.parseInt(st.nextToken()); //간선의 개수
		V = Integer.parseInt(st.nextToken()); //탐색 시작 번호
		
		D = new int[N+1][N+1];
		
		for(int m = 0; m < M; ++m) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			D[r][c] = D[c][r] = 1;
		}
		
		visited = new boolean[N+1];
		dfs(V);
		sb.append("\n");
		visited = new boolean[N+1];
		bfs();
	}
	
	private static void dfs(int v) {
		visited[v] = true;
		sb.append(v + " ");
		for(int i = 1; i <= N; ++i)
			if(D[v][i] == 1 && !visited[i]) dfs(i);
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[V] = true;
		queue.offer(V);
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			sb.append(num + " ");
			for(int i = 1; i <= N; ++i) {
				if(D[num][i] == 1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
		
		System.out.print(sb);
		
	}

}
