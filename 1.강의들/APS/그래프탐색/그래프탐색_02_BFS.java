import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 그래프탐색_02_BFS {
	static int V; // 정점의 수
	static List<Integer>[] adj; // 인접행렬
	static boolean[] visited; // 방문체크

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		V = sc.nextInt();
		int E = sc.nextInt();
		adj = new ArrayList[V + 1]; // 시작 정점이 1번부터 시작
		visited = new boolean[V + 1];
		{
			for (int i = 1; i <= V; i++)
				adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			adj[A].add(B);
			adj[B].add(A);
		}
	}

	static String input = "7 9\r\n" + "1 2\r\n" + "1 3\r\n" + "1 6\r\n" + "2 4\r\n" + "2 7\r\n" + "3 4\r\n" + "4 7\r\n"
			+ "5 6\r\n" + "5 7\r\n" + "";

	public static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited[v] = true;
		while (!queue.isEmpty()) {
			int curr = queue.poll(); // 정점 하나를 꺼내
			System.out.println(curr);// 경로 한번 찍어보기
			// 인접리스트!
			for (int w : adj[curr]) {
				queue.add(w);
				visited[w] = true; //미리 방문처리해서 중복으로 큐에 넣는 것 방지
			}
		}
	}
}
