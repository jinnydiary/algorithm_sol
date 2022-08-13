import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int N;
	static char[][] color;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = { 0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		color = new char[N][N];
		for(int r = 0; r < N; ++r) {
			char[] ch = br.readLine().toCharArray();
			for(int c = 0; c < N; ++c)
				color[r][c] = ch[c];
		}
		
		for(int i = 0; i < 2; ++i) {
			int cnt = 0;
			 visited = new boolean[N][N];
			 for(int r = 0; r < N; ++r) {
				for(int c = 0; c < N; ++c) {
					if(!visited[r][c]) {
						bfs(r, c, i, color[r][c]);
						++cnt;
					}
				}
			}
			System.out.print(cnt + " ");
		}

	}
	
	private static void bfs(int r, int c, int i, char alpha) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {r, c});
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			
			for(int d = 0; d < 4; ++d) {
				int tr = p[0] + dr[d];
				int tc = p[1] + dc[d];
				if(tr >= 0 && tr < N && tc >= 0 && tc < N && !visited[tr][tc]) {
					if((i == 0 && color[tr][tc] == alpha)
					|| i == 1 && (((alpha == 'R' || alpha == 'G') && (color[tr][tc] == 'R' || color[tr][tc] == 'G')) || (alpha == 'B' && color[tr][tc] == 'B'))) {
						queue.offer(new int[] {tr, tc});
						visited[tr][tc] = true;
					}
				}
			}
			
		}
		
	}

}
