package stream;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class StreamExample2 {
	public static void main(String[] args) {
		
		
		//1~100까지 숫자 가져오기 
		IntStream stream = IntStream.rangeClosed(1, 100);
		stream.forEach(value->System.out.println("1~100: " + value));
		
		
		System.out.println("================================");
		
		//짝수만 결과를 출력...
		IntStream stream1 = IntStream.rangeClosed(1, 100);
		stream1.filter(value-> value%2==0)
		.forEach(value-> System.out.println("짝수출력: " + value));
			
		int sum = IntStream.rangeClosed(1, 100)
		.filter(value-> value%2==0)
		.sum();
		System.out.println("짝수의 합계: " + sum);
		
		int[] intAry = {2,6,4,8,1,9};
		IntStream is = Arrays.stream(intAry);
		int min = is.min().getAsInt(); 
		System.out.println("배열의 최소값:" +  min);
//		OptionalInt max = is.max();
//		System.out.println(max);
//		System.out.println("배열의 최대값: " + max.getAsInt());
		
		is = Arrays.stream(intAry);
		double avg = is.average().getAsDouble();
		System.out.println("intAry의 평균값: " + avg);
		
		
		//조건(filter)
		is = Arrays.stream(intAry);
		int sum1=Arrays.stream(intAry).filter((int a) -> a%2==1)		
		.sum();
		System.out.println("홀수의 합: " + sum1);
	}
	
	
	
	
}
