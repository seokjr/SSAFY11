import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int N;
	static int[] arr;
	static String[] result;
	static boolean[] visited;
	static int K;
	static Set<Integer> ans_list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];
		result = new String[K];
		ans_list = new HashSet<>();
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		making(0);
		System.out.println(ans_list.size());
	}

	static void making(int idx) {
		if (idx >= K) {
			String temp = "";
			for (String i : result) {
				temp += i;
			}
			int tmp = Integer.parseInt(temp);
			ans_list.add(tmp);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			result[idx] = Integer.toString(arr[i]);
			making(idx + 1);
			visited[i] = false;
		}
	}

}
