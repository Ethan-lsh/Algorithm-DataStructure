package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {

	static class Node {
		int vertex;  // 상대 vertex
		int weight;
		
		Node next;

		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		
		Node[] adjList = new Node[V];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, weight, adjList[from]);
		}
		
		System.out.println(getMinDistance(adjList, start, end));
		
	}
	
	/*다익스트라 함수*/
	static int getMinDistance(Node[] adjList, int start, int end) {
		final int V = adjList.length;
		final int INF = Integer.MAX_VALUE;
		
		boolean[] visited = new boolean[V];  // 방문 정점 관리
		
		int[] minDistance = new int[V];  // 시작정점에서 자신으로의 최소거리
		
		Arrays.fill(minDistance, INF);
		minDistance[start] = 0;
		
		for (int i = 0; i < V; i++) {
			// step 1. 미방문 정점 중 시작정점에서 가장 가까운 정점 선택
			int min = INF;
			int stopOver = -1;
			for (int j = 0; j < V; j++) {
				if(!visited[j] && min > minDistance[j]) {
					min = minDistance[j];
					stopOver = j;
				}
			}
			
//			if (stopOver == end) break;  // 도착점
			if (stopOver == - 1) break;  // 방문할 정점이 없는 경우
			
			visited[stopOver] = true;
			
			// step 2. 선택된 정점(stopOver)을 경유해서 미방문 인접한 정점으로의 최소 비용을 갱신할 수 있는지 체크
			for (Node temp = adjList[stopOver]; temp != null; temp = temp.next) { // 인접리스트 방문 법
				if ( //!visited[temp.vertex] && 
						minDistance[temp.vertex] > min+temp.weight) {
					minDistance[temp.vertex] = min + temp.weight;
				}
			}
		}
		
		System.out.println(Arrays.toString(minDistance));
		return minDistance[end] != INF ? minDistance[end] : -1;
	}

}
