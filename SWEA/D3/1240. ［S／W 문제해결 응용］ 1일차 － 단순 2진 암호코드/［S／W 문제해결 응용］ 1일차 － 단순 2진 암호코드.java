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
			String[] arr = new String[H];
			for (int i = 0; i < H; i++) {
				String s = sc.nextLine();
				arr[i] = s;
			}
			int row = 0;
			for (int i = 0; i < H; i++) {
				// 만약 1이 들어가 있는 행이 나온다면 멈추고 그 행을 기억
				if (arr[i].contains("1")) {
					row = i;
					break;
				}
			}
			String tar = arr[row];
			int odd_num = 0;
			int even_num = 0;
			int start = 0;
			for (int i = tar.length() - 1; i >= 0; i--) {
				// 뒤부터 보면서 처음 1이 나오면 거기부터 암호
				if (tar.charAt(i) == '1') {
					start = i;
					break;
				}
			}
			int cnt = 0;
			for (int i = start; i > start - (8 * 7); i -= 7) {
				String temp = "";
				int num = 0;
				for (int j = 6; j >= 0; j--) {
					temp += tar.charAt(i - j);
				}
				if (temp.equals("0001101")) {
					num = 0;
				}
				else if (temp.equals("0011001")) {
					num = 1;
				}
				else if (temp.equals("0010011")) {
					num = 2;
				}
				else if (temp.equals("0111101")) {
					num = 3;
				}
				else if (temp.equals("0100011")) {
					num = 4;
				}
				else if (temp.equals("0110001")) {
					num = 5;
				}
				else if (temp.equals("0101111")) {
					num = 6;
				}
				else if (temp.equals("0111011")) {
					num = 7;
				}
				else if (temp.equals("0110111")) {
					num = 8;
				}
				else if (temp.equals("0001011")) {
					num = 9;
				}
				// 뒤부터 오는데 cnt가 짝수면 even에 넣어준다.
				if (cnt % 2 == 0) {
					even_num += num;
				} else {
					odd_num += num;
				}
				cnt++;
			}
			int answer = 0;
			if (((odd_num * 3) + even_num) % 10 == 0) {
				answer = odd_num + even_num;
			}
			
			// 여기에 써야 함
			System.out.println("#" + tc + " " + answer);
		}
	}
}
