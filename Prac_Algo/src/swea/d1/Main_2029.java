package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2029. 몫과 나머지 출력하기(D1)
public class Main_2029 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append("#" + tc + " " + a/b + " " + a%b +"\n");
		}
		System.out.println(sb);

	}

}
