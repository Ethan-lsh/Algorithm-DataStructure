package kruskal;
import java.util.Arrays;
import java.util.Scanner;

public class MST_KruskalTest {
	
	// 간선 클래스
	static class Edge implements Comparable<Edge> {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}

	static int V;
	static int[] parents;
	
	static void make() {
		parents = new int[V];
		for (int i = 0; i < V; i++)
			parents[i] = -1;  // 가중치를 음수로 관리
	}
	
	static int findSet(int a) {
		if (parents[a] < 0) return a;  // 0보다 작으면 자기 자신을 가리킴
		else return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if (aRoot == bRoot) return false;  // 이미 같은 집합임
		
		parents[aRoot] += parents[bRoot];  // 집합 크기 관리 (절대값을 사용하면 집합의 크기가 됨)
		parents[bRoot] = aRoot;

		return true;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		
		int E = sc.nextInt();
		
		Edge[] edges = new Edge[E];
		for (int i = 0; i < E; i++) {
			edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(edges);  // 간선의 가중치 기준 오름차순 정렬
		
		make();  // 모든 정점을 분리집합으로
		
		int cnt = 0, cost = 0;
		for (Edge edge : edges) {
			if (union(edge.start, edge.end)) {
				cost += edge.weight;
				if (++cnt == V-1) break; // 최소 신장트리 완성
			}
		}
		
		System.out.println(cost);
		
	}

}
