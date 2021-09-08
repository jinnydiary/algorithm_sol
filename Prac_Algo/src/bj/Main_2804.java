package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 2804번 크로스워드 만들기(0822)
public class Main_2804 {

	static char[] A, B; //두 단어를 각각 쪼갠 배열
	static int sameR, sameC; //공유단어 인덱스
	static char same; //공유단어
	static char[][] puzzle; //크로스워드 퍼즐
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = st.nextToken().toCharArray();
		B = st.nextToken().toCharArray();
		
		same = findSameWord(0, A.length, A, B);
		
		int N = A.length, M = B.length; //열과 행의 크기
		puzzle = new char[M][N];
		makeCrossWord(0, 0, M, N);

	}

	//공유단어 찾기
	private static char findSameWord(int cnt, int len, char[] compare1, char[] compare2) {
		
		for(int i=0; i<compare2.length; i++)
			if(compare1[cnt] == compare2[i]) {
				sameR = i; //공유단어 A에서의 인덱스 담기
				sameC = cnt;
				return compare1[cnt]; //공유단어 리턴
			}
		
		//해당 인덱스에 위치한 단어가 공유단어가 아니면 넘기기
		return findSameWord(cnt+1, len, compare1, compare2);
		
	}

	//크로스워드 만들기
	private static void makeCrossWord(int r, int c, int M, int N) {
		if(r >= M) return; //모든 위치 탐색 완료시 종료
		if(c >= N) { //한 행을 다 탐색했다면 출력 후 넘기기
			System.out.println(new String(puzzle[r]));
			makeCrossWord(r+1, 0, M, N);
			return;
		}
		
		if(r == sameR) puzzle[r][c] = A[c]; //B에서의 공유단어의 위치와 같다면
		else if(c == sameC) puzzle[r][c] = B[r]; //A에서의 공유단어의 위치와 같다면
		else puzzle[r][c] = '.'; //나머지 글자
		
		makeCrossWord(r, c+1, M, N); //다음 위치로 넘기기
	}

}
