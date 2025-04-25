import java.util.Scanner;
import java.util.Random;

public class roll_dice {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numOfRoll;
        int total = 0;

        System.out.print("Enter the Number of Rolls : ");
        numOfRoll = scanner.nextInt();

        if(numOfRoll > 0){
            System.out.println("You rolled the Dice");

            for(int i=0; i < numOfRoll; i++){
                int roll = random.nextInt(1, 7);
                diagramroll(roll);
                System.out.println("You Rolled : " + roll);
                total += roll;

            }
            System.out.println("\nTotal : " + total);
        }
        else{
            System.out.println("You have Enter greater than 0");
        }

    }
    static void diagramroll(int roll){
        String dice1 = """
                     ----------
                    |         |
                    |    ⬤    |  
                    |         |
                     ----------
                """;

        String dice2 = """
                     ----------
                    | ⬤       |
                    |         |  
                    |       ⬤ |
                     ----------
                """;

        String dice3 = """
                     ----------
                    | ⬤       |
                    |    ⬤    |  
                    |       ⬤ |
                     ----------
                """;

        String dice4 = """
                     ----------
                    | ⬤     ⬤ |
                    |          |  
                    | ⬤     ⬤ |
                     ----------
                """;

        String dice5 = """
                     ----------
                    | ⬤    ⬤ |
                    |    ⬤    |  
                    | ⬤    ⬤ |
                     ----------
                """;
        String dice6 = """
                     ----------
                    | ⬤     ⬤ |
                    | ⬤     ⬤ |  
                    | ⬤     ⬤ |
                     ----------
                """;
        switch(roll){
            case 1 -> System.out.print(dice1);
            case 2 -> System.out.print(dice2);
            case 3 -> System.out.print(dice3);
            case 4 -> System.out.print(dice4);
            case 5 -> System.out.print(dice5);
            case 6 -> System.out.print(dice6);
            default -> System.out.println("INVALID DICE");
        }

    }
}

