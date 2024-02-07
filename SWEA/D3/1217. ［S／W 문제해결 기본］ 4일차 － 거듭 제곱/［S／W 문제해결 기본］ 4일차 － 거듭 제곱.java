import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{	
    public static int Squared(int n, int m){
        if (m <= 1){
        	return n;
        } 
        return Squared(n, m-1) * n;
    }
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			int answer = Squared(n, m);
			System.out.println("#" + test_case + " " + answer);
		}
	}
}