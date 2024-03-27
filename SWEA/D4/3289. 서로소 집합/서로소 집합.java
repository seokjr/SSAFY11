import java.util.Scanner;

public class Solution {
	static int N;
	static int M;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N + 1];
			// 초기화 및 arr 해서 각각의 집합으로 만들기
			for (int i = 0; i < N; i++) {
				arr[i] = i;
			}
			StringBuilder answer = new StringBuilder();
			answer.append("#" + tc + " ");
			for (int i = 0; i < M; i++) {
				int f = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();
				// 합집합으로 만들기
				if (f == 0) {
					if (findset(x) != findset(y)) {
						union(x, y);
					}
				}
				// 합집합인지 확인
				if (f == 1) {
					if (findset(x) == findset(y)) {
						answer.append(1);
					} else {
						answer.append(0);
					}
				}
			}
			System.out.println(answer.toString());
		}
		sc.close();
	}
	static void union(int x, int y) {
		arr[findset(y)] = findset(x);
	}

	static int findset(int x) {
		// 패스 컴프레션
		if (x != arr[x])
			arr[x] = findset(arr[x]);
		return arr[x];
	}
}