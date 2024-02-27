import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, L;
	static int[] score;
	static int[] calorie;
	static boolean[] check;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			// 전체 입력 받기
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			// 초기화
			score = new int[N];
			calorie = new int[N];
			check = new boolean[N];
			max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				calorie[i] = Integer.parseInt(st.nextToken());
			}
			powerset(0);
			System.out.println("#" + tc + " " + max);
		}
	}

	static void powerset(int idx) {
		// base case
		if (idx >= N) {
			int cal_sum = 0;
			int score_sum = 0;
			// check가 true 인 것들 중에서
			for (int i = 0; i < N; i++) {
				if (check[i]) {
					cal_sum += calorie[i];
					score_sum += score[i];
				}
			}
			// calorie의 합이 L이하 일 때
			if (cal_sum <= L) {
				// 현재의 max 값 보다 더 크면 갱신
				if (max <= score_sum) {
					max = score_sum;
				}
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
