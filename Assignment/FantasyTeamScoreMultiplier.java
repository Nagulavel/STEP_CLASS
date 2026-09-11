import java.util.Scanner;
public class FantasyTeamScoreMultiplier {
    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] = playerScores[captainIndex] * 2;
        playerScores[viceCaptainIndex] = playerScores[viceCaptainIndex] * 1.5;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of players:");
        int n = sc.nextInt();
        double[] playerScores = new double[n];
        System.out.println("Enter player scores:");
        for (int i = 0; i < n; i++) {
            playerScores[i] = sc.nextDouble();
        }
        System.out.println("Enter captain index:");
        int captainIndex = sc.nextInt();
        System.out.println("Enter vice-captain index:");
        int viceCaptainIndex = sc.nextInt();
        applyMultipliers(playerScores, captainIndex, viceCaptainIndex);
        System.out.println("Updated scores:");
        for (int i = 0; i < playerScores.length; i++) {
            System.out.print(playerScores[i] + " ");
        }
        sc.close();
    }
}