import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		for(int i=0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			switch(order) {
				case "push":
					int X = Integer.parseInt(st.nextToken());
					stack.push(X);
					break;
				case "pop":
					if(stack.isEmpty()) sb.append(-1 + "\n");
					else sb.append(stack.pop() + "\n");
					break;
				case "size":
					sb.append(stack.size() + "\n");
					break;
				case "empty":
					if(stack.isEmpty()) sb.append(1 + "\n");
					else sb.append(0 + "\n");
					break;
				case "top":
					if(stack.isEmpty()) sb.append(-1 + "\n");
					else sb.append(stack.peek() + "\n");
					break;
			}
		}
		
		System.out.print(sb.substring(0, sb.length()-1));

	}

}
