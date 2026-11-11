
package models;

import java.util.Objects;

public class Product implements Comparable<Product> {

    private String name;
    private int serialNumber;
    private double price;

    public Product(String name, int serialNumber, double price) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Product product)) {
            return false;
        }

        return serialNumber == product.serialNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }

    @Override
    public String toString() {
        return name + " | Numer seryjny: " + serialNumber
                + " | Cena: " + price + " zl";
    }
    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price);
    }
}
