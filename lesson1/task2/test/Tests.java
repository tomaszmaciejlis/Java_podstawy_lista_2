import org.junit.Assert;
import org.junit.Test;

public class Tests {

  @Test
  public void testSolution() {
    Assert.assertEquals("Wynik dla parametrów \"To w zdaniu o zdaniu jest mowa.\" i \"zdaniu\" to 19",
            19, Task.lengthSkipping("To w zdaniu o zdaniu jest mowa.", "zdaniu"));
  }

  @Test
  public void testSolution2() {
    Assert.assertEquals("Wynik dla parametrów \"zdania nie zmieniam o ile właśnie w zdaniu doszło do zmiany zdania\" i \"zdania\" to 52",
            52, Task.lengthSkipping("zdania nie zmieniam o ile właśnie w zdaniu doszło do zmiany zdania", "zdania"));
  }

  @Test
  public void testSolution3() {
    Assert.assertEquals("Wynik dla parametrów \"zdania nie zmieniam o ile właśnie w zdaniu doszło do zmiany zdania.\" i \"bzdura\" to 67. Nic nie powinno być usunięte więc wynikiem powinna być cała długość zdania",
            67, Task.lengthSkipping("zdania nie zmieniam o ile właśnie w zdaniu doszło do zmiany zdania.", "bzdura"));
  }

  @Test
  public void testSolution4() {
    Assert.assertEquals("Wynik dla parametrów \"\" i \"bzdura\" to 0. Zdanie puste nie może zostać zredukowane do czegoś dłuższego.",
            0, Task.lengthSkipping("", "bzdura"));
  }

  @Test
  public void testSolution5() {
    Assert.assertEquals("Należy pamiętać o operacji trim. Parametry \"  zadanie zadanie   \" zredukowane o \"zadanie\" powinno zostać skrócone do długości 0.",
            0, Task.lengthSkipping("  zadanie zadanie   ", "zadanie"));
  }
}