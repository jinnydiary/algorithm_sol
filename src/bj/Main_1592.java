package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 1592번 영식이와 친구들(0826)
public class Main_1592 {

	static int N, M, L; //인원, 공받은 횟수, 공받을 사람 위치
	static int[] count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		count = new int[N+1]; //1~N번 사람까지 공을 받는 횟수
		count[1] = 1; //1번 사람이 처음 공 받음
		
		throwBall(1, 0);
	}

	//공 던져서 횟수 카운트
	private static void throwBall(int idx, int cnt) {
		//현재 공 받은 사람이 공 받은 횟수 M번이라면 리턴
		if(count[idx] == M) {
			System.out.println(cnt);
			return;
		}
		
		//공받은 횟수가 M보다 작은 경우
		if(count[idx]%2 == 1) idx = (idx+L > N) ? idx+L-N : idx+L; //홀수면 시계 방향
		else idx = (idx-L <= 0) ? idx-L+N : idx-L; //짝수면 반시계 방향
		
		count[idx]++;
		throwBall(idx, cnt+1);
	}

}
