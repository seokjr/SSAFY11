import java.util.Comparator;
import java.util.PriorityQueue;

class Person implements Comparable<Person>{
	String name;
	int age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	@Override
	public int compareTo(Person o) {
		if (this.age == o.age) {
			return this.name.compareTo(o.name);
		} 
		return this.age - o.age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}

public class priority_queue {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return b - a;
				// -1 바꾸지 않음
				// 0 같은 값으로 판단
				// 1 자리를 바꾼다.
//				if (a < b) {
//					return 1;
//				} else if (a == b) {
//					return 0;
//				} 
//				return -1;
			}
		});
		pq.add(12);
		pq.add(23);
		pq.add(5532);
		pq.add(558);
		pq.offer(73);

		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		// 익명 클래스를 넣어도 어차피 들어갈 수 있는게 comparator 밖에 없는 걸 알고 이렇게 하는 것
		PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> {
			return b - a;
		});
		PriorityQueue<Person> pq3 = new PriorityQueue<>();
		pq3.add(new Person("대전 3반 김수아", 25));
		pq3.add(new Person("대전 3반 정다운", 29));
		pq3.add(new Person("대전 3반 석재륜", 28));
		pq3.add(new Person("대전 3반 권지인", 27));
		pq3.add(new Person("대전 3반 이상휘", 30));
		// 1. Comparator PQ 생성자에 넣어준다(람다식)
		// 2. Person이 Comparable 인터페이스를 구현
		System.out.println(pq3.poll());
		System.out.println(pq3.poll());
		System.out.println(pq3.poll());
		System.out.println(pq3.poll());
		System.out.println(pq3.poll());
		
	}
}
