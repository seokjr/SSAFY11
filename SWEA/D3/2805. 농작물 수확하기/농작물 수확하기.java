import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] board = new int[N][N];
			for (int r = 0; r < N; r++) {
				String line = sc.next();
				for (int c = 0; c < N; c++) {
					board[r][c] = line.charAt(c) - '0';
				}
			}
			// 마름모 형태로 순회
			int sum = 0;
			int left = N/2;
			int right = N/2;
			
			// 위쪽 삼각형
			for (int r = 0; r < N/2; r++) {
				for (int c = left; c <= right; c++) {
					sum += board[r][c];
				}
				left--;
				right++;
			}
			// 아래쪽 삼각형
			for (int r = N/2; r<N;r++) {
				for (int c = left; c <= right; c++) {
					sum += board[r][c];
				}
				left++;
				right--;
			}
			
//			// 여긴 삼각형을 한 번에 
//			for (int r = 0; r < N; r++) {
//				int mid = N / 2;
//				if (r < N / 2) {
//					// 한 행 탐색 범위 증가
//					for (int c = mid - r; c <= mid + r; c++) {
//						sum += board[r][c];
//					}
//				} else {
//					// 한 행 탐색 범위 감소
//					for (int c = mid - (N - 1 - r); c <= mid + (N - 1 - r); c++) {
//						sum += board[r][c];
//					}
//
//				}
//			}
			System.out.println("#" + tc + " " + sum);
		}
	}
}
