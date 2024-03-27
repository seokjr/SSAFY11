import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N;
	static int M;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N + 1];
			int[] answer_list = new int[N + 1];
			int answer = 0;
			// 초기화 및 arr 해서 각각의 집합으로 만들기
			for (int i = 1; i < N + 1; i++) {
				arr[i] = i;
			}
			// 입력 받는 사람들 관계로 엮어주기
			for (int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int px = findset(x);
				int py = findset(y);
				if (px != py) {
					union(x, y);
				}
			}
			// count리스트에 하나씩 증가시켜주기
			for (int i = 1; i < N + 1; i++) {
				answer_list[findset(arr[i])]++;
			}
			// count리스트를 돌면서 0이 아닌 값이 나오면 관계의 수인 answer 증가
			for (int i = 1; i< N + 1; i++) {
				if (answer_list[i] != 0){
					answer++;
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
		sc.close();
	}

	static void union(int x, int y) {
		arr[findset(y)] = findset(x);
	}

	static int findset(int x) {
		// 패스 컴프레션
		if (x != arr[x])
			arr[x] = findset(arr[x]);
		return arr[x];
	}
}