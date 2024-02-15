public class Tree_heap {

	static int[] heap = new int[100];
	static int heapSize;

	public static void main(String[] args) {
		heapPush(55);
		heapPush(56);
		heapPush(54);
		heapPush(32);
		heapPush(1);
		heapPush(11);
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());

	}

	// swap
	static void swap(int p, int ch) {
		int tmp = heap[p];
		heap[p] = heap[ch];
		heap[ch] = tmp;
	}

	// 삽입
	static void heapPush(int data) {
		// 마지막 위치에 노드 추가
		heap[++heapSize] = data;

		// 부모와 비교하면서 swap
		// 부모는 현재 위치에서 2 나눈 것
		int ch = heapSize;
		int p = heapSize / 2;
		while (p > 0 && heap[p] < heap[ch]) {
			swap(p, ch);

			p = ch;
			ch = p * 2;

		}
	}

	// 삭제
	static int heapPop() {
		// 루트에 있는 원소 제거
		int popItem = heap[1];
		// 마지막에 있는 원소를 루트로 옮기기
		heap[1] = heap[heapSize--];

		int p = 1;
		int ch = p * 2;

		// leaf 노드로 가면 자식이 없을 수 있으니까 ch가 heapSize이하인지 확인
		while (ch <= heapSize && heap[p] < heap[ch]) {
			// 두개를 써도 되는데 오른쪽 자식이 힙 size 이하에 있으면
			// 원소가 존재한다는 뜻인데 오른쪽 자식이 더 크면 더 큰애랑 바꾼다는 뜻
			if (ch + 1 <= heapSize && heap[ch] < heap[ch + 1]) {
				ch++;
			}
			// 자식이 더 크면 swap
			swap(p, ch);

			p = ch;
			ch = p * 2;
		}
		return popItem;
	}
}
