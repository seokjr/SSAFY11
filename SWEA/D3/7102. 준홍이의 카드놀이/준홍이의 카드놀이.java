/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		
	
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int tc = 1; tc<=T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[] n_list = new int[n];
			int[] m_list = new int[m];
			for(int i=1; i<=n; i++) {
				n_list[i-1] = i;
			}
			int[] answer_list = new int[n+m+1];
			for(int i=1; i<=m; i++) {
				m_list[i-1] = i;
			}
			for (int i=0; i<n_list.length; i++) {
				for (int j=0; j<m_list.length; j++) {
					answer_list[n_list[i] + m_list[j]]++;
				}
			}
			int max = 0;
			for (int i=0; i<answer_list.length;i++) {
				if (answer_list[i] >= max) {
					max = answer_list[i];
				}
			}
			List<Integer> ans = new ArrayList<>();
			for (int i=0; i<answer_list.length;i++) {
				if (answer_list[i] == max) {
					ans.add(i);
				}
			}
			System.out.print("#" + tc + " ");
			for(int i: ans){ // for each로 리스트 원소들을 하나씩 내보낸다
			    System.out.print(i+" "); // 원소들을 하나씩 내보내며 줄바꿈 없이 진행한다
			}
            System.out.println();
		}
	}
}