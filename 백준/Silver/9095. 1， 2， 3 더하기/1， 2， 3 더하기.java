import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 9095번 1,2,3 더하기
public class Main {

	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine()); //정수 n 입력
			
			result = 0;
			perm(0, n);
			
			sb.append(result).append("\n");
		}
		System.out.print(sb);

	}
	
	//방법 개수 구하기
	private static void perm(int sum, int n) {
		if(sum > n) return;
		if(sum == n) {
			result++;
			return;
		}
		
		for(int i=1; i<=3; i++)
			perm(sum+i, n);
	}

}
