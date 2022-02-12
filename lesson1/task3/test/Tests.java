import org.junit.Assert;
import org.junit.Test;

public class Tests {
  @Test
  public void testSolution() {
      String code = "main(String... args) {\n" +
              "     // komentarz\n" +
              "     int a = 0;\n" +
              "     if (a > 0) { }\n" +
              "     else {\n" +
              "     }\n" +
              "}";

      Assert.assertEquals(String.format("Poprawny jest następujący kod: %s", code), true, Task.isValid(code));
  }

  @Test
  public void testSolution2() {
    String code = "main(String... args) {\n" +
            "     // komentarz\n" +
            "     int a = 0;\n" +
            "     if (a > 0) { }\n" +
            "     else {\n" +
            "     }}\n" +
            "}";

    Assert.assertEquals(String.format("Niepoprawny jest następujący kod: %s", code), false, Task.isValid(code));
  }

  @Test
  public void testSolution3() {
    String code = "main(String... args) {" +
            "     int a = 0;" +
            "     if (a > 0) { }" +
            "     else {" +
            "     }" +
            "}";

    Assert.assertEquals(String.format("Poprawny jest następujący kod: %s", code), true, Task.isValid(code));
  }

  @Test
  public void testSolution4() {
    String code = "main(String... args) {" +
            "     // komentarz" +
            "     int a = 0;" +
            "     if (a > 0)  }" +
            "     else {"
           ;

    Assert.assertEquals(String.format("Niepoprawny jest następujący kod: %s", code), false, Task.isValid(code));
  }

  @Test
  public void testSolution5() {
    String code = "[]{";

    Assert.assertEquals(String.format("Niepoprawny jest następujący kod: %s", code), false, Task.isValid(code));
  }

  @Test
  public void testSolution6() {
    String code = "[]{}";

    Assert.assertEquals(String.format("Poprawny jest następujący kod: %s", code), true, Task.isValid(code));
  }

  @Test
  public void testSolution7() {
    String code = "";

    Assert.assertEquals("Poprawny jest następujący pusty kod", false, Task.isValid(code));
  }
}