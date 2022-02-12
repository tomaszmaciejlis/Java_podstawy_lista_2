# Lista 1 zadanie 2

Napisz program, którego celem będzie:
- Pobranie Zdania za pomocą klasy `Scanner`
- Pobranie frazy do wyszukania w zdaniu
- Następnie wszystkie wystąpienia danego słowa powinny zostać usunięte
- W wyniku działania program powinien podać długość tekstu po usunięciu wystąpień frazy oraz obcięciu białych znaków na początku i końcu

Na przykład kiedy Podane będą parametry:
```
To w zdaniu o zdaniu jest mowa.
```
oraz:
```
zdaniu
```
pozostały String byłby:
```
To w  o  jest mowa.
```
A jego długość to `19`

Jeśli natomiast podane parametry będą:
```
zdania nie zmieniam o ile właśnie w zdaniu doszło do zmiany zdania
```
oraz
```
zdania
```
pozostały string będzie:
```
nie zmieniam o ile właśnie w zdaniu doszło do zmiany
```
a długość pozostałego tekstu bez znaków białych na początku i końcu to: `52`

Obliczenia proszę wykonać w osobnej wydzielonej metodzie:

```
public static int lengthSkipping(String sentence, String skipPart)
```

Testowany będzie wynik metody.
