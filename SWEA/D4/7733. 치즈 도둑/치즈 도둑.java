import java.util.Scanner;

public class Solution {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            arr = new int[N][N];
            int max_target = 0;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                    max_target = Math.max(arr[i][j], max_target);
                }
            }
            
            int[] answer_list = new int[max_target + 1];
            
            for (int i = 0; i <= max_target; i++) {
                int result = 0;
                visited = new boolean[N][N];
                
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        if (dfs(i, r, c)) {
                            result += 1;
                        }
                    }
                }
                
                answer_list[i] = result;
            }
            int answer = 0;
            for (int i = 0; i <= max_target; i++) {
                if (answer_list[i] >= answer){
                	answer = answer_list[i];
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
        
        sc.close();
    }
    
    public static boolean dfs(int v, int y, int x) {
        if (x <= -1 || x >= N || y <= -1 || y >= N || arr[y][x] <= v) {
            return false;
        }
        
        if (arr[y][x] > v && !visited[y][x]) {
            visited[y][x] = true;
            dfs(v, y-1, x);
            dfs(v, y, x-1);
            dfs(v, y+1, x);
            dfs(v, y, x+1);
            return true;
        }
        
        return false;
    }
}

