package hashes;

public class OverrideHashcodeAndEqualsTheOldWay {
  private String name;
  private int age;
  private String passport;

  // getters and setters, constructor

  @Override
  public boolean equals(Object o) {

    if (o == this) return true;
    if (!(o instanceof OverrideHashcodeAndEqualsTheOldWay)) {
      return false;
    }

    OverrideHashcodeAndEqualsTheOldWay user = (OverrideHashcodeAndEqualsTheOldWay) o;

    return user.name.equals(name) && user.age == age && user.passport.equals(passport);
  }

  // Idea from effective Java : Item 9
  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + name.hashCode();
    result = 31 * result + age;
    result = 31 * result + passport.hashCode();
    return result;
  }
}
