import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
			int[][] arr = new int[100][100];
			List<Integer> answer_list = new ArrayList<>();
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			// 행의 합
			for (int i = 0; i < 100; i++) {
				int sum = Arrays.stream(arr[i]).sum();
				answer_list.add(sum);
			}
			// 행을 90도 회전하면 열이 행이 된다.
			int[][] newarr = new int[100][100];
            // 대각선 합 같이 구하기
            int answer = 0;

			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
                    // 대각선 합
                    if (r==c){
                    	answer += arr[r][c];
                    }
					newarr[r][c] = arr[100 - c - 1][r];
				}
			}
            answer_list.add(answer);
			// 그 값을 다 더하면 열의 합
			for (int i = 0; i < 100; i++) {
				int sum = Arrays.stream(newarr[i]).sum();
				answer_list.add(sum);
			}
			int max = Collections.max(answer_list);
			System.out.println("#" + N + " " + max);
		}
	}
}