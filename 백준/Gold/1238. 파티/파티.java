import java.io.*;
import java.util.*;

public class Main {
	static List<Node>[] graph, reverse_graph;
	static int[] time, reverse_time;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		reverse_graph = new ArrayList[N + 1];
		time = new int[N + 1];
		reverse_time = new int[N + 1];
		visit = new boolean[N + 1];
		Arrays.fill(time, Integer.MAX_VALUE);
		Arrays.fill(reverse_time, Integer.MAX_VALUE);
		time[X] = 0;
		reverse_time[X] = 0;
		for(int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
			reverse_graph[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			graph[S].add(new Node(E, T));
			reverse_graph[E].add(new Node(S, T));
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> reverse_time[o1] - reverse_time[o2]);
		pq.add(X);
		
		while(!pq.isEmpty()) {
			int tmp = pq.poll();
			if(visit[tmp]) continue;
			visit[tmp] = true;
			for(int i = 0; i < reverse_graph[tmp].size(); i++) {
				Node node = reverse_graph[tmp].get(i);
				if(reverse_time[node.target] > reverse_time[tmp] + node.time) {
					reverse_time[node.target] = reverse_time[tmp] + node.time;
					pq.offer(node.target);
				}
			}
		}
		
		visit = new boolean[N + 1];
		pq = new PriorityQueue<>((o1, o2) -> time[o1] - time[o2]);
		pq.add(X);
		
		while(!pq.isEmpty()) {
			int tmp = pq.poll();
			if(visit[tmp]) continue;
			visit[tmp] = true;
			for(int i = 0; i < graph[tmp].size(); i++) {
				Node node = graph[tmp].get(i);
				if(time[node.target] > time[tmp] + node.time) {
					time[node.target] = time[tmp] + node.time;
					pq.offer(node.target);
				}
			}
		}
		
		int value = Integer.MIN_VALUE;
		for(int i = 1; i <= N; i++) {
			if(value < time[i] + reverse_time[i]) {
				value = time[i] + reverse_time[i];
			}
		}
		
		System.out.println(value);
	}
	static class Node {
		int target, time;

		public Node(int target, int time) {
			this.target = target;
			this.time = time;
		}
	}
}
