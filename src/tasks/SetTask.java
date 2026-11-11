
package tasks;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.Set;

public class SetTask {

    private final Scanner scanner;

    private final Set<Integer> hashSet = new HashSet<>();
    private final Set<Integer> treeSet = new TreeSet<>();

    public SetTask(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {

        int choice;

        do {
            System.out.println("\n===== SET =====");
            System.out.println("1. Dodaj liczbe");
            System.out.println("2. Usun liczbe");
            System.out.println("3. Sprawdz liczbe");
            System.out.println("4. Wyswietl HashSet");
            System.out.println("5. Wyswietl TreeSet");
            System.out.println("6. Wyswietl oba zbiory");
            System.out.println("7. Wyczysc zbiory");
            System.out.println("8. Porownaj czas wyszukiwania");
            System.out.println("0. Powrot do menu glownego");
            System.out.print("Wybor: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addElement();
                case 2 -> removeElement();
                case 3 -> checkElement();
                case 4 -> System.out.println("HashSet: " + hashSet);
                case 5 -> System.out.println("TreeSet: " + treeSet);
                case 6 -> showBoth();
                case 7 -> clearSets();
                case 8 -> measureSearchTime();
                case 0 -> System.out.println("Powrot do menu glownego.");
                default -> System.out.println("Niepoprawny wybor!");
            }

        } while (choice != 0);
    }

    private void addElement() {

        System.out.print("Podaj liczbe: ");
        int number = scanner.nextInt();

        boolean addedHash = hashSet.add(number);
        boolean addedTree = treeSet.add(number);

        System.out.println("HashSet: " +
                (addedHash ? "Dodano element." : "Element juz istnieje."));

        System.out.println("TreeSet: " +
                (addedTree ? "Dodano element." : "Element juz istnieje."));
    }

    private void removeElement() {

        System.out.print("Podaj liczbe do usuniecia: ");
        int number = scanner.nextInt();

        hashSet.remove(number);
        treeSet.remove(number);

        System.out.println("Usunieto element (jesli istnial).");
    }

    private void checkElement() {

        System.out.print("Podaj liczbe do sprawdzenia: ");
        int number = scanner.nextInt();

        System.out.println("HashSet: " + hashSet.contains(number));
        System.out.println("TreeSet: " + treeSet.contains(number));
    }

    private void showBoth() {

        System.out.println("HashSet: " + hashSet);
        System.out.println("TreeSet: " + treeSet);
    }

    private void clearSets() {

        hashSet.clear();
        treeSet.clear();

        System.out.println("Oba zbiory zostaly wyczyszczone.");
    }


    private void measureSearchTime() {

        for (int i = 0; i < 100000; i++) {
            hashSet.add(i);
            treeSet.add(i);
        }

        int searchedNumber = 99999;

        long startHash = System.nanoTime();
        hashSet.contains(searchedNumber);
        long endHash = System.nanoTime();

        long startTree = System.nanoTime();
        treeSet.contains(searchedNumber);
        long endTree = System.nanoTime();

        System.out.println("Czas wyszukiwania w HashSet: "
                + (endHash - startHash) + " ns");

        System.out.println("Czas wyszukiwania w TreeSet: "
                + (endTree - startTree) + " ns");
    }

}
