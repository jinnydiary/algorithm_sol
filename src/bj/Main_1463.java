package bj;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

//백준 1463번 1로 만들기 - DP사용(동적계획법)(0930)
public class Main_1463 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(findMin(N, new int[N+1]));
	}

	private static int findMin(int n, int[] D) {
		
		for(int i=2; i<=n; i++) {
			int min = Integer.MAX_VALUE;				
			if(i%3==0) min = Math.min(min, D[i/3]+1);
			if(i%2==0) min = Math.min(min, D[i/2]+1);
			if(i-1>=1) min = Math.min(min, D[i-1]+1);
			D[i] = min;
		}
			
		return D[n];
	}

}
