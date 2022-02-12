# Lista 3 Zadanie 1

Napisz program, który:
- Będzie miał zainicjalizowaną stałą przy pomocy tablicy dopuszczalnych imion: `Adam, Agata, Aleksandra, Andżelika, Grzegorz, Justyna, Kamil, Kamila, Marek, Mateusz, Rafał, Patryk, Paula, Piotr, Przemysław, Tomasz, Wojciech`
- Będzie bazował na tablicy parametrów wejściowych `String[] args`
- Jeśli tablica jest długości mniej niż 3 program powinien wypisać tekst `"Nieprawidłowe parametry. Proszę podać 3 parametry."`
- W przeciwnym razie kontynuuj działanie programu:
  - Sprawdź, czy pierwszy parametr imie znajdujące się w tablicy dopuszczalnych imion
  - Sprawdź, czy drugi parametr zawiera cyfrę (możesz użyć `Pattern` i `Matcher` lub inną znaną metodę), następnie przypisz numer zawarty w stringu do zmiennej integer i sprawdź czy mieści się ona pomiędzy wartościami 18 a 100 
  - Sprawdź przy pomocy obiektów klas `Pattern` i `Matcher` czy parametr trzeci to poprawny e-mail
- Jeśli wszystkie parametry są poprawne wypisz na ekranie "Witamy na kursie!".
- Jeśli, któryś z parametrów jest niepoprawny wypisz tekst "Błąd w parametrze %d" wstawiając numer parametru