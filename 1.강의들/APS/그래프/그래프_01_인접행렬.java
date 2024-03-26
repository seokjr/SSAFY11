
public class 그래프_01_인접행렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점의 개수 (시작점이 0인지, 1인지를 문제를 보고 확인
		int E = sc.nextInt(); // 간선의 개수
		
		int[][] adjArr = new int[V][V]; //위를 보고 V*V로 할지 V+1 * V+1로 할지 결정
		for (int i = 0; i< E ; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
//			int W = sc.nextInt(); // 경우에 따라 가중치를 입력 받을 수도 있음
			adjArr[A][B] = 1; // 가중치 없을 때
			adjArr[B][A] = 1; // 해당 코드는 그래프가 무향일 때 처리
			
//			adjArr[A][B] = adjArr[B][A] = W; // 한줄로 작성도 가능
			
		}
	}
}
