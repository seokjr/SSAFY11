import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int tmp = n/5;
		int cnt = 0;
		while(tmp>=0) {
			cnt = tmp;
			
			if(n%5==0) break;
			
			if((n-tmp*5)%3==0) {
				cnt+=(n-tmp*5)/3;
				break;
			} 
			
			tmp--;
			
		}
		if(tmp==-1) cnt = -1;
		System.out.println(cnt);
	
	}
}