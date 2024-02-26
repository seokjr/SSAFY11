import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int end = 1;
		int idx = 1;
		int level = 1;
		while(true) {
			if(end >= N) break;
			
			end += 6 * idx++;
			level++;
		}
		
		System.out.println(level);
	}
}
