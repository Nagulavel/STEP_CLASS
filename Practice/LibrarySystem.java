import java.time.LocalDate;
import java.util.*;

abstract class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getDays();
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    int getDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    DVD(String title) {
        super(title);
    }

    int getDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    int getDays() {
        return 3;
    }
}

class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            String type = line.substring(0, line.indexOf(" "));
            String title = line.substring(line.indexOf("\"") + 1,
                    line.lastIndexOf("\""));

            LibraryItem item;

            if (type.equals("BOOK"))
                item = new Book(title);
            else if (type.equals("DVD"))
                item = new DVD(title);
            else
                item = new Magazine(title);

            LocalDate dueDate = currentDate.plusDays(item.getDays());

            System.out.println(title + ": " + dueDate);
        }
    }
}