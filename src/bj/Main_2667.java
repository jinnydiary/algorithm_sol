package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

//백준 2667번 단지번호붙이기(1004)
public class Main_2667 {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int map[][], N, cnt, num;
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //지도의 크기
		map = new int[N][N];
		 
		//집 표시
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		ArrayList<Integer> apart = new ArrayList<Integer>(); //각 단지 내 아파트 수
		num = 0; //단지 수
		visited = new boolean[N][N]; //방문한 아파트인지 확인 여부
		
		//단지 수와 각 단지 내 아파트 수 찾기
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) { //방문한 아파트가 아닌 경우
					++num; //단지 수 증가
					bfs(i, j);
					apart.add(cnt); //해당 단지 내 아파트 수 입력
				}
			}
		}
		
		Collections.sort(apart); //오름차순 정렬
		
		System.out.println(num);
		for(int i=0; i<num; i++)
			System.out.println(apart.get(i));
	}
	
	//단지 내 아파트 수 찾기
	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		visited[i][j] = true;
		cnt = 1;

		while(!queue.isEmpty()) {
			int[] ap = queue.poll();
			int r = ap[0], c = ap[1];
			
			//사방탐색
			for(int d=0; d<4; ++d) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				//경계 내에 있고 방문하지 않은 아파트라면
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					cnt++;
					queue.offer(new int[] {nr, nc});
				}
			}
		}

	}

}
