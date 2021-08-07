package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2058. 자릿수 더하기(D1)
public class Main_2058 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		
		while(N > 0) {
			sum += N%10;
			N /= 10;
		}
		
		System.out.print(sum);

	}

}
