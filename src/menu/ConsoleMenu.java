
package menu;

import java.util.Scanner;
import tasks.SetTask;
import tasks.ListTask;
import tasks.MapTask;
import tasks.EqualsHashCodeTask;
import tasks.ComparatorTask;
import tasks.ComparableTask;
public class ConsoleMenu {

    private final Scanner scanner;

    public ConsoleMenu() {
        scanner = new Scanner(System.in);
    }

    public void showMainMenu() {

        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("       JAVA COLLECTIONS");
            System.out.println("================================");
            System.out.println("1. Zbiory (Set)");
            System.out.println("2. Listy (List)");
            System.out.println("3. Mapy (Map)");
            System.out.println("4. equals() i hashCode()");
            System.out.println("5. Comparator");
            System.out.println("6. Comparable");
            System.out.println("7. Wlasne obiekty jako klucze Map");
            System.out.println("0. Zakoncz program");
            System.out.println("================================");
            System.out.print("Wybierz opcje: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> new SetTask(scanner).run();
                case 2 -> new ListTask(scanner).run();
                case 3 -> new MapTask(scanner).run();
                case 4 -> new EqualsHashCodeTask(scanner).run();
                case 5 -> new ComparatorTask(scanner).run();
                case 6 -> new ComparableTask(scanner).run();
                case 7 -> System.out.println("Wybrano: Wlasne obiekty jako klucze Map");
                case 0 -> System.out.println("Koniec programu.");
                default -> System.out.println("Niepoprawny wybor!");
            }

        } while (choice != 0);
    }
}
