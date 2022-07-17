import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//백준 1927번 최소 힙(1004)
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); //우선순위 큐(오름차순)
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) { //0일 경우
				if(pq.isEmpty()) sb.append(0 + "\n");
				else sb.append(pq.poll() + "\n");
			}else { //자연수일 경우
				pq.offer(x);
			}
		}
		
		System.out.print(sb);

	}

}
