package bj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 16953번 A->B(0916)
public class Main_16953 {

	static long A, B, cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextLong();
		B = sc.nextLong();

		cnt = -1;
		dfs();
		
		System.out.print(cnt);
		sc.close();

	}

	private static void dfs() {
		Queue<long[]> queue = new LinkedList<>();
		queue.offer(new long[] {A, 0});
		
		while(!queue.isEmpty()) {
			long[] num = queue.poll();
			if(num[0] > B) {
				continue;
			}else if(num[0] == B) {
				cnt = num[1]+1;
				break;
			}else {
				queue.offer(new long[] {num[0]*2, num[1]+1});
				queue.offer(new long[] {num[0]*10+1, num[1]+1});
			}
		}
		
	}

}
