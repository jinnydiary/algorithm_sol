package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//stack으로 풀어보기
public class Main_5432_2 {
	
	static Stack<Character> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			stack = new Stack<>();
			char[] ch = br.readLine().toCharArray();
			int cnt = 0, sum = 0;
			
			for(int i=0; i<ch.length; i++) {
				
				if(ch[i] == ')' && stack.peek() == '(') //레이저일 때
					sum += --cnt;
				else if(ch[i] == '(') //쇠막대기 하나 시작
					++cnt;
				else if(ch[i] == ')' && !(stack.peek() == '(')) { //쇠막대기 하나가 끝날 때
					sum += 1;
					--cnt;
				}
				stack.push(ch[i]);
			}
			sb.append("#" + tc + " " + sum + "\n");
		}
		System.out.print(sb);

	}

}
