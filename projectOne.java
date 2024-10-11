import java.util.Scanner;

public class projectOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Ask for User's name
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        //Welcome message
        System.out.println("Welcome to the Game, " + playerName + "...");

        //Score display
        System.out.println("Thanks for playing, " + playerName +".");
        System.out.println("Your final score is: ");

        //Creating Quiz Logic
        public class Quiz {

            private int score;
            private int totalQuestion;

            //Sample questions for the quiz
            private String [] questions = {
                    "What is the capital of France?",
                    "2 + 2 = what?",
                    "How many states does the USA have?"
            };

            //Sample answers (multiple choice)
            private String[][] options = {
                    {"A. London", "B. Paris", "C. Rome", "D. Madrid"},
                    {"A. 3", "B. 4", "C. 5", "D. 6"},
                    {"A. 60", "B. 25", "C. 50", "D. 13"}
            };



        }
    }
}