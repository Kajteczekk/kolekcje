
package models;

public class SimpleProduct {
    private String name;
    private int serialNumber;
    private double price;

    public SimpleProduct(String name, int serialNumber, double price) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " | Numer seryjny: " + serialNumber
                + " | Cena: " + price + " zl";
    }
}
