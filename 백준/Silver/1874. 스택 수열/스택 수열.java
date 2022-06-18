import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	private static int push(int pos, int num) {
		while(stack.isEmpty() || pos > stack.peek()) {
			stack.push(++num);
			sb.append("+\n");
		}
		return num;
	}

	private static void pop(int pos) {
		while(!stack.isEmpty() && pos <= stack.peek()) {
			stack.pop();
			sb.append("-\n");				
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	static Stack<Integer> stack = new Stack<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int num = 0;
		
		for(int i = 0; i < n; ++i) { //n번
			int pos = Integer.parseInt(br.readLine());
			
			num = push(pos, num);
			pop(pos);
			
			if(num > n) break;
		}
		
		if(num <= n && stack.isEmpty()) System.out.print(sb);
		else System.out.print("NO");
	}

}
