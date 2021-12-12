package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//정글 1304번 숫자사각형3
public class Main_1304 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= n; ++i) {
			int num = i;
			for(int j = 0; j < n; ++j) {
				num = i + n*j;
				sb.append(num + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb.substring(0, sb.length()-1));
	}

}
