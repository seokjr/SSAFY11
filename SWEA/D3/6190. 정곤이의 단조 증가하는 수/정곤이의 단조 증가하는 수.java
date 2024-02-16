import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int n = 0; n<N; n++) {
				arr[n] = sc.nextInt();
			}
			int answer = -1;
			boolean flag = false;
			for (int i = 0; i<arr.length;i++) {
				for (int j = i+1; j<arr.length;j++) {
					flag = false;
					// 곱한 수를 문자열로 바꿔서 하나하나 개별 접근이 가능하게 만든다.
					String t = Integer.toString(arr[i] * arr[j]);
					// 처음 비교 시작할 부분
					int first = t.charAt(0) - '0';
					for (int k = 1; k<t.length(); k++) {
						// 곱한 수의 자리수 앞부분과 뒷 부분을 비교한다.
						int second = t.charAt(k) - '0';
						// 만약 앞부분이 더 크면 단조증가가 아니니까 flag를 올리고 그만한다.
						if (first > second) {
							flag = true;
							break;
						}
						first = t.charAt(k) - '0';
					}
					// 단조증가이고
					if (!flag) {
						// 현재 정답값보다 곱한 값이 크면
						if (answer <= arr[i]*arr[j]) {
							answer = arr[i] * arr[j];
						}
					}
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}
