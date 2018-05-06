package hadoop.exercise.uno;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

public class MiscUtils {

	static Map<Text, IntWritable> sortByValuesDesc(Map<Text, IntWritable> map) {

		List<Map.Entry<Text, IntWritable>> entries = new LinkedList<Map.Entry<Text, IntWritable>>(map.entrySet());

		Collections.sort(entries, new Comparator<Map.Entry<Text, IntWritable>>() {

			@Override
			public int compare(Map.Entry<Text, IntWritable> o1, Map.Entry<Text, IntWritable> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		Map<Text, IntWritable> sortedMap = new LinkedHashMap<Text, IntWritable>();

		for (Map.Entry<Text, IntWritable> entry : entries) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}
}
