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
		sc.nextLine();
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			String str = sc.nextLine();
			Stack<Character> stack = new Stack<>();
			int cnt = 0;
			for (int i = 0; i<str.length(); i++){
				char text = str.charAt(i);
				if (text == '(') {
					stack.push(text);
				}
				else if (text == ')') {
					if (str.charAt(i-1) == '(') {
						stack.pop();
						cnt += stack.size();
					}
					else {
						stack.pop();
						cnt += 1;
					}
				}
			}
			System.out.println("#" + test_case + " " + cnt);

		}
	}
}