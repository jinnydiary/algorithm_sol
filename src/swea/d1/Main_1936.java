package swea.d1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1936. 1대1 가위바위보(D1)
public class Main_1936 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		System.out.println(winner(A, B));
	}

	private static char winner(int a, int b) {
		switch(a) {
		case 1: //가위
			if(b == 2) return 'B';
			break;
		case 2: //바위
			if(b == 3) return 'B';
			break;
		case 3: //보
			if(b == 1) return 'B';
			break;
		}
		return 'A';
	}

}
