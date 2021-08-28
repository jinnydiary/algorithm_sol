package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2068. 최대수 구하기(D1)
public class Main_2068 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int max = Integer.parseInt(st.nextToken());
			
			for(int i=1; i<10; i++)
				max = Math.max(max, Integer.parseInt(st.nextToken()));
			sb.append("#" + tc + " " + max + "\n");
		}
		
		System.out.print(sb);

	}

}
