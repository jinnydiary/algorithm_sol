package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2070. 큰 놈, 작은 놈, 같은 놈(D1)
public class Main_2070 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			sb.append("#" + tc + " ");
			if(n1 < n2) sb.append("<\n");
			else if(n1 > n2) sb.append(">\n");
			else sb.append("=\n");
		}
		
		System.out.print(sb);

	}

}
