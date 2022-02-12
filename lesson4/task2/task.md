# Lista 4 Zadanie 2

Przechodzimy do programowania obiektowego.

Wciąż będziemy używać klasy task, ale tym razem jej jedyną rolą będzie pobranie parametrów wejściowych i sprawdzenie wyniku.

Cała reszta zadania powinna być zrealizowana w osobnych plikach klas.

## Opis domeny podstawowej:
- Rozważamy symulację wycinku świata rzeczywistego
- Nasz system będzie oparty o książki, autorów oraz bibliotekę oraz czytelników
- Wszystkie klasy zdefiniowane niżej powinny być umieszczone w pakiecie `pl.my.library`
- Czytelnik to obiekt klasy `Reader`
- Klasa `Reader` jest definiowana przez następujące pola:
  - `name` - Imię - pole prywatne i do niego getter
  - `surname` - Nazwisko - pole prywatne i do niego getter
  - `number` - automatycznie generowany przez bibliotekę - pole prywatne i do niego getter o widoczności pakietowej (to nie jest standard! ale chcemy sobie coś pokazać)
- Autor to obiekt klasy `Author` definiowanej przez pola:
  - `name` - Imię - pole prywatne i do niego getter
  - `surname` - Nazwisko - pole prywatne i do niego getter
- Klasy `Author` (o widoczności publicznej) i `Reader` (o widoczności pakietowej) mają mieć konstruktory, przyjmujące argumenty takie same jak pola klasy
- Książka to obiekt klasy `Book`, która jest definiowana przez pola:
  - `title` - Tytuł - pole prywatne i do niego getter
  - `authors` - tablica obiektów klasy `Author` - pole prywatne i do niego getter
  - `count` - ilość książek o tym tytule w bibliotece - pole prywatne
  - `currentReaders` - czytelnicy, którzy wypożyczyli egzemplarz, ale jeszcze nie oddali. Referencja do tablicy. - pole prywatne

## Klasa książka metody:

- konstruktor przyjmujący parametry `String title`, `Author[] authors` i `int count`
- metoda `isAvailable` widoczności pakietowej
  - jej wynik zależy od tego, czy ilość zajętych indeksów tablicy `currentReaders` jest mniejsza niż `count`. 
  - Jeśli jest mniejsza to wynik jest `true`,
  - w przeciwnym razie `false`.
- `lendTo(Reader reader)` metoda widoczności pakietowej 
  - która zwróci `true`, jeśli udało się znaleźć wolny indeks w tablicy `currentReaders` i wstawić na ten index obiekt z parametru. 
  - w przeciwnym razie `false`.

## Biblioteka

- Biblioteka jest obiektem klasy `Library`
- Klasa `Library` definiuje następujące pola:
  - `readers` - tablica obiektów klasy `Reader` - przyjmujemy, że biblioteka ma możliwość wydania maksymalnie 50 kart bibliotecznych
  - `books` - tablica obiektów klasy `Book` - przyjmujemy, że biblioteka może obsługiwać jedynie 20 tytułów
  - `cardGenerator` - referencja do obiektu klasy opisanej niżej

### Generowanie karty bibliotecznej
- Klasa `Library` definiuje klasę wewnętrzną `CardGenerator`, której rolą jest określanie numerów czytelników
- `CardGenerator` definiuje metodę:
  - `nextId()` - która dla podanego parametru biblioteki zwróci następny dostępny numer karty bibliotecznej.
     - Generowanie numeru polega na sprawdzeniu, jaki jest pierwszy wolny indeks na tablicy readers.
     - Metoda powinna zwracać ten indeks.
     - W przypadku braku takiego indeksu proszę zwrócić `-1`.

### Metody klasy Library
- `Library()` - konstruktor bezparametryczny, w ramach którego tworzony jest dla biblioteki 
    - `CardGenerator` i przypisywany do odpowiedniego pola
    - tablica obiektów `Reader` o pojemności 50 i przypisana do odpowiedniego pola
    - tablica obiektów `Books` o pojemności 20 i przypisana do odpowiedniego pola
- `register(String name, String surname)` - metoda tworzy czytelnika i przypisuje mu numer przy pomocy `CardGeneratora`
    - Nie można zarejestrować więcej niż 50 czytelników. 
    - Stworzony obiekt należy przypisać do pierwszego wolnego indeksu w tablicy `readers` 
    oraz zwrócić w wyniku metody. 
    - Jeśli nie można było dodać użytkownika należy zwrócić `null`.
- `addBook(String title, Author[] authors, int count)` - metoda zwraca boolean. 
    - Tworzy obiekt książki na podstawie zadanych parametrów i przypisuje ją na wolny indeks w tablicy `books`. 
    - Jeśli nie ma wolnego indeksu, metoda zwraca `false`.
- `lendABook(Reader reader, String title, Author[] authors)` - metoda zwraca boolean. 
   - Jeśli udało się wypożyczyć książkę wynikiem będzie `true`, w przeciwnym razie `false`. 
   - Warunkiem do wypożyczenia jest to, aby ilość zajętych indeksów na tablicy `currentReaders` dla danej książki była mniejsza niż `count`
   - Nie możliwe jest wypożyczenie książki, której nie ma w tablicy `books` w bibliotece. 
   - Warunkiem wyszukania książki jest równość tytułu i zgodność listy autorów.
   - Zakładamy, że w autorzy w parametrze mogą zostać podani w innej kolejności niż w odnalezionej książce.
   - Zgodność tytułu oznacza, że tytuł w parametrze jest równy tytułowi książki w tablicy. 
   Przy tym porównaniu wielkość znaków nie ma znaczenia (`equalsIgnoreCase` z klasy `String`).
   - Jeśli wyporzyczenie jest możliwe należy wywołać metodę `Book.lendTo(Reader reader)` przy użyciu `readera` podanego
    w `Library.lendABook(Reader reader)`



UWAGA! Podpowiedź: pamiętajcie, że do porównania obiektów używamy metody equals.
Proszę zaimplementować odpowiednie metody equals, tak aby np. porównanie autora polegało na porównaniu imienia i nazwiska

