import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

//백준 11279번 최대 힙(1004)
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); //연산의 개수
		
		//Collections.reverseOrder() : 내림차순 정렬
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i = 0; i < N ; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) { //0일 경우
				if(pq.isEmpty()) sb.append(0 + "\n");
				else {
					int num = pq.poll();
					sb.append(num + "\n");
				}
			}else { //자연수일 경우
				pq.offer(x);
			}
		}
		
		System.out.print(sb);
		
	}

}
