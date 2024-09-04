package dp;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciTest {

	static long calCnt1, calCnt2, calCnt3;
	static long[] memo;
	
	static long fibo1(int n) {
		calCnt1++;
		if (n <= 2) return 1;
		return fibo1(n-1) + fibo1(n-2);
	}
	
	/*메모이제이션 기법*/
	static long fibo2(int n) {
		calCnt2++;
		// n이 가리키는 값을 memo[n]에 저장하여 재활용한다
		// fibo2(5)는 fibo2(4), fibo2(3)을 호출하는데
		// fibo2(4)는 fibo2(3)을 또 호출한다.
		// 이떄, memo[3]에는 값이 저장되기 때문에 다른 재귀 호출에서 재사용 가능한것
		if(memo[n] == -1) {
			memo[n] = fibo2(n-1) + fibo2(n-2);
		}
		return memo[n];
	}
	
	/*DP 기법*/
	static long fibo3(int n) {
		long[] D = new long[n+1];  //동적 테이블 정리
		
		D[1] = D[2] = 1;
		for (int i = 3; i <= n; i++) {
			calCnt3++;
			// 재귀적으로 함수를 호출 할 필요 없이 동작한다
			D[i] = D[i-2] + D[i-1];
		}
		
		return D[n];
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		memo = new long[N+1];
		
		Arrays.fill(memo, -1);

		memo[1] = memo[2] = 1;
		
		System.out.println("메모버전 : " + fibo2(N));
		System.out.println("메모버전 수행횟수 : " + calCnt2);
		
		System.out.println("메모 x : " + fibo1(N));
		System.out.println("메모 x 수행횟수 : " + calCnt1);
		
		System.out.println("DP : " + fibo3(N));
		System.out.println("DP 수행횟수 : " + calCnt3);
	}

}
