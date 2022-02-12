import org.hamcrest.CoreMatchers;
import org.hamcrest.core.StringContains;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
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
    String inputText = "Wanda wiedziała o wieściach od Wiesława.\nw";
    System.setIn(new ByteArrayInputStream(inputText.getBytes()));

    Task.main(new String[]{});

    assertThat("Oczekujemy w wyniku liczbę 6", outContent.toString(),
            StringContains.containsString("6"));
    assertThat("Oczekujemy w wyniku liczbę 18", outContent.toString(),
            StringContains.containsString("18"));
    assertThat("Oczekujemy w wyniku liczbę 37", outContent.toString(),
            StringContains.containsString("37"));
            //89.6, Double.parseDouble(outContent.toString().trim()), 0.1);
  }

  @Test
  public void testSolution2() {
    String inputText = "Wanda wiedziała o wieściach od Wiesława.\nW";
    System.setIn(new ByteArrayInputStream(inputText.getBytes()));

    Task.main(new String[]{});

    assertThat("Oczekujemy w wyniku liczbę 0", outContent.toString(),
            StringContains.containsString("0"));
    assertThat("Oczekujemy w wyniku liczbę 31", outContent.toString(),
            StringContains.containsString("31"));
  }

  @Test
  public void testSolution3() {
    String inputText = "12345678901\n1";
    System.setIn(new ByteArrayInputStream(inputText.getBytes()));

    Task.main(new String[]{});

    assertThat("Oczekujemy w wyniku liczbę 0", outContent.toString(),
            StringContains.containsString("0"));
    assertThat("Oczekujemy w wyniku liczbę 10", outContent.toString(),
            StringContains.containsString("10"));
  }

  @Test
  public void testSolution4() {
    String inputText = "AAAAaaaCCCC\nb";
    System.setIn(new ByteArrayInputStream(inputText.getBytes()));

    Task.main(new String[]{});
    for (int i = 0; i < inputText.length(); i++) {
      assertThat(String.format("Dla wejścia na indexie %d to %c a nie 'c'. Szukamy 'c'.", i, inputText.charAt(i)), outContent.toString(),
              CoreMatchers.not(StringContains.containsString(String.valueOf(i))));
    }
  }
}