package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class CompleteBinaryTree<E> {
	private Object[] nodes;
	private int lastIndex;
	private final int MAX_SIZE;

	public CompleteBinaryTree(int maxSize) {
		super();
		MAX_SIZE = maxSize;
		nodes = new Object[MAX_SIZE + 1];
	}

	public boolean isFull() {
		return lastIndex == MAX_SIZE;
	}

	public void add(E e) {
		if (isFull())
			throw new RuntimeException("트리가 노드로 가득찼습니다");

		nodes[++lastIndex] = e;
	}

	public void bfs() {
		// 1. 순서를 관리할 큐 준비
		Queue<Integer> queue = new ArrayDeque<>();

		// 2. 처음 탐색이 될 대상을 큐에 넣기
		queue.offer(1);

		// 3. 큐에 저장되어 있는 탐색대상들을 차례대로 꺼내어 방문
		while (!queue.isEmpty()) {
			// 4. 탐색 대상 꺼내기
			int cur = queue.poll();
			// 5. 탐색 대상 탐색 하기
			System.out.println(nodes[cur] + "\t");
			// 6. 탐색 대상과 관계를 맺고 있는 대상들을 다음에 방문하기 위해 순서를 결정하는 큐에 넣기
			if (cur * 2 <= lastIndex)
				queue.offer(cur * 2); // 왼쪽 자식 노드
			if (cur * 2 + 1 <= lastIndex)
				queue.offer(cur * 2 + 1); // 오른쪽 자식 노드
		}

	}

	public void bfs2() {
		// 1. 순서를 관리할 큐 준비
		Queue<int[]> queue = new ArrayDeque<>();

		// 2. 처음 탐색이 될 대상과 너비를 큐에 넣기
		queue.offer(new int[] { 1, 0 });

		// 3. 큐에 저장되어 있는 탐색대상들을 차례대로 꺼내어 방문
		while (!queue.isEmpty()) {
			// 4. 탐색 대상 꺼내기
			int info[] = queue.poll();
			int cur = info[0];
			int breadth = info[1];
			// 5. 탐색 대상 탐색 하기
			System.out.println(nodes[cur] + "(" + breadth + ")\t");
			// 6. 탐색 대상과 관계를 맺고 있는 대상들을 다음에 방문하기 위해 순서를 결정하는 큐에 넣기
			if (cur * 2 <= lastIndex)
				queue.offer(new int[] { cur * 2, breadth + 1 }); // 왼쪽 자식 노드
			if (cur * 2 + 1 <= lastIndex)
				queue.offer(new int[] { cur * 2 + 1, breadth + 1 }); // 오른쪽 자식 노드
		}
	}

	public void dfsByPreOrder(int cur) {

		// 5. 탐색 대상 탐색 하기
		System.out.println(nodes[cur] + "\t");
		if (cur * 2 <= lastIndex)
			dfsByPreOrder(cur * 2); // 왼쪽 자식 노드
		if (cur * 2 + 1 <= lastIndex)
			dfsByPreOrder(cur * 2 + 1); // 오른쪽 자식 노드

	}

}
