import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] arr = new boolean[42];
		for(int i=0; i<10; i++) {
			int n = Integer.parseInt(br.readLine());
			arr[n%42]= true;
		}
		int cnt = 0;
		for(int i=0; i<42; i++) {
			cnt += arr[i]? 1:0;
		}
		System.out.println(cnt);
	}
}