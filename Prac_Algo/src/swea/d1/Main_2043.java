package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2043. 서랍의 비밀번호(D1)
public class Main_2043 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int P = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		System.out.println(P - K + 1);
	}

}
