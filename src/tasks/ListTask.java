
package tasks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListTask {

    private final Scanner scanner;

    private final List<Integer> arrayList = new ArrayList<>();
    private final List<Integer> linkedList = new LinkedList<>();

    public ListTask(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {

        int choice;

        do {
            System.out.println("\n===== LIST =====");
            System.out.println("1. Dodaj element");
            System.out.println("2. Usun element");
            System.out.println("3. Modyfikuj element");
            System.out.println("4. Wyswietl ArrayList");
            System.out.println("5. Wyswietl LinkedList");
            System.out.println("6. Wyswietl obie listy");
            System.out.println("7. Wyczysc listy");
            System.out.println("8. Porownaj czas operacji");
            System.out.println("0. Powrot do menu glownego");
            System.out.print("Wybor: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addElement();
                case 2 -> removeElement();
                case 3 -> modifyElement();
                case 4 -> System.out.println("ArrayList: " + arrayList);
                case 5 -> System.out.println("LinkedList: " + linkedList);
                case 6 -> showBoth();
                case 7 -> clearLists();
                case 8 -> measurePerformance();
                case 0 -> System.out.println("Powrot do menu glownego.");
                default -> System.out.println("Niepoprawny wybor!");
            }

        } while (choice != 0);
    }

    private void addElement() {

        System.out.print("Podaj liczbe: ");
        int number = scanner.nextInt();

        arrayList.add(number);
        linkedList.add(number);

        System.out.println("Dodano element do obu list.");
    }

    private void removeElement() {

        System.out.print("Podaj indeks elementu do usuniecia: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < arrayList.size()) {
            arrayList.remove(index);
            linkedList.remove(index);

            System.out.println("Usunieto element.");
        } else {
            System.out.println("Niepoprawny indeks!");
        }
    }

    private void modifyElement() {

        System.out.print("Podaj indeks elementu do modyfikacji: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < arrayList.size()) {

            System.out.print("Podaj nowa wartosc: ");
            int number = scanner.nextInt();

            arrayList.set(index, number);
            linkedList.set(index, number);

            System.out.println("Zmodyfikowano element.");
        } else {
            System.out.println("Niepoprawny indeks!");
        }
    }

    private void showBoth() {

        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);
    }

    private void clearLists() {

        arrayList.clear();
        linkedList.clear();

        System.out.println("Obie listy zostaly wyczyszczone.");
    }


    private void measurePerformance() {

        int numberOfElements = 50000;

        List<Integer> array = new ArrayList<>();
        List<Integer> linked = new LinkedList<>();

        // Pomiar dodawania
        long start = System.nanoTime();

        for (int i = 0; i < numberOfElements; i++) {
            array.add(i);
        }

        long arrayAddTime = System.nanoTime() - start;

        start = System.nanoTime();

        for (int i = 0; i < numberOfElements; i++) {
            linked.add(i);
        }

        long linkedAddTime = System.nanoTime() - start;

        // Pomiar pobierania
        start = System.nanoTime();

        for (int i = 0; i < numberOfElements; i++) {
            array.get(i);
        }

        long arrayGetTime = System.nanoTime() - start;

        start = System.nanoTime();

        for (int i = 0; i < numberOfElements; i++) {
            linked.get(i);
        }

        long linkedGetTime = System.nanoTime() - start;

        // Pomiar usuwania z początku
        start = System.nanoTime();

        while (!array.isEmpty()) {
            array.remove(0);
        }

        long arrayRemoveTime = System.nanoTime() - start;

        start = System.nanoTime();

        while (!linked.isEmpty()) {
            linked.remove(0);
        }

        long linkedRemoveTime = System.nanoTime() - start;

        // Wyniki
        System.out.println("\n===== WYNIKI POMIAROW =====");

        System.out.println("Dodawanie:");
        System.out.println("ArrayList: " + arrayAddTime + " ns");
        System.out.println("LinkedList: " + linkedAddTime + " ns");

        System.out.println("\nPobieranie po indeksie:");
        System.out.println("ArrayList: " + arrayGetTime + " ns");
        System.out.println("LinkedList: " + linkedGetTime + " ns");

        System.out.println("\nUsuwanie z poczatku:");
        System.out.println("ArrayList: " + arrayRemoveTime + " ns");
        System.out.println("LinkedList: " + linkedRemoveTime + " ns");
    }

}
