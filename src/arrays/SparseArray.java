package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
	will indicate the number of ocurrences in strings for every string in queries
*/
public class SparseArray {

	public static void main(String [] args){

		String [] strings = new String[]{"aba", "baba", "aba", "xzxb"};
		String [] queries = new String[]{"aba", "xzxb", "ab"};
		matchingStrings (strings, queries) ;
	}

	// Complete the matchingStrings function below.
	static int[] matchingStrings(String[] strings, String[] queries) {

		List<String> listQueries = Arrays.asList(queries);
		Map<String,Integer> result = Arrays.stream(strings)
		.filter(item-> listQueries.contains(item))
		.collect(
		Collectors.groupingBy(
		Function.identity(),Collectors.summingInt(x->1)
		)
		);

		System.out.println(result);
		int arr[] = new int[queries.length];
		for (int i =0; i < queries.length; i++){
			arr[i] = result.get(queries[i]) == null?0:result.get(queries[i]);
		}

		return arr;
	}
}
