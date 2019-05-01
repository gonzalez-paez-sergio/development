import java.util.Scanner;
import search.BinarySearchST;

public class FrequencyCounter {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int minlen = scanner.nextInt(); // key-length cutoff
    BinarySearchST<String, Integer> st = new BinarySearchST(100);
    // for(int i = 0; i <= 10; i++){
    while (scanner.hasNextLine()) {
      String word = scanner.nextLine();
      if (word.length() < minlen) continue; // Ignore short keys.
      if (!st.contains(word)) {
        System.out.printf("not contains %s\n", word);
        st.put(word, 1);
      } else {
        System.out.printf("word %s, current %d\n", word, st.get(word));
        st.put(word, st.get(word) + 1);
      }
    }
    // Find a key with the highest frequency count.
    String max = "";
    st.put(max, 0);
    for (String word : st.keys()) {
      System.out.printf("word %s\n", word);
      if (st.get(word) > st.get(max)) {
        max = word;
      }
    }
    System.out.println(max + " - " + st.get(max));
  }
}
