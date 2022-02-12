import org.hamcrest.core.StringContains;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Random;

import static org.junit.Assert.assertThat;

public class Tests {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;
  private final InputStream originalIn = System.in;

  private static final Locale LOCALE = new Locale("pl-PL");
  private Locale systemLocale;

  @Before
  public void setUpStreams() {
    systemLocale = Locale.getDefault();
    Locale.setDefault(LOCALE);
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  @After
  public void restoreStreams() {
    Locale.setDefault(systemLocale);
    System.setOut(originalOut);
    System.setErr(originalErr);
    System.setIn(originalIn);
  }

  @Test
  public void testSolution() {
    for (String name : new String[]{"Adam", "Agata", "Aleksandra", "Andżelika", "Grzegorz", "Justyna", "Kamil", "Kamila", "Marek", "Mateusz", "Rafał", "Patryk", "Paula", "Piotr", "Przemysław", "Tomasz", "Wojciech"}) {
      String age = String.valueOf(Math.abs(new Random().nextInt()) % 82 + 18);
      String email = name.toLowerCase(LOCALE) + "@sda.pl";
      Task.main(new String[]{name, age, email});
      assertThat(String.format("Dla parametrów %s %s %s powinno być powitanie.",
                      name, age, email),
              outContent.toString(),
              StringContains.containsString("Witamy"));
    }
  }

  @Test
  public void testSolution2() {
    for (String name : new String[]{"Adam", "Agata", "Aleksandra", "Andżelika", "Grzegorz", "Justyna", "Kamil", "Kamila", "Marek", "Mateusz", "Rafał", "Patryk", "Paula", "Piotr", "Przemysław", "Tomasz", "Wojciech"}) {
      String age = String.valueOf(Math.abs(new Random().nextInt()) % 82 + 18);
      String email = name.toLowerCase(LOCALE) + "@1";
      Task.main(new String[]{name, age, email});
      assertThat(String.format("Dla parametrów %s %s %s powinien być błąd w 2 parametrze.",
                      name, age, email),
              outContent.toString(),
              StringContains.containsString("w parametrze 2"));
    }
  }

  @Test
  public void testSolution3() {
    for (String name : new String[]{"Regina", "Janusz", "Zyta", "Roman"}) {
      String age = String.valueOf(Math.abs(new Random().nextInt()) % 82 + 18);
      String email = name.toLowerCase(LOCALE) + "@sda.pl";
      Task.main(new String[]{name, age, email});
      assertThat(String.format("Dla parametrów %s %s %s powinien być błąd w 0 parametrze.",
                      name, age, email),
              outContent.toString(),
              StringContains.containsString("w parametrze 0"));
    }
  }

  @Test
  public void testSolution4() {
    for (String name : new String[]{"Adam", "Agata", "Aleksandra", "Andżelika", "Grzegorz", "Justyna", "Kamil", "Kamila", "Marek", "Mateusz", "Rafał", "Patryk", "Paula", "Piotr", "Przemysław", "Tomasz", "Wojciech"}) {
      String age = String.valueOf(Math.abs(new Random().nextInt()) % 82 + 18);
      Task.main(new String[]{name, age});
      assertThat(String.format("Dla parametrów %s %s powinien być błąd ilości parametrów.",
                      name, age),
              outContent.toString(),
              StringContains.containsString("3 parametry"));
    }
  }

  @Test
  public void testSolution5() {
    for (String name : new String[]{"Adam", "Agata", "Aleksandra", "Andżelika", "Grzegorz", "Justyna", "Kamil", "Kamila", "Marek", "Mateusz", "Rafał", "Patryk", "Paula", "Piotr", "Przemysław", "Tomasz", "Wojciech"}) {
      Task.main(new String[]{name});
      assertThat(String.format("Dla parametrów %s powinien być błąd ilości parametrów.",
                      name),
              outContent.toString(),
              StringContains.containsString("3 parametry"));
    }
  }

  @Test
  public void testSolution6() {
    for (String name : new String[]{"Adam", "Agata", "Aleksandra", "Andżelika", "Grzegorz", "Justyna", "Kamil", "Kamila", "Marek", "Mateusz", "Rafał", "Patryk", "Paula", "Piotr", "Przemysław", "Tomasz", "Wojciech"}) {
      String email = name.toLowerCase(LOCALE) + "@sda.pl";
      Task.main(new String[]{name, email});
      assertThat(String.format("Dla parametrów %s powinien być błąd ilości parametrów.",
                      name, email),
              outContent.toString(),
              StringContains.containsString("3 parametry"));
    }
  }

  @Test
  public void testSolution7() {
    for (String name : new String[]{"Adam", "Agata", "Aleksandra", "Andżelika", "Grzegorz", "Justyna", "Kamil", "Kamila", "Marek", "Mateusz", "Rafał", "Patryk", "Paula", "Piotr", "Przemysław", "Tomasz", "Wojciech"}) {
      String age = String.valueOf(Math.abs(new Random().nextInt()) % 82 + 18);
      String email = name.toLowerCase(LOCALE) + "@sda.pl";
      Task.main(new String[]{email, age, name});
      assertThat(String.format("Dla parametrów %s %s %s powinien być błąd parametru 0.",
                      name, age, email),
              outContent.toString(),
              StringContains.containsString("parametrze 0"));
    }
  }

  @Test
  public void testSolution8() {
    for (String name : new String[]{"Adam", "Agata", "Aleksandra", "Andżelika", "Grzegorz", "Justyna", "Kamil", "Kamila", "Marek", "Mateusz", "Rafał", "Patryk", "Paula", "Piotr", "Przemysław", "Tomasz", "Wojciech"}) {
      String age = String.valueOf(Math.abs(new Random().nextInt()) % 82 + 18);
      String email = name.toLowerCase(LOCALE) + "@sda.pl";
      Task.main(new String[]{name, email, age});
      assertThat(String.format("Dla parametrów %s %s %s powinien być błąd parametru 1.",
                      name, age, email),
              outContent.toString(),
              StringContains.containsString("parametrze 1"));
    }
  }
}