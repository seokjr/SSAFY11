import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 크루스칼 {
	static class Edge implements Comparable<Edge>{
		int A, B, W;

		public Edge(int a, int b, int w) {
			A = a;
			B = b;
			W = w;
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.W - o.W;
		}
		
	}
	static int[] p;

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input);
		int V = sc.nextInt(); // 정점의 개수 (정점의 시작 번호)
		int E = sc.nextInt(); // 간선의 개수

		// 간선의 배열을 이용
		// 1.클래스 2.2차원배열
		int[][] edges = new int[E][3]; // [0]:시작정점, [1]끝정점, [2]: 가중치
		for (int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		} // 간선 입력 끝

		// 크루스칼 제 1장 : 가중치 기준으로 정렬을 해야함.(오름차순)
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] e1, int[] e2) {
				return e1[2] - e2[2];
			}
		});
		
		// 클래스를 이용해서 정렬을 해볼 수도 있다.
//		Edge[] edges2 = new Edge[E];
//		for (int i = 0; i<E; i++) {
//			edges2[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
//		}// 간선 입력 끝
//		
//		Arrays.sort(edges2);
		
		// 크루스칼 제 2장 : V-1개의 간선을 뽑아야 한다. (사이클이 발생 안하게)
		// 상호배타집합 이라고 하는 것을 활용해보자.
		p = new int[V];
		// make-set 하자. (나 자신을 대표로 초기화 하자.)
		for (int i = 0; i < V; i++) {
//			makeset(i);  // 이것이 정석
			p[i] = i; // 이것이 스킬
		}
		// V-1 개의 간선을 뽑기 위함
		// while 문으로도 작성을 한번 해보자.
		int ans = 0; // 최소 비용의 합
		int pick = 0; // 내가 뽑은 간선의 수

		for (int i = 0; i < E; i++) {
			// i번째 간선을 뽑아 두 정점의 대표를 확인!
//			int x = edges[i][0];
//			int y = edges[i][1];
//			// 아래의 if 문의 의미는? x와 y가 대표가 달라!
//			if (findset(x) != findset(y)) {
//				union(x, y);
//				ans += edges[i][2]; // 현재 간선을 선택한 것이니 가중치를 추가
//				pick++; // 간선 선택한 것이니 간선개수 추가
//			}
			int px = findset(edges[i][0]);
			int py = findset(edges[i][1]);
			if (px != py) {
				union(px, py);
				ans += edges[i][2];
				pick++;
			}

			// 아래의 문장이 있든 없든 답은 같아.
			if (pick == (V - 1))
				break;

		} // 간선 배열을 순회하는 for
		System.out.println(ans);
	}

	static void union(int x, int y) {
		// rank를 고려하지 않기 때문에 냅다 y 집합을 x의 집합으로 넣기
//		p[findset(y)] = findset(x);
		// 이제 어차피 x, y는 대표만 넣어주기로 했어!
		p[y] = x;
	}

	static int findset(int x) {
		// 정석
//		if (x==p[x]) return x;
//		return findset(p[x]);

		// 패스 컴프레션
		if (x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}

	static void makeset(int x) {
		p[x] = x;
	}

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "";
}
