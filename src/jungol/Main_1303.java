package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//정글 1303번 숫자사각형1
public class Main_1303 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int num = 1;
		
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= m; ++j)
				sb.append(num++ + " ");
			sb.append("\n");
		}
		System.out.print(sb.substring(0, sb.length()-1));
	}

}
