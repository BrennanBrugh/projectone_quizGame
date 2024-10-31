/**
 * The program is supposed to run a short Trivia game.
 * The player enters their name and from there it will prompt you to
 * answer the trivia questions via a/b/c/d.
 * Based off the score for each level it will show you the score, before continuing.
 * Once the game is done whether the score was good or not, it will ask the player
 * if they would like to play again and let you get the option of typing y/n.
 * If yes, the game will loop back to the ASCII art and prompt the user's name again.
 * If no, it will thank the user and end the program.
 */

import java.util.Scanner;

public class projectOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while(playAgain) {
        //ASCII art
        System.out.println("+==========================================================+");
        System.out.println("| _____ _____ ____ _____  __   _____  _   _ ____           |");
        System.out.println("||_   _| ____/ ___|_   _| \\ \\ / / _ \\| | | |  _ \\          |");
        System.out.println("|  | | |  _| \\___ \\ | |    \\ V / | | | | | | |_) |         |");
        System.out.println("|  | | | |___ ___) || |     | || |_| | |_| |  _ <          |");
        System.out.println("| _|_|_|_____|____/ |_|    _|_| \\___/_\\___/|_| \\_\\__ _____ |");
        System.out.println("|| |/ / \\ | |/ _ \\ \\      / / |   | ____|  _ \\ / ___| ____||");
        System.out.println("|| ' /|  \\| | | | \\ \\ /\\ / /| |   |  _| | | | | |  _|  _|  |");
        System.out.println("|| . \\| |\\  | |_| |\\ V  V / | |___| |___| |_| | |_| | |___ |");
        System.out.println("||_|\\_\\_| \\_|\\___/  \\_/\\_/  |_____|_____|____/ \\____|_____||");
        System.out.println("+==========================================================+");

        // Welcome message
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        System.out.println("Welcome, " + playerName + "... you are about to be tested.");
        System.out.println("Answer correctly to proceed, but beware too many wrong answers, and you'll have to start over.");

        // Start Tutorial (invocation method)
        Quiz quiz = new Quiz(scanner, tutorialQuestions(), tutorialOptions(), tutorialAnswers());
        startQuiz(scanner, playerName, quiz, "Let us begin with some basics.");

        // Start Level One
        quiz.setQuestions(levelOneQuestions(), levelOneOptions(), levelOneAnswers());
        startQuiz(scanner, playerName, quiz, "Welcome to Level One. Answer the following riddles.");

        //Start Level Two
        quiz.setQuestions(levelTwoQuestions(), levelTwoOptions(), levelTwoAnswers());
        startQuiz(scanner, playerName, quiz, "Level Two, don't give up now.");

        //Start Level Three
        quiz.setQuestions(levelThreeQuestions(), levelThreeOptions(), levelThreeAnswers());
        startQuiz(scanner, playerName, quiz, "Here is the final level, with this you can really test yourself.");

        // Check rewards
        showRewards(quiz.getScore());

        //Asks the player if they want to play again
        System.out.print("Do you want to play again? (Y/N): ");
        char response = scanner.next().toUpperCase().charAt(0);
        playAgain = (response == 'Y');

        //clear the buffer
        scanner.nextLine();
    }

        System.out.println("Thank you for playing! Goodbye.");
        scanner.close();
    }

    // Utility to start and display score for a quiz round
    private static void startQuiz(Scanner scanner, String playerName, Quiz quiz, String message) {
        System.out.println(message);
        quiz.startQuiz();
        System.out.println("Good job, " + playerName + ".");
        System.out.println("Your score: " + quiz.getScore() + "/" + quiz.getTotalQuestions());
    }

    // Reward display based on score
    private static void showRewards(int score) {
        switch (score) {
            case 6 -> System.out.println("Congratulations, you completed the quiz.");
            case 5 -> System.out.println("Outstanding! you have managed to excel expectations.");
            case 4 -> System.out.println("Excellent work! You could always do better though.");
            case 3 -> System.out.println("Good job. Could be better.");
            case 2 -> System.out.println("Not bad, but you can do better. You made it through, though.");
            case 1 -> System.out.println("Just a step forward, try again?");
            case 0 -> System.out.println("How unfortunate. It seems you messed up somewhere. Try again perhaps?");
            default -> System.out.println("Score out of bounds! Please check your scoring logic.");
        }
    }

    // Sample questions and answers
    private static String[] tutorialQuestions() {
        return new String[]{
                "What is the capital of France?",
                "2 + 2 = what?",
                "How many states does the USA have?"
        };
    }

    private static String[][] tutorialOptions() {
        return new String[][]{
                {"A. London", "B. Paris", "C. Rome", "D. Madrid"},
                {"A. 3", "B. 4", "C. 5", "D. 6"},
                {"A. 60", "B. 25", "C. 50", "D. 13"}
        };
    }

    private static char[] tutorialAnswers() {
        return new char[]{'B', 'B', 'C'};
    }

    private static String[] levelOneQuestions() {
        return new String[]{
                "The more of this there is, the less you see. What is it?",
                "Turn once, what is out will not get in. I turn again, what is in will not get out. What am I?",
                "What travels faster, sound or light?",
                "Which number does every Major League Baseball player wear on April 15?"
        };
    }

    private static String[][] levelOneOptions() {
        return new String[][]{
                {"A. Fog", "B. Darkness", "C. Light", "D. Wind"},
                {"A. A door key", "B. A wheel", "C. A clock", "D. A lock"},
                {"A. Sound", "B. Light", "C. Both", "D. Neither"},
                {"A. 42", "B. 13", "C. 1", "D. 15"}
        };
    }

    private static char[] levelOneAnswers() {
        return new char[]{'B', 'D', 'B', 'A'};
    }

    private static String[] levelTwoQuestions() {
        return new String[]{
                "I can make time stand still, yet everyone keeps moving; What am I?",
                "Which ancient Greek mathematician is known as the father of Geometry?",
                "What is the longest river in Asia?",
                "In the show Friends, what is the name of Ross's pet monkey?",
                "Which country has the most Olympic medals in men's field hockey?"
        };
    }

    private static String[][] levelTwoOptions() {
        return new String[][]{
                {"A. Movie", "B. Clock", "C. Photograph", "D. Phone"},
                {"A. Euclid", "B. Aristotle", "C. Plato", "D. Haley"},
                {"A. Mekong", "B. Ganges", "C. Indus", "D. Yangtze"},
                {"A. Mickey", "B. Marcel", "C. Marty", "D. Marshall"},
                {"A. Japan", "B. India", "C. Canada", "D. U.S.A"}
        };
    }

    private static char[] levelTwoAnswers() {
        return new char[]{'C', 'A', 'D', 'B', 'B'};
    }

    private static String[] levelThreeQuestions() {
        return new String[]{
                "What is the most-watched TV show finale of all time?",
                "In Greek Mythology, who is the god of dreams?",
                "Who invented the World Wide Web?",
                "What is the only metal that is liquid at room temperature?",
                "What year did the Berlin Wall fall?",
                "What is the only bird that can fly backwards?"
        };
    }

    private static String[][] levelThreeOptions() {
        return new String[][]{
                {"A. Friends", "B. Seinfield", "C. M.A.S.H", "D. Cheers"},
                {"A. Hypnos", "B. Morpheus", "C. Thanatos", "D. Phobos"},
                {"A. Bill Gates", "B. Steve Jobs", "C. Tim Berners-Lee", "D. Larry Page"},
                {"A. Gallium", "B. Mercury", "C. Cesium", "D. Bromine"},
                {"A. 1987", "B. 1990", "C. 1949", "D. 1989"},
                {"A. Humming Bird", "B. Kingfisher", "C. Sparrow", "D. Swallow"}
        };
    }

    private static char[] levelThreeAnswers() {
        return new char[] {'C', 'B', 'C', 'B', 'D', 'A'};
    }
}

// Simplified Quiz class for better callback
class Quiz {
    private int score;
    private int totalQuestions;
    private Scanner scanner;
    private String[] questions;
    private String[][] options;
    private char[] answers;

    public Quiz(Scanner scanner, String[] questions, String[][] options, char[] answers) {
        this.scanner = scanner;
        setQuestions(questions, options, answers);
    }

    public void setQuestions(String[] questions, String[][] options, char[] answers) {
        this.questions = questions;
        this.options = options;
        this.answers = answers;
        this.totalQuestions = questions.length;
        this.score = 0;
    }

    public void startQuiz() {
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (String option : options[i]) System.out.println(option);

            char userAnswer;
            while (true) {
                System.out.print("Enter your answer (A/B/C/D): ");
                userAnswer = scanner.next().toUpperCase().charAt(0);

                // Check if the user input is valid
                if (userAnswer >= 'A' && userAnswer <= 'D') {
                    break; // valid input, exit the loop
                } else {
                    System.out.println("Invalid input. Please enter A, B, C, or D.");
                }
            }

            // Check if the answer is correct
            if (userAnswer == answers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer is: " + answers[i]);
            }
            System.out.println();
        }
    }

    public int getScore() {
        return score;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }
}

