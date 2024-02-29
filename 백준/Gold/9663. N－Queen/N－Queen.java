import java.util.Scanner;
 
public class Main {
    static int N;
    static int[] visited;
    static int cnt;
 
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
            
        visited = new int[N];
            
        cnt = 0;
        queens(0);
        System.out.println(cnt);
    }
 
    // idx : x 위치 columns의 위치들
    static void queens(int idx) {
        // 기저 조건 : 입력받은 N개만큼 될 때
        if (idx >= N) {
            // 뭔가를 찾았으니까 개수 늘리고
            cnt++;
            return;
        }
        // 호출 조건 여긴 행이라고 생각
        for (int i = 0; i < N; i++) {
            // 방문 했으면
            visited[idx] = i;
            // 같은 줄에 없는지는 지금 어차피 i가 열이라고 생각하기에 같은 행에 없고 대각선에 없고만 찾는다.
            if (isok(idx)) {
                queens(idx + 1);
            }
        }
    }
 
    static boolean isok(int idx) {
        // 0 부터 idx가 있는 줄까지만 보면 된다. 뒷줄은 어차피 확인을 할 수 있기에 idx가 차면 찰수록
        for (int i = 0; i < idx; i++) {
            // 같은 행인지 확인 하는 것
            if (visited[idx] == visited[i])
                return false;
            // 대각선에 있나? 대각선은 열과 행의 절대값이 같은데
            // idx - i 는 x 좌표들의 차이라고 생각 visited에 들어가는 값은 y좌표 들의 차이
            else if (idx - i == Math.abs(visited[idx] - visited[i])) {
                return false;
            }
        }
        return true;
    }
}