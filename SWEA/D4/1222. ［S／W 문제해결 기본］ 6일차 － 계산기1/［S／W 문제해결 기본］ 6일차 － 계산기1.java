import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		Map<Character,Integer> priority =new HashMap<>();
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('(', 0);

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			String expression = sc.next();

			// 중위 표기식 -> 후위 표기식
			String postfix= "";
			Stack<Character> op = new Stack<>();
			for (int i = 0; i<expression.length(); i++) {
				char c = expression.charAt(i);
				if (c == '(' ) {
					op.push(c);
				} else if (c == ')') {
					while (op.peek() != '(') {
						postfix += op.pop();
					}
					// 마지막에 여는 괄호 일때는 pop 만 하고 버린다.
					op.pop();
				} else if ('0' <= c && c <='9') {
					postfix += c;
				} else {
					// 연산자들
					if (op.isEmpty()) {
						op.push(c);
					} else {
						// 우선 순위가 낮은 연산자가 마지막에 위치할 때까지 pop
						// 꼭대기에 있는 친구가 나보다 크거나 같으면 뽑아야 한다.
						while(!op.isEmpty() && priority.get(c) <= priority.get(op.peek())) {
							postfix += op.pop();
						}
						op.push(c);
					}
				}
			}
			Stack<Integer> temp = new Stack<>();
			for (int i = postfix.length()-1; i >= 0; i--) {
				char c = postfix.charAt(i);
				if ('0' <= c && c <= '9') {
					int m = c - '0';
					temp.push(m);
				} else if (c == '+') {
					char m = postfix.charAt(--i);
					int b = (m - '0');
					int a = temp.pop();
					temp.push(a+b);
				}
			}
			int answer = 0;
			while (!temp.isEmpty()) {
				answer += temp.pop();
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}
}