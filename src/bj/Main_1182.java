package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 1182번 부분수열의 합(0829)
public class Main_1182 {

	static int n; //정수 개수
	static long s; //목표합
	static int[] num; //정수 배열
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Long.parseLong(st.nextToken());
		num = new int[n]; //정수 배열
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(num);
		
		if( n<1 || n>20 || Math.abs(s) > 1000000 ) result = 0;
		else {
			long sum = (s == 0) ? -1 : 0; //구하려는 값이 0일 경우 공집합 제거후 시작
			result = (s == 0) ? -1 : 0; 
			findCnt(0, sum);
		}
		System.out.print(result);
	}
	
	//부분수열 구하기 - 부분집합
	private static void findCnt(int cnt, long sum) {
		if(cnt == n) {
			if(sum == s) result++;
			return;
		}
		
		findCnt(cnt+1, sum+num[cnt]);
		findCnt(cnt+1, sum);
		
	}

}
