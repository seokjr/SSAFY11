import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int[][] arr = new int[9][9];
			int answer = 1;
			for (int i = 0; i<9;i++) {
				for (int j = 0; j<9;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i<9;i++) {
				for (int j = 0; j<9;j++) {
					answer = checking_row(arr, i);
					if (answer != 1) {
						break;
					}
					answer = checking_column(arr, j);
					if (answer != 1) {
						break;
					}
					answer = checking3by3(arr, i, j);
					if (answer != 1) {
						break;
					}
				}
				if (answer != 1) {
					break;
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
		sc.close();
	}

	// 가로 검사
	static int checking3by3(int[][] arr, int row, int column) {
		List<Integer> check = new ArrayList<>();
		int x = row / 3;
		int y = column / 3;
		for (int m = 3 * x; m < 3 * (x + 1); m++) {
			for (int k = 3 * y; k < 3 * (y + 1); k++) {
				check.add(arr[m][k]);
			}
		}
		Set<Integer> Setcheck = new HashSet<>(check);
		if (Setcheck.size() != 9) {
			return 0;
		}
		return 1;
	}

	// 세로 검사
	static int checking_column(int[][] arr, int column) {
		List<Integer> check = new ArrayList<>();
		for (int m = 0; m < 9; m++) {
			check.add(arr[m][column]);
		}
		Set<Integer> Setcheck = new HashSet<>(check);
		if (Setcheck.size() != 9) {
			return 0;
		}
		return 1;
	}

	static int checking_row(int[][] arr, int row) {
		List<Integer> check = new ArrayList<>();
		for (int m = 0; m < 9; m++) {
			check.add(arr[row][m]);
		}
		Set<Integer> Setcheck = new HashSet<>(check);
		if (Setcheck.size() != 9) {
			return 0;
		}
		return 1;
	}
}
