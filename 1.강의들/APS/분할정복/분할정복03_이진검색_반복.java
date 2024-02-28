
public class 분할정복03_이진검색_반복 {
	public static void main(String[] args) {
		
	}
	static boolean binarySearch(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (arr[mid] == key)
				return true;
			else if (arr[mid] > key)
				right = mid -1;
			else
				left = mid + 1;
		}
		return false;
	}
}
