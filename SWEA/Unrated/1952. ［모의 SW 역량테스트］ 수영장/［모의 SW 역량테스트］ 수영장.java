import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int oneDay = scanner.nextInt();
            int oneMonth = scanner.nextInt();
            int threeMonth = scanner.nextInt();
            int oneYear = scanner.nextInt();
            int[] plan = new int[13];
            for (int i = 1; i <= 12; i++) {
                plan[i] = scanner.nextInt();
            }
            int[] dp = new int[13];
            for (int i = 1; i <= 12; i++) {
            	// 한달에서 하루치 사용해서 하는 비용과 한달이용권을 사는 비용을 비교한다.
                dp[i] = Math.min(dp[i-1] + (oneDay * plan[i]), dp[i-1] + oneMonth);
                // 3이 넘어가면 3개월치의 이용권도 끊을 수 있으니 지금까지한 거랑 뭐가 더 이득인지 비교
                if (i >= 3) {
                    dp[i] = Math.min(dp[i], dp[i-3] + threeMonth);
                }
            }
            // 12개월을 다 한 거랑 1년치 이용권이랑 더 싼 것을 산다.
            int answer = Math.min(dp[12], oneYear);
            System.out.println("#" + tc + " " + answer);
        }
        scanner.close();
    }
}

