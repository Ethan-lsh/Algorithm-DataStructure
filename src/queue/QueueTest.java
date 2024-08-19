package queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		int N = 20;
		Queue<int[]> queue = new ArrayDeque<>();
		int person = 1;
		queue.offer(new int[] {person, 1});
		
		while (N > 0) {
			int[] p = queue.poll();
			int availableCnt = N>=p[1]? p[1] : N;
			N -= availableCnt;
			if (N == 0) {
				System.out.println("마지막에 마이쮸를 포함해서 가져가는 사람" + p[0] 
						+"번이며" + availableCnt + "만큼 가져갑니다.");
			} else {
				System.out.println(p[0] + "번의 사람이" + availableCnt + "만큼 가져갑니다. 남은 개수" + N);
				p[1]++;
				queue.offer(p);
				queue.offer(new int[] {person, 1});
			}
		}

	}

}
