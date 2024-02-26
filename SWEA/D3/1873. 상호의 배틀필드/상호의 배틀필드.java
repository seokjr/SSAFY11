import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= T; tc++) {
			// 전체 입력 받기
			int H = sc.nextInt();
			int W = sc.nextInt();
			sc.nextLine();
			int tank_x = 0;
			int tank_y = 0;
			char[][] map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String s = sc.nextLine();
				for (int j = 0; j < s.length(); j++) {
					map[i][j] = s.charAt(j);
					// 만약 화살표 모양이 나오면 탱크자리니까 거기 저장
					if (s.charAt(j) == '<' || s.charAt(j) == '>' || s.charAt(j) == '^' || s.charAt(j) == 'v') {
						tank_x = j;
						tank_y = i;
					}
				}
			}
			int orderCNT = sc.nextInt();
			sc.nextLine();
			String order = sc.nextLine();
			char[] order_list = new char[orderCNT];
			for (int i = 0; i < orderCNT; i++) {
				order_list[i] = order.charAt(i);
			}
			for (int i = 0; i < orderCNT; i++) {
				char ord = order_list[i];
				// 윗 방향
				if (ord == 'U') {
					// 맵 보다 작은 공간이면서
					if (tank_y - 1 >= 0) {
						// 평지라면 그 방향으로 이동하고 방향 바꾸고
						if (map[tank_y - 1][tank_x] == '.') {
							// 원래 자리는 평지로
							map[tank_y][tank_x] = '.';
							map[tank_y - 1][tank_x] = '^';
							tank_y--;
						}
						// 평지가 아니라면 그냥 그 자리에서 방향만 바꿔준다.
						else {
							map[tank_y][tank_x] = '^';
						}
					}
					// 맵을 벗어나게 된다면 그냥 제자리에서 방향만 바꿔준다.
					else {
						map[tank_y][tank_x] = '^';
					}
				}
				// 아랫 방향
				else if (ord == 'D') {
					// 맵 보다 작은 공간이면서
					if (tank_y + 1 < H) {
						// 평지라면 그 방향으로 이동하고 방향 바꾸고
						if (map[tank_y + 1][tank_x] == '.') {
							// 원래 자리는 평지로
							map[tank_y][tank_x] = '.';
							map[tank_y + 1][tank_x] = 'v';
							tank_y++;
						}
						// 평지가 아니라면 그냥 그 자리에서 방향만 바꿔준다.
						else {
							map[tank_y][tank_x] = 'v';
						}
					}
					// 맵을 벗어나게 된다면 그냥 제자리에서 방향만 바꿔준다.
					else {
						map[tank_y][tank_x] = 'v';
					}
				}
				// 오른 방향
				else if (ord == 'R') {
					// 맵 보다 작은 공간이면서
					if (tank_x + 1 < W) {
						// 평지라면 그 방향으로 이동하고 방향 바꾸고
						if (map[tank_y][tank_x + 1] == '.') {
							// 원래 자리는 평지로
							map[tank_y][tank_x] = '.';
							map[tank_y][tank_x + 1] = '>';
							tank_x++;
						}
						// 평지가 아니라면 그냥 그 자리에서 방향만 바꿔준다.
						else {
							map[tank_y][tank_x] = '>';
						}
					}
					// 맵을 벗어나게 된다면 그냥 제자리에서 방향만 바꿔준다.
					else {
						map[tank_y][tank_x] = '>';
					}
				}
				// 왼쪽 방향
				else if (ord == 'L') {
					// 맵 보다 작은 공간이면서
					if (tank_x - 1 >= 0) {
						// 평지라면 그 방향으로 이동하고 방향 바꾸고
						if (map[tank_y][tank_x - 1] == '.') {
							// 원래 자리는 평지로
							map[tank_y][tank_x] = '.';
							map[tank_y][tank_x - 1] = '<';
							tank_x--;
						}
						// 평지가 아니라면 그냥 그 자리에서 방향만 바꿔준다.
						else {
							map[tank_y][tank_x] = '<';
						}
					}
					// 맵을 벗어나게 된다면 그냥 제자리에서 방향만 바꿔준다.
					else {
						map[tank_y][tank_x] = '<';
					}
				}
				// 발사연산이 나오면
				else {
					// 일단 현재 위치에서 방향 확인
					char cur_dir = map[tank_y][tank_x];
					// 윗 방향이면
					if (cur_dir == '^') {
						// 현재 위치부터 위로 for문 돌면서
						for (int j = tank_y - 1; j >= 0; j--) {
							// 벽돌이 나오면 처음으로 만나는 것일 테니까 깨부수고 break 걸고 넘어감
							if (map[j][tank_x] == '*') {
								map[j][tank_x] = '.';
								break;
							}
							// 강철 벽이면 못뚫는다.
							else if (map[j][tank_x] == '#') {
								break;
							}
						}
					}
					// 아랫방향이면
					else if (cur_dir == 'v') {
						// 현재 위치 다음부터 아래로 for문 돌면서
						for (int j = tank_y + 1; j < H; j++) {
							// 벽돌이 나오면 처음으로 만나는 것일 테니까 깨부수고 break 걸고 넘어감
							if (map[j][tank_x] == '*') {
								map[j][tank_x] = '.';
								break;
							}
							// 강철 벽이면 못뚫는다.
							else if (map[j][tank_x] == '#') {
								break;
							}
						}
					}
					// 오른방향이면
					else if (cur_dir == '>') {
						// 현재 위치 다음부터 오른쪽으로 for문 돌면서
						for (int j = tank_x + 1; j < W; j++) {
							// 벽돌이 나오면 처음으로 만나는 것일 테니까 깨부수고 break 걸고 넘어감
							if (map[tank_y][j] == '*') {
								map[tank_y][j] = '.';
								break;
							}
							// 강철 벽이면 못뚫는다.
							else if (map[tank_y][j] == '#') {
								break;
							}
						}
					}
					// 왼쪽 방향이면
					if (cur_dir == '<') {
						// 현재 위치부터 왼쪽으로 for문 돌면서
						for (int j = tank_x - 1; j >= 0; j--) {
							// 벽돌이 나오면 처음으로 만나는 것일 테니까 깨부수고 break 걸고 넘어감
							if (map[tank_y][j] == '*') {
								map[tank_y][j] = '.';
								break;
							}
							// 강철 벽이면 못뚫는다.
							else if (map[tank_y][j] == '#') {
								break;
							}
						}
					}
				}
			}
			// 여기에 써야 함
			System.out.print("#" + tc + " ");
			for (int i = 0; i<H;i++) {
				for (int j = 0; j<W;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
