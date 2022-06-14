import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		while(N-- != 0) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			switch(str) {
			case "push":
				queue.add(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(!queue.isEmpty()) sb.append(queue.poll() + "\n");
				else sb.append(-1 + "\n");
				break;
			case "size":
				sb.append(queue.size() + "\n");
				break;
			case "empty":
				if(!queue.isEmpty()) sb.append(0 + "\n");
				else sb.append(1 + "\n");
				break;
			case "front":
				if(!queue.isEmpty()) sb.append(queue.peekFirst() + "\n");
				else sb.append(-1 + "\n");
				break;
			case "back":
				if(!queue.isEmpty()) sb.append(queue.peekLast() + "\n");
				else sb.append(-1 + "\n");
				break;
			}
		}
		
		System.out.print(sb);

	}

}
