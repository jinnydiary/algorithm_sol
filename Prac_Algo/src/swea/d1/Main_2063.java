package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//2063. 중간값 찾기(D1)
public class Main_2063 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] scores = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++)
			scores[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(scores);
		
		System.out.print(scores[N/2]);

	}

}
