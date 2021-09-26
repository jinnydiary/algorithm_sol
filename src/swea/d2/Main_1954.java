package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//SWEA 1954번 달팽이 숫자(0926)
public class Main_1954 {

	static int[] dr = {0, 1, 0, -1}; //우,하,좌,상
	static int[] dc = {1, 0, -1, 0};
	static int N, snails[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			snails = new int[N][N];
			putNumber(1, 0, 0, 0);
			sb.append("#" + t + "\n");
			print();
		}
		System.out.print(sb);

	}
	
	//달팽이 출력하기
	private static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(snails[i][j] + " ");
			}
			sb.append("\n");
		}
		
	}

	//달팽이 숫자 채우기
	private static void putNumber(int num, int r, int c, int dir) {
		if(num > N*N) return;
		if(r>=0 && r<N && c>=0 && c<N && snails[r][c] == 0) {
			snails[r][c] = num;
		}
		
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		
		if(nr<0 || nr>=N || nc<0 || nc>=N || snails[nr][nc] != 0) {
			if(++dir > 3) dir = 0;
			nr = r + dr[dir];
			nc = c + dc[dir];
		}
		
		putNumber(num+1, nr, nc, dir);
	}

}
