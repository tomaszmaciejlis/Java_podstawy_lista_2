# Lista 3 Zadanie 3

Celem zadania jest liczenie sum w wierszach i kolumnach.

Najpierw należy stworzyć tablicę o wartościach:

```
1   2   3   4   5   6   7   8   9
2   4   6   8   12  14  16  18  20
1   3   5   7   9   11  13  15  17
1   2   3   5   7   11  13  17  23
3   1   4   9   2   13  0   17  6
3   9   27  81  243 81  27  9   3
1   1   1   1   1   1   1   1   1
1   2   3   4   5   4   3   2   1
10  100 1   99  89  11  21  210 3       
```

Następnie zostanie policzona suma w wierszach i wpisana do ostatniej pozycji w wierszu.

Po wykonaniu wszystkich sum w wierszach, prośba o obliczenie sum kolumn (ostania kolumna powinna być na podstawie obliczonych sum wierszy).

Tym sposobem wynik w prawym dolnym rogu będzie sumą wszystkich elementów 2 wymiarowej tablicy.

Obliczenia proszę wykonać w osobnej wydzielonej metodzie:

```
public static int[][] sum(int[][] input)
```

Testowany będzie wynik metody.
