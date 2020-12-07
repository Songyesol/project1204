package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;

public class ReduceExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(//
				new Student("Hong", 80),//
				new Student("Song", 90),//
				new Student("Kim", 87)//
				);
		
		int sum = list.stream().mapToInt(value-> value.getScore()).sum();
		System.out.println(sum);
		
		//reduce
		//초기값 지정 X
		int sum2 = list.stream().mapToInt(t -> t.getScore())
		.reduce(new IntBinaryOperator() {

			@Override
			public int applyAsInt(int a, int b) {
				System.out.println("left: " + a + ", right: " + b);
				return a+b;
			}
			
		}).getAsInt();
		System.out.println("결과값: " + sum2);
		
		//reduce
		//초기값 지정 O
		int sum3 = list.stream()
				.mapToInt(t-> t.getScore())
				.reduce(0,(left, right)-> left + right);
		System.out.println(sum3);
		
		
		//reduce 최대값
		int sum4 = list.stream()
				.mapToInt(t-> t.getScore())
				.reduce(0,(left, right)-> left > right ? left : right);
		System.out.println("최대값: " + sum4);
		
		
		//reduce 최소값
		int sum5 = list.stream()
				.mapToInt(t-> t.getScore())
				.reduce((left, right)-> left < right ? left : right)
				.getAsInt();
		System.out.println("최소값: " + sum5);
		
		
		//reduce 평균 
		int avg = list.stream()
		.mapToInt(s->s.getScore())
		.reduce((left,right)-> (left + right)/2)
		.getAsInt();
		System.out.println("평균값: " + (double)avg);
		
		
		
	}
}
