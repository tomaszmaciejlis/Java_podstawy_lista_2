import org.junit.Assert;
import org.junit.Test;

public class Tests {
  @Test
  public void testSolution() {
    String email = "a@a.pl";

    Assert.assertTrue(String.format("%s to poprawny e-mail. Wynik powinien być true.", email), Task.checkEmail(email));
  }

  @Test
  public void testSolution2() {
    String email = "aty.aty@waty.a.pla";

    Assert.assertTrue(String.format("%s to poprawny e-mail. Wynik powinien być true.", email), Task.checkEmail(email));
  }

  @Test
  public void testSolution3() {
    String email = "a12.4#-a/s`d{s-?}a=e@watgsdsdg124fas.xom";

    Assert.assertTrue(String.format("%s to poprawny e-mail. Wynik powinien być true.", email), Task.checkEmail(email));
  }

  @Test
  public void testSolution4() {
    String email = "#hashTag-to-zło@facebook.tez";

    Assert.assertFalse(String.format("%s to poprawny e-mail. Wynik powinien być false.", email), Task.checkEmail(email));
  }

  @Test
  public void testSolution5() {
    String email = "a@.";

    Assert.assertFalse(String.format("%s to poprawny e-mail. Wynik powinien być false.", email), Task.checkEmail(email));
  }
}