package jungol;

//정글 1856번 숫자사각형2
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1856 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int num1 = 1, num2 = m*2;

		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= m; ++j) {
				if(i%2 == 1) sb.append(num1++ + " ");
				else sb.append(num2-- + " ");
			}
			if(i%2 == 1) num1 = num2+1;
			else num2 = num1 +m*2 -1;
			sb.append("\n");
		}
		
		System.out.print(sb.substring(0, sb.length()-1));
	}

}
