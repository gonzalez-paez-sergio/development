package sets;

import java.util.Set;
import java.util.TreeSet;

public class TestingSortedSet {

  public static void main(String[] string) {

    Set<String> sortedSet = new TreeSet<String>((s1, s2) -> s2.compareTo(s1));

    sortedSet.add("aq1");
    sortedSet.add("aq2");
    sortedSet.add("aq3");
    sortedSet.add("aq4");
    sortedSet.add("aq1");
    sortedSet.add("aq9");
    sortedSet.add("aq8");
    sortedSet.add("aq6");

    // sortedSet.
    // sortedSet.add(null);

    System.out.println(sortedSet);
  }
}
