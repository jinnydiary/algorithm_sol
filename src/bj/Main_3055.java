package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 3055번 탈출(1027)
public class Main_3055 {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	static int R, C; //행과 열
	static char[][] map; //티떱숲의 지도
	static Queue<int[]> water; //물이 차있는 곳의 위치
	static Queue<int[]> urchin; //고슴도치가 이동가능한 위치 및 각 소요시간
	static int time;
	static boolean[][] uv;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		time = 0;
		
		map = new char[R][C];
		uv = new boolean[R][C];
		water = new LinkedList<>();
		urchin = new LinkedList<>();
		
		for(int r = 0; r < R; r++) {
			char[] ch = br.readLine().toCharArray();
			for(int c = 0; c < C; c++) {
				map[r][c] = ch[c];
				if(map[r][c] == '*') water.offer(new int[] {r, c}); //물이 차있는 지역
				else if(map[r][c] == 'S') {
					urchin.offer(new int[] {r, c, 0}); //고슴도치 위치
					map[r][c] = '.';
					uv[r][c] = true;
				}
			}
		}
		
		if(bfs()) System.out.print(time);
		else System.out.print("KAKTUS");

	}
	
	//고슴도치 이동 - bfs
	private static boolean bfs() {

		boolean escape = false;
		int level = urchin.size();
		
		while(!urchin.isEmpty()) {

			if(escape) break; //비버의 굴 도착시 break
			
			if(--level == 0) { //고슴도치가 이동할 수 있는 곳의 개수가 0이 되면 1분 지난 것
				moveWater(); //분마다 물도 확장 일어남
				level = urchin.size();
			}

			int p[] = urchin.poll();
			int r = p[0], c = p[1], t = p[2];
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				//경계 내에 있으며 돌이 있는 자리가 아니며 물이 차있는 곳이 아니며 아직 지나지 않은 곳일 경우
				if(nr >= 0 && nr < R && nc >= 0 && nc < C 
				   && map[nr][nc] != 'X' && map[nr][nc] != '*' && !uv[nr][nc]) {
					if(map[nr][nc] == 'D') { //비버의 굴일 경우
						escape = true;
						time = t+1;
						break;
					}else { //그 외의 비어있는 곳인 경우
						uv[nr][nc] = true;
						urchin.offer(new int[] {nr, nc, t+1});							
					}
				}
			}
			
		}
		
		return escape;
		
	}

	//물의 확장 - bfs
	private static void moveWater() {
		
		int size = water.size();
		
		for(int i=0; i<size; i++) {
			int p[] = water.poll();
			int r = p[0], c = p[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				//경계 내에 있으며 비어있는 칸이라면
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] =='.') {
					map[nr][nc] = '*';
					water.offer(new int[] {nr, nc});
				}
			}			
		}
	}

}

/*
D..*
.X.S
....
....
 * */