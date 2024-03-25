import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[][] times = new int[100_001][2];
		for(int i = 0; i < times.length; i++) {
			times[i][0] = i;
			if(i == N) times[i][1] = 0; 
			else times[i][1] = Integer.MAX_VALUE;
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.offer(times[N]);
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			if(now[0] + 1 < times.length && times[now[0] + 1][1] > now[1] + 1) {
				times[now[0] + 1][1] = now[1] + 1;
				pq.offer(times[now[0] + 1]);
			}
			if(now[0] - 1 > 0 && times[now[0] - 1][1] > now[1] + 1) {
				times[now[0] - 1][1] = now[1] + 1;
				pq.offer(times[now[0] - 1]);
			}
			if(now[0] * 2 < times.length &&  times[now[0] * 2][1] > now[1]) {
				times[now[0] * 2][1] = now[1];
				pq.offer(times[now[0] * 2]);
			}
		}
		
		System.out.println(times[K][1] == Integer.MAX_VALUE ? Math.abs(N-K) : times[K][1]);
	}
}
