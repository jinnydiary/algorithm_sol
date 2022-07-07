import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, friends[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		friends = new int[N+1][N+1];
		for(int m = 0; m < M; ++m) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friends[a][b] = friends[b][a] = 1;
		}
		
		int min = Integer.MAX_VALUE;
		int minPerson = 0;
		for(int n = 1; n <= N; ++n) {
			int count = bfs(n);
			if(min > count) {
				min = count;
				minPerson = n;
			}
		}
		
		System.out.print(minPerson);
	}
	
	private static int bfs(int n) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {n, 0});
		boolean[] meet = new boolean[N+1];
		meet[n] = true;
		
		int res = 0;
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			int p = info[0], cabin = info[1];
			
			for(int i = 1; i <= N; ++i) {
				if(friends[p][i] == 1 && !meet[i]) {
					queue.offer(new int[] {i, cabin+1});
					res += (cabin+1);
					meet[i] = true;
				}
			}
		}
		
		return res;
		
	}

}
