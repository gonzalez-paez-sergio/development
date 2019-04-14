package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountDuplicatesInArray {

	public static void main(String [] args){

		String [] strings = new String[]{"aba", "baba", "aba", "xzxb"};
		countOcurrences (strings) ;
	}

	public static Map<String, Long>    countOcurrences (String [] strings) {
		Map<String, Long> result = Arrays.stream(strings).collect(
			Collectors.groupingBy(
				Function.identity(), Collectors.counting()			
			)
		);
		System.out.println(result);
		return result;
	}
}
