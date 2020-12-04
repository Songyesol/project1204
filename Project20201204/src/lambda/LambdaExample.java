package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class LambdaExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("Hong", "MALE", 70), new Student("Kim", "FEMALE", 80),
				new Student("Song", "MALE", 85), new Student("Park", "FEMALE", 90));

		// 1. 여학생 정보 :이름 - 점수 list

		for (Student students : list) {
			if (students.getSex().equals("FEMALE")) {
				System.out.println(students.getName() + "-" + students.getScore());
			}
		}
		// 2. 전체학생: 점수가 80점 초과하는 학생 list
		for (Student students : list) {
			if (students.getScore() > 80) {
				System.out.println(
						"이름:" + students.getName() + ", 성별: " + students.getSex() + ", 점수: " + students.getScore());
			}
		}
		// 3. 남학생 총점 : 155
		int sum = 0;
		for (Student students : list) {
			if (students.getSex().equals("MALE")) {
				sum += students.getScore();
			}
		}
		System.out.println("남학생 총점: " + sum);

		// 4. 여학생 평균 : 85
		int sum2 = 0;
		int count = 0;
		double avg = 0;
		
		for (Student students : list) {
			if (students.getSex().equals("FEMALE")) {
				count++;
				sum2 += students.getScore();
			}
		}
		avg = sum2/count;
		System.out.println("여학생 평균: " + avg);
		System.out.println("============================================================");
		//반복문(반복자) : stream (반복자)
		//스트림 생성 -> 소진
		Stream<Student> stream = list.stream();
		stream.filter(new Predicate<Student>() { //조건을 만족하는 true값을 건져내고싶을때. filter사용 

			@Override
			public boolean test(Student t) {
				return t.getSex().equals("FEMALE");
			}
			
		}).forEach(new Consumer<Student>() {

			@Override
			public void accept(Student t) {
				System.out.println(t.getName()+"-"+ t.getScore());
			}
		
		});

		stream = list.stream();
		stream.filter((t)-> t.getScore()>80)
		.forEach((t)->System.out.println(t.getName()+"-"+t.getScore()));
			
		int sum1 = list.stream().filter(t->t.getSex().equals("MALE"))
		.mapToInt((Student value)-> value.getScore())
		.sum();
		System.out.println("남학생총합: " + sum1);
		double avg1 = list.stream().filter(t->t.getSex().equals("FEMALE"))
		.mapToInt(s->s.getScore())
		.average()
		.getAsDouble();
		System.out.println("평균:" + avg1);
		
	}
}
