import java.util.Arrays;
import java.util.Scanner;

public class Test2_대전_03반_석재륜 {
	static boolean[] visited;
	static int[] result;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int answer = 0;
			arr = new int [3][9];
			result = new int[3];
			// 입력 받기
			visited = new boolean [3];
			for (int i = 0; i<3;i++) {
				for (int j = 0; j<9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			perm(0);
			// 순환하면서 최적의 3조합 찾기?
			// 첫날에서 3개 2일에서 3개 3일에서 3개
			// 조합처럼 찾으면 될듯
			// 3개의 각각의 날에서 3개가 되는 모든 조합들을 각각 날별로 구한다
			// 그리고 그 때의 idx를 같이 함께 저장한 다음.
			// idx를 모두 더한게 1, 2, 3, 4, 5, 6, 7, 8, 9를 만족하며
			// 그 날들의 값의 합이 최대일 때만 값을 갱신.
			
			
			// 시간이 없으니 풀이 방법 정리
			// 조합을 사용하여 각각의 일차별로 3개씩의 모든 조합을 인덱스와 함께 정리한다.
			// ex) 1일차 : [5, 1, 8][0, 1, 2], [3, 7, 3][3, 4, 5], [2, 5, 2][6, 7, 8]
			// 일자별 리스트가 존재할텐데 일차별 순서대로 리스트의 인덱스를 하나씩 증가시키며
			// 전체 인덱스의 총 모음이 0~8까지 있으면서 최대인 값일 때 값을 갱신한다.
			// 1일차 값:[1, 3, 7] 인덱스[0, 1, 3] 
			// 2일차 값:[1, 2, 2] 인덱스[5, 2, 3]
			// 3일차 값:[5, 6, 7] 인덱스[1, 2, 3] 이런 경우는 불가
			// 1일차 값:[1, 3, 7] 인덱스[0, 1, 2] 
			// 2일차 값:[1, 2, 2] 인덱스[3, 4, 5]
			// 3일차 값:[5, 6, 7] 인덱스[6, 7, 8] 이런 경우는 가능 최대값일 때만 값 갱신
			System.out.println("#" + tc + " " + answer);
		}
		sc.close();
	}
	public static void perm(int idx) {
		if (idx >= 3) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = 0; i<9; i++) {
			// 방문했으면 continue
			if (visited[idx]) {
				continue;
			}
			// 방문 안했으면
			// 했다고 하고
			visited[idx] = true;
			result[idx] = arr[0][i]; 
			perm(i+1);
			// 다시 안 간척한다.
			visited[idx] = false;
		}
	}	
}
