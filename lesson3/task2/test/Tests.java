import org.junit.Assert;
import org.junit.Test;

public class Tests {
  @Test
  public void testSolution() {
    Assert.assertEquals("Wynik dla `1 3 15 23 1 4 0 32 4 12 5 95 2 39` powinien wynieść 28.", 28, Task.sum(new int[]{1, 3, 15, 23, 1, 4, 0, 32, 4, 12, 5, 95, 2, 39}));
  }
}