package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2025. N줄덧셈(D1)
public class Main_2025 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(sum(N));
	}

	private static int sum(int n) {
		if(n <= 1)
			return 1;
		return n + sum(n-1);
	}

}
