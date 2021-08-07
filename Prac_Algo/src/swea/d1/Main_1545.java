package swea.d1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1545. 거꾸로 출력해 보아요(D1) 
public class Main_1545 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		while(N >=0)
			sb.append(N--).append(" "); //N을 1씩 감소시키면서 sb에 추가
		System.out.print(sb);
	}

}
