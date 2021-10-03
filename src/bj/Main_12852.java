package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 12852번 1로 만들기 2(1003)
public class Main_12852 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //정수 N
		int[] Min = new int[N+1]; //연산 최소 사용 횟수 저장할 배열
		int[][] num = new int[N+1][]; //N을 1로 만드는 방법에 포함된 수 저장할 배열
		
		//정수 1은 미리 설정
		Min[1] = 0;
		num[1] = new int[1];
		num[1][0] = 1;
		
		//최소 연산 횟수 및 1을 만드는 방법에 포함된 수 찾기
		for(int i=2; i<=N; i++) {
			int min = Integer.MAX_VALUE;
			int idx = 0;
			if(i%3 == 0) {
				if(min > Min[i/3]+1) {
					min = Min[i/3]+1;
					idx = i/3;					
				}
			}
			if(i%2 == 0) {
				if(min > Min[i/2]+1) {
					min = Min[i/2]+1;
					idx = i/2;					
				}
			}
			if(i-1 >= 1) {
				if(min > Min[i-1]+1) {
					min = Min[i-1]+1;
					idx = i-1;					
				}
			}
			
			Min[i] = min;
			num[i] = new int[min+1];
			for(int m=0; m<min; m++)
				num[i][m] = num[idx][m];
			num[i][min] = i;
		}
		
		//출력
		System.out.println(Min[N]);
		for(int i=Min[N]; i>=0; --i)
			System.out.print(num[N][i] + " ");

	}

}
