package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//백준 1012번 유기농 배추(1014)
public class Main_1012 {

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int M, N, K; //배추밭의 가로길이, 세로길이, 배추심은 위치 개수
	static int[][] map; //배추밭 배열
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[M][N];
			ArrayList<int[]> baechu = new ArrayList<>();
			for(int k=0; k<K; k++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
				baechu.add(new int[] {r, c});
			}
			
			visited = new boolean[M][N]; //배추 체크 여부
			int min = 0; //최소 배추흰지렁이 수
			for(int k=0; k < K; k++) { //배추 수 만큼 돌리기
				int[] b = baechu.get(k);
				int r = b[0], c = b[1];
				if(visited[r][c]) continue;
				dfs(r, c);
				++min;
			}
			
			sb.append(min + "\n");
		}
		
		System.out.print(sb);

	}
	
	//배추 간 인접 체크 - DFS
	private static void dfs(int r, int c) {
		
		visited[r][c] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr >= 0 && nr < M && nc >= 0 && nc < N && map[nr][nc] == 1 && !visited[nr][nc]) {
				dfs(nr, nc);
			}
		}
		
		
	}

}
