import java.util.Arrays;

public class 순열_2_swap {
	static int[] nums;
	static int N;

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2 };
		N = nums.length;
		perm(0);
	}

	// idx : 현재 판단하는 위치
	static void perm(int idx) {
		// 기저 조건
		if (idx >= N) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		// 재귀 조건
		for (int i = idx; i < N; i++) {
			// i와 idx의 위치를 swap
			swap(i, idx);
			perm(idx + 1);
			// 다음 것을 위해 원상보구하는 과정
			swap(i, idx);
		}
	}

	static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
