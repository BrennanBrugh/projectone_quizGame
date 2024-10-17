/**
 * This program is setting up a trivia game.
 * The user inputs their answer to the questions
 * they will get a score in return based on the correct answers. 
 */

import java.util.Scanner;

public class projectOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for User's name
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        // Welcome message
        System.out.println("Welcome to the Game, " + playerName + "...");

        // Creating a Quiz instance and starting the quiz
        Quiz quiz = new Quiz(scanner); // Pass scanner to the Quiz constructor
        quiz.startQuiz();

        // Score display
        System.out.println("Thanks for playing, " + playerName + ".");
        System.out.println("Your final score is: " + quiz.getScore() + "/" + quiz.getTotalQuestions());

        scanner.close(); // Close the scanner to avoid resource leaks
    }
}

// Creating Quiz Logic
class Quiz {
    private int score;
    private int totalQuestions;
    private Scanner scanner; // Keep the Scanner as a field

    // Sample questions for the quiz
    private String[] questions = {
            "What is the capital of France?",
            "2 + 2 = what?",
            "How many states does the USA have?"
    };

    // Sample answers (multiple choice)
    private String[][] options = {
            {"A. London", "B. Paris", "C. Rome", "D. Madrid"},
            {"A. 3", "B. 4", "C. 5", "D. 6"},
            {"A. 60", "B. 25", "C. 50", "D. 13"}
    };

    // Correct answers in correspondence with the multiple-choice questions
    private char[] correctAnswers = {'B', 'B', 'C'};

    // Constructor to initialize scanner and total questions
    public Quiz(Scanner scanner) {
        this.score = 0;
        this.totalQuestions = questions.length;
        this.scanner = scanner;
    }

    // Method to start the quiz
    public void startQuiz() {
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]); // Displays questions
            for (String option : options[i]) {
                System.out.println(option); // Displays answer options
            }

            // Get user answer
            System.out.print("Enter your answer (A/B/C/D): ");
            char userAnswer = scanner.next().charAt(0);

            // Check if answer is correct
            if (Character.toUpperCase(userAnswer) == correctAnswers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer is: " + correctAnswers[i]);
            }

            System.out.println(); // Places blank line between questions
        }
    }

    // Getter for the score
    public int getScore() {
        return score;
    }

    // Getter for the total number of questions
    public int getTotalQuestions() {
        return totalQuestions;
    }
}
