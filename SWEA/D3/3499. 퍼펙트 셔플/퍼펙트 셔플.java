import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int tc = 1; tc<=T; tc++) {
			int n = sc.nextInt();
			sc.nextLine();
			String[] deck = sc.nextLine().split(" ");
			
			int deck_size = n/2;
			// 짝수일 때
			String[] Front_deck;
			String[] Back_deck;
			
			if (n % 2 == 0) {
				Front_deck = new String[deck_size];
				Back_deck = new String[deck_size];
				for (int i = 0, fcnt=0, bcnt=0; i<deck.length;i++) {
					// 그냥 몇번 숫자까지는
					if (i < deck_size) {
						Front_deck[fcnt++] = deck[i];
					}
					else {
						Back_deck[bcnt++] = deck[i];
					}
				}
			} 
			// 홀수일 때
			else {
				Front_deck = new String[deck_size+1];
				Back_deck = new String[deck_size];
				for (int i = 0, fcnt=0, bcnt=0; i<deck.length;i++) {
					// 그냥 몇번 숫자까지는
					if (i <= deck_size) {
						Front_deck[fcnt++] = deck[i];
					}
					else {
						Back_deck[bcnt++] = deck[i];
					}
				}
			}
			List<String> ans = new ArrayList<>();
			for (int i = 0, fcnt=0, bcnt=0; i<deck.length;i++) {
				// 그냥 몇번 숫자까지는
				if (i % 2 == 0) {
					ans.add(Front_deck[fcnt++]);
				}
				else {
					ans.add(Back_deck[bcnt++]);
				}
			}
			System.out.print("#" + tc + " ");
			for (String i : ans) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
