package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 4963번 섬의 개수(1026) - bfs
public class Main_4963 {

	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
	
	static int w, h;
	static int[][] island;
	static boolean[][] visited; //해당 섬을 이미 체크했는지 여부
	static ArrayList<int[]> list; //섬 위치 담을 리스트
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break; //입력이 0, 0이면 break;
			
			island = new int[h][w];
			list = new ArrayList<>();
			
			for(int i=0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j < w; j++) {
					island[i][j] = Integer.parseInt(st.nextToken());
					if(island[i][j] == 1) list.add(new int[] {i, j});
				}
			}
			
			visited = new boolean[h][w];
			
			int cnt = 0, size = list.size();
			for(int p = 0; p < size; p++) {
				int[] il = list.get(p);
				int i = il[0], j = il[1];
				if(!visited[i][j]) { //아직 방문하지 않은 섬이라면
					bfs(i, j);
					++cnt;
				}
			}
			
			sb.append(cnt + "\n");
		}
		
		System.out.print(sb);

	}
	
	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			int r = p[0], c = p[1];
			
			for(int d = 0; d < 8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr >= 0 && nr < h && nc >= 0 && nc < w && !visited[nr][nc] && island[nr][nc] == 1) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc});
				}
			}
		}
		
	}

}
