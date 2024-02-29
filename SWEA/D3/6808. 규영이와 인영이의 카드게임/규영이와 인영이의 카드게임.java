import java.util.Scanner;

public class Solution {
	static int N = 9;
	static int[] nums;
	static boolean[] visited;
	static int[] inyoungs;
	static int[] result;
	static int win_cnt;
	static int lose_cnt;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			nums = new int[N];
			result = new int[N];
			visited = new boolean[N];
			inyoungs = new int[N];
			win_cnt = 0;
			lose_cnt = 0;
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			int m = 0;
			// 인영이 카드 분배하기
			int[] temp = new int[19];
			temp[0] = 1;
			for (int i : nums) {
				temp[i] = 1;
			}
			for (int i = 0; i< 19; i++) {
				if (temp[i] != 1) {
					inyoungs[m++] = i;
				}
			}
			perm(0);
			System.out.println("#" + tc + " " + win_cnt + " " + lose_cnt);
		}
		sc.close();
	}

	// idx : 내가 현재 판단할 위치
	static void perm(int idx) {
		// 기저 조건 현재 한번을 끝낼 때
		if (idx >= N) {
			int gyuyoung_cnt = 0;
			int inyoung_cnt = 0;
			for (int i = 0; i < N; i++) {
				// 원본(규영이꺼)과 결과(인영이꺼)를 비교해서
				if (nums[i] > result[i]) {
					gyuyoung_cnt += (nums[i] + result[i]);
				} else if (nums[i] < result[i]) {
					inyoung_cnt += (nums[i] + result[i]);
				}
			}
			if (gyuyoung_cnt > inyoung_cnt)
				win_cnt++;
			else if (inyoung_cnt > gyuyoung_cnt)
				lose_cnt++;
			return;
		}
		// 재귀 호출
		for (int i = 0; i < N; i++) {
			// 만약 방문했으면
			if (visited[i])
				continue;
			// 방문 안했으면
			visited[i] = true;
			// 결과에 idx 자리에 현재 값 준다.
			result[idx] = inyoungs[i];
			// 그리고 다음 호출한다.
			perm(idx + 1);
			// 방문 안한 척 입 싹 닦는다.
			visited[i] = false;
		}
	}
}
