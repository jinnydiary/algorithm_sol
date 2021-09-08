package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

//백준 17413 단어 뒤집기 2(0827~0828)
public class Main_17413 {

	static String S;
	static ArrayList<String> arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		S = br.readLine(); //문자열 S
		
		//단어 담을 배열(동시에 S를 String 배열 만들어 값으로 초기화)
		arr = new ArrayList<String>(Arrays.asList(S.split("")));
		
		int start = 0;
		for(int i = 0; i <= S.length()-1; i++) {
			
			if( arr.get(i).equals("<") ) {
				sb.append(arr.get(i)); // < 출력
				while(!arr.get(i+1).equals(">")) sb.append(arr.get(++i));
				
			}else if( arr.get(i).equals(" ") || arr.get(i).equals(">") ){ //공백이나 닫는 괄호일 경우
				sb.append(arr.get(i));
				
			}else { //특수문자와 공백이 아닐 경우
				start = i;
				while( (i+1) <= S.length()-1 && !arr.get(i+1).equals("<") && !arr.get(i+1).equals(" ") )
					i++;
				reverse(start, i);
			}
		}
		
		System.out.println(sb);

	}

	//단어 뒤집기
	private static void reverse(int start, int end) {
		int mid = (start + end) / 2;
		for(int i = start, j = end; i <= mid; i++, j--)
			swap(i, j);
		for(int i = start; i <= end; i++) {
			sb.append(arr.get(i));
		}
	}

	private static void swap(int i, int j) {
		String temp1 = arr.get(i);
		String temp2 = arr.get(j);
		arr.add(i, temp2);
		arr.remove(i+1);
		arr.add(j, temp1);
		arr.remove(j+1);
	}

}
