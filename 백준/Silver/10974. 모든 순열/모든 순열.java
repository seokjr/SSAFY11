import java.io.*;
import java.util.*;

public class Main {
	static int[] select;
	static boolean[] visit;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		select = new int[N];
		visit = new boolean[N + 1];
		permutation(0);
	}
	
	static void permutation(int idx) {
		if(idx == N) {
			for(int i : select) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 1; i <= N; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			select[idx] = i;
			permutation(idx + 1);
			visit[i] = false;
		}
	}
}
