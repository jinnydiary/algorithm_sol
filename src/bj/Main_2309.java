package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//백준 2309번 일곱 난쟁이(0906)
public class Main_2309 {

	static int[] height, people, temp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		height = new int[9]; //9명의 난쟁이
		for(int i=0; i<height.length; i++)
			height[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(height);
		people = new int[7];
		temp = new int[7];
		
		findCnt(0, 0);
		
		Arrays.sort(people);
		for(int p : people) sb.append(p).append("\n");
		System.out.print(sb);
	}
	
	//진짜 난쟁이 찾기
	private static void findCnt(int cnt, int start) {
		if(cnt == 7) {
			calculate();
			return;
		}
		
		for(int i=start; i<height.length; i++) {
			temp[cnt] = height[i];
			findCnt(cnt+1, i+1);
		}
		
	}

	private static void calculate() {
		int sum = 0;
		for(int t : temp) sum += t;
		if(sum == 100)
			for(int i=0; i<temp.length; i++)
				people[i] = temp[i];	
	}

}
