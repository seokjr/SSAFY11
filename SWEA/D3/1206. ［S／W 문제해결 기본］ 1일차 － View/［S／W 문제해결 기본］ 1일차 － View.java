import java.util.Scanner;
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
			int[] APT = new int[N];
			for (int i=0;i<N;i++) {
				APT[i] = sc.nextInt();
			}
			int answer = 0;
			
			for (int i = 2; i<N-2; i++) {
			    int cur = APT[i];
			    int minus1 = APT[i - 1];
			    int minus2 = APT[i - 2];
			    int plus1 = APT[i + 1];
			    int plus2 = APT[i + 2];
			    // 만약 하나라도 그거를 넘게 되면 다음으로 넘어가도 된다.
			    // 둘 중에 하나라도 안 넘으면 ok이고 더 큰 값에서 현재 값을 빼서 하면 됨
			    int temp_max = Math.max(minus1, minus2);
			    int temp_min = Math.max(plus1, plus2);
			    int max = Math.max(temp_max, temp_min);
			    if (cur > max) {
			        answer += cur - max;
			    }
			}
			System.out.println("#"+test_case+ " "+answer);
		}
	}
}