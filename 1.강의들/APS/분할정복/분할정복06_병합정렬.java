import java.util.Arrays;

public class 분할정복06_병합정렬 {
	static int[] arr = { 5, 22, 32, 26, 57, 19, 32, 55, 84 };
	static int[] sortedArr = new int[arr.length]; // 임시로 저장할 배열

	public static void main(String[] args) {
		System.out.println("정렬 전 : " + Arrays.toString(arr));
		mergeSort(0, arr.length - 1);
		System.out.println("정렬 후 : " + Arrays.toString(arr));

	}

	// left : 구간의 시작 위치/ right : 구간의 끝 위치
	static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left, mid, right);
		}
		return;
	}

	static void merge(int left, int mid, int right) {
		int L = left; //왼쪽 구간의 시작 포인트
		int R = mid + 1; // 오른쪽 구간의 시작 포인트
		int idx = left; // sortedArr의 어디에 집어 넣을지
		
		// 서로 아직 비교할 수 있는 값들이 남아있을 때
		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) sortedArr[idx++] = arr[L++];
			else sortedArr[idx++] = arr[R++];
		}
		// 왼쪽 구간 남았어
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				sortedArr[idx++] = arr[i];
			}
		}
		// 오른쪽 구간 남았어
		else {
			for (int i = R; i <= right; i++) {
				sortedArr[idx++] = arr[i];
			}
		}
		// 마지막으로 해야할 거
		// 원본에 반영하기
		for (int i = left; i <= right; i++) {
			arr[i] = sortedArr[i];
		}
	}

}
