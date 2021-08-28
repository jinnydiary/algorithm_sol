package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2056. 연월일 달력(D1)
public class Main_2056 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			
			char[] date = br.readLine().toCharArray();
			String year = "", month = "", day = "";
			
			for(int i=0; i<date.length; i++) {
				if(i<4) year += date[i];
				else if(i<6) month += date[i];
				else day += date[i];
			}
			
			boolean check = false; //날짜 유효한지 확인
			
			int m = Integer.parseInt(month);
			check = (m >= 1 && m <=12) ? false : true;
			
			int d = Integer.parseInt(day);
			switch(m) {
			case 1: case 3: case 5: case 7:
			case 8: case 10: case 12:
				check = (d >= 1 && d <=31) ? false : true;
				break;
			case 4: case 6: case 9: case 11:
				check = (d >= 1 && d <=30) ? false : true;
				break;
			case 2:
				check = (d == 28) ? false : true;
				break;
			}
			
			if(check) sb.append("#" + tc + " " + -1 + "\n");
			else sb.append("#" + tc + " " + year +"/" + month + "/" + day + "\n");
		}
		
		System.out.print(sb);

	}

}
