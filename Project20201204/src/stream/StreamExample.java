package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
	
		//스트림 만드는 순서!! 
		// 1.스트림을 만들려면 컬렉션이나 배열로부터 스트림을 생성해야한다.

		List<String> list = null;
		list = Arrays.asList("Hong", "Hwang", "Park", "Choi", "Kim");

		// 2. 문자열을 담고 있는 스트림선언
		Stream<String> stream = list.stream(); //

		// 3. 중간처리메소드
		// boolean타입을 반환하는 predicate 인터페이스 호출
		stream.filter((t) -> t.length() > 3)

				/* 4. 최종처리메서드 */
				.forEach((t) -> System.out.println(t));
		
		
		
		
		System.out.println();
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		// BaseStream ->Stream<T>, IntStream, LongStream, DoubleStream
		// IntStream :Stream<Integer> =>실제 데이터 타입이 int형
		// LongStream : Stream<Long> =>long형 데이터타입, DoubleStream =>실제 데이터가 double타입

		
		
		// Stream 타입의 배열
		String[] strAry = { "Hong", "Hwang", "Park" };
		Stream<String> strStream = Arrays.stream(strAry);

		int[] intAry = { 1, 2, 3, 4, 5 };
		IntStream intStream = Arrays.stream(intAry);
		int sum = intStream.sum();
		System.out.println("합계: " + sum);

		double[] dbAry = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		DoubleStream dbStream = Arrays.stream(dbAry);
		dbStream.forEach(new DoubleConsumer() {
			double result = 0;

			@Override
			public void accept(double value) {
				result += value;
				System.out.println(result);
			}

		});
		
		//숫자의 범위를 통해서 만드는 Stream
		IntStream is = IntStream.range(1, 10); // 1~9까지 담겨있는 stream
		is.forEach(n-> System.out.println(n));
		
		is=IntStream.rangeClosed(1, 10); //1~10까지
		System.out.println("합: " + is.sum());
		
		
		//file정보를 통해서 만드는 Stream
		Path path = Paths.get("list.txt");
		try {
			Stream<String> stream1 = Files.lines(path);
			stream1.forEach(s->System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
