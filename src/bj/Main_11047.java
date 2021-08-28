package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 - 11047번 동전 0
public class Main_11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] values = new int[N];
		
		for(int i=0; i<N; i++)
			values[i] = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for(int i=N-1; i>=0; i--) {
			if(values[i] > K || K == 0) continue;
			cnt += K / values[i];
			K -= (K/values[i]) * values[i];
		}
		System.out.println(cnt);
	}

}
