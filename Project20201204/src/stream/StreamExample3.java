package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

import lambda.Student;

public class StreamExample3 {
	public static void main(String[] args) {

		String[] strs = "Java-Lambda-Hello".split("-");

		List<String> strList = Arrays.asList("Java8 lambda", "stream mapping");
		strList.stream().flatMap((t) -> Arrays.stream(t.split(" ")))
//	.filter(s ->s.startsWith("J"))
				.forEach(s -> System.out.println(s));

		strList.stream().map(new Function<String, String>() {

			@Override
			public String apply(String t) {
				return t.toUpperCase();
			}

		}).forEach(s -> System.out.println(s));

	
		List<Student> students = Arrays.asList(
				new Student("홍길동", "M", 75),
				new Student("오리부용", "F", 85),
				new Student("박달", "M",60),
				new Student("송실이","F", 70));
	
		double studentAvg = students.stream()
		.mapToInt(new ToIntFunction<Student>() {

			@Override
			public int applyAsInt(Student s) {
				System.out.println(s.getName()+"/"+s.getScore());
				return s.getScore();
			}
			
		}).average().getAsDouble();
		System.out.println(studentAvg);
		
		
	}
}
