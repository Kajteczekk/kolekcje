
package tasks;

import models.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ComparatorTask {

    private final Scanner scanner;
    private final List<Person> people = new ArrayList<>();

    public ComparatorTask(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {

        int choice;

        do {
            System.out.println("\n===== COMPARATOR =====");
            System.out.println("1. Dodaj osobe");
            System.out.println("2. Wyswietl osoby");
            System.out.println("3. Sortuj wedlug wieku");
            System.out.println("4. Wyczysc liste");
            System.out.println("0. Powrot do menu glownego");
            System.out.print("Wybor: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addPerson();
                case 2 -> showPeople();
                case 3 -> sortByAge();
                case 4 -> {
                    people.clear();
                    System.out.println("Lista zostala wyczyszczona.");
                }
                case 0 -> System.out.println("Powrot do menu glownego.");
                default -> System.out.println("Niepoprawny wybor!");
            }

        } while (choice != 0);
    }

    private void addPerson() {

        System.out.print("Podaj imie: ");
        String name = scanner.next();

        System.out.print("Podaj wiek: ");
        int age = scanner.nextInt();

        people.add(new Person(name, age));

        System.out.println("Dodano osobe.");
    }

    private void showPeople() {

        if (people.isEmpty()) {
            System.out.println("Lista jest pusta.");
            return;
        }

        for (Person person : people) {
            System.out.println(person);
        }
    }

    private void sortByAge() {

        people.sort(Comparator.comparingInt(Person::getAge));

        System.out.println("Posortowano wedlug wieku.");
        showPeople();
    }
}
