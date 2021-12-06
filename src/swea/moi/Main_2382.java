package swea.moi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//2382. [모의 SW 역량테스트] 미생물 격리
public class Main_2382 {
	
	static class Microbe {
		int r, c, cnt, move;
		public Microbe(int r, int c, int cnt, int move) {
			this.r = r;
			this.c= c;
			this.cnt = cnt;
			this.move = move;
		}
	}

	static Queue<Microbe> queue;
	static int N, M, K;
	static int[][] map, cnt_max, cnt_sum, move_max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		queue = new LinkedList<>();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; ++t) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //한변의 셀 개수
			M = Integer.parseInt(st.nextToken()); //격리시간
			K = Integer.parseInt(st.nextToken()); //미생물 군집의 개수
			
			for(int k = 0; k < K; ++k) { //미생물 정보 입력받기
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				queue.offer(new Microbe(r, c, m, d));
			}
			
			countMicrobe(0);
			int sum = 0, size = queue.size();
			for(int i=0; i<size; ++i)
				sum += queue.poll().cnt;
			
			sb.append("#" + t + " " + sum + "\n");
		}
		System.out.print(sb.substring(0, sb.length()-1));

	}
	
	private static void countMicrobe(int m) {
		
		while(m < M) {
			
			int size = queue.size();
			map = new int[N][N]; //해당 위치에 있는 미생물 군집 개수
			cnt_max = new int[N][N]; // 해당 위치에서 최대 미생물 수
			cnt_sum = new int[N][N]; // 해당 위치에서 총 미생물 합
			move_max = new int[N][N]; // 해당 위치에서 최대 미생물 수의 군집의 방향

			//step1. 미생물 이동
			for(int i=0; i<size; ++i) {
				Microbe mc = queue.poll();
				switch(mc.move) {
				case 1: //상
					mc.r -= 1;
					break;
				case 2: //하
					mc.r += 1;
					break;
				case 3: //좌
					mc.c -= 1;
					break;
				case 4: //우
					mc.c += 1;
					break;
				}
				
				if(mc.r == 0 || mc.r == N-1 || mc.c == 0 || mc.c == N-1) { // 약품이 칠해져 있는 셀에 있을 경우
					mc.cnt /= 2;
					mc.move = (mc.move == 1) ? 2 : ( (mc.move == 2) ? 1 : ( (mc.move == 3) ? 4 : 3 ) );
				}
				
				if(mc.cnt != 0) { //미생물 수가 있는 경우				
					map[mc.r][mc.c]++;
					cnt_sum[mc.r][mc.c] += mc.cnt;
					//군집이 하나만 위치하거나 여러 군집 중 가장 많은 미생물 수를 가진 군집이라면
					if( (map[mc.r][mc.c] == 1) || ( (map[mc.r][mc.c] > 1) && (mc.cnt > cnt_max[mc.r][mc.c]) ) ) {
						cnt_max[mc.r][mc.c] = mc.cnt;
						move_max[mc.r][mc.c] = mc.move;
					}
				}
			}
			
			//step2. 같은 위치의 미생물들 합치기 및 큐에 삽입
			for(int r = 0; r < N; ++r)
				for(int c = 0; c < N; ++c)
					if(map[r][c] >= 1)
						queue.offer(new Microbe(r, c, cnt_sum[r][c], move_max[r][c]));
			
			//step3. 시간 증가
			++m; //1시간씩 지날때마다 증가
		}
		
	}

}
