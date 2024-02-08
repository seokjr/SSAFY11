import java.util.Arrays;

public class APS기본_Queue2_원형큐구현 {
    static String[] queue = new String[5];
    static int front = 0, rear = 0;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(queue));
        enQueue("1. A");
        enQueue("2. B");
        enQueue("3. C");
        enQueue("4. D");
        deQueue();
        deQueue();
        enQueue("5. E");
        enQueue("6. F");
        System.out.println(Arrays.toString(queue));
        
    }

    // 공백 상태
    // front == rear
    public static boolean isEmpty() {
        return front == rear;

    }

    // 포화 상태
    // front == rear + 1
    public static boolean isFull() {
        return front == (rear + 1) % queue.length;
    }

    // 삽입
    public static void enQueue(String data) {
        if (isFull()) {
            System.out.println("큐가 포화상태입니다.");
            return;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = data;
    }

    // 삭제
    public static String deQueue() {
        if (isEmpty()) {
            System.out.println("큐가 비어있습니다.");
            return null;
        }
        front = (front + 1) % queue.length;
        return queue[front];
    }
}
