
public class 분할정복02_거듭제곱_재귀 {
	public static void main(String[] args) {
		int C = 2;
		int N = 11;
		
		System.out.println(pow(C, N));
		System.out.println(pow2(C, N));
		System.out.println(pow3(C, N));
		
	}
	public static int pow(int C, int N) {
		if (N==1)
			return C;
		// 재귀 부분 : 짝수일 때와 아닐 때를 나누어서 생각하겠다.
		if (N % 2 == 0) {
			return pow(C, N/2) * pow(C, N/2);
		} else {
			return pow(C, (N-1)/2) * pow(C, (N-1)/2) * C;
		}
	}
	public static int pow2(int C, int N) {
		if (N==1)
			return C;
		// 재귀 부분 : 짝수일 때와 아닐 때를 나누어서 생각하겠다.
		int tmp;
		if (N % 2 == 0) {
			tmp = pow(C, N/2);
			return tmp * tmp;
		} else {
			tmp =pow(C, (N-1)/2);
			return tmp * tmp * C;
		}
	}
	public static int pow3(int C, int N) {
		if (N==1)
			return C;
		// 재귀 부분 : 짝수일 때와 아닐 때를 나누어서 생각하겠다.
		int tmp = pow(C, N/2);
		if (N % 2 == 0) {
			return tmp * tmp;
		} else {
			return tmp * tmp * C;
		}
	}
}
