import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			sc.nextLine();
			// 우선순위큐이자 높은 값부터 뽑아내는 걸 만들기 위해서 lambda를 사용한다.
			PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
				return b - a;
			});
			System.out.print("#" + tc);
			for (int i = 0; i < N; i++) {
				// 공백을 기준으로 분리
				String[] t = sc.nextLine().split(" ");
				// 만약 2개가 주어지면 힙에 추가
				if (t.length == 2) {
					pq.offer(Integer.parseInt(t[1]));
				}
				// 1개가 주어지면 무조건 poll 연산일 것이다.
				else {
					// 가장 위의 값이 null 이면, 즉 비었다면 -1 출력
					if (pq.peek() == null) {
						System.out.print(" " + -1);
					} else {
						System.out.print(" " + pq.poll());
					}
				}
			}
			System.out.println();
		}
		sc.close();
	}
}
