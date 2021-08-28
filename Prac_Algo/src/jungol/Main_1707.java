package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//정올 1707번 달팽이삼각형
public class Main_1707 {

	static int n; //정사각형 크기
	static int[] dr = {0, 1, 0, -1}; //우하좌상
	static int[] dc = {1, 0, -1, 0};
	static int[][] snail; //숫자 넣을 배열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		snail = new int[n][n];
		
		search(0, -1, 0, 1);
		
		for(int[] sn : snail) {
			for(int s : sn)
				sb.append(s).append(" ");
			sb.append("\n");
		}
		System.out.print(sb);
		
	}
	
	//달팽이사각형 만들기 - 델타방식
	private static void search(int r, int c, int dir, int cnt) {
		if(cnt > n*n) return;
		
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		
		if(nr>=0 && nr<n && nc>=0 && nc<n && snail[nr][nc] == 0) { //조건에 맞다면
			snail[nr][nc] = cnt++;
			r = nr;
			c = nc;
		}else { //방향을 바꿔야 하는 경우
			if(dir == 3) dir = 0;
			else ++dir;
		}
		
		search(r, c, dir, cnt);
		
	}

}
