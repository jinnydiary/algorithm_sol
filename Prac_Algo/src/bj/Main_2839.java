package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 - 2839번 설탕 배달
public class Main_2839 {

	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		System.out.println(count(N, 0));
	}

	private static int count(int n, int c) {
		if(n == 0) return c; //딱 나눠졌기 때문에 횟수인 c 리턴!
		else if(n%5 == 0) return count(n-5, ++c); //n%3==0도 동시에 되는 경우도 포함!
		else if(n%3 == 0) return count(n-3, ++c);
		else if( (n-5) >= 3) return count(n-5, ++c);
		else return -1; //위 경우 모두 안되면 딱 나눌 수 없음
	}

}
