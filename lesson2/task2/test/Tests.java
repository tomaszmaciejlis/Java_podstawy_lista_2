import org.junit.Assert;
import org.junit.Test;

public class Tests {
    @Test
    public void testSolution() {
        String sentence = "Janusz to jest fajny gość.";
        String name = "Janusz";

        Assert.assertEquals("Janusz jest częścią zdania ale na jego początku. Wynik powinien być false.",
                false, Task.containsName(sentence, name));
    }

    @Test
    public void testSolution2() {
        String sentence = "Gościem fajnym jest Janusz.";
        String name = "Janusz";

        Assert.assertEquals("Janusz jest częścią zdania ale na jego końcu. Wynik powinien być false.",
                false, Task.containsName(sentence, name));
    }

    @Test
    public void testSolution3() {
        String sentence = "Gościem fajnym jest Roman.";
        String name = "Janusz";

        Assert.assertEquals("Janusz nie jest częścią zdania. Wynik powinien być false.",
                false, Task.containsName(sentence, name));
    }

    @Test
    public void testSolution4() {
        String sentence = "Gościem fajnym jest Janusz i Roman.";
        String name = "Janusz";

        Assert.assertEquals("Janusz jest częścią zdania i zdanie nie rozpoczyna się ani nie kończy jego imieniem. " +
                        "Wynik powinien być true.",
                true, Task.containsName(sentence, name));
    }
}