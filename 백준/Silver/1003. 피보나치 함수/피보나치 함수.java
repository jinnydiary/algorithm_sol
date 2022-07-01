import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 1003번 피보나치 함수(0930) - DP(동적계획법)
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] fibo = new int[N+2][2]; //각 숫자별로 0과 1의 호출 개수 담을 배열
			fibo[0][0] = fibo[1][1] = 1;
			fibo[0][1] = fibo[1][0] = 0;
			
			for(int n = 2; n<=N; n++) {
				fibo[n][0] = fibo[n-1][0] + fibo[n-2][0];
				fibo[n][1] = fibo[n-1][1] + fibo[n-2][1];
			}
			
			sb.append(fibo[N][0] + " " + fibo[N][1] + "\n");
		}
		
		System.out.print(sb);

	}

}
