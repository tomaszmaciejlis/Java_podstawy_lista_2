# Lista 2 Zadanie 1

Napisz program, który:
- będzie miał zanicjalizowaną stałą klasy `Pattern` zainicjalizowaną wyrażeniem regularnym, które sprawdzi poprawność zdania:
  - Zdanie kończy się kropką(.), znakiem zapytania (?) lub wykrzyknikiem (!)
  - Zdanie rozpoczyna się dużą literą
  - Zdanie może zawierać słowa składające się z liter dużych i małych
  - Zdanie może zawierać również spacje
  - Dopuszczalne jest w zdaniu w pisania liczby
  - Wewnątrz zdania może znajdować się interpunkcja w postaci przecinka
- przy pomocy obiekt klasy `Scanner` pobierze zdanie
- Zdanie zostanie przypisane do zmiennej `String`
- Następnie przy pomocy stałej pattern zostanie skonstruowany obiekt klasy `Matcher`
- obiekt klasy `Matcher` powinien sprawdzić, czy zdanie jest poprawne

Sprawdzenia proszę wykonać w osobnej wydzielonej metodzie:

```
public static boolean isValid(String sentence)
```

Testowany będzie wynik metody.
