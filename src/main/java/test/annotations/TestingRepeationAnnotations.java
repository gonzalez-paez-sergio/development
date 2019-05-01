package test.annotations;

public class TestingRepeationAnnotations {

  @Schedule(dayOfMonth = "last")
  @Schedule(dayOfWeek = "Fri", hour = "23")
  public void doPeriodicCleanup() {}
}
