package hadoop.exercise;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TopNWordCountMapper extends Mapper<Object, Text, Text, IntWritable> {

  private static final IntWritable intWritable = new IntWritable(1);

  private Text text = new Text();

  @Override
  protected void map(
      Object key, Text value, Mapper<Object, Text, Text, IntWritable>.Context context)
      throws IOException, InterruptedException {

    System.out.printf("TopNWordCountMapper.map.static.intWritable:%s \n", intWritable);
    System.out.printf("TopNWordCountMapper.map.static.text:%s \n", text);

    System.out.printf("TopNWordCountMapper.map.key:%s \n", key);
    System.out.printf("TopNWordCountMapper.map.value:%s \n", value.toString());
    System.out.printf("TopNWordCountMapper.map.context:%s \n", context);

    // StringTokenizer stringTokenizer = new StringTokenizer(value.toString());
    char[] simpleArray = value.toString().toCharArray();

    // while (stringTokenizer.hasMoreTokens()) {
    for (char c : simpleArray) {
      // String string = stringTokenizer.nextToken();
      // System.out.printf("TopNWordCountMapper.map tokens%s, ", string);
      text.set(String.valueOf(c));
      // text.set(string);
      context.write(text, intWritable);
    }

    System.out.println();
  }
}
