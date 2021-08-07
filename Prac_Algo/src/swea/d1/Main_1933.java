package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//1933. 간단한 N 의 약수(D1)
public class Main_1933 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> front = new LinkedList<Integer>();
		Stack<Integer> back = new Stack<Integer>();
		
		for(int i=1; i<N/2; i++) {
			if(N%i == 0) {
				if(!front.contains(N/i) && !back.contains(i)) {
					front.offer(i);
					back.push(N/i);
				}
			}
		}
		
		while(true) {
			if(!front.isEmpty()) {
				sb.append(front.poll()).append(" ");
			}else if(!back.isEmpty()) {
				sb.append(back.pop()).append(" ");
			}else
				break;
		}
		
		System.out.print(sb);
		
	}

}
