import org.junit.Assert;
import org.junit.Test;

public class Tests {
  @Test
  public void testSolution() {
    String ip = "10.3.3.127";
    Assert.assertTrue(String.format("%s jest poprawnym adresem ip.", ip), Task.checkIp(ip));
  }

  @Test
  public void testSolution2() {
    String ip = "127.0.0.1";
    Assert.assertTrue(String.format("%s jest poprawnym adresem ip.", ip), Task.checkIp(ip));
  }

  @Test
  public void testSolution3() {
    String ip = "255.255.255.255";
    Assert.assertTrue(String.format("%s jest poprawnym adresem ip.", ip), Task.checkIp(ip));
  }

  @Test
  public void testSolution4() {
    String ip = "111.222.233.1";
    Assert.assertTrue(String.format("%s jest poprawnym adresem ip.", ip), Task.checkIp(ip));
  }

  @Test
  public void testSolution5() {
    String ip = "111.222.233.1.1";
    Assert.assertFalse(String.format("%s nie jest poprawnym adresem ip.", ip), Task.checkIp(ip));
  }

  @Test
  public void testSolution6() {
    String ip = "111.222.";
    Assert.assertFalse(String.format("%s nie jest poprawnym adresem ip.", ip), Task.checkIp(ip));
  }

  @Test
  public void testSolution7() {
    String ip = "111.";
    Assert.assertFalse(String.format("%s nie jest poprawnym adresem ip.", ip), Task.checkIp(ip));
  }

  @Test
  public void testSolution8() {
    String ip = "5555.1223.2122.42115";
    Assert.assertFalse(String.format("%s nie jest poprawnym adresem ip.", ip), Task.checkIp(ip));
  }

  @Test
  public void testSolution9() {
    String ip = "5";
    Assert.assertFalse(String.format("%s nie jest poprawnym adresem ip.", ip), Task.checkIp(ip));
  }


  @Test
  public void testSolution10() {
    String ip = "";
    Assert.assertFalse(String.format("Pusty string nie jest poprawnym adresem ip."), Task.checkIp(ip));
  }
}