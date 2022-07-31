import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M, N, H;
	static int[] dh = {0, 0, 0, 0, 1, -1}; //상, 하, 좌, 우, 위, 아래
	static int[] dr = {-1, 1, 0, 0, 0, 0};
	static int[] dc = {0, 0, -1, 1, 0, 0};
	static int[][][] tomato;
	static boolean[][][] visited;
	static Queue<int[]> queue = new LinkedList<int[]>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); //가로 칸 수
		N = Integer.parseInt(st.nextToken()); //세로 칸 수
		H = Integer.parseInt(st.nextToken()); //상자 수
		
		tomato = new int[H][N][M]; //토마토가 든 상자
		visited = new boolean[H][N][M];
		int count = 0;
		
		for(int h = 0; h < H; ++h) {
			for(int r = 0; r < N; ++r) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int c = 0; c < M; ++c) {
					tomato[h][r][c] = Integer.parseInt(st.nextToken());
					if(tomato[h][r][c] == 1) {
						queue.offer(new int[] {h, r, c, 0});
						visited[h][r][c] = true;
					}
					if(tomato[h][r][c] != 0) { //1: 익은 토마토, 0: 익지 않은 토마토, -1: 토마토 없음
						++count;
					}
				}
			}
		}
		System.out.print(bfs(count));
	}
	
	private static int bfs(int count) {
		int day = 0;
		
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			if(p[3] > day) day = p[3];
			
			for(int d = 0; d < 6; ++d) {
				int h = p[0] + dh[d];
				int r = p[1] + dr[d];
				int c = p[2] + dc[d];
				if(h >= 0 && h < H && r >= 0 && r < N && c >= 0 && c < M && tomato[h][r][c] == 0 && !visited[h][r][c]) {
					queue.offer(new int[] {h, r, c, p[3]+1});
					visited[h][r][c] = true;
					++count;
				}
			}
		}
		return count == M * N * H ? day : -1;
	}

}
