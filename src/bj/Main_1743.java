package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 1743번 음식물 피하기(1008)
public class Main_1743 {

	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1};
	static int N, M, K, map[][], max;
	static boolean[][] checked; //체크한 통로인지 확인 여부
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //통로의 세로 길이
		M = Integer.parseInt(st.nextToken()); //통로의 가로 길이
		K = Integer.parseInt(st.nextToken()); //음식물 쓰레기의 개수
		
		map = new int[N+1][M+1]; //통로 배열
		
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
		}
		
		max = Integer.MIN_VALUE;
		checked = new boolean[N+1][M+1];
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= M; c++) {
				if(map[r][c] == 1 && !checked[r][c]) //쓰레기가 있는 통로이며 아직 확인하지 않은 곳일 경우
					bfs(r, c);
			}
		}
		
		System.out.println(max);

	}
	
	//인접한 음식물들 찾아 최대 크기 구하기
	private static void bfs(int R, int C) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {R, C});
		checked[R][C] = true;
		int cnt = 1;
		
		while(!queue.isEmpty()) {
			int[] num = queue.poll();
			int r = num[0], c = num[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr >= 0 && nr <= N && nc >= 0 && nc <= M && !checked[nr][nc] && map[nr][nc] == 1) {
					checked[nr][nc] = true;
					cnt++;
					queue.offer(new int[] {nr, nc});
				}
			}
			
		}
		
		max = Math.max(max, cnt);
		
	}

}
