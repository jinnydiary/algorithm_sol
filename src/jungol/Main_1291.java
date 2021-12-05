package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//정글 1291번 구구단
public class Main_1291 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		while( !( 2 <= s && s <= 9 ) || !( 2 <= e && e <= 9 ) ){
			System.out.println("INPUT ERROR!");
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
		}
		
		for(int j = 1; j <= 9; ++j) {
			if(s < e) {
				for(int i = s; i <= e; ++i) {
					if(i*j < 10) sb.append(i + " * " + j + " =  " + (i*j));
					else sb.append(i + " * " + j + " = " + (i*j));
					
					if(i == e) sb.append("\n");
					else sb.append("   ");
				}
			}else {
				for(int i = s; i >= e; --i) {
					if(i*j < 10) sb.append(i + " * " + j + " =  " + (i*j));
					else sb.append(i + " * " + j + " = " + (i*j));
					
					if(i == e) sb.append("\n");
					else sb.append("   ");
				}
			}
		}
		
		System.out.print(sb.substring(0, sb.length()-1));	
	}

}
