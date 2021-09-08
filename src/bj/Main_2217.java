package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 1439번 뒤집기(0908)
public class Main_2217 {

	static int cnt0, cnt1;
	static char[] S, temp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine().toCharArray();
		
		temp = S.clone();
		check0(0, 0, 0);
		check1(0, 0, 0);

		System.out.println((cnt0 < cnt1) ? cnt0 : cnt1);

	}
	
	//모두 1로 만들 경우
	private static void check1(int cnt, int i, int j) {
		if(cnt >= temp.length) {
			if(i != j) cnt1++;
			return;
		}
		
		if(temp[j] == '1') {
			if(i != j) { //i와 j가 다르면 0이 있는 범위
				cnt1++;
				i = j;
			}
			check1(cnt+1, i+1, j+1);
		}else { //0일 경우
			check1(cnt+1, i, j+1);
		}
		
	}

	// 모두 0으로 만들 경우
	private static void check0(int cnt, int i, int j) {
		if(cnt >= temp.length) {
			if(i != j) cnt0++;
			return;
		}
		
		if(temp[j] == '0') {
			if(i != j) { //i와 j가 다르면 1이 있는 범위
				cnt0++;
				i = j;
			}
			check0(cnt+1, i+1, j+1);
		}else {
			check0(cnt+1, i, j+1);
		}
		
	}

}
