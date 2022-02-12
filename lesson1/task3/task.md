# Lista 1 zadanie 3

Celem zadania będzie analiza syntaktyczna kodu w javie.
Elementem, którym będziemy się zajmować są nawiasy klamrowe `{` i `}`.
Program, który napiszemy, będzie miał na celu sprawdzenie parowania nawiasów.

Na wejściu program powinien pobierać przy pomocy obiektu klasy `Scanner` kolejne linie
aż do wystąpienia linii o wartości "}".

UWAGA! Jeśli chcecie sobie uprościć zamiast pobierania scannerem możecie po prostu podawać string wpisany wkodzie.
Istotna jest implementacja metody `isValid` a nie metody main :-)
Zachęcam jednak pomyśleć jak zrobić opisane powyżej pobieranie bo pozwoli się to łatwiej bawić warunkami wejściowymi.


Jako sprawdzenie poprawności kodu wykonywane powinny być nastęujące czynności:
- złączenie wszystkich linii w jeden duży string
- każdą kolejną linię proszę poprzedzać znakiem new line `\n`
- na złączonym Stringu proszę znaleźć pierwszy `{` i ostatni `}`
- w przypadku braku jednego z nich proszę zwrócić `false`
- jeśli znajdują się nawiasy zamykające to w pętli:
  - zliczaj wystąpienia każdego kolejnego nawiasu `{` jako `count++` 
  - a każdego `}` jako `count--`
  - z każdym krokiem sprawdzaj czy `count >= 0` jeśli taki warunek nie zostanie spełniony przerwij pętlę natychmiast
  - za każdym znalezionym znakiem `{` proszę zapisywać pozycję
  - otrzymanie pozycji `-1` oznacza, że nie ma więcej nawiasów `{`
- w przypadku gdy po zakończeniu pętli wynik `count == 0` proszę zwrócić `true`
- wszystkie inne sytuacje powinny kończyć się na zwróceniu `false`

Obliczenia proszę wykonać w osobnej wydzielonej metodzie:

```
public static boolean isValid(String code)
```

Testowany będzie wynik metody.
