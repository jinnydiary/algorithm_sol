package prac0824;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MSTKruskalTest {
	
	static class Edge implements Comparable<Edge>{
		int start, end, weight;
		
		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int V, E;
	static Edge[] edgeList;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/prac0824/kruskal_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken()); //정점의 수
		E = Integer.parseInt(st.nextToken()); //간선의 수
		
		edgeList = new Edge[E]; //간선리스트
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(start, end, weight);
		}
		
		Arrays.sort(edgeList);
		make();
		union();

	}

	private static void union() {
		
		int cnt = 0, result = 0;
		for(Edge edge : edgeList) {
			int r1 = find(edge.start);
			int r2 = find(edge.end);
			if(r1 != r2) {
				parents[r2] = r1;
				result += edge.weight;
				if(++cnt == V-1) break;
			}

		}
		System.out.println(result);
		
	}

	private static int find(int n) {
		if(n == parents[n]) return n;
		else return parents[n] = find(parents[n]);
	}

	private static void make() {
		parents = new int[V];
		for(int i=0; i<V; i++) {
			parents[i] = i;
		}
		
	}

}
