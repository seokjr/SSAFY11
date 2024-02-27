import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] synergy;
	static int[] A_idx;
	static List<Integer> A_idxToList;
	static List<Integer> A_num;
	static List<Integer> B_num;
	static int min;
	static int R;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			// 전체 입력 받기
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			// 초기화
			synergy = new int[N][N];
			R = N / 2;
			A_idx = new int[R];
			A_num = new ArrayList<>();
			B_num = new ArrayList<>();
			A_idxToList = new ArrayList<>();
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			combination(0, 0);
			System.out.println("#" + tc + " " + min);
		}
	}

	static void combination(int idx, int sidx) {
		// base case
		// sidx 가 N / 2 되면 절반 개수만큼 확인한 거니깐
		// 그때 A의 배열과 B의 배열을 확인하고 서로의 합의 절대값을 준다.
		// 절대값의 차이가 가장 작은 것이 좋은 것이니까 갱신할 수 있도록 한다.
		if (sidx >= R) {
			A_num = new ArrayList<>();
			B_num = new ArrayList<>();
			// 굳이 list로 만들어야 하나 싶긴한데 있는지 확인하고
			// 역수 취하려면 나의 로직에선 해야한다.
			A_idxToList = new ArrayList<>();
			for (int i : A_idx) {
				A_idxToList.add(i);
			}
			for (int i = 0; i < N; i++) {
				// A_list에 있는 애들을 넣는 과정
				if (A_idxToList.contains(i)) {
					A_num.add(i);
				} 
				else {
					B_num.add(i);
				}
			}
			// 시너지에서 각각의 만큼에서 2개를 뽑는 조합을 더해야 한다.
			// A의 맛점수 조합들
			int A_sum = 0;
			for (int i = 0; i<A_num.size()-1;i++) {
				for (int j =i+1;j<A_num.size();j++) {
					int a = A_num.get(i);
					int b = A_num.get(j);
					// 대칭의 자리를 더해줘야한다.
					A_sum += synergy[a][b];
					A_sum += synergy[b][a];
				}
			}
			// B의 맛점수 조합들
			int B_sum = 0;
			for (int i = 0; i<B_num.size()-1;i++) {
				for (int j =i+1;j<B_num.size();j++) {
					int a = B_num.get(i);
					int b = B_num.get(j);
					B_sum += synergy[a][b];
					B_sum += synergy[b][a];
				}
			}
			int temp = Math.abs(A_sum - B_sum); 
			min = Math.min(temp, min);
			return;
		}
		
		// recursive case
		// N / 2개씩은 무조건 서로 가져가야 한다. 그래서 sidx 사용
		for (int i = idx; i <= N - R + sidx; i++) {
			A_idx[sidx] = i; // 인덱스로 어떤 것을 골랐는지 확인
			combination(i + 1, sidx + 1);
		}
	}
}
