# Lista 2 Zadanie 4

Napisz program, który:
- Pobierze zmienną klasy `String` przy pomocy `Scanner`
- Zainicjalizuje obiekty klas `Pattern` i `Matcher`, tak aby możliwe było znalezienie adresu e-mail w tekście
  - adres email składa się z:
    - części lokalnej (local-part) - składającej się z liter, cyfr oraz znaków specjalnych z zakresu ```[.!#$%&'*+-/=?^_`{|}~]``` (najczęściej spotyka się kropkę lub myślnik)
    - część lokalna nie może zaczynać się od znaku specjalnego
    - pojedynczego znaku `@`
    - nazwy domeny, składającej się z liter, cyfr i znaków specjalnych `.-`
    - nazwa domeny kończy się główną domeną np. `.com` lub `pl`, dla ułatwienia przyjmijmy, że jest to kropka oraz ciąg liter długości 2 lub 3
- Przy pomocy zainicjalizowanego matchera, sprawdź czy pobrany w pierwszym punkcie tekst zawiera adres e-mail

Obliczenia proszę wykonać w osobnej wydzielonej metodzie:

```
public static boolean checkEmail(String email)
```

Testowany będzie wynik metody.
