import java.util.*;

abstract class LibraryItem {
    String title;
    int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double getFine();
}

class Book extends LibraryItem {
    Book(String title, int daysLate) {
        super(title, daysLate);
    }

    double getFine() {
        return daysLate * 2;
    }
}

class DVD extends LibraryItem {
    DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    double getFine() {
        double fine = daysLate * 5;

        if (fine > 50)
            fine = 50;

        return fine;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    double getFine() {
        return daysLate;
    }
}

class LibraryFine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();

            LibraryItem item;

            if (type.equals("BOOK"))
                item = new Book(title, days);
            else if (type.equals("DVD"))
                item = new DVD(title, days);
            else
                item = new Magazine(title, days);

            double fine = item.getFine();

            System.out.printf("%s: %.2f%n", title, fine);
            total += fine;
        }

        System.out.printf("Total Fines: %.2f%n", total);
    }
}