public class 부분집합_2_비트마스크 {
	public static void main(String[] args) {
		String[] 재료 = { "단무지", "참치", "햄", "소고기" };
		int N = 4; // 재료는 4개
		int[] sel = new int[N];

		// N개의 재료를 이용하여 만들 수 있는 모든 경우의 수
		for (int i = 0; i < (1 << N); i++) {
			String tmp = "";
			// i 라는 값은 -> 부분집합의 값인 걸 알 았는데 재료가 무엇인지는 알 수가 없다.
			for (int j = 0; j < N; j++) {
				// 재료 검사! 비트연산자를 사용해서 확인할 수 있다. &연산은 둘다 1일 때 1반환
				// 1이라고 하는 값을 j번 << (비트시프트)하면서 값을 비교한다.
				
				if ((i & (1 << j)) > 0) {
					// 이럴 땐 재료가 들어있다는 뜻
					tmp += 재료[j];
				}
			}
			System.out.println(tmp + " 김밥");
		}
	}
}
