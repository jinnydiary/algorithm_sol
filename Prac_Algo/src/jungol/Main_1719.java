package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//정올 1719번 별삼각형2(0828)
public class Main_1719 {

	static int n, m; //삼각형의 높이와 종류
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		if( !(1<=n && n<=100 && n%2 == 1) || !(1<=m && m<=4) ) //범위를 벗어날 경우
			sb.append("INPUT ERROR!");
		else if(m == 1) { //종류1
			shape1(n/2, n/2+1, 0, false);
		}else if(m == 2) { //종류2
			shape2(n/2, n/2+1, 0, false);
		}else if(m == 3) { //종류3
			shape3(0, n/2, 0, false);
		}else { //종류4
			shape4(1, n/2+1, 0, false);
		}
		System.out.print(sb);
	}

	//종류1
	private static void shape1(int empty, int len, int cnt, boolean check) {
		if(cnt >= n) return;
		
		for(int i=1; i<=len; i++) {
			if(i > len - empty) break;
			else sb.append("*");
		}
		sb.append("\n");
		
		if(empty > 0 && check == false) {
			--empty;
		}else {
			++empty;
			check = true;
		}
		shape1(empty, len, cnt+1, check);
	}
	
	//종류2
	private static void shape2(int empty, int len, int cnt, boolean check) {
		if(cnt >= n) return;
		
		for(int i=1; i<=len; i++) {
			if(i <= empty) sb.append(" ");
			else sb.append("*");
		}
		sb.append("\n");
		
		if(empty > 0 && check == false) {
			--empty;
		}else {
			++empty;
			check = true;
		}
		shape2(empty, len, cnt+1, check);
	}
	
	//종류3
	private static void shape3(int empty, int limit, int cnt, boolean check) {
		if(cnt >= n) return;
		
		for(int i = 1; i<= n; i++) {
			if(i <= empty || i> n-empty) sb.append(" ");
			else sb.append("*");
		}
		sb.append("\n");
		
		if(empty < limit && check == false) {
			++empty;
		}else {
			--empty;
			check = true;
		}
		
		shape3(empty, limit, cnt+1, check);
		
	}
	
	//종류4
	private static void shape4(int start, int end, int cnt, boolean check) {
		if(cnt >= n) return;
		for(int i = 1; i<=n; i++) {
			if(i >= start && i <= end) sb.append("*");
			else sb.append(" ");
		}
		sb.append("\n");
		
		if(cnt < n/2 && check == false) {
			++start;
		}else {
			++end;
			check = true;
		}
		
		shape4(start, end, cnt+1, check);
		
	}

}
