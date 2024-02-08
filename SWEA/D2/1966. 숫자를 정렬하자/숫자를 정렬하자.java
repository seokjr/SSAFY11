import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
         
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[] data = new int[N];
            for (int i = 0; i<N; i++){
                data[i] = sc.nextInt();
            }
 
        // 정렬되지 않은 집합의 원소를 하나씩 순회
        // 원소의 가장 앞을 정렬된 집합이라고 가정
        // 1번부터 비교
            for (int i = 1; i < data.length; i++) {
                int key = data[i];
 
            // 정렬된 집합에 접근해 뒤에서 부터 하나씩 비교
            // key가 놓일 위치를 찾음
               int j = i - 1;
            for (; j >= 0 && data[j] > key; j--) {
                data[j + 1] = data[j];
            }
            data[j + 1] = key;
        }
            System.out.print("#" + test_case + " ");
            for (int i : data){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}