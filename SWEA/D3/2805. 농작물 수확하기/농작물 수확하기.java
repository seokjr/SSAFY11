import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				String t = sc.next();
				for (int j = 0; j<t.length();j++) {
					arr[i][j] = Character.getNumericValue(t.charAt(j));
				}
			}
			int start = (int) (N / 2);
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (i <= start) {
					for (int j = start - i; j < N - start + i; j++) {
						cnt += arr[i][j];
					}
				} else {
					for (int j = i - start; j < N - i + start; j++) {
						cnt += arr[i][j];
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
