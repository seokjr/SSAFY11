import java.util.Arrays;

public class 부분집합_3_재귀함수 {
	static String[] 재료 = { "단무지", "참치", "햄", "소고기" };
	static int N; // 재료는 4개
	static boolean[] sel; // 재료의 사용유무 저장 배열
	public static void main(String[] args) {
		// 재귀함수 사용을 위해서는 사용을 했는지 안했는지 체크할 배열이 필요
		N = 4;
		sel = new boolean[N];
		
		powerset(0);
	}
	// idx : 해당 재료의 인덱스
	static void powerset(int idx) {
		// base case : 기저조건 : 재귀를 빠져나갈 조건
		if (idx >= N) {
			String tmp = "";
			for (int i =0; i<N; i++) {
				if (sel[i]) {
					tmp += 재료[i];
				}
			}
			System.out.println(tmp);
			return;
		}
		
		// recursive case : 나 자신을 다시 호출하는 부분
		sel[idx] = true; // 이번 재료 넣었어!
		powerset(idx + 1); // 다음 재료 판단해라.
		
		sel[idx] = false; // 이번 재료 안 넣었어!
		powerset(idx + 1);
	}
}
