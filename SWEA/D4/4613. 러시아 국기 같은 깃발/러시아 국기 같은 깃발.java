import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			sc.nextLine();
			char[][] country = new char[N][M];
			int[][] color = new int[N][3];
			for (int i = 0; i < N; i++) {
				String t = sc.nextLine();
				for (int j = 0; j < t.length(); j++) {
					country[i][j] = t.charAt(j);
				}
			}
			// 하나씩 돌면서 W, B, R의 개수를 세준다.
			int white = 0;
			int blue = 0;
			int red = 0;
			for (int i = 0; i < N; i++) {
				white = 0;
				blue = 0;
				red = 0;
				for (int j = 0; j < M; j++) {
					if (country[i][j] == 'W') {
						white++;
					} else if (country[i][j] == 'B') {
						blue++;
					} else {
						red++;
					}
				}
				color[i][0] = white;
				color[i][1] = blue;
				color[i][2] = red;
			}
			// 변화의 개수
			int min = Integer.MAX_VALUE;
			int change = 0;
			// blue가 가능한 줄은 1부터 시작
			for (int blues = 1; blues<N; blues++) {
				// red가 가능한 곳은 blue + 1부터 시작
				for (int reds = blues + 1; reds<N;reds++) {
					change = 0;
					// 여기는 전체 순회하면서 확인하는 공간
					for (int i = 0; i <N; i++) {
						// 파랑보다 윗줄이면 여기는 무조건 흰색인 곳이니까
						// 파랑과 빨강 색만큼을 더해준다.
						if(i < blues) {
							change += color[i][1];
							change += color[i][2];
						} 
						// 빨강 보다 윗줄이면 파랑색이어야 하니까
						else if (i < reds) {
							change += color[i][0];
							change += color[i][2];
						}
						// 여긴 빨강이어야만 하는 줄
						else {
							change += color[i][0];
							change += color[i][1];
						}
					}
					min = Math.min(change, min);
				}
			}
			System.out.println("#" + tc + " " + min);
		}

	}
}
