
# Lista 1 - Zadanie 1

Zaimplementuj program, który:
- Przy pomocy klasy `Scanner` pobierze linię tekstu
- Użytkownik powinien zostać poproszony o podanie zdania.
- Zdanie powinno być pod zmienną klasy `String`
- Następnie użytkownik będzie poproszony o podanie pojedynczego znaku
- Znak zostanie pobrany odpowiednią metodą klasy `Scanner` (podpowiedź, oprócz scannera będzie potrzebne użycie pewnej metody klasy `String`)
- Przy pomocy metod klasy `String` będą pobierane położenia danego znaku
- Każde wystąpienie powinno zostać wypisane na konsolę
- Podpowiedź: potrzebne będą metody `indexOf`
- Podpowiedź 2: Zastanów się, czy lepiej wykonywać pętle `for` czy `while` i dlaczego
- Podpowiedź 3: na tym etapie szukamy wystąpienia znaku, dokładnie tak jak podano. 
Jeśli podane będą prarametry:

```
Wanda wiedziała o wieściach od Wiesława.
```

```
w
```
oczekiwanym wynikiem będzie:
```
6
18
37
```

Jeśli natomiast podane:
```
Wanda wiedziała o wieściach od Wiesława.
```

```
W
```

oczekujemy wyniku:
```
0
31
```