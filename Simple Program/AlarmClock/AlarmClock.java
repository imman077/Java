import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

public class AlarmClock implements Runnable{

    private final LocalTime alarmtime;
    private final String filepath;
    private final Scanner scanner;

    AlarmClock(LocalTime alarmtime, String filepath, Scanner scanner){
        this.alarmtime = alarmtime;
        this.filepath = filepath;
        this.scanner = scanner;
    }

    @Override
    public void run(){
        while(LocalTime.now().isBefore(alarmtime)){
            try{

                Thread.sleep(1000);
                LocalTime now = LocalTime.now();
                System.out.printf("\r%02d:%02d:%02d",now.getHour(),now.getMinute(),now.getSecond());
            }
            catch(InterruptedException e){
                System.out.println("Thread was Corrupted");
            }
        }
        System.out.println("\n*ALARM NOISES*");
        playSound(filepath);
    }


    private void playSound(String filepath){
        File audioFile = new File(filepath);

        try(AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile)){
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            System.out.println("Press *ENTER* to stop the alarm");
            scanner.nextLine();
            clip.stop();
            scanner.close();

        }catch(UnsupportedAudioFileException e){
            System.out.println("Audio File is not Supported");
        }
        catch(LineUnavailableException e){
            System.out.println("Audio is Unavailable");
        }
        catch(IOException e){
            System.out.println("Error reading audio file");
        }

    }
}
