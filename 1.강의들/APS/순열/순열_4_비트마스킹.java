import java.util.Arrays;

public class 순열_4_비트마스킹 {
	static int[] nums;
	static int N;
	static int[] result;

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2 };
		N = nums.length;
		result = new int[N];
		perm(0, 0);
	}

	// idx : 현재 내가 뽑아서 결과에 저장할 위치
	static void perm(int idx, int visited) {
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
			// 썼는지 안썼는지 알려면 내가 1로 만들려는 그 자리만 확인을 하겠다는 것임
			// 그 자리가 0이 아니면 사용했다는 것임.
			if ((visited & (1 << i)) != 0)
				continue;
			// 안썼으면 실행한다.
			result[idx] = nums[i];
			// 썼다고 해주고 일회성으로만 쓴다.
			perm(idx + 1, visited | (1 << i)); // 다음 자리 판단한다.
		}
	}
}
