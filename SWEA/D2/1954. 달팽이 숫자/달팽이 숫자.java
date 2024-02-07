import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		 for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int num = 1;
            int d = 0;
            // 우 하 좌 상
            int[] dr = { 0, 1, 0, -1 };
            int[] dc = { 1, 0, -1, 0 };
 
            int cr = 0;
            int cc = 0;
            for (int i = 0; i < n * n; i++) {
                arr[cr][cc] = num;
                num++;
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && arr[nr][nc] == 0) {
                    cr = nr;
                    cc = nc;
                } else {
                    d = (d + 1) % 4;
                    cr += dr[d];
                    cc += dc[d];
                }
            }
            System.out.printf("#%d%n" , t);
            for (int r = 0; r < arr.length; r++) {
                for (int c = 0; c < arr.length; c++) {
                    System.out.print(arr[r][c] + " ");
                }
                System.out.println();
            }
         }
	}
}