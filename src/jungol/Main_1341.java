package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//정글 1341번 구구단2
public class Main_1341 {

	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		if(s < e)
			for(int i = s; i <= e; ++i)
				makeGugun(i);
		else
			for(int i = s; i >= e; --i)
				makeGugun(i);
		
		System.out.print(sb.substring(0, sb.length()-2));
		
	}
	private static void makeGugun(int i) {
		for(int j = 1; j <= 9; ++j) {
			if(i*j < 10) sb.append(i + " * " + j + " =  " + (i*j));
			else sb.append(i + " * " + j + " = " + (i*j));
			
			if(j%3 == 0) sb.append("\n");
			else sb.append("   ");
		}
		sb.append("\n");
	}

}
