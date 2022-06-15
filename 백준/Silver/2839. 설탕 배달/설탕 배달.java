import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = findMin(N, new int[N+1]);
		System.out.print(result == 0 ? -1 : result);

	}

	private static int findMin(int n, int[] num) {
		for(int i = 3; i <= n; ++i) {
			int temp = Integer.MAX_VALUE;
			if( (i-3)%3 == 0 || (i-3)%5 == 0 || num[i-3] != 0) temp = Math.min(temp, num[i-3]+1);
			if( (i-5>=0) && ((i-5)%5 == 0 || (i-5)%3 == 0 || num[i-5] != 0)) temp = Math.min(temp, num[i-5]+1);
			num[i] = temp == Integer.MAX_VALUE ? 0 : temp;
		}
		return num[n];
	}

}
