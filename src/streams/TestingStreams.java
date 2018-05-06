package streams;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class TestingStreams {

	// Driver code
	// Driver code
	public static void main(String[] args) {

		// Creating an IntStream
		IntStream stream = IntStream.of(4, 5, 8, 10, 12, 16)
		// .parallel()
		;

		// Using IntStream findFirst().
		// Executing the source code multiple times
		// must return the same result.
		// Every time you will get the same
		// Integer which is divisible by 4.
		stream = stream.filter(num -> num % 4 == 0);

		OptionalInt answer = stream.findFirst();
		if (answer.isPresent())
			System.out.println(answer.getAsInt());
	}
}