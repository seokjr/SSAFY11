import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 조합_2_재귀함수_반복문 {
	static String[] 속 = { "상추", "패티", "치즈", "피클" };
	static int N, R;
	static String[] sel;

	public static void main(String[] args) {
		N = 4;
		R = 2;
		sel = new String[R];
		combination(0, 0);
	}

	// idx : 현재 내가 판단할 재료
	// sidx : 조합할 재료의 인덱스
	static void combination(int idx, int sidx) {
		// base case
		if (sidx >= R) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		// idx 가 경계를 벗어날 걱정을 안해도 된다.
		// 그래서 기저조건 하나 줄어들었다.

		// recursive case
		for (int i = idx; i <= N - R + sidx; i++) {
			sel[sidx] = 속[i]; // 재료 뽑았어요
			combination(i + 1, sidx + 1);
		}
	}
}
