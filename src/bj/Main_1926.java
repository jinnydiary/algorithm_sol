package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 1926번 그림(1107)
public class Main_1926 {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	static int n, m, cnt, sum, max;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<int[]> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		list = new ArrayList<>();
		
		for(int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < m; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 1) list.add(new int[] {r, c});
			}
		}
		
		for(int i = 0; i < list.size(); ++i) {
			int[] p = list.get(i);
			int r = p[0], c = p[1];
			if(!visited[r][c]) {
				sum = 1;
				bfs(r, c);
				if(sum > max) max = sum;
				++cnt;
			}
		}
		
		System.out.print(cnt + "\n" + max);

	}
	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {r, c});
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			int pr = p[0], pc = p[1];
			
			for(int d = 0; d < 4; ++d) {
				int nr = pr + dr[d];
				int nc = pc + dc[d];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < m
				&& !visited[nr][nc] && map[nr][nc] == 1) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc});
					++sum;
				}
			}
			
		}
		
	}

}
