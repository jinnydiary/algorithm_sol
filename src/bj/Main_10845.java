package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//백준 10845번 큐(1103)
public class Main_10845 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			if("push".equals(order)) { //삽입일 경우
				int num = Integer.parseInt(st.nextToken());
				queue.offer(num);
			}
			else if("pop".equals(order)) { //삭제일 경우
				if(queue.isEmpty()) sb.append("-1\n");
				else {
					int num = queue.poll();
					sb.append(num + "\n");
				}
			}
			else if("size".equals(order)) { //큐의 크기
				sb.append(queue.size() + "\n");
			}
			else if("empty".equals(order)) { //큐가 비어있는지 여부
				if(queue.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
			}
			else if("front".equals(order)) { //큐의 가장 앞에 있는 값 출력
				if(queue.isEmpty()) sb.append("-1\n");
				else sb.append(queue.get(0) + "\n");
			}
			else if("back".equals(order)) { //큐의 가장 뒤에 있는 값 출력
				if(queue.isEmpty()) sb.append("-1\n");
				else sb.append(queue.get(queue.size()-1) + "\n");
			}
		}
		
		System.out.print(sb);
	}

}
