import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        for (int tc = 1; tc <= T; tc++) {
            int N = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            ArrayList<String[]> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(scanner.nextLine().split(" "));
            }
            	
            int[] dx = {-1, 1, 0, 0, -1, 1, 1, -1};
            int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
            int maxAnswer = 1;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    int cnt = 0;
                    String t = arr.get(x)[y];

                    if (t.equals("G")) {
                        continue;
                    }

                    for (int i = 0; i < dx.length; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < N && arr.get(nx)[ny].equals("W")) {
                            cnt += 1;
                        } 
                    }

                    if (maxAnswer <= cnt) {
                        maxAnswer = cnt;
                    }
                }
            }
            System.out.println("#" + tc + " " + maxAnswer);
        }
        scanner.close();
    }
}

