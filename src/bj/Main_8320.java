package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//백준 8320 직사각형을 만드는 방법(0828)
public class Main_8320 {

	static int n, res;
	static ArrayList<Integer> arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); //정사각형의 갯수
		
		arr = new ArrayList<>();
		find(1);
		
		System.out.println(res);
	}
	
	//직사각형 갯수 찾기(정사각형도 직사각형에 포함된다!!)
	private static void find(int cnt) {
		if(cnt > n) return;
		arr.clear();
		for(int i=1; i<= cnt; i++) {
			if(arr.contains(i)) break;
			if( (cnt%i) == 0 ) {
				arr.add(i);
				res++;
				if(cnt/i == i) continue;
				arr.add(cnt/i);
			}
		}
		find(cnt+1);
		
	}

}
