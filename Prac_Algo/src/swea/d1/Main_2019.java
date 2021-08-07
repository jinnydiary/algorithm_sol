package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2019. 더블더블(D1)
public class Main_2019 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int i = 0;
		while(i<=N) {
			int num = (int)Math.pow(2, i++); //Math.pow함수 사용해서 제곱값 구하기
			sb.append(num).append(" ");
		}
		System.out.print(sb);
	}

}
