package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//SWEA 3124번 최소 스패닝 트리(0926)
public class Main_3124 {

	static class Tree implements Comparable<Tree>{
		int v1, v2, weight;
		
		public Tree(int v1, int v2, int weight) {
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Tree o) {
			return this.weight - o.weight;
		}
	}
	static int V, p[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			p = new int[V+1];
			make();
			
			Tree[] treeList = new Tree[E];
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				treeList[i] = new Tree(v1, v2, weight);
			}
			
			Arrays.sort(treeList);
			int cnt = 0;
			long res = 0;
			for(Tree tree : treeList) {
				if(union(tree.v1, tree.v2)) {
					res += tree.weight;
					if(++cnt == V-1) break;
				}
			}
			
			sb.append("#" + t + " " + res + "\n");
			
		}
		System.out.print(sb);

	}
	
	private static boolean union(int v1, int v2) {
		int root1 = find(v1);
		int root2 = find(v2);
		if(root1 == root2) return false;
		
		p[root2] = root1;
		return true;
	}

	private static int find(int v) {
		if(v == p[v]) return v;
		else return p[v] = find(p[v]);
	}

	private static void make() {
		for(int v=1; v<=V; v++)
			p[v] = v;
	}

}
