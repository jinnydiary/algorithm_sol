package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SWEA 9229번 한빈이와 Spot Mart(0926)
public class Main_9229 {

	static int N, M;
	static int[] snack;
	static long res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			snack = new int[N];
			for(int i=0; i<N; i++)
				snack[i] = Integer.parseInt(st.nextToken());
			
			res = -1;
			selectSnack(0, 0, 0);
			
			sb.append("#" + t + " " + res + "\n");
			
		}
		System.out.print(sb);
	}
	
	private static void selectSnack(int start, int cnt, int sum) {
		if(cnt == 2) {
			if(res < sum && sum <= M) res = sum;
			return;
		}
		
		for(int i = start; i < N; i++) {
			selectSnack(i+1, cnt+1, sum+snack[i]);
		}
	}

}
