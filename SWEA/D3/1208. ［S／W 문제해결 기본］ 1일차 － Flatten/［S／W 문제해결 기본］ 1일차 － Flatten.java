import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[] arr = new int[100];
			for (int i = 0; i < 100; i++) {
				arr[i] = sc.nextInt();
			}

			int cnt = 0;
			int max_index;
			int min_index;
			int max;
			int min;
			int answer = 0;
			for (int i = 0; i < 1000; i++) {
				max = Arrays.stream(arr).max().getAsInt();
				min = Arrays.stream(arr).min().getAsInt();
				List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
				max_index = list.indexOf(max);
				min_index = list.indexOf(min);
				arr[max_index] = arr[max_index] - 1;
				arr[min_index] = arr[min_index] + 1;
				cnt++;

				if (cnt == N) {
					break;
				}
				if (Math.abs(arr[max_index] - arr[min_index]) == 0) {
					break;
				}
			}
			// result 를 돌면서
			max = Arrays.stream(arr).max().getAsInt();
			min = Arrays.stream(arr).min().getAsInt();
			List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
			max_index = list.indexOf(max);
			min_index = list.indexOf(min);
			answer = Math.abs(arr[max_index] - arr[min_index]);
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}