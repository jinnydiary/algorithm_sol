package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//백준 9012번 괄호(1129)
public class Main_9012 {

	static Stack<Character> stack;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		stack = new Stack<Character>();
		for(int t = 0; t < T; t++) {
			char[] ch = br.readLine().toCharArray();
			stack.clear();
			sb.append(checkStack(ch) ? "YES":"NO").append("\n");
		}
		
		System.out.print(sb.substring(0, sb.length()-1));
	}

	private static boolean checkStack(char[] ch) {
		boolean check = true;
		for(int i = 0; i < ch.length; i++) {
			if(ch[i] == '(') stack.push(ch[i]); // ( 괄호 일때 
			else if(ch[i] == ')' && !stack.isEmpty()) stack.pop(); // ) 괄호 일때
			else {
				check = false;
				break;
			}
		}
		
		if(check && !stack.isEmpty()) check = false;
		return check;
	}

}
