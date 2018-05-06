package hadoop.exercise;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TopNWordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	private Map<Text, IntWritable> map = new HashMap<Text, IntWritable>();

	@Override
	protected void reduce(

			Text text,

			Iterable<IntWritable> iterable,

			Reducer<Text, IntWritable, Text, IntWritable>.Context context)

			throws IOException, InterruptedException {

		System.out.printf("TopNWordCountReducer.reduce - text:%s \n", text);

		int total = 0;

		for (IntWritable intWritable : iterable) {

			System.out.printf("TopNWordCountReducer.reduce - intWritable:%s, intWritable.get():%s \n", intWritable,
					intWritable.get());
			
			total += intWritable.get();
		}

		map.put(text, new IntWritable(total));
		context.write(text, new IntWritable(total));
	}
}