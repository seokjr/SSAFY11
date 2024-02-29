import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static int[] result;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];
		result = new int[N];
		int tmp = 0;
		for (int i = 1; i <= N; i++) {
			arr[tmp++] = i;
		}
		perm(0);
	}

	static void perm(int idx) {
		if (idx >= N) {
			for (int i : result) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i<N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			result[idx] = arr[i];
			perm(idx+1);
			visited[i] = false;
		}
	}

}
