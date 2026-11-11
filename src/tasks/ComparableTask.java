
package tasks;

import models.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ComparableTask {
    private final Scanner scanner;
    private final List<Product> products = new ArrayList<>();

    public ComparableTask(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        int choice;

        do {
            System.out.println("\n===== COMPARABLE =====");
            System.out.println("1. Dodaj produkt");
            System.out.println("2. Wyswietl produkty");
            System.out.println("3. Sortuj wedlug ceny (Comparable)");
            System.out.println("4. Sortuj wedlug nazwy (Comparator)");
            System.out.println("5. Wyczysc liste");
            System.out.println("0. Powrot do menu glownego");
            System.out.print("Wybor: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> showProducts();
                case 3 -> sortByPrice();
                case 4 -> sortByName();
                case 5 -> clearProducts();
                case 0 -> System.out.println("Powrot do menu glownego.");
                default -> System.out.println("Niepoprawny wybor!");
            }

        } while (choice != 0);
    }

    private void addProduct() {
        System.out.print("Podaj nazwe produktu: ");
        String name = scanner.next();

        System.out.print("Podaj numer seryjny: ");
        int serialNumber = scanner.nextInt();

        System.out.print("Podaj cene: ");
        double price = scanner.nextDouble();

        products.add(new Product(name, serialNumber, price));

        System.out.println("Produkt zostal dodany.");
    }

    private void showProducts() {
        if (products.isEmpty()) {
            System.out.println("Lista produktow jest pusta.");
            return;
        }

        for (Product product : products) {
            System.out.println(product);
        }
    }

    private void sortByPrice() {
        Collections.sort(products);
        System.out.println("Posortowano produkty wedlug ceny.");
        showProducts();
    }

    private void sortByName() {
        Collections.sort(products, Comparator.comparing(Product::getName));
        System.out.println("Posortowano produkty wedlug nazwy.");
        showProducts();
    }

    private void clearProducts() {
        products.clear();
        System.out.println("Lista zostala wyczyszczona.");
    }
}
