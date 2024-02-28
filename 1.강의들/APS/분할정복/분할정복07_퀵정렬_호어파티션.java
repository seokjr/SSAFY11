import java.util.Arrays;

public class 분할정복07_퀵정렬_호어파티션 {
	static int[] arr = { 5, 22, 32, 26, 57, 19, 32, 55, 84 };
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(arr));
		quickSort(0, arr.length-1);
		System.out.println(Arrays.toString(arr));

	}
	static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot-1);
			quickSort(pivot+1, right);
		}
	}
	// 호어 파티션
	static int partition(int left, int right) {
		int pivot = arr[left]; // 제일 왼쪽 값을 피봇이라고 하겠다.
		
		int L = left + 1; // 시작은 피봇 한칸 옆부터. 왜냐면 이미 정렬이니까
		int R = right; 
		//교차가 되면 그만해
		while (L<=R) {
			// L : pivot보다 큰 값을 찾을 때까지 이동 하겠다.
			while (L<= R && arr[L] <= pivot) L++;
			// R : pivot보다 작은 값을 찾을 때까지
			while (arr[R] > pivot) R--;
			if (L < R) {
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		// R이 pivot이 위치해야할 곳까지 이도한 상태
		int tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;
		
		return R; // 피봇값의 위치
	}
	
}
