package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2050. 알파벳을 숫자로 변환(D1)
public class Main_2050 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] alpa = br.readLine().toCharArray();
		for(int i=0; i<alpa.length; i++)
			sb.append((alpa[i] - 'A' + 1) + " ");
		System.out.print(sb);
	}

}
