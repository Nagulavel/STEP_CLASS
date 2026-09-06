import java.util.Arrays;
import java.util.Scanner;
public class PlacementShortlisting {
    static class Candidate implements Comparable<Candidate> {
        private String name;
        private double cgpa;
        private int codingScore;
        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }
        static boolean isEligible(double cgpa) {
            return cgpa >= 7.0;
        }
        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }
        double getCompositeScore() {
            return cgpa * 10 + codingScore * 0.5;
        }
        String getName() {
            return name;
        }
        @Override
        public int compareTo(Candidate other) {
            return Double.compare(
                    other.getCompositeScore(),
                    this.getCompositeScore()
            );
        }
    }
    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;
        for (Candidate candidate : candidates) {
            if (Candidate.isEligible(candidate.cgpa) || Candidate.isEligible(candidate.cgpa, candidate.codingScore)) {
                shortlisted[count] = candidate;
                count++;
            }
        }
        Candidate[] finalList = Arrays.copyOf(shortlisted, count);
        Arrays.sort(finalList);
        String result = "";
        for (int i = 0; i < finalList.length; i++) {
            result = result + (i + 1) + ". " + finalList[i].getName() + " (" + finalList[i].getCompositeScore() + ")";
            if (i < finalList.length - 1) {
                result = result + " | ";
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        sc.nextLine();
        Candidate[] candidates = new Candidate[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nCandidate " + (i + 1));
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter CGPA: ");
            double cgpa = sc.nextDouble();
            System.out.print("Enter coding score: ");
            int codingScore = sc.nextInt();
            sc.nextLine();
            candidates[i] = new Candidate(name, cgpa, codingScore);
        }
        String result = shortlistAndRank(candidates);
        System.out.println("\nShortlisted Candidates:");
        System.out.println(result);
        sc.close();
    }
}