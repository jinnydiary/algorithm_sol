package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//정글 2046번 숫자사각형4
public class Main_2046 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //n <= 100
		int m = Integer.parseInt(st.nextToken()); //1 <= m <= 3
		
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= n; ++j) {
				switch(m) {
				case 1:
					sb.append(i + " ");
					break;
				case 2:
					if(i%2 == 1) sb.append(j + " ");
					else sb.append((n+1-j) + " ");
					break;
				case 3:
					sb.append(i*j + " ");
					break;
				}
			}
			sb.append("\n");
		}
		
		System.out.print(sb.substring(0, sb.length()-1));

	}

}
