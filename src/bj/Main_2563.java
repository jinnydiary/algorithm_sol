package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 2563번 색종이(0926)
public class Main_2563 {

	static class Paper {
		int r, c;
		
		public Paper(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, res;
	static Paper[] p;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		map = new int[100][100];
		N = Integer.parseInt(br.readLine());
		
		p = new Paper[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			p[i] = new Paper(r, c);
		}
		
		fillPaper(0);
		System.out.println(res);
	}
	
	private static void fillPaper(int cnt) {
		if(cnt == N) return;
		
		int r = p[cnt].r;
		int c = p[cnt].c;
		
		for(int i=r; i<r+10; i++)
			for(int j=c; j<c+10; j++)
				if(map[i][j] == 0) {
					map[i][j] = 1;
					res++;
				}
		
		fillPaper(cnt+1);
	}

}
