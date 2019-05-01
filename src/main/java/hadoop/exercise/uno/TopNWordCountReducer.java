package hadoop.exercise.uno;

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
    System.out.printf("TopNWordCountReducer.reduce - iterable:%s \n", iterable);
    System.out.printf("TopNWordCountReducer.reduce - context:%s \n", context);

    int total = 0;

    for (IntWritable intWritable : iterable) {

      System.out.printf(
          "TopNWordCountReducer.reduce - intWritable:%s, intWritable.get():%s \n",
          intWritable, intWritable.get());
      total += intWritable.get();
    }

    // context.write(text, new IntWritable(total));
    map.put(text, new IntWritable(total));
  }

  @Override
  protected void cleanup(Reducer<Text, IntWritable, Text, IntWritable>.Context context)
      throws IOException, InterruptedException {

    Map<Text, IntWritable> localMap = MiscUtils.sortByValuesDesc(this.map);

    for (Text text : localMap.keySet()) {
      System.out.printf("text:%s, v:%s", text, localMap.get(text));
      context.write(text, localMap.get(text));
    }
    // super.cleanup(context);
  }
}
