
public class 그래프_03_간선배열 {
	static class Edge {
		int A, B; // 시작과 끝 노드
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점의 개수 (시작점이 0인지, 1인지를 문제를 보고 확인
		int E = sc.nextInt(); // 간선의 개수
		
		Edge[] edges = new Edge[E];
		List<Edge> edges2 = new ArrayList<>();
		
		for (int i = 0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			edges[i] = new Edge(A,B);
		}
		int[][] edges3 = new int[E][2];
	}
}
