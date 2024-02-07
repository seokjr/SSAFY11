import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			Stack<Integer> stack = new Stack<>();
			for (int i =0; i<N; i++) {
				int m = sc.nextInt();
				if (m == 0) {
					stack.pop();
				}
				else {
					stack.push(m);
				}
			}
			int answer = 0;
			while(!stack.isEmpty()) {
				answer += stack.pop();
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}
}