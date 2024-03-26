
public class 그래프_02_인접리스트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점의 개수 (시작점이 0인지, 1인지를 문제를 보고 확인
		int E = sc.nextInt(); // 간선의 개수
		
		List<Integer>[] adjList = new ArrayList[V];
		
		for (int i = 0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			// 가중치를 함께 저장하고 싶으면 클래스를 만들어 넣던지 int[] 형을 넣던지
			if (adjList[A] == null) {
				
			}
			adjList[A].add(B);
			adjList[B].add(A);
		}
		// 인접행렬 vs 인접리스트
		
	}
}
