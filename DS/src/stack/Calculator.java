package stack;

import java.util.Stack;

public class Calculator {

	public static void main(String[] args) {

		String expression = "6528-*2/+";
		System.out.println(expression);
		
		Stack<Integer> stack = new Stack<>(); // 피연산자 저장
		for (int i = 0, size = expression.length(); i < size; i++) {
			char temp = expression.charAt(i);
			// 피연산자면 스택에 넣기
			if (Character.isDigit(temp)) {
				stack.push(temp - '0');
			} else {
				int val2 = stack.pop();
				int val1 = stack.pop();
				
				switch (temp) {
				case '+':
					stack.push(val1 + val2);
					break;
				case '-':
					stack.push(val1 - val2);
					break;
				case '*':
					stack.push(val1 * val2);
					break;
				case '/':
					stack.push(val1 / val2);
					break;
				}
			} // end if
		} // end for
		
		System.out.println(stack.pop());
	}

}
