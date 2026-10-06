import java.util.*;

abstract class Question {
    String correct;
    String student;
    double points;

    Question(String correct, String student, double points) {
        this.correct = correct;
        this.student = student;
        this.points = points;
    }

    abstract double getScore();
}

class MCQ extends Question {
    MCQ(String correct, String student, double points) {
        super(correct, student, points);
    }

    double getScore() {
        if (student.equalsIgnoreCase(correct))
            return points;
        return 0;
    }
}

class TF extends Question {
    TF(String correct, String student, double points) {
        super(correct, student, points);
    }

    double getScore() {
        if (student.equalsIgnoreCase(correct))
            return points;
        return 0;
    }
}

class Essay extends Question {
    Essay(String correct, String student, double points) {
        super(correct, student, points);
    }

    double getScore() {
        String[] keywords = correct.split(",");
        int count = 0;

        for (String word : keywords) {
            if (student.toLowerCase().contains(word.trim().toLowerCase()))
                count++;
        }

        if (count >= 2)
            return points * 0.75;
        else if (count == 1)
            return points * 0.50;
        else
            return 0;
    }
}

class ExaminationGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            String type = line.substring(0, line.indexOf(" "));

            String[] parts = line.split("\"");

            String correct = parts[3];
            String student = parts[5];

            double points = Double.parseDouble(parts[6].trim());

            Question q;

            if (type.equals("MCQ"))
                q = new MCQ(correct, student, points);
            else if (type.equals("TF"))
                q = new TF(correct, student, points);
            else
                q = new Essay(correct, student, points);

            double score = q.getScore();

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}