import org.junit.Assert;
import org.junit.Test;

public class Tests {
  @Test
  public void testSolution() {
      String sentence = "To jest poprawne zdanie.";

      Assert.assertEquals(String.format("Poprawne jest zdanie: %s", sentence), true, Task.isValid(sentence));
  }

    @Test
    public void testSolution2() {
        String sentence = "Rozkaz to poprawne zdanie!";

        Assert.assertEquals(String.format("Poprawne jest zdanie: %s", sentence), true, Task.isValid(sentence));
    }

    @Test
    public void testSolution3() {
        String sentence = "Pytanie czy zdanie jest poprawne zdanie?";

        Assert.assertEquals(String.format("Poprawne jest zdanie: %s", sentence), true, Task.isValid(sentence));
    }

    @Test
    public void testSolution4() {
        String sentence = "To jest poprawne zdanie, nawet tak na 5.";

        Assert.assertEquals(String.format("Poprawne jest zdanie: %s", sentence), true, Task.isValid(sentence));
    }

    @Test
    public void testSolution5() {
        String sentence = "Nie jest zdaniem coś co kończy się na ,";

        Assert.assertEquals(String.format("Poprawne jest zdanie: %s", sentence), false, Task.isValid(sentence));
    }

    @Test
    public void testSolution6() {
        String sentence = "Nie jest zdaniem coś co kończy się na #";

        Assert.assertEquals(String.format("Poprawne jest zdanie: %s", sentence), false, Task.isValid(sentence));
    }

    @Test
    public void testSolution7() {
        String sentence = "nie jest zdaniem coś co nie zaczyna się z małej litery";

        Assert.assertEquals(String.format("Poprawne jest zdanie: %s", sentence), false, Task.isValid(sentence));
    }
}