import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = -1;
		int cnt = 1;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		while((N = Integer.parseInt(br.readLine())) != 0) {
			int[][] cost = new int[N][N];
			int[][] dp = new int[N][N];
			boolean[][] visit = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					cost[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					dp[i][j] = Integer.MAX_VALUE;
				}
			}
			
			dp[0][0] = cost[0][0];
			
			PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2) -> dp[p1.x][p1.y]-dp[p2.x][p2.y]);
			
			pq.offer(new Point(0, 0));
			
			while(!pq.isEmpty()) {
				Point p = pq.poll();
				
				if(visit[p.x][p.y]) continue;
				visit[p.x][p.y] = true;
				
				for(int i = 0; i < dx.length; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					
					if(dp[nx][ny] > dp[p.x][p.y] + cost[nx][ny] ) {
						dp[nx][ny] = dp[p.x][p.y] + cost[nx][ny];
						pq.offer(new Point(nx, ny));
					}
				}
			}
			
			sb.append("Problem "+ cnt++ +": "+ dp[N-1][N-1] + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
class Point {
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
