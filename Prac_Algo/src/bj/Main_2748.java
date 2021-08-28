package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 - 2748번 피보나치 수2
public class Main_2748 {
	static long[] num = new long[91];
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		num[1] = 1;
		fibo(0);
		System.out.println(num[n]);

	}

	private static void fibo(int cnt) {
		if(cnt > n || n < 2) return;
		else if(cnt >= 2 && num[cnt] == 0)
			num[cnt] = num[cnt-1] + num[cnt-2];
		fibo(cnt+1);
	}

}
