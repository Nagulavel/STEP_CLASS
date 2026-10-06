import java.time.LocalDate;
import java.util.*;
import java.util.Scanner;

abstract class Plan {
    LocalDate startDate;

    Plan(LocalDate startDate) {
        this.startDate = startDate;
    }

    abstract LocalDate getRenewalDate();
}

class Basic extends Plan {
    Basic(LocalDate startDate) {
        super(startDate);
    }

    LocalDate getRenewalDate() {
        return startDate.plusDays(30);
    }
}

class Standard extends Plan {
    Standard(LocalDate startDate) {
        super(startDate);
    }

    LocalDate getRenewalDate() {
        return startDate.plusDays(90);
    }
}

class Premium extends Plan {
    Premium(LocalDate startDate) {
        super(startDate);
    }

    LocalDate getRenewalDate() {
        return startDate.plusDays(365);
    }
}

class StreamingPlan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());

            Plan p;

            if (type.equals("BASIC"))
                p = new Basic(date);
            else if (type.equals("STANDARD"))
                p = new Standard(date);
            else
                p = new Premium(date);

            System.out.println(name + ": " + p.getRenewalDate());
        }
    }
}