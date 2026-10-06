import java.util.*;

interface Insurable {
    double getInsurance();
}

abstract class Parcel {
    double weight, value;

    Parcel(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    abstract double getCharge();

    double getInsurance() {
        return 0;
    }
}

class StandardParcel extends Parcel {
    StandardParcel(double weight, double value) {
        super(weight, value);
    }

    double getCharge() {
        return 40 + 10 * weight;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weight, double value) {
        super(weight, value);
    }

    double getCharge() {
        return 80 + 15 * weight;
    }

    public double getInsurance() {
        return value * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weight, double value) {
        super(weight, value);
    }

    double getCharge() {
        return 40 + 10 * weight + 50;
    }

    public double getInsurance() {
        return value * 0.02;
    }
}

class ParcelShipping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            Parcel p;

            if (type.equals("STANDARD"))
                p = new StandardParcel(weight, value);
            else if (type.equals("EXPRESS"))
                p = new ExpressParcel(weight, value);
            else
                p = new FragileParcel(weight, value);

            double charge = p.getCharge();
            double insurance = p.getInsurance();
            double total = charge + insurance;

            System.out.printf(
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type, charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}