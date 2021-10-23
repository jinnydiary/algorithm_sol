package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 2178번 미로탐색(1020)
public class Main_2178 {

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, M;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			char[] ch = br.readLine().toCharArray();
			for(int j=1; j<=M; j++) {
				map[i][j] = ch[j-1] - '0';
			}
		}

		System.out.println(bfs());
		
	}
	
	private static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {1, 1, 1});
		boolean[][] visited = new boolean[N+1][M+1];
		visited[1][1] = true;
		int level = 0;
		
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			int r = p[0], c = p[1];
			level = p[2];
			
			if(r == N && c == M) break;
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr >= 1 && nr <= N && nc >= 1 && nc <= M && map[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc, level+1});
				}
			}
			
		}
		
		return level;
		
	}

}
