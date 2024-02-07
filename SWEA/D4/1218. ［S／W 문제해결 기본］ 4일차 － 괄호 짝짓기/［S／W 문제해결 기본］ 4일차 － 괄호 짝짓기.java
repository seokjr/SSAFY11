import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			Stack<Character> stack = new Stack<>();
			List<Character> left = new ArrayList<>();
			left.add('(');
			left.add('{');
			left.add('[');
			left.add('<');
			List<Character> right = new ArrayList<>();
			right.add(')');
			right.add('}');
			right.add(']');
			right.add('>');
//			array_left = Arrays.asList(left);
			for (int i = 0; i<str.length();i++) {
				char text = str.charAt(i);
				if (left.contains(text)) {
					stack.push(text);
				}
				if (right.contains(text)) {
					if (right.indexOf(text) == left.indexOf(stack.peek())) {
						stack.pop();
					}
					else {
						break;
					}
					
				}
			}
			int answer = 0;
			if (stack.size() == 0) {
				answer = 1;
			}
			System.out.println("#" + test_case + " " + answer);
		}
        sc.close();
	}
}