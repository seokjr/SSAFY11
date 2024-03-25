import java.util.Scanner;

public class Test1_대전_03반_석재륜 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int answer = 0;
			int[][] arr = new int[9][9];
			// 입력 받기
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					int m = sc.nextInt();
					arr[i][j] = m;
				}
			}
			int n = sc.nextInt();
			int[][] info = new int[n][3];
			for (int i = 0; i < n; i++) {
				int M = sc.nextInt();
				int D = sc.nextInt();
				int S = sc.nextInt();
				info[i][0] = M;
				info[i][1] = D;
				info[i][2] = S;
			}

			// 입력받은 수만큼 순회하려는 절차

			start: for (int k = 0; k < n; k++) {
				// 소음 거리 확인
				int temp_m = info[k][0];
				int temp_d = info[k][1];
				int temp_s = info[k][2];
				// 9 x 9 배열을 돌면서 빈 자리를 확인한다.
				for (int r = 0; r < 9; r++) {
					// r % 2 == 0일때 짝수일 때는 왼쪽으로 가면서 확인
					if (r % 2 == 0) {
						for (int c = 0; c < 9; c++) {
							// 가다가 빈 자리를 만나면
							if (arr[r][c] == 0) {
								// 주변 확인
								// -temp_d에서 + temp_d까지
								int temp = 0;
								boolean flag = false;
								for (int i = -temp_d; i <= temp_d; i++) {
									for (int j = -temp_d; j <= temp_d; j++) {
										// i의 절대값과 j의 절대값을 더한게 temp_d가 아니면
										// 그건 그냥 넘어간다.
										if (Math.abs(i) + Math.abs(j) > temp_d) {
											continue;
										}
										// 절대값이 서로 딱 temp_d 만큼만 간 상황인 거고
										int nr = r + i;
										int nc = c + j;
										// 지도 범위 밖이면 continue 그것도 넘어간다.
										// 그리고 arr[nr][nc] == -1 도 넘어간다.
										if (nr < 0 || nc < 0 || nc >= 9 || nr >= 9 || arr[nr][nc] == -1) {
											continue;
										}
										// 한번이라도 안쪽으로 들어와야 temp를 늘릴 것 flag로 확인
										flag = true;
										// 모든 절차를 다 넘어서 왔으면 arr[nr][nc]를 temp에 더해준다.
										temp += arr[nr][nc];
										// 그리고 다 돌고 나서 확인했을 때 temp가 temp_m보다 같거나 작으면
										// 그때의 arr[r][c]를 앉은 것으로 간주
									}
								}
								if (flag && temp <= temp_m) {
									arr[r][c] = temp_s;
									++answer;
									// 정답을 늘려줬으면 시작으로 가야한다.
									continue start;
								}
							}
						}
					}
					// 아닐 때는 오른쪽에서부터 오면서 확인
					else {
						for (int c = 8; c >= 0; c--) {
							// 가다가 빈 자리를 만나면
							if (arr[r][c] == 0) {
								// 주변 확인
								int temp = 0;
								boolean flag = false;
								for (int i = -temp_d; i <= temp_d; i++) {
									for (int j = -temp_d; j <= temp_d; j++) {
										if (Math.abs(i) + Math.abs(j) > temp_d) {
											continue;
										}
										int nr = r + i;
										int nc = c + j;
										if (nr < 0 || nc < 0 || nc >= 9 || nr >= 9 || arr[nr][nc] == -1) {
											continue;
										}
										flag = true;
										temp += arr[nr][nc];
									}
								}
								if (flag && temp <= temp_m) {
									arr[r][c] = temp_s;
									++answer;
									continue start;
								}
							}
						}
					}

				}
			}
			if (answer == 0) {
				answer = -1;
			}
			System.out.println("#" + tc + " " + answer);
		}
		sc.close();
	}
}
