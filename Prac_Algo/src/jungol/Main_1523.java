package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//정올 1523번 별삼각형1(0828)
public class Main_1523 {

	static int n, m; //삼각형의 높이와 종류
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		//주어진 범위 벗어나면 에러 출력
		if( !( 1<=n && n<=100 ) || !( 1<=m && m<=3 ) ) sb.append("INPUT ERROR!");
		else if(m ==1) triangle1(n, 1); //종류1일 때
		else if(m ==2) triangle2(n, n); //종류2일 때
		else triangle3(n, n-1); //종류3일 때
		
		System.out.print(sb);
	}
	
	//종류1 삼각형 만들기
	private static void triangle1(int height, int cnt) {
		if(cnt > height) return;
		
		for(int i=1; i<=cnt; i++) sb.append("*");
		sb.append("\n");
		triangle1(height, cnt+1);
	}
	
	//종류2 삼각형 만들기
	private static void triangle2(int height, int cnt) {
		if(cnt < 1) return;
		
		for(int i=cnt; i>= 1; i--) sb.append("*");
		sb.append("\n");
		triangle2(height, cnt-1);
	}
	
	//종류3 삼각형 만들기
	private static void triangle3(int height, int cnt) {
		if(cnt < 0) return;
		
		int count = height*2-1;
		for(int j=1; j<=count; j++) {
			if(cnt < j && j <= count-cnt ) sb.append("*");
			else if(j > count-cnt) break;
			else sb.append(" ");
		}
		sb.append("\n");

		triangle3(height, cnt-1);
	}

}
