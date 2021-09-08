package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 1931번 회의실 배정(0906)
public class Main_1931 {
	
	static class Meeting implements Comparable<Meeting>{
		int start, end;
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			int value = this.end - o.end;
			if(value != 0) return value;
			return this.start - o.start;
		}
		
		@Override
		public String toString() {
			return "Meeting[start=" + this.start + ", end=" + this.end + "]";
		}
	}
	
	static Meeting[] meets; //회의 시간 배열
	static int N, max; //회의의 수, 회의의 최대 개수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		meets = new Meeting[N];
		
		//회의 시간 배열에 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken()); 
			meets[i] = new Meeting(start, end);
		}
		
		Arrays.sort(meets);
		max = 1; //첫 회의 count
		findMaxMeeting(0, 1);
		
		System.out.println(max);

	}
	
	private static void findMaxMeeting(int idx, int cnt) {
		if(cnt >= N) return;
		
		if(meets[idx].end <= meets[cnt].start) {
			max++;
			findMaxMeeting(cnt, cnt+1);
		}else {
			findMaxMeeting(idx, cnt+1);
		}
	}

}
