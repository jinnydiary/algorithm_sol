package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2072. 홀수만 더하기_난의도(D1)
public class Main_2072 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<10; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(num%2 == 1)
					sum += num;
			}
			
			System.out.println("#" + tc + " " + sum);
		}

	}

}
