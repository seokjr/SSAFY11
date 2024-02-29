import java.util.Scanner;

public class Solution {
	static int N;
	static int[] visited;
	static int cnt;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			// N * N 체스보드
			visited = new int[N];
			cnt = 0;
			queens(0);
			System.out.println("#" + tc + " " + cnt);
		}
	}

	// idx : x 위치 columns의 위치들
	static void queens(int idx) {
		// 기저 조건 : 입력받은 N개만큼 될 때
		if (idx >= N) {
			// 뭔가를 찾았으니까 개수 늘리고
			cnt++;
			return;
		}
		// 호출 조건 여긴 행이라고 생각
		for (int i = 0; i < N; i++) {
			// 방문 했으면
			visited[idx] = i;
			// 방문 안했으면
			// 같은 줄에 없는지는 지금 어차피 i가 행이라고 생각하기에 같은 열에 없고 대각선에 없고만 찾는다.
			if (isok(idx)) {
				queens(idx + 1);
			}
		}
	}

	static boolean isok(int idx) {
		// 0 부터 idx가 있는 줄까지만 보면 된다.
		for (int i = 0; i < idx; i++) {
			// 같은 열인가? 
			if (visited[idx] == visited[i])
				return false;
			// 대각선에 있나? 대각선은 열과 행의 절대값이 같은데 한 쪽에만 절대값 들어가야하는데 그게 뭘까 항상 큰 것은 idx값이 항상 클것
			else if (idx - i == Math.abs(visited[idx] - visited[i])) {
				return false;
			}
		}

		return true;
	}
}
