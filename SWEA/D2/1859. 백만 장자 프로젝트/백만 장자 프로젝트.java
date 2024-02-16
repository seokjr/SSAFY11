import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// 내림차순 : 이득 0
		// 오름차순 : 매일 사서 마지막날 전부 판다

		// 그 외
		// 살까말까 : 지금보다 큰 수가 있다면 사고
		// 언제살까 : 뒤에 나오는 수 중 최대값에 판다
		// i번째날 N-i번 탐색해야 함 => 시간복잡도 O(N^2)
		// 뒤에서 앞으로 탐색하면서 최대값 갱신 후
		// 기존 입력 값을 빼준뒤 더하면 최대 이득
		// 1 1 3 1 2
		// 3 3 3 2 2
		// 2 2 0 1 0 = 5
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			int[] max = new int[N];
			max[N-1] = arr[N-1];
			long sum = 0;
			// 뒤에서부터 지금까지 나온 최댓값 갱신
			for (int i = N-2; i>=0; i--) {
				if (arr[i] > max[i+1]) {
					max[i] = arr[i];
				} else {
					max[i] = max[i+1];
				}
				sum += max[i] - arr[i];
			}
			System.out.println("#" + tc + " " + sum);
		}

	}
}
