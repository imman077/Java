import java.util.Random;
import java.util.Scanner;

public class rock_paper_scissors {
    public static void main(String[] args) {
        // Stone, Paper, Scissors game in Java

        String guess;
        String getUser = "yes";
        String[] choice = {"rock","paper","scissors"};
        Random random = new Random();

        Scanner scanner = new Scanner(System.in);


        while(getUser.equals("yes")) {
            System.out.print("Enter the move (rock, paper, scissors): ");
            guess = scanner.nextLine().toLowerCase();
            if(!guess.equals("rock") && !guess.equals("paper") && !guess.equals("scissors")) {
                System.out.println("Invalid Choice!");
                continue;
            }
            int computerGuess = random.nextInt(choice.length);
            String computerChoice = choice[computerGuess];

            System.out.println("Computer Choice: " + computerChoice);
            if(guess.equals(computerChoice)){
                System.out.println("It is a Tie");
            }
            else if ((guess.equals("paper") && computerChoice.equals("rock") ||
                    (guess.equals("scissors") && computerChoice.equals("paper")) ||
                    (guess.equals("rock") && computerChoice.equals("scissors")))){
                System.out.println("You win!");
            } else {
                System.out.println("You lose!");
            }

            System.out.print("Play Again (yes/no) : ");
            getUser = scanner.nextLine().toLowerCase();

        }
        System.out.println("Thank for playing!");

        scanner.close();
    }
}
