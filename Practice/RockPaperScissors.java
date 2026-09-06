import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if (playerMove.equals("Rock") && computerMove.equals("Scissors")) {
            return "Player Wins";
        }

        if (playerMove.equals("Paper") && computerMove.equals("Rock")) {
            return "Player Wins";
        }

        if (playerMove.equals("Scissors") && computerMove.equals("Paper")) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[] playerMoves = new String[5];
        String[] computerMoves = new String[5];
        String[] results = new String[5];

        for (int i = 0; i < 5; i++) {

            System.out.print("Round " + (i + 1) +
                    " - Enter Rock, Paper or Scissors: ");

            playerMoves[i] = sc.nextLine();

            int randomIndex = random.nextInt(3);
            computerMoves[i] = moves[randomIndex];

            results[i] = playRound(playerMoves[i], computerMoves[i]);

            System.out.println("Computer: " + computerMoves[i]);
            System.out.println("Result: " + results[i]);
            System.out.println();

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        printSummary(playerMoves, computerMoves, results,
                wins, losses, draws);

        sc.close();
    }

    static void printSummary(String[] playerMoves,
                             String[] computerMoves,
                             String[] results,
                             int wins,
                             int losses,
                             int draws) {

        System.out.println("========== FINAL SUMMARY ==========");

        System.out.printf("%-8s %-15s %-15s %-15s%n",
                "Round", "Player Move", "Computer Move", "Result");

        for (int i = 0; i < 5; i++) {

            System.out.printf("%-8d %-15s %-15s %-15s%n",
                    i + 1,
                    playerMoves[i],
                    computerMoves[i],
                    results[i]);
        }

        double winPercentage = (wins / 5.0) * 100;

        System.out.println("-----------------------------------");
        System.out.println("Wins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.printf("Win %%  : %.1f%%%n", winPercentage);
    }
}