package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//백준 2304번 창고 다각형(1023)
public class Main_2304 {
	
	static class Pillar implements Comparable<Pillar>{
		int pos, h;
		
		public Pillar(int pos, int h) {
			this.pos = pos;
			this.h = h;
		}

		@Override
		public int compareTo(Pillar o) {
			return this.pos - o.pos;
		}
	}

	static int N;
	static List<Pillar> plr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		plr = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			plr.add(new Pillar(p, h));
		}
		
		Collections.sort(plr);		
		int area = findArea();
		System.out.println(area);
	}
	
	private static int findArea() {
		int start = 0; //제일 처음 기둥
		int end = plr.size()-1; //제일 끝 기둥
		int row = 0, sum = 0, bf = 0;
		
		while(true) {
			
			if(!(start >= 0 && end >= 0 && start < N && end < N && start <= end) ) break;
			row = plr.get(end).pos - plr.get(start).pos + 1;
			
		//	System.out.println("전 " + start + " " + end + " " + sum);
			int h = 0;
			if(plr.get(end).h > plr.get(start).h) {
				h = plr.get(start).h - bf;
				bf = plr.get(start).h;
				++start;
				while(start <= end && bf > plr.get(start).h) ++start;
			}else {
				h = plr.get(end).h - bf;
				bf = plr.get(end).h;
				--end;
				while(start <= end && bf > plr.get(end).h) --end;
			}
			
			sum += row * h;
		//	System.out.println("후 " + start + " " + end + " " + sum);
			
		}
		return sum;
	}

}
