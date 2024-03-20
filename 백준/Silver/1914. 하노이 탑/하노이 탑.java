import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main{
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		System.out.println(power(cnt).subtract(BigInteger.valueOf(1)));
		if(cnt > 20) return;
		hanoi(cnt, 1, 2, 3);
		System.out.println(sb.toString());
	}
	
	private static void hanoi(int cnt, int from, int temp, int to) {
		if(cnt == 0) return;
		hanoi(cnt - 1, from, to, temp);
		sb.append(from + " " + to + "\n");
		hanoi(cnt - 1, temp, from, to);
	}
	
	private static BigInteger power(int cnt) {
		if(cnt == 0) return BigInteger.valueOf(1);
		return  BigInteger.valueOf(2).multiply(power(cnt-1));
	}
}
