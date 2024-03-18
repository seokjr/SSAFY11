import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 시간 복잡도 = O((V+E)log V)
 * 
 * sample input
 * 5 6
 * 1
 * 5 1 1
 * 1 2 2
 * 1 3 3
 * 2 3 4
 * 2 4 5
 * 3 4 6
 */
public class Main {
	
	private static int V, E, start;
	private static List<Node>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());	// 노드의 개수
		E = Integer.parseInt(st.nextToken());	// 간선의 개수
		start = Integer.parseInt(br.readLine());	// 출발 지점
		
		// 인접 리스트 생성
		graph = new ArrayList[V + 1];
		for(int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[x].add(new Node(y, cost));
		}
		
		// 최소 비용 배열 생성
		int[] dist = new int[V + 1];
		for(int i = 0; i <= V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node cur_node = pq.poll();
			
			if(dist[cur_node.idx] < cur_node.cost) continue;
			
			for(int i = 0; i < graph[cur_node.idx].size(); i++) {
				Node next_node = graph[cur_node.idx].get(i);
				
				if(dist[next_node.idx] > cur_node.cost + next_node.cost) {
					dist[next_node.idx] = cur_node.cost + next_node.cost;
					pq.offer(new Node(next_node.idx, dist[next_node.idx]));
				}
			}
		}
		
		for(int i = 1; i <= V; i++) {
			System.out.println(dist[i]==Integer.MAX_VALUE?"INF":dist[i]);
		}
		
	}
	
	static class Node {
		int idx, cost;
		
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
}
