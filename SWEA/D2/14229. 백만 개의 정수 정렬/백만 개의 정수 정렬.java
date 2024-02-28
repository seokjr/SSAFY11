import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static long[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int i = 0;
		arr = new long[1000000];
		while (st.hasMoreTokens()) {
			arr[i++] = Long.parseLong(st.nextToken());
		}
		quickSort(0, arr.length - 1);
		System.out.println(arr[500000]);
	}

	static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot - 1);
			quickSort(pivot + 1, right);
		}
	}

	// 로무토로 해보자.
	static int partition(int left, int right) {
		long pivot = arr[right];
		int i = left - 1;
		for (int j = left; j<right; j++) {
			if (arr[j] <= pivot) {
				i++;
				long tmp = arr[j];
				arr[j] = arr[i];
				arr[i] = tmp;
			}
		}
		// 다 끝나고 제 자리로 가게 하는 거
		long tmp = arr[i+1];
		arr[i+1] = arr[right];
		arr[right] = tmp;
		return i+1;
	}
}
