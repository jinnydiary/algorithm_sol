package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 1244번 스위치 켜고 끄기(0920)
public class Main_1244 {

	static int N, S;
	static int[] switches;
	static int[][] students;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine()); //스위치 개수
		switches = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//스위치 초기 상태
		for(int i=1; i<N+1; i++)
			switches[i] = Integer.parseInt(st.nextToken());
		
		S = Integer.parseInt(br.readLine()); //학생 수
		students = new int[S][2];
		
		for(int i=0; i<S; i++) {
			st = new StringTokenizer(br.readLine());
			students[i][0] = Integer.parseInt(st.nextToken());
			students[i][1] = Integer.parseInt(st.nextToken());
		}
		
		change(0);
		for(int i=1; i<N+1; i++) {
			if(i%20 == 0) sb.append(switches[i] + "\n");
			else sb.append(switches[i] + " ");
		}
		
		System.out.print(sb);

	}

	private static void change(int cnt) {
		if(cnt == S) return;
		
		int gender = students[cnt][0];
		int number = students[cnt][1];
		
		if(gender == 1) { //남학생일 경우
			for(int n = number; n < N+1; n+=number)
				switches[n] = (switches[n] == 1) ? 0 : 1;
		}else { //여학생일 경우
			switches[number] = (switches[number] == 1) ? 0 : 1;
			int left = number-1, right = number+1;
			while(true) {				
				if(left>0 && right<N+1 && switches[left] == switches[right]) {
					switches[left] = (switches[left] == 1) ? 0 : 1;
					switches[right] = switches[left];
					left -= 1;
					right += 1;
				}else break;
			}
		}

		change(cnt+1);
		
	}

}
