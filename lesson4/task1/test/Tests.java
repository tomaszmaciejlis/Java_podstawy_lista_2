import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.junit.Test;

public class Tests {
  @Test
  public void testSolution() {
    Processor processor1 = new Processor();
    Processor processor2 = new Processor();

    Computer computer = new Computer(1);
    computer.accept(processor1);
    Assert.assertFalse("Nie można akceptować procesora kiedy już dodany.", computer.accept(processor2));
  }

  @Test
  public void testSolution2() {
    Disc disc = new Disc();
    Disc disc2 = new Disc();

    Computer computer = new Computer(1);
    computer.accept(disc);
    Assert.assertFalse("Nie można akceptować dysku kiedy już dodany.", computer.accept(disc2));
  }

  @Test
  public void testSolution3() {
    Disc disc = new Disc();
    Disc disc2 = new Disc();

    Computer computer = new Computer(1);
    computer.accept(disc);
    Assert.assertFalse("Nie można akceptować dysku kiedy już dodany.", computer.accept(disc2));
  }

  @Test
  public void testSolution4() {
    Memory memory = new Memory();

    Computer computer = new Computer(2);
    computer.accept(memory);
    computer.accept(memory);
    computer.accept(memory);
    Assert.assertFalse("Nie można akceptować więcej ramu niż przewidzianych slotów.", computer.accept(memory));
  }

  @Test
  public void testSolution5() {
    Assert.assertThat("toString klasy Computer powinien zawierać słowo ram.", new Computer(2).toString(), StringContains.containsString("ram"));
  }

  @Test
  public void testSolution6() {
    Assert.assertThat("toString klasy Computer powinien zawierać słowo disc.", new Computer(2).toString(), StringContains.containsString("disc"));
  }

  @Test
  public void testSolution7() {
    Assert.assertThat("toString klasy Computer powinien zawierać słowo processor.", new Computer(2).toString(), StringContains.containsString("processor"));
  }

  @Test
  public void testSolution8() {
    Assert.assertThat("toString klasy Processor powinien zawierać słowo model", new Processor().toString(), StringContains.containsString("model"));
  }

  @Test
  public void testSolution9() {
    Assert.assertThat("toString klasy Processor powinien zawierać słowo coreCount", new Processor().toString(), StringContains.containsString("coreCount"));
  }

  @Test
  public void testSolution10() {
    Assert.assertThat("toString klasy Processor powinien zawierać słowo hyperThreading", new Processor().toString(), StringContains.containsString("hyperThreading"));
  }

  @Test
  public void testSolution11() {
    Assert.assertThat("toString klasy Processor powinien zawierać słowo cacheSize", new Processor().toString(), StringContains.containsString("cacheSize"));
  }

  @Test
  public void testSolution12() {
    Assert.assertThat("toString klasy Processor powinien zawierać słowo baseClockSpeed", new Processor().toString(), StringContains.containsString("baseClockSpeed"));
  }

  @Test
  public void testSolution13() {
    Assert.assertThat("toString klasy Processor powinien zawierać słowo maxTurboFrequency", new Processor().toString(), StringContains.containsString("maxTurboFrequency"));
  }

  @Test
  public void testSolution14() {
    Assert.assertThat("toString klasy Memory powinien zawierać słowo ddrType", new Memory().toString(), StringContains.containsString("ddrType"));
  }

  @Test
  public void testSolution15() {
    Assert.assertThat("toString klasy Memory powinien zawierać słowo casLatency", new Memory().toString(), StringContains.containsString("casLatency"));
  }

  @Test
  public void testSolution16() {
    Assert.assertThat("toString klasy Memory powinien zawierać słowo speed", new Memory().toString(), StringContains.containsString("speed"));
  }

  @Test
  public void testSolution17() {
    Assert.assertThat("toString klasy Memory powinien zawierać słowo size", new Memory().toString(), StringContains.containsString("size"));
  }

  @Test
  public void testSolution18() {
    Assert.assertThat("toString klasy Disc powinien zawierać słowo size", new Disc().toString(), StringContains.containsString("size"));
  }

  @Test
  public void testSolution19() {
    Assert.assertThat("toString klasy Disc powinien zawierać słowo type", new Disc().toString(), StringContains.containsString("type"));
  }
}