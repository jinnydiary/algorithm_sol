package prac0824;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MSTPrimTest {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/prac0824/prim_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine());
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		
		
		

	}

}
