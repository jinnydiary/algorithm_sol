package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2071. 평균값 구하기(D1)
public class Main_2071 {
	
	static int N = 10;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			double sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				sum += Integer.parseInt(st.nextToken());
			
			System.out.printf("#%d %d %n", tc, Math.round(sum/N));
		}

	}

}
