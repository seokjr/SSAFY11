import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 먹을 수 있는 사람의 수
			int M = sc.nextInt(); // 들이는 시간
			int K = sc.nextInt(); // 만들 수 있는 붕어빵 개수
			int[] human = new int[N];
			for (int i = 0; i<N; i++) {
				human[i] = sc.nextInt();
			}
			Arrays.sort(human);
			String result = "Possible";
			// x초까지 만들어진 붕어 개수: (x // M) * K
			for (int i=0;i<N;i++) {
				int boong = (human[i] / M) * K - (i+1);
				if (boong < 0) {
					result = "Impossible";
		            break;
				}
			}
//			boong = (arrive_time[i] // M) * K - (i+1)
			System.out.println("#" + test_case + " " + result);
		}
		sc.close();
	}
}
