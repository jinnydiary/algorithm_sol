package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 10974번 모든 순열(0829)
public class Main_10974 {

	static int n; //숫자
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		
		permutation(0, 0, new int[n]);
		System.out.print(sb);
	}

	//순열
	private static void permutation(int cnt, int flag, int[] num) {
		if(cnt == n) {
			for(int n : num) sb.append(n).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if( (flag & 1<<i) != 0) continue;
			num[cnt] = i;
			permutation(cnt+1, (flag | 1<<i), num);
		}
		
	}

}
