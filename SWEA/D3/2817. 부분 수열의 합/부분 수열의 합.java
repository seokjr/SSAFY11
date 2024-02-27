import java.util.Scanner;

public class Solution {
	static int N, K;
	static int[] arr;
	static boolean[] check;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= T; tc++) {
			// 전체 입력 받기
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N];
			check = new boolean[N];
			cnt = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			sc.nextLine();
			powerset(0);
			System.out.println("#" + tc + " " + cnt);
		}
	}

	static void powerset(int idx) {
		// base case
		if (idx >= N) {
			int sum = 0;
			for (int i = 0; i<N; i++) {
				if (check[i]) {
					sum += arr[i];
				}
			}
			if (sum == K) {
				cnt++;
			}
			return;
		}

		// recursive case
		// check 에 넣는 부분
		check[idx] = true;
		powerset(idx + 1);

		check[idx] = false;
		powerset(idx + 1);
	}
}
