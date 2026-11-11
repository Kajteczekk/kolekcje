
package tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MapTask {

    private final Scanner scanner;

    private final Map<String, Integer> hashMap = new HashMap<>();
    private final Map<String, Integer> treeMap = new TreeMap<>();

    public MapTask(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {

        int choice;

        do {
            System.out.println("\n===== MAP =====");
            System.out.println("1. Dodaj pare klucz-wartosc");
            System.out.println("2. Usun element");
            System.out.println("3. Zmien wartosc");
            System.out.println("4. Wyszukaj po kluczu");
            System.out.println("5. Wyswietl HashMap");
            System.out.println("6. Wyswietl TreeMap");
            System.out.println("7. Wyswietl obie mapy");
            System.out.println("8. Wyczysc mapy");
            System.out.println("0. Powrot do menu glownego");
            System.out.print("Wybor: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addElement();
                case 2 -> removeElement();
                case 3 -> modifyElement();
                case 4 -> searchElement();
                case 5 -> System.out.println("HashMap: " + hashMap);
                case 6 -> System.out.println("TreeMap: " + treeMap);
                case 7 -> showBoth();
                case 8 -> clearMaps();
                case 0 -> System.out.println("Powrot do menu glownego.");
                default -> System.out.println("Niepoprawny wybor!");
            }

        } while (choice != 0);
    }

    private void addElement() {

        System.out.print("Podaj klucz: ");
        String key = scanner.next();

        System.out.print("Podaj wartosc: ");
        int value = scanner.nextInt();

        hashMap.put(key, value);
        treeMap.put(key, value);

        System.out.println("Dodano element do obu map.");
    }

    private void removeElement() {

        System.out.print("Podaj klucz do usuniecia: ");
        String key = scanner.next();

        hashMap.remove(key);
        treeMap.remove(key);

        System.out.println("Usunieto element (jesli istnial).");
    }

    private void modifyElement() {

        System.out.print("Podaj klucz: ");
        String key = scanner.next();

        if (hashMap.containsKey(key)) {

            System.out.print("Podaj nowa wartosc: ");
            int value = scanner.nextInt();

            hashMap.put(key, value);
            treeMap.put(key, value);

            System.out.println("Zmieniono wartosc.");
        } else {
            System.out.println("Nie znaleziono klucza.");
        }
    }

    private void searchElement() {

        System.out.print("Podaj klucz: ");
        String key = scanner.next();

        System.out.println("HashMap: " + hashMap.get(key));
        System.out.println("TreeMap: " + treeMap.get(key));
    }

    private void showBoth() {

        System.out.println("HashMap: " + hashMap);
        System.out.println("TreeMap: " + treeMap);
    }

    private void clearMaps() {

        hashMap.clear();
        treeMap.clear();

        System.out.println("Obie mapy zostaly wyczyszczone.");
    }
}
