# Java Collections – demonstracja kolekcji w Javie

## 1. Opis projektu

Projekt przedstawia działanie podstawowych kolekcji dostępnych w języku Java. Program posiada konsolowy interfejs użytkownika, który umożliwia wykonywanie operacji na różnych typach kolekcji.

Głównym celem projektu jest zaprezentowanie różnic pomiędzy implementacjami interfejsów `Set`, `List` oraz `Map`, a także pokazanie znaczenia metod `equals()` i `hashCode()` oraz mechanizmów sortowania obiektów za pomocą `Comparable` i `Comparator`.

## 2. Rodzaje kolekcji

### 2.1. Set – zbiory

Interfejs `Set` reprezentuje kolekcję, która nie przechowuje duplikatów. Oznacza to, że dodanie tego samego elementu ponownie nie zwiększa liczby elementów w zbiorze.

W projekcie wykorzystano dwie implementacje:

**HashSet**
- Nie gwarantuje kolejności przechowywania elementów.
- Zapewnia szybkie dodawanie, usuwanie i wyszukiwanie elementów.
- Wykorzystuje mechanizm `hashCode()` oraz `equals()` do rozpoznawania duplikatów.

**TreeSet**
- Przechowuje elementy w uporządkowanej kolejności.
- Domyślnie sortuje elementy zgodnie z ich naturalnym porządkiem.
- Wyszukiwanie, dodawanie i usuwanie elementów odbywa się zazwyczaj w czasie O(log n).
- Nie pozwala na przechowywanie elementów uznawanych za równe na podstawie porównania.

**Najważniejsza różnica:** HashSet nie gwarantuje kolejności elementów, natomiast TreeSet utrzymuje je w uporządkowanym porządku.

### 2.2. List – listy

Interfejs `List` reprezentuje uporządkowaną kolekcję elementów. W przeciwieństwie do Set pozwala na przechowywanie powtarzających się elementów.

W projekcie wykorzystano:

**ArrayList**
- Przechowuje elementy w tablicy o dynamicznie zmienianym rozmiarze.
- Zapewnia szybki dostęp do elementów na podstawie indeksu.
- Dodawanie elementów na końcu listy jest zazwyczaj szybkie.
- Usuwanie elementów ze środka lub początku może wymagać przesunięcia pozostałych elementów.

**LinkedList**
- Przechowuje elementy w postaci połączonych ze sobą węzłów.
- Dodawanie i usuwanie elementów na początku listy jest szybkie.
- Dostęp do elementu na podstawie indeksu wymaga przejścia przez kolejne węzły.
- Może być mniej wydajna przy częstym odczytywaniu elementów według indeksu.

**Najważniejsza różnica:** ArrayList sprawdza się lepiej przy częstym odczytywaniu elementów według indeksu, natomiast LinkedList może być korzystniejsza przy operacjach na początku listy.

### 2.3. Map – mapy

Interfejs `Map` przechowuje dane w postaci par klucz–wartość. Każdy klucz musi być unikalny. Ponowne dodanie elementu z istniejącym kluczem powoduje zastąpienie przypisanej mu wartości.

W projekcie wykorzystano:

**HashMap**
- Nie gwarantuje kolejności przechowywania par klucz–wartość.
- Zapewnia zazwyczaj szybkie dodawanie, usuwanie i wyszukiwanie po kluczu.
- Wykorzystuje `hashCode()` oraz `equals()` do identyfikowania kluczy.

**TreeMap**
- Przechowuje wpisy uporządkowane według kluczy.
- Domyślnie wykorzystuje naturalny porządek kluczy.
- Operacje dodawania, usuwania i wyszukiwania zajmują zazwyczaj O(log n).

**Najważniejsza różnica:** HashMap nie gwarantuje kolejności kluczy, natomiast TreeMap sortuje wpisy według kluczy.

## 3. Metody equals() i hashCode()

Metody `equals()` oraz `hashCode()` pochodzą z klasy `Object` i mają istotne znaczenie przy korzystaniu z kolekcji takich jak HashSet i HashMap.

**equals()**
- Określa, czy dwa obiekty są logicznie równe.
- Domyślna implementacja z klasy Object porównuje tożsamość obiektów, a nie ich zawartość.
- Można ją nadpisać, aby definiować własne kryterium równości.

**hashCode()**
- Zwraca liczbę całkowitą będącą kodem skrótu obiektu.
- Jest wykorzystywana m.in. przez HashSet i HashMap.
- Jeżeli dwa obiekty są równe według equals(), muszą zwracać taki sam hashCode().

W projekcie metody te zostały nadpisane w klasie `Product`.

Przyjęto, że dwa produkty są uznawane za równe, jeśli posiadają taki sam numer seryjny. Metoda `equals()` porównuje więc numery seryjne, a `hashCode()` generuje kod na podstawie tego samego pola.

Dzięki temu HashSet rozpoznaje dwa różne obiekty Product z takim samym numerem seryjnym jako duplikaty.

**Co się stanie, jeśli nie nadpiszemy tych metod?**

Domyślne `equals()` porównuje tożsamość obiektów. Dwa osobno utworzone obiekty z identycznymi danymi nie będą automatycznie uznawane za równe. Domyślny `hashCode()` również nie jest oparty na zawartości pól obiektu.

Dlatego kolekcje takie jak HashSet mogą przechowywać oba takie obiekty jako odrębne elementy.

### 3.1. Porównanie obiektów z nadpisanymi i domyślnymi metodami

W celu lepszego zobrazowania działania metod `equals()` i `hashCode()` dodano dodatkowy test z wykorzystaniem klasy `SimpleProduct`.

Klasa `SimpleProduct` zawiera te same podstawowe pola co `Product` (nazwę, numer seryjny i cenę), ale nie nadpisuje metod `equals()` oraz `hashCode()`.

W teście tworzone są dwa osobne obiekty posiadające identyczne dane, a następnie dodawane do kolekcji `HashSet`.

**Wynik testu:**
- W przypadku klasy `Product`, która nadpisuje `equals()` i `hashCode()`, dwa produkty o tym samym numerze seryjnym są traktowane jako jeden element.
- W przypadku klasy `SimpleProduct`, która korzysta z domyślnych implementacji tych metod, dwa osobne obiekty są traktowane jako dwa różne elementy.

Dzięki temu można zaobserwować, że samo posiadanie identycznych wartości pól nie oznacza automatycznie równości obiektów w Javie. To sposób implementacji `equals()` i `hashCode()` wpływa na zachowanie kolekcji opartych na haszowaniu.

## 4. Comparable i Comparator

Java udostępnia dwa podstawowe mechanizmy określania kolejności obiektów.

### 4.1. Comparable

Interfejs `Comparable` pozwala określić naturalny porządek obiektów bezpośrednio w ich klasie.

W projekcie klasa `Product` implementuje `Comparable<Product>`. Metoda `compareTo()` porównuje ceny produktów.

Dzięki temu możliwe jest użycie:

`Collections.sort(products);`

Produkty zostają posortowane rosnąco według ceny.

Metoda `compareTo()` zwraca:
- wartość ujemną – bieżący obiekt powinien znaleźć się przed porównywanym;
- zero – obiekty są równoważne w przyjętym porządku sortowania;
- wartość dodatnią – bieżący obiekt powinien znaleźć się za porównywanym.

### 4.2. Comparator

Interfejs `Comparator` pozwala określić zewnętrzną regułę porównywania obiektów. Nie wymaga modyfikowania klasy, której obiekty chcemy sortować.

W projekcie wykorzystano go na dwa sposoby:
- Sortowanie obiektów Person według wieku.
- Sortowanie obiektów Product według nazwy.

Przykładowe zastosowanie:

`people.sort(Comparator.comparingInt(Person::getAge));`

**Najważniejsza różnica:**

Comparable określa domyślny sposób porównywania obiektów w samej klasie, natomiast Comparator umożliwia tworzenie wielu różnych reguł sortowania poza klasą.

## 5. Podsumowanie

Projekt prezentuje najważniejsze różnice pomiędzy kolekcjami Java Collections Framework:

- Set – przechowuje unikalne elementy.
- List – przechowuje elementy w określonej kolejności i dopuszcza duplikaty.
- Map – przechowuje pary klucz–wartość z unikalnymi kluczami.
- HashSet i HashMap – wykorzystują mechanizm haszowania.
- TreeSet i TreeMap – utrzymują elementy w uporządkowanej kolejności.
- ArrayList i LinkedList – różnią się sposobem przechowywania danych i wydajnością poszczególnych operacji.
- equals() i hashCode() – pozwalają definiować logiczną równość obiektów.
- Comparable i Comparator – umożliwiają sortowanie obiektów według różnych kryteriów.

Program umożliwia samodzielne wykonywanie operacji na kolekcjach i obserwowanie różnic w ich zachowaniu.
