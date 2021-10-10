package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 3109번 빵집(1010)
public class Main_3109 {

	static int[] dr = {-1, 0, 1}; //오른쪽위, 오른쪽, 오른쪽아래
	static int[] dc = {1, 1, 1};

	static int R,C, res; //행과 열의 크기, 결과
	static char[][] map; //빵근 근처 모습
	static boolean[][] visited; //방문 체크
	static boolean arrive; //도착 여부
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R+1][C+1];
		
		for(int r=1; r<=R; r++) {
			char[] m = br.readLine().toCharArray();
			for(int c=1; c<=C; c++) {
				map[r][c] = m[c-1];
			}
		}
		
		res = 0;
		visited = new boolean[R+1][C+1];
		for(int r=1; r<=R; r++) { //1행부터 가스관 연결 가능한지 확인하며 파이프라인 놓기
			dfs(r, 1);
			arrive = false; //다음 행에 파이프라인을 놓을 수 있는지 확인하기 위해 false
		}
		
		System.out.println(res);

	}
	 
	//파이프라인 놓기 - 백트래킹(dfs)
	private static void dfs(int r, int c) {
		if(c == C) { //근처 빵집의 가스관이라면
			res++;
			visited[r][c] = true;
			arrive = true;
			return;			
		}
		
		visited[r][c] = true; //방문 체크
		
		for(int d = 0; d < 3; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			//경계 내에 있으며 아직 방문하지 않았고 빈칸인 경우
			if(isAvailable(nr, nc)) dfs(nr, nc);
			
			//해당 행이 마지막 열에 도착했다면 탐색 끝냄
			if(arrive) return;
		}
		
	}

	private static boolean isAvailable(int r, int c) {
		return r > 0 && r <= R && c > 0 && c <= C && !visited[r][c] && map[r][c] == '.';
	}

}
