# Lista 4 Zadanie 1

Utworzymy model klas do symulacji składania komputera.

Model domenowy powinien zostać utworzony w pakiecie: `pl.my.hardware`.

W tym zadaniu nauczymy się używać `instanceof`, konstrukcji, która pozwala na sprawdzenie
jakiej klasy jest dany obiekt.

Komputer będzie składany z następujących części:
- procesor
- od jednej do n kości ram (konfigurowane na poziomie konstruktora komputera)
- dysk

W zadaniu należy utworzyć klasy:
- `Processor` o parametrach:
    - `model` - nazwa modelu
    - `coreCount` - ilość rdzeni
    - `hyperThreading` - informacja czy obsługuje wiele wątków na jednym rdzeniu jednocześnie
    - `cacheSize` - ilość MB cache
    - `baseClockSpeed` - szybkość procesora w GHz (pamiętajmy, że możliwe jest np. 3.2 GHz)
    - `maxTurboFrequency` - szybkość procesora w trybie overclocking
- `Memory` o parametrach:
  - `ddrType` - typ portu ddr - numer 1, 2, 3, 4, 5
  - `casLatency` - wartości 9, 10, 11 określające latencję w cyklach
  - `speed` - ilość MB, które mogą być operowane na sekundę
  - `size` - pojemność ram w GB
- `Disc` o parametrach:
  - `size` - pojemność w GB
  - `type` - wartość enuma `DiscType`, który jest również zaimplementowany wewnątrz klasy

Wszystkie pola mają być prywatne i trzeba do nich stworzyć gettery i settery.

Enum `DiscType` powinien definiować następujące wartości:
- `SSD`
- `HDD`

Wszystkie te klasy muszą mieć odpowiednie typy danych dla pól. Dobierz je tak aby miało to najwięcej sensu.

W naszym zadaniu komputer nie będzie standardowym komputerem.
Będzie to klasa, która posłuży nam, do zbierania części, o ile mogą zostać przyjęte.
W tym celu do klasy `Computer` została dodana metoda `accept(Object computerPart)`. 
Kilka założeń co do niej:
 - nie znamy na tym etapie interfejsów, skorzystamy z faktu, że każda klasa dziedziczy po klasie `Object`. 
Stąd parametrem jest właśnie obiekt tej klasy. Nie wiemy też do końca, o co chodzi z dziedziczeniem.
W związku z tym przyjmijmy po prostu, że jeśli metoda przyjmuje obiekt klasy `Object` to przyjmie obiekt dowolnej klasy.
 - metoda będzie miała na celu sprawdzenie, czy obiekt przyjęty w parametrze należy do jednej z klas spośród `Processor`, `Memory`, `Disc`
 - jeśli obiekt będzie klasy `Disc` to zachowanie metody będzie następujące:
    - jeśli w naszym komputerze pole `disc` jest już podstawione to metoda `accept` ma zwrócić `false` i przerwać działanie
    - jeśli pole `disc` jest puste to należy castować `computerPart` do `Disc`, zainicjalizować nim pole `disc` i zwrócić `true`
 - jeśli obiekt będzie klasy `Memory` to:
   - jeśli jest jakiś pusty slot w tablicy `ram` (istnieje indeks tablicy dla, której wciąż mamy null), należy wstawić `computerPart` castowane do `Memory` i zwrócić `true`
   - w przeciwnym razie zwrócić false
 - jeśli obiekt `computerPart` jest instancją klasy `Processor`:
   - w przypadku pustego pola `processor` należy podstawić pod nie `computerPart` castowane do `Processor` i zwrócić true
   - w przeciwnym razie zwrócić false

Klasa Computer musi również definiować konstruktor parametryczny:
`Computer(int ramSlots)` który zainicjalizuje pole `ram` tablicą rozmiaru `ramSlots`.

Oprócz tego wszystkie klasy muszą definiować customowe  `toString`. Kod wygenerujemy. Pokarzemy sobie na zajęciach jak.
