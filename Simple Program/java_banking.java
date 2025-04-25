import java.util.Scanner;

public class java_banking {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // JAVA BANKING PROGRAM
        int choice;
        double balance = 0;
        boolean isRunning = true;

        while(isRunning){
            System.out.println("\n\n**************************");
            System.out.println("WELCOME TO ONLINE BANKING!");
            System.out.println("**************************");
            System.out.println("1. SHOW BALANCE");
            System.out.println("2. DEPOSIT");
            System.out.println("3. WITHDRAW");
            System.out.println("4. EXIT");
            System.out.println("**************************");
            System.out.print("Enter the Choice (1-4): ");
            choice = scanner.nextInt();

            switch(choice){
                case 1 -> showBalance(balance);
                case 2 -> balance += despositAmount();
                case 3 -> balance -= withdrawAmount(balance);
                case 4 -> isRunning = false;
                default -> System.out.println("INVALID CHOICE");
            }
        }
        System.out.println("***********************");
        System.out.println("THANK YOU! VISIT AGAIN!");
        System.out.println("***********************");

    }
    static void showBalance(double balance){
        System.out.printf("BALANCE : $%.2f",balance);
    }
    static double despositAmount(){
        double amount;
        System.out.print("ENTER THE AMOUNT TO BE DEPOSIT : ");
        amount = scanner.nextDouble();

        if(amount < 0){
            System.out.println("AMOUNT CAN'T BE NEGATIVE");
            return 0;
        } else {
            return amount;
        }
    }
    static double withdrawAmount(double balance){
        double amount;
        System.out.print("ENTER THE AMOUNT TO BE WITHDRAW : ");
        amount = scanner.nextDouble();
        if(amount > balance){
            System.out.println("INSUFFICIENT AMOUNT");
            return 0;
        } else if (amount < 0) {
            System.out.println("AMOUNT CAN'T BE NEGATIVE");
            return 0;
        }
        else{
            return amount;
        }
    }

}

