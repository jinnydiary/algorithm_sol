package prac0824;

import java.util.Arrays;

//서로소 집합
public class DisjointSet {

	static int N;
	static int[] parents;
	public static void main(String[] args) {
		
		N = 5;
		parents = new int[N];
		
		//make set
		make();
		System.out.println(Arrays.toString(parents));
		
		//union set
		System.out.println(union(0,1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(2,1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(3,2));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(4,2));
		System.out.println(Arrays.toString(parents));
		
		//find set
		System.out.println("==========find==========");
		System.out.println(find(4));
		System.out.println(Arrays.toString(parents));
		System.out.println(find(3));
		System.out.println(Arrays.toString(parents));			
		System.out.println(find(2));
		System.out.println(Arrays.toString(parents));			
		System.out.println(find(0));
		System.out.println(Arrays.toString(parents));
		System.out.println(find(1));
		System.out.println(Arrays.toString(parents));
	}
	
	private static boolean union(int n1, int n2) {
		int root1 = find(n1);
		int root2 = find(n2);
		if(root1 == root2) return false;
		
		parents[root2] = root1;
		return true;
	}

	private static int find(int n) {
		if(n == parents[n]) return n;
		else return parents[n] = find(parents[n]);
	}

	private static void make() {
		for(int i=0; i<N; i++)
			parents[i] = i;		
	}

}
