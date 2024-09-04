package prism;

import java.util.Arrays;
import java.util.Scanner;

public class PrismTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int[][] adjMatrix = new int[V][V];
		boolean[] visited = new boolean[V];  // 방문 여부 확인 (트리 정점 포함)
		int[] minEdge = new int[V];    // 자신과 타정점들간의 간선비용 중 최소 간선 비용
		
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = sc.nextInt();
			}
		}
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		minEdge[0] = 0; // 0번 정점을 트리의 시작점이 되도록 함
		
		int cost = 0;
		
		int i = 0;
		for (i = 0; i < V; i++) {
			// step 1. 트리 구성에 초함된 가장 유리한 정점 선택 (비트리 정점 중 최소비용 간선의 정점 선택)
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			
			for (int j = 0; j < minEdge.length; j++) {
				if (visited[j]) continue;
				
				// 현재 최소값 보다 선택된 정점의 가중치가 더 작은 경우 선택
				if (min > minEdge[j]) {
					minVertex = j;
					min = minEdge[j];
				}
			}
			
			if (minVertex == -1) break;
			
			visited[minVertex] = true;  // 선택된 정점을 트리 정점에 추가
			cost += min;
			
			// step 2. 선택된 정점과 타 정점들 간선비용 비교하기
			for (int j = 0; j < V; j++) {
				if (!visited[j] && adjMatrix[minVertex][j] > 0 && 
						minEdge[j] > adjMatrix[minVertex][j]) {
					minEdge[j] = adjMatrix[minVertex][j];
				}
			}
		}
		
		System.out.println(i == V ? cost : -1);
		
	}

}
