import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
			int M = sc.nextInt();
			
			int[][] arr = new int[N][N];
			// 정답 리스트 선언
			List<Integer> answer_list = new ArrayList<>();
			// 전체 맵 입력 받기
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			// 전체 순회하면서 찾기
			int answer;
			for (int r = 0; r < N-M+1; r++) {
				for (int c = 0; c< N-M+1; c++) {
					answer = 0;
					for (int i =0; i<M; i++) {
						for (int j = 0; j<M; j++) {
							answer += arr[r+i][c+j];
						}
					}
					answer_list.add(answer);
				}
			}
			
			int max = Collections.max(answer_list);
			System.out.println("#" + test_case + " " + max);
		}
	}
}