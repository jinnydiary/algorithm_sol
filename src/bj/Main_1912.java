package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 1912번 연속합(0927)
public class Main_1912 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //정수 개수 입력
		
		int[] num = new int[N]; //정수 배열
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			num[i] = Integer.parseInt(st.nextToken()); //정수 입력
		
		int[][] S = new int[N][2]; //정수들의 합을 입력받을 배열
		S[0][0] = S[0][1] = num[0]; //0번째값 우선 설정
		int max = num[0]; //최댓값도 초기값으로 설정
		
		for(int i=1; i<N; i++) {
			S[i][0] = num[i]; //[i][0] 번째는 현재 위치 값
			//[i][1]는 앞의 값들을 고려해 큰 값 입력 받음
			S[i][1] = Math.max(num[i], Math.max(S[i-1][0]+num[i], S[i-1][1]+num[i]));
			
			max = Math.max(max, Math.max(S[i][0], S[i][1])); //위의 값들과 max 값들을 비교해 max 값 결정
		}
		System.out.println(max);
	}
}
