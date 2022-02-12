# Lista 2 Zadanie 3

Napisz program, który:
- Pobierze zmienną klasy `String` przy pomocy `Scanner`
- Zainicjalizuje obiekty klas `Pattern` i `Matcher`, tak aby możliwe było znalezienie adresu IP w tekście
  - W tej wersji zadania rozważamy adresy IP jako ciąg znaków XXX.XXX.XXX.XXX gdzie za każde z XXX mogą być podstawione jedynie liczby
  - Liczby podstawione pod XXX mogą mieć długość od 1 do 3 cyfr
  - Dla ułatwienia **nie** sprawdzamy, czy XXX > 255 (wartość 266 jest poza zakresem, ale na razie się tym nie martwimy)
- Przy pomocy zainicjalizowanego matchera, sprawdź czy pobrany w pierwszym punkcie tekst zawiera adres IP

Sprawdzenia proszę wykonać w osobnej wydzielonej metodzie:

```
public static boolean checkIp(String ip)
```

Testowany będzie wynik metody.
