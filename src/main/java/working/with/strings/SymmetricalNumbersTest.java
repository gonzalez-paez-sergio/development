package working.with.strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class SymmetricalNumbersTest {

  @Test
  public void testSymmetricalNumber() {
    StringBuffer stringLine = new StringBuffer("234432");
    assertEquals("235532", SymmetricalNumbers.findNextSymmetricalNumber(stringLine));
  }

  @Test
  public void testDescendingNumberWithEvenNumberOfDigits() {
    StringBuffer stringLine = new StringBuffer("654321");
    assertEquals("654456", SymmetricalNumbers.findNextSymmetricalNumber(stringLine));
  }

  @Test
  public void testDescendingNumberWithOddNumberOfDigitsCase1() {
    StringBuffer stringLine = new StringBuffer("6543210");
    assertEquals("6543456", SymmetricalNumbers.findNextSymmetricalNumber(stringLine));
  }

  @Test
  public void testDescendingNumberWithOddNumberOfDigitsCase2() {
    StringBuffer stringLine = new StringBuffer("6543450");
    assertEquals("6543456", SymmetricalNumbers.findNextSymmetricalNumber(stringLine));
  }

  @Test
  public void testNonSymetricalNumberWithEvenNumberOfDigits() {
    StringBuffer stringLine = new StringBuffer("1211");
    assertEquals("1221", SymmetricalNumbers.findNextSymmetricalNumber(stringLine));
  }

  @Test
  public void testNonSymetricalNumberWithOddNumberOfDigits() {
    StringBuffer stringLine = new StringBuffer("12111");
    assertEquals("12121", SymmetricalNumbers.findNextSymmetricalNumber(stringLine));
  }

  @Test
  public void testNonSymetricalNumberWithOddNumberOfDigitsWNine() {
    StringBuffer stringLine = new StringBuffer("12911");
    assertEquals("12921", SymmetricalNumbers.findNextSymmetricalNumber(stringLine));
  }
}
