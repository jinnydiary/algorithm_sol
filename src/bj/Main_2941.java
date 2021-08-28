package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

//백준 2941 크로아티아 알파벳(0821)
public class Main_2941 {

	//변경된 크로아티아 알파벳 담은 배열
	final static ArrayList<String> croatia = new ArrayList<>( Arrays.asList("c=", "c-", "dz=" ,"d-", "lj", "nj", "s=", "z=") );
	static int len, ans; //문장 길이, 알파벳 총 개수
	static String[] str; //한 알파벳씩 담은 배열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine().split("");
		len = str.length;
		
		count(0);
		System.out.println(ans);
	}
	
	//크로아티아 알파벳 갯수 세기
	private static void count(int cnt) {
		
		if(cnt == len) return; //모든 탐색 끝나면 종료

		//'dz='제외한 나머지 크로아티아 알파벳인 경우 횟수 증가 없이 다음으로 넘기기(변경 알파벳 2개)
		if(str[cnt].equals("=") || str[cnt].equals("-") || str[cnt].equals("j")) {  //=, -, j인 경우
			
			//dz=인 경우가 맞다면 =인 경우 1증가 안했으므로 1만 감소
			if(cnt-2 >= 0 && croatia.contains( (str[cnt-2]+str[cnt-1]+str[cnt]) )) ans--;		
			//그냥 알파벳일 경우
			else if(cnt-1 < 0 || !croatia.contains( (str[cnt-1]+str[cnt]) )) ans++;
			
		}else ans++; //=, -, j가 아닌 경우 우선 알파벳 갯수 증가
		
		count(cnt+1);
		
	}

}
