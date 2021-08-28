package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2046. 스탬프 찍기(D1)
public class Main_2046 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(br.readLine());
		for(int i=0; i < num; i++)
			sb.append("#");
		System.out.print(sb);
	}

}
