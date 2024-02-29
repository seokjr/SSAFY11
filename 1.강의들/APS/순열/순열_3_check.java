import java.util.Arrays;

public class 순열_3_check {
	static int[] nums;
	static int N;
	static boolean[] visited;
	static int[] result;

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2 };
		N = nums.length;
		visited = new boolean[N];
		result = new int[N];
		perm(0);
	}

	// idx : 현재 내가 뽑아서 결과에 저장할 위치
	static void perm(int idx) {
		// 기저 조건
		// 다 뽑았어~~
		if (idx >= N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		// 재귀 조건
		// 너 썼어 안썼어 물어보고 result 에 넣으려는 거
		for (int i = 0; i < N; i++) {
			// 이거 썼지롱
			if (visited[i])
				continue;
			// 안썼으면 실행한다.
			else {
				// 썼다고 해주고
				visited[i] = true;
				result[idx] = nums[i];
			}
			perm(idx + 1); // 다음 자리 판단한다.
			// 다시 초기화, 안 쓴 척. 순열이니깐
			visited[i] = false;
		}
	}
}
