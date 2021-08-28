package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//정올 1329번 별삼각형3(0828)
public class Main_1329 {

	static int n;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		
		if( !(1<=n && n<=100 && n%2==1) ) sb.append("INPUT ERROR!"); //범위를 벗어날 경우
		else triangle(0, 1, n/2+n, 0, false);
		
		System.out.print(sb);
	}

	//삼각형 만들기
	private static void triangle(int empty, int star, int len, int cnt, boolean check) {
		if(cnt >= n) return;
		
		for(int i=1; i<=len; i++) {
			if(i > empty+star) break; //빈칸+별칸 보다 큰 수일 경우
			else if(i <= empty) sb.append(" "); //빈칸 영역
			else sb.append("*"); //별 영역
		}
		sb.append("\n");
		
		//빈칸, 별칸 증감
		if(check == false && empty+star != len) {
			++empty;
			star += 2;
		}else {
			--empty;
			star -= 2;
			check = true;
		}
		
		triangle(empty, star, len, cnt+1, check);
		
	}

}
