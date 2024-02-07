package temp_list;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person {
	String name;
	int cnt;

	Person(String name, int cnt) {
		this.name = name;
		this.cnt = cnt;
	}
}

public class 마이쮸 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Person> queue = new LinkedList<>();

		// 마이쮸 개수
		int N = 20;
		// 몇 번째 사람인가.
		int pNum = 1;
		queue.offer(new Person(sc.next(), 1));
		// 마이쮸가 남아있을 때 까지만
		while (N > 0) {
			// 비어있지 않다면
			if (!queue.isEmpty()) {
				Person p = queue.poll();
				N -= p.cnt;
				if (N <= 0) {
					System.out.println(p.name + "님이 마지막 마이쮸를 가져갔습니다.");
					break;
				} else {
					System.out.println(p.name + "님이 " + p.cnt + "개를 가져갔습니다.");
					p.cnt++;
					System.out.println("남은 마이쮸" + N + "개");
					queue.offer(p);
					queue.offer(new Person(sc.next(), 1));
				}
			}
		}
	}
}
