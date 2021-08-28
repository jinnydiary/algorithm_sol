package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_5432 {
	
	static ArrayList<Character> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			arr = new ArrayList<>();
			char[] ch = br.readLine().toCharArray();
			int cnt = 0, sum = 0;
			
			for(int i=0; i<ch.length; i++) {
				
				if(ch[i] == ')' && arr.get(arr.size()-1) == '(') //레이저일 때
					sum += --cnt;
				else if(ch[i] == '(') //쇠막대기 하나 시작
					++cnt;
				else if(ch[i] == ')' && !(arr.get(arr.size()-1) == '(')) { //쇠막대기 하나가 끝날 때
					sum += 1;
					--cnt;
				}
				arr.add(ch[i]);
			}
			sb.append("#" + tc + " " + sum + "\n");
		}
		System.out.print(sb);

	}

}
