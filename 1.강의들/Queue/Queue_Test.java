package temp_list;

public class Queue_Test {
	// createQueue 연산
	static int[] queue = new int[10];
	static int front = -1, rear = -1;
	// 포화상태 확인, 공백확인, 삽입, 삭제

	public static void main(String[] args) {
		for (int i = 0; i < 11; i++) {
			enQueue(100);
		}

	}

	public static boolean isFull() {
		// 데이터가 추가로 들어갈 수 있는지 확인 -> rear확인
		return rear == queue.length - 1;
	}

	public static boolean isEmpty() {
		// 빠져나올 데이터가 있는지 확인 -> front
		return front == rear;
	}

	// 삽입할 때 실패여부 확인을 위해 boolean으로 반환 가능하다.
	public static void enQueue(int data) {
// 		삽입 : rear
//		queue[rear+1] = data;
//		rear += 1;
		if (isFull()) {
			System.out.println("큐가 꽉 차있어요.");
			return;
		}
		queue[++rear] = data;
	}

	public static int deQueue(int data) {
		// 삭제 : front
		if (isEmpty()) {
			System.out.println("큐가 비어있어요");
			return -1;
		}
		return queue[++front];
	}

	public static int Qpeek() {
		// 확인만 하는 것이기에 포인터를 변경 시킬 필요 없다.
		if (isEmpty()) {
			System.out.println("큐가 비어있어요");
			return -1;
		}
		return queue[front + 1];
	}
}
