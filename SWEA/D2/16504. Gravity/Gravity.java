import java.util.Scanner;
import java.io.FileInputStream;
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
			int[] arr = new int[N];
			for (int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			int[] result = new int[N];
			for (int i=0;i<N;i++) {
				int cnt = 0;
				for (int j=i+1;j<N;j++) {
					if (arr[i] > arr[j]) {
						cnt ++;
					}
				}
				result[i] = cnt;
			}
			int answer = 0;
			for (int num =0; num<result.length;num++) {
				if(result[num] > answer) {
					answer = result[num];
				}
			}
			System.out.println("#"+ test_case + " " + answer);
		}
	}
}