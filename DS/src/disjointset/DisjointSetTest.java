package disjointset;

import java.util.Arrays;

public class DisjointSetTest {

	static int N = 5;
	static int[] parents;
	
	static void make() {
		for (int i = 0; i < 5; i++) {
			parents[i] = i;   // make set-i : 자신의 부모를 자신의 대표자가 되도록 설정
		}
	}
	
	static int findSet(int a) {
		
		if (a == parents[a]) return a;  // 자신이 집합의 대표자
//		return findSet(parents[a]);
		return parents[a] = findSet(parents[a]);  // 최적화 코드
		
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) return false;  // 두 집합의 대표자가 같으면 이미 같은 집합임
		// aRoot에 bRoot를 흡수 -> 두 집합 합치기
		parents[bRoot] = aRoot;
		
		return true;
		
	}
	
	public static void main(String[] args) {
		
		parents = new int[N];
		
		// 모든 원소에 대해 단위로서의 집합
		make();
		System.out.println(Arrays.toString(parents));
		System.out.println(union(0, 1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(2, 1));
		System.out.println(Arrays.toString(parents));
		
	}

}
