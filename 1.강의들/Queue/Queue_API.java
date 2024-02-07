import java.util.LinkedList;
import java.util.Queue;

public class Queue_API {
	public static void main(String[] args) {
		// 큐의 구현체는 LinkedList임.
		Queue<Integer> queue = new LinkedList<>();

		// 삽입
		queue.add(1);    // 연산이 실패했을 때 예외 발생 사이즈보다 더 많은 것을 넣으려고 해서
		queue.offer(1);  // 실패시 false 반환
		// 삭제
		queue.remove();  // 연산이 실패했을 때 예외 발생
		queue.poll();    // null
		// 조회
		queue.element(); // 연산이 실패했을 때 예외 발생
		queue.peek();    // null
		
		// 마이쮸를 받는다. 받고 제일 뒤로 간다.
		// 그 다음 새로운 사람이 줄을 선다.
		// 다음 번 사람이 들어와서 줄을 선다.
		// 앞 사람이 마이쮸를 받을 땐 지금까지 받은 개수에서 1개를 더 받는다.
		
	}
}
