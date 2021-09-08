package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 11399번 ATM(0826)
public class Main_11399 {

	static int N; //사람의 수
	static int[] p; //각 사람이 돈 인출 걸리는 시간 배열
	static int time;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		p = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) p[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(p); //오름차순 정렬
		int temp = 0;
		for(int t : p) {
			temp += t;
			time += temp;
		}

		System.out.println(time);

	}
	
	//줄세우기(순열 이용) -- 아까워서 못지옹.. 경우의 수가 너무 많아서 시간초과뜸 시간복잡도 고려할 것!!
	private static void permutation(int cnt, int flag, int[] index) {
		//줄 세우기가 끝났다면
		if(cnt == N) {
			int sum = 0, temp = 0;
			for(int idx : index) {
				temp += p[idx];
				sum += temp;
			}
			if(time > sum) time = sum;
			return;
		}
		
		for(int n = 0; n < N; n++) {
			if( (flag & 1<<n) != 0 ) continue;
			index[cnt] = n;
			permutation(cnt+1, (flag | 1<<n), index);
		}
	}

}
