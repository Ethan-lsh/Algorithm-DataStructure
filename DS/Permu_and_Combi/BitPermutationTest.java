package Permu_and_Combi;

import java.util.Arrays;
import java.util.Scanner;

public class BitPermutationTest {

	static int N, R;
	static int[] input, numbers;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		numbers = new int[R];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		permutation(0, 0);
				
	}
	
	static void permutation(int cnt, int flag) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		
		for (int i = 0; i < N; i++) {
			if ((flag & 1<<i) != 0) continue;
			numbers[cnt] = input[i];
			
			// flag 값을 변화 시킨 후 전달한다면
//			flag |= 1 << i;
//			permutation(cnt + 1, flag);
//			flag &= ~(1 << i);
//			
			// parmeter로 넘기면 굳이 변화 시키지 않아도 된다
			permutation(cnt + 1, flag | 1 << i);
		}
	}

}
