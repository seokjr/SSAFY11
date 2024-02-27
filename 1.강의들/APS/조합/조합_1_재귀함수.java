import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 조합_1_재귀함수 {
	static String[] 속 = { "상추", "패티", "치즈", "피클" };
	static int N, R;
	static String[] sel;
	static List<String[]> list = new ArrayList<>();

	public static void main(String[] args) {
		N = 4;
		R = 2;
		sel = new String[R];
		combination(0, 0);
		System.out.println("모든 결과 총합");
		for(String[] s : list) {
			System.out.println(Arrays.toString(s));
		}

	}

	// idx : 현재 내가 판단할 재료
	// sidx : 조합할 재료의 인덱스
	static void combination(int idx, int sidx) {
		// base case
		if (sidx >= R) { // 필요한 재료의 개수만큼 다 뽑았어 (햄버거 완성)
			// deepcopy
			String[] tmp = new String[R];
			for (int i = 0; i < R; i++) {
				tmp[i] = sel[i];
			}

			System.out.println(Arrays.toString(sel));
//			list.add(sel); // 그냥 이거만 하면 deepcopy가 아니기 대문에 안나옴.
			list.add(tmp); 
			return;
		}

		if (idx >= N) { // 몰라 재료는 다 고려했어! 안됐으면 미안
			return;
		}

		// recursive case
		sel[sidx] = 속[idx]; // 재료 넣었다는 표현
		combination(idx + 1, sidx + 1); // 해당 idx 번째 재료 sidx 위치에 넣었어요

		combination(idx + 1, sidx); // 해당 idx 번째 재료 sidx 위치에 안 넣었어요.

	}
}
