package lambda;

import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import hashes.Entry;

public class CountingWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method();
	}

	public static void method() {
		Stream<String> stream;
		try {
			stream = Files.lines(Paths.get("/home/sergiogp/eclipse-workspace/Test/src/lambda/hitch2.txt"));

			Map<String, Long> o = stream.flatMap(s -> Arrays.stream(s.split("[,. \"]")))
					//
					.filter(s -> s.trim().length() > 3)
					//
					.map(s -> new Entry<>(s, 1))
					//
					.collect(

							Collectors.groupingBy(Entry::getKey, Collectors.counting())

			);

			// System.out.println(o);
			Stream<Map.Entry<String, Long>> result = o.entrySet().stream()
					.sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
			
			Map.Entry<String, Long> entry = result.findFirst().get();

			System.out.println(entry);

			System.out.println();

			stream = Files.lines(Paths.get("/home/sergiogp/eclipse-workspace/Test/src/lambda/hitch2.txt"));

			o = stream.flatMap(s -> Arrays.stream(s.split("[,. \"]")))
					//
					.filter(s -> s.trim().length() > 3)
					//
					.map(s -> new Entry<>(s, 1)).
					//
					reduce(

							new HashMap<String, Long>(),

							(accumulator, e) -> {

								accumulator.put(e.getKey(), accumulator.get(

										e.getKey()) == null ? 1 : accumulator.get(e.getKey()) + 1);

								return accumulator;
							},

							(p1, p2) -> p1);

			// System.out.println(o);
			result = o.entrySet().stream().sorted(

					(o1, o2) -> o2.getValue().compareTo(o1.getValue())

			);

			entry = result.findFirst().get();

			System.out.println(entry);

			/// lets find the maximum letter used, using chars
			stream = Files.lines(Paths.get("/home/sergiogp/eclipse-workspace/Test/src/lambda/hitch2.txt"));

			Map<Character, Integer> map = new HashMap<Character, Integer>();

			stream

					.flatMap(s -> CharBuffer.wrap(s.toCharArray()).chars().mapToObj(ch -> (char) ch))
					.filter(c -> c.compareTo(' ') > 0).forEach(c -> {
						map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
					});

			// System.out.println(map);

			Object f = map.entrySet().stream().sorted(

					// (o1, o2) -> o2.getValue().compareTo(o1.getValue())
					Comparator.comparing(Map.Entry<Character, Integer>::getValue).reversed()

			).findFirst();

			System.out.println(f);

			/// lets find the maximum letter used, using chars and collect method
			stream = Files.lines(Paths.get("/home/sergiogp/eclipse-workspace/Test/src/lambda/hitch2.txt"));

			Map<Character, Long> ooo = stream
					.flatMap(s -> CharBuffer.wrap(s.toCharArray()).chars().mapToObj(ch -> (char) ch))
					.filter(c -> c.compareTo(' ') > 1

					).map(c -> new Entry<Character, Integer>(c, 1))

					.collect(Collectors.groupingBy((Entry<Character, Integer> e) -> {
						return e.getKey();
					}, Collectors.counting()));

			// System.out.println("/");
			// System.out.println(ooo);

			Object o1 = ooo.entrySet().stream().sorted(Comparator.comparing(Map.Entry<Character, Long>::getKey))
					.findFirst();
			;
			// ooo.
			// ooo.

			// System.out.println("/");
			System.out.println(o1.toString());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
