package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 1697번 숨바꼭질(1101)
public class Main_1697 {

	static final int num = 100001;
	static int N, K; //수빈이의 현재 위치, 동생의 위치
	static boolean[] visited;
	static Queue<int[]> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		System.out.println(bfs());
	}
	
	//수빈이 이동 - bfs
	private static int bfs() {
		queue = new LinkedList<>();
		queue.offer(new int[] {N, 0});
		visited = new boolean[num];
		visited[N] = true;
		int time = 0;
		
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			int pos = p[0];
			time = p[1];
			if(pos == K) break; //동생을 찾았다면 break
			
			//걸을 경우 1초 후에 있을 수 있는 위치: +1, -1
			checkVisit(pos-1, time);
			checkVisit(pos+1, time);
			//순간이동을 하는 경우 1초 후 있을 수 있는 위치: *2
			checkVisit(pos*2, time);

		}
		return time;
	}

	//이동할 수 있는 위치인지 체크
	private static void checkVisit(int next, int time) {
		if(0 <= next && next < num && !visited[next]) {
			visited[next] = true;
			queue.offer(new int[] {next, time+1});				
		}
		
	}

}
