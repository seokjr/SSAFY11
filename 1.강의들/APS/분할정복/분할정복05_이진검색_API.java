import java.util.Arrays;

public class 분할정복05_이진검색_API {
	static int[] arr;
	static int key;
	public static void main(String[] args) {
		arr = new int[] {2, 4, 6, 8, 9, 17, 28};
		key = 4;
		System.out.println(Arrays.binarySearch(arr, key));
		// 있는 키를 찾으면 해당 index를 반환해준다.
		// 없는 키를 찾으면 이상한 음수값을 반환해준다.
		// 음수를 반환하는 규칙이 존재한다.
	}
}
