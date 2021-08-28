package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1938. 아주 간단한 계산기(D1)
public class Main_1938 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		sb.append((a+b) + "\n");
		sb.append((a-b) + "\n");
		sb.append((a*b) + "\n");
		sb.append(a/b);
		System.out.print(sb);

	}

}
