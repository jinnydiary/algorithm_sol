import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Stack<String> stack = new Stack<String>();
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < T; ++t) {
			stack.clear();
			String str = br.readLine();
			
			boolean check = true;
			
			for(int i=0; i<str.length(); ++i) {
				char temp = str.charAt(i);
				if('(' == temp) stack.push("(");
				else if(')' == temp && !stack.isEmpty()) stack.pop();
				else {
					check = false;
					break;
				}
			}
			
			if(check && stack.isEmpty()) sb.append("YES\n");
			else sb.append("NO\n");
		}
		
		System.out.print(sb.substring(0, sb.length()-1));
	}

}
