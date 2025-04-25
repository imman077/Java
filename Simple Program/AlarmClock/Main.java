import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;
        String filepath = "melody-of-nature-main-6672.wav";

        while(alarmTime == null){
            try{
                System.out.print("Enter the Alarm (HH:MM:SS) : ");
                String inputTime = scanner.nextLine();

                alarmTime = LocalTime.parse(inputTime, formatter);
                System.out.println("Your Alarm Time is " +  alarmTime);

            }
            catch(DateTimeParseException e){
                System.out.println("Invalid Format. Please use format(HH:MM:SS)");
            }


        }

        AlarmClock alarmClock = new AlarmClock(alarmTime, filepath, scanner);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();


    }
}
