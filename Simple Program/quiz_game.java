import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class quiz_game {

    public static void main(String[] args) {

        // Java Quiz Game
        String[] questions = {"Who is the father of computer?",
                "Who is the 5th Hokage?",
                "Who is the father of Naruto?",
                "Which didn't win trophy in IPL history?",
                "React JS is"};

        String[][] options = {{"1. James Bond","2. Thomas Alva Edison","3. Elan Musk","4. Charles Barbage"},
                {"1. Minato","2. Tsunade","3. Naruto","4. Kakashi"},
                {"1. Jiraya","2. Mighty Gay","3. Minato","4. Chikago"},
                {"1. CSK","2. RCB","3. MI","4. DD"},
                {"1. Frontend","2. Fullstack","3. Backend","4. None of the Above"}};

        int[] answers = {4, 2, 3, 2, 1};
        int guess;
        int total = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("*************************");
        System.out.println("WELCOME TO JAVA QUIZ GAME");
        System.out.println("*************************");

        for(int i = 0; i < questions.length; i++){
            System.out.println(questions[i]);

            for(String option : options[i]){
                System.out.println(option);
            }
            System.out.println("ENTER YOUR GUESS : ");
            guess = scanner.nextInt();

            if(guess == answers[i]){
                System.out.println("*******");
                System.out.println("CORRECT!");
                System.out.println("*******");
                total++;
            }else{
                System.out.println("*******");
                System.out.println("WRONG!");
                System.out.println("*******");
            }

        }
        System.out.println("Your Final Score is " + total + " out of " + questions.length);


    }
}

