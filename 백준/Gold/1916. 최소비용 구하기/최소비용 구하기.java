import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<Node>[] graph = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[s].add(new Node(t, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[N + 1];
		for(int i = 0; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
		
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node cur_node = pq.poll();
			if(cur_node.x == target) break;
			
			if(dist[cur_node.x] < cur_node.cost) continue;
			
			for(int i = 0; i < graph[cur_node.x].size(); i++) {
				Node next_node = graph[cur_node.x].get(i);
				
				if(dist[next_node.x] > cur_node.cost + next_node.cost) {
					dist[next_node.x] = cur_node.cost + next_node.cost;
					pq.offer(new Node(next_node.x, dist[next_node.x]));
				}
			}
		}
		
		System.out.println(dist[target]);
		
	}
	
	private static class Node {
		int x, cost;

		public Node(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}
	}
}
