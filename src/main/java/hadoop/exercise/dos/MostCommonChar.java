package hadoop.exercise.dos;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

/**
 * basic implementation to get the most common char in a file
 *
 * @author sergiogp
 */
public class MostCommonChar {

  public static void main(String[] args) throws Exception {
    Configuration configuration = new Configuration();
    String[] otherArgs = new GenericOptionsParser(configuration, args).getRemainingArgs();
    if (otherArgs.length != 2) {
      System.err.println("Usage: MostCommonChar <in> <out>");
      System.exit(2);
    }
    Job job = Job.getInstance(configuration);
    job.setJobName("MostCommonChar");
    job.setJarByClass(MostCommonChar.class);
    job.setMapperClass(MostCommonCharMapper.class);
    job.setReducerClass(MostCommonCharReducer.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
    FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }

  /** */
  public static class MostCommonCharMapper extends Mapper<Object, Text, Text, IntWritable> {

    private final IntWritable intWritable = new IntWritable(1);
    private final Text text = new Text();

    /** s */
    @Override
    protected void map(
        Object key, Text value, Mapper<Object, Text, Text, IntWritable>.Context context)
        throws IOException, InterruptedException {
      /*
       * we replace the space char in the current line, in all the tests the most
       * common char was the space char
       */
      char[] charArray = value.toString().replaceAll("[ ]", "").toCharArray();

      for (char c : charArray) {
        text.set(String.valueOf(c));
        context.write(text, intWritable);
      }
    }
  }

  /** */
  public static class MostCommonCharReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    private Map<Text, IntWritable> countMap = new HashMap<Text, IntWritable>();

    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context)
        throws IOException, InterruptedException {

      // computes the number of occurrences of a single char
      int total = 0;
      for (IntWritable val : values) {
        total += val.get();
      }

      countMap.put(new Text(key), new IntWritable(total));
    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {

      Map<Text, IntWritable> sortedMap = sortByValuesDesc(countMap);

      for (Text key : sortedMap.keySet()) {
        context.write(key, sortedMap.get(key));
        break;
      }
    }

    private Map<Text, IntWritable> sortByValuesDesc(Map<Text, IntWritable> map) {

      List<Map.Entry<Text, IntWritable>> entries =
          new LinkedList<Map.Entry<Text, IntWritable>>(map.entrySet());

      Collections.sort(
          entries,
          new Comparator<Map.Entry<Text, IntWritable>>() {

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
}
