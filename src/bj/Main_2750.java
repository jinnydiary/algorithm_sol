package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 - 2750번 수 정렬하기
public class Main_2750 {
	
	static int[] nums;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		
		for(int i=0; i<N; i++)
			nums[i] = Integer.parseInt(br.readLine());
		
		ascendingSort(N-1, 0);
		
		for(int num : nums)
			sb.append(num).append("\n");
		System.out.print(sb);

	}

	private static void ascendingSort(int cnt, int check) {
		if(check >= N) return;
		for(int i=0; i<cnt; i++) {
			if(nums[i] >= nums[i+1])
				swap(i, i+1);
		}
		ascendingSort(cnt-1, check+1);
	}
	
	private static void swap(int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}


}
