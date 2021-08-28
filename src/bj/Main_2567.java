package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//백준 2567 색종이 - 2
public class Main_2567 {

	static int x, y;
	static int [][] map;
	static ArrayList<Integer> xarr;
	static ArrayList<Integer> yarr;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		
		map = new int[100][100];

		//
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			fillBlack(y, x);
			
			//x,y 좌표 각각 담기
			if(!xarr.contains(x)) xarr.add(x);
			if(!yarr.contains(y)) yarr.add(y);
		}
		
		//기본 정렬(오름차순)
		Collections.sort(xarr);
		Collections.sort(yarr);
		
		//검은색 색종이 중 가장 처음과 끝 값 각각 입력(범위에 사용)
		int sx = xarr.get(0);
		int sy = yarr.get(0);
		int fx = xarr.get(xarr.size()-1);
		int fy = yarr.get(yarr.size()-1);
		
		//검은색 색종이 테두리 길이
		ans = 2 * ((fx - sx + 1) + (fy - sy + 1));
		
		//안쪽 공백이 생길 수 있는 범위는 각 두번째 범위
		fy = yarr.get(yarr.size()-2); 
		searchLen(sx, sy, sx, sy, fx, fy);
		System.out.println(ans);

	}

	//검은색 색종이들의 안쪽 길이 찾기
	private static void searchLen(int x, int y, int sx, int sy, int fx, int fy) {
		if(y > fy) {
			return;
		}
		if(x > sx) {
			searchLen(sx, y+1, sx, sy, fx, fy);
			return;
		}
		
		//흰 공백이 있다면
		if(map[x][y] == 0) {
			
		}
		
		//검은 공간이면 계속해서 넘기기
		searchLen(x+1, y, sx, sy, fx, fy);
	}

	//검은 색종이 붙이기
	private static void fillBlack(int r, int c) {
		if(r >= x + 10) return;
		if(c >= y + 10) {
			fillBlack(r+1, y);
			return;
		}
		
		map[r][c] = 1; //검은 색으로 칠하기
		fillBlack(r, c+1);
		
	}

}
