package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//정글 1071번 약수와 배수
public class Main_1071 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //정수의 개수
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i)
			num[i] = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine()); //약수&배수 구할 정수
		
		for(int i = 0; i < 2; ++i) {
			int sum = 0;
			for(int j = 0; j < n; ++j)
				if( (i == 0 && num[j] <= m && m%num[j] == 0) || (i == 1 && num[j] >= m && num[j]%m == 0) )
					sum += num[j];
			System.out.print(sum + "\n");
		}

	}

}
