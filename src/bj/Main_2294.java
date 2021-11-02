package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 2294번 동전 2(1102)
public class Main_2294 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //동전 개수
		int k = Integer.parseInt(st.nextToken()); //가치의 합
		int[] money = new int[n]; //각각의 동전 가치
		for(int m = 0; m < n; ++m)
			money[m] = Integer.parseInt(br.readLine());
		
		int[] C = new int[k+1]; //각 가치의 동전 최소 사용 개수
		C[0] = 0; //0 가치는 0
		for(int m = 1; m <= k; ++m) {
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < n; i++) {
				//가치보다 크거나 같고 해당 숫자를 가치로 나눴을 때 0이거나 m-money[i]의 위치하는 숫자의 동전 사용 개수가 0 초과일 경우
				if(m - money[i] >= 0 &&  (m % money[i] == 0 || C[m-money[i]] > 0) ) {
					min = Math.min( min, C[m-money[i]] );
				}
			}
			C[m] = (min == Integer.MAX_VALUE) ? 0 : min + 1;
		}
		
		//System.out.println(Arrays.toString(C));
		System.out.print( (C[k] == 0) ? -1 : C[k] );
	}

}
