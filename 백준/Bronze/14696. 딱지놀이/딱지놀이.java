import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 별 : 4, 동그라미 : 3, 네모 : 2, 세모 : 1
		int round = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < round; i++) {
			// A 입력
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			Map<Integer, Integer> A = new HashMap<>();
			for(int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				A.put(tmp, A.getOrDefault(tmp, 0) + 1);
			}
			// B 입력
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			Map<Integer, Integer> B = new HashMap<>();
			for(int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				B.put(tmp, B.getOrDefault(tmp, 0) + 1);
			}
			
			if(A.getOrDefault(4, 0) != B.getOrDefault(4, 0)) {
				System.out.println(A.getOrDefault(4, 0)>B.getOrDefault(4, 0)?"A":"B");
				continue;
			}
			
			if(A.getOrDefault(3, 0) != B.getOrDefault(3, 0)) {
				System.out.println(A.getOrDefault(3, 0)>B.getOrDefault(3, 0)?"A":"B");
				continue;
			}
			
			if(A.getOrDefault(2, 0) != B.getOrDefault(2, 0)) {
				System.out.println(A.getOrDefault(2, 0)>B.getOrDefault(2, 0)?"A":"B");
				continue;
			}
			
			if(A.getOrDefault(1, 0) != B.getOrDefault(1, 0)) {
				System.out.println(A.getOrDefault(1, 0)>B.getOrDefault(1, 0)?"A":"B");
				continue;
			}
			
			System.out.println("D");
		}
		
	}
}
