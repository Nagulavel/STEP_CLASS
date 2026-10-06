class PiggyBank {
    private int savings;
    private final String id;

    PiggyBank(String id) {
        this.id = id;
        savings = 0;
    }

    void deposit(int amount) {
        savings += amount;
    }

    void withdraw(int amount) {
        if (amount <= savings)
            savings -= amount;
        else
            System.out.println("Withdrawal rejected");
    }

    int getSavings() {
        return savings;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        System.out.println(pb.getSavings());

        pb.withdraw(30);
        System.out.println(pb.getSavings());

        pb.withdraw(500);
        System.out.println(pb.getSavings());
    }
}