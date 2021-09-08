package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 - 2750번 수 정렬하기
public class Main_2750_2 {
	
	static Integer[] nums;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		nums = new Integer[N];
		
		for(int i=0; i<N; i++)
			nums[i] = Integer.parseInt(br.readLine());
		
		
		
		for(int num : nums)
			sb.append(num).append("\n");
		System.out.print(sb);

	}


}
