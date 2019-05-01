package hashes;

import java.util.Objects;

public class OverrideHashcodeAndEquals {
  private String name;
  private int age;
  private String passport;

  // getters and setters, constructor

  @Override
  public boolean equals(Object o) {

    if (o == this) return true;
    if (!(o instanceof OverrideHashcodeAndEquals)) {
      return false;
    }
    OverrideHashcodeAndEquals user = (OverrideHashcodeAndEquals) o;
    return age == user.age
        && Objects.equals(name, user.name)
        && Objects.equals(passport, user.passport);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age, passport);
  }
}
