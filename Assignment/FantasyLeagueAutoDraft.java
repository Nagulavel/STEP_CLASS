import java.util.Arrays;
import java.util.Scanner;
public class FantasyLeagueAutoDraft {
    static class Player implements Comparable<Player> {
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;
        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }
        static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }
        static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 5 && !injured;
        }
        @Override
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage,
                    this.battingAverage);
        }
        public String getName() {
            return name;
        }
    }
    static String draftAndRank(Player[] players) {
        Player[] draftable = new Player[players.length];
        int count = 0;
        for (int i = 0; i < players.length; i++) {
            if (Player.isDraftable(players[i].matchesPlayed) || Player.isDraftable(players[i].matchesPlayed, players[i].injured)) {
                draftable[count] = players[i];
                count++;
            }
        }
        Player[] finalDraftable = new Player[count];
        for (int i = 0; i < count; i++) {
            finalDraftable[i] = draftable[i];
        }
        Arrays.sort(finalDraftable);
        String result = "";
        for (int i = 0; i < finalDraftable.length; i++) {
            result += (i + 1) + ". " + finalDraftable[i].getName();
            if (i < finalDraftable.length - 1) {
                result += " | ";
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of players:");
        int n = sc.nextInt();
        sc.nextLine();
        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter player name:");
            String name = sc.nextLine();
            System.out.println("Enter matches played:");
            int matchesPlayed = sc.nextInt();
            System.out.println("Enter batting average:");
            double battingAverage = sc.nextDouble();
            System.out.println("Is injured? (true/false):");
            boolean injured = sc.nextBoolean();
            sc.nextLine();
            players[i] = new Player(name, matchesPlayed, battingAverage, injured);
        }
        System.out.println(draftAndRank(players));
        sc.close();
    }
}