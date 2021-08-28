package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.print(findMin(N, 0));
	}

	private static int findMin(int n, int cnt) {
		System.out.print(n + " ");
		if(n == 1) return cnt;
		else if(n % 3 == 0) return findMin(n/3, cnt+1);
		else if(n % 2 == 0 && ((n-1)/3)%2 != 0 ) return findMin(n/2, cnt+1);
		else return findMin(n-1, cnt+1);	
		
	}

}
