package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(//
				new Student("Hong", 80), //
				new Student("Song", 90), //
				new Student("Kim", 87)//
		);

		List<Student> student80s = list.stream().filter(t -> t.getScore() / 10 == 8).sorted()
				.collect(Collectors.toList()); // collector 클래스에 이미 만들어져있는 메소드 사용

		for (Student student : student80s) {
			System.out.println("학생이름: " + student.getName() + ", 점수: " + student.getScore());
		}
//		.forEach(System.out::println); //toString 

		Map<String, Integer> map = list.stream().filter(t -> t.getScore() / 10 == 8).sorted().collect(//
				Collectors.toMap((t) -> t.getName(), 
								 (t) -> t.getScore())
								);
		Set<String> set = map.keySet();
		for(String key : set) {
			System.out.println("key: " + key + ", value: " + map.get(key));
		}
	}
}
