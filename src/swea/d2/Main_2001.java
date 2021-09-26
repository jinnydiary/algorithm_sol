package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SWEA 2001번 파리 퇴치(0926)
public class Main_2001 {

	static int N, M, max;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = 0;
			catchFly(0, 0);
			
			sb.append("#" + t + " " + max + "\n");
		}
		System.out.print(sb);

	}
	
	//파리 잡기
	private static void catchFly(int r, int c) {
		if(r+M-1>=N) return;
		if(c+M-1 >= N) {
			catchFly(r+1, 0);
			return;
		}

		int sum = 0;
		for(int i = r; i<r+M; i++) {
			for(int j = c; j<c+M; j++) {
				sum += map[i][j];
			}
		}
			
		if(max < sum) max = sum;
		catchFly(r, c+1);
		
	}

}
