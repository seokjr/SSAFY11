import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			//입력받기
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				queue.offer(sc.nextInt());
			}
			int cycle = 1;
			// cycle을 선언
			while(true) {
				// 5가 넘으면 cycle을 1로 초기화
				if(cycle > 5) {
					cycle = 1;
				}
				// queue에서 가장 앞에 있는 것을 빼내고 cycle만큼 뺀다.
				int m = queue.poll() - cycle;
				// 만약 그 값이 0보다 작거나 같아지면 마지막 값에 0 넣고 종료
				if (m <= 0) {
					queue.offer(0);
					break;
				}
				// 아닐때는 항상 그냥 계속 끝으로 넣어준다.
				queue.offer(m);
				// cycle을 올린다.
				cycle++;
			}
			System.out.print("#" + n + " ");
			for (int i : queue) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
