package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 2798번 블랙잭(0826)
public class Main_2798 {

	static int N, M; //카드 개수, 제한 수
	static int[] card; //카드 정보
	static int sum = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		card = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) card[i] = Integer.parseInt(st.nextToken());
		
		combination(0, 0, 0, new int[3]);
		System.out.println(sum);
	}
	
	//카드 3장 뽑아 M을 넘지 않는 최대합 구하기(조합 이용)
	private static void combination(int cnt, int start, int flag, int[] cards) {
		if(cnt == 3) {
			int s = 0;
			for(int c : cards) s += c;
			if(sum < s && s <= M) sum = s;
			return;
		}
		
		for(int n = start; n < N; n++) {
			if((flag & 1<<n) != 0) continue;
			cards[cnt] = card[n];
			combination(cnt+1, n+1, (flag | 1<<n), cards);
		}
		
	}

}
