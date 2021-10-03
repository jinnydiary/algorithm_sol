package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 15649번 N과 M(1)(1003)
public class Main_15649 {

	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); //자연수 N과 M
		
		backtracking(0, new int[M]);
	}
	
	//사전 순으로 증가하는 순서로 수열 출력
	private static void backtracking(int cnt, int[] num) {
		if(cnt == M) {
			for(int i=0; i<M; i++)
				System.out.print(num[i] + " ");
			System.out.println();
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(isAvailble(i, cnt, num)) { //중복 확인
				num[cnt] = i;
				backtracking(cnt+1, num);
			}
		}
		
	}

	////0~cnt-1번까지 숫자들과 중복인지 확인
	private static boolean isAvailble(int number, int cnt, int[] num) {
		for(int i=0; i<cnt; i++)
			if(num[i] == number) return false; //0~cnt-1번 중 숫자와 겹치는 경우 false
		return true;
	}

}
