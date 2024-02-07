public class recursive {
  static int count = 0;
	public static void main(String[] args) {
		  int result = factorial(10);
	    System.out.println(result);
		}

	}
  public static int factorial(int n) {
	if (n <= 1)
		return 1;
	System.out.println(count++);

	return n * factorial(n - 1);
  }
	public static boolean isFull() {
		// 데이터가 추가로 들어갈 수 있는지 확인 -> rear확인
		return rear == queue.length - 1;
	}

	public static int fibo(int N) {
		if (N <= 1)
			return N;
		return fibo(N - 1) + fibo(N - 2);
	}
}
