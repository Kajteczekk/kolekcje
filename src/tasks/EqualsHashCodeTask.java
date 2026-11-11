
package tasks;

import models.Product;
import models.SimpleProduct;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class EqualsHashCodeTask {

    private final Scanner scanner;
    private final Set<Product> products = new HashSet<>();

    public EqualsHashCodeTask(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {

        int choice;

        do {
            System.out.println("\n===== EQUALS() I HASHCODE() =====");
            System.out.println("1. Dodaj produkt");
            System.out.println("2. Wyswietl produkty");
            System.out.println("3. Sprawdz rownosc dwoch produktow");
            System.out.println("4. Wyczysc zbior");
            System.out.println("6. Porownaj obiekty bez equals() i hashCode()");
            System.out.println("0. Powrot do menu glownego");
            System.out.print("Wybor: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> showProducts();
                case 3 -> compareProducts();
                case 4 -> {
                    products.clear();
                    System.out.println("Zbior wyczyszczony.");
                }
                case 6 -> testWithoutEqualsAndHashCode();
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

        Product product = new Product(name, serialNumber, price);

        boolean added = products.add(product);

        if (added) {
            System.out.println("Produkt zostal dodany.");
        } else {
            System.out.println("Produkt o takim numerze seryjnym juz istnieje!");
        }
    }

    private void showProducts() {

        if (products.isEmpty()) {
            System.out.println("Zbior jest pusty.");
            return;
        }

        System.out.println("\nZawartosc HashSet:");

        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println("Liczba produktow: " + products.size());
    }

    private void compareProducts() {

        System.out.println("Podaj dane pierwszego produktu:");

        Product first = createProduct();

        System.out.println("Podaj dane drugiego produktu:");

        Product second = createProduct();

        System.out.println("Wynik porownania equals(): "
                + first.equals(second));

        System.out.println("HashCode pierwszego: "
                + first.hashCode());

        System.out.println("HashCode drugiego: "
                + second.hashCode());
    }

    private Product createProduct() {

        System.out.print("Nazwa: ");
        String name = scanner.next();

        System.out.print("Numer seryjny: ");
        int serialNumber = scanner.nextInt();

        System.out.print("Cena: ");
        double price = scanner.nextDouble();

        return new Product(name, serialNumber, price);
    }
    private void testWithoutEqualsAndHashCode() {
        Set<SimpleProduct> products = new HashSet<>();

        SimpleProduct product1 = new SimpleProduct("Laptop", 101, 3000);
        SimpleProduct product2 = new SimpleProduct("Laptop", 101, 3000);

        products.add(product1);
        products.add(product2);

        System.out.println("\n===== TEST BEZ EQUALS() I HASHCODE() =====");
        System.out.println("Dodano dwa obiekty o identycznych danych.");
        System.out.println("Liczba elementow w HashSet: " + products.size());

        for (SimpleProduct product : products) {
            System.out.println(product);
        }
    }
}
