import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class hangman_game {
    public static void main(String[] args){
        System.out.println("****************************");
        System.out.println("Welcome to Java Hangman Game");
        System.out.println("****************************");



        String filePath = "src\\words.txt";
        ArrayList<String> words = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader((new FileReader(filePath)))){
            String line;
            while((line = reader.readLine()) != null){
                words.add(line.trim());
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }catch(IOException e){
            System.out.println("Something Went Wrong");
        }

        Random random = new Random();

        String word = words.get(random.nextInt(words.size()));


        int wrongGuesses = 0;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();
        for(int i = 0 ; i < word.length() ; i++){
            wordState.add('_');
        }

        System.out.print("Word : ");
        for(char c : wordState){
            System.out.print(c + " ");
        }


        while(wrongGuesses <= 6){
            System.out.println(getHangmanArt(wrongGuesses));
            System.out.println("\nGuess the letter : ");
        char letter = scanner.next().toLowerCase().charAt(0);

        if(word.indexOf(letter) >= 0){
            System.out.println("CORRECT GUESS!");
            for(int i=0; i<word.length(); i++){
                if(word.charAt(i) == letter){
                    wordState.set(i, letter);
                }
            }
            for(char c : wordState){
                System.out.print(c + " ");

            }
            System.out.println();
            if(!wordState.contains('_')){
                System.out.println("\nYOU WIN!");
                break;
            }
        }
        else{
            System.out.println("WRONG GUESS!");
            wrongGuesses++;
            for(char c : wordState){
                System.out.print(c + " ");
            }
            System.out.println();

            }

        if(wrongGuesses >= 6){
            System.out.println(getHangmanArt(wrongGuesses));
            System.out.println("GAME OVER!");
            System.out.println("The Correct Word : "+ word);
            break;
        }
        }

        scanner.close();
    }
    static String getHangmanArt(int wrongGuesses){
        return switch (wrongGuesses){
            case 1 -> """
                       o
                        
                        
                        
                      """;
            case 2 -> """
                       o
                       | 
                        
                      """;
            case 3 -> """
                       o
                      /| 
                        
                      """;
            case 4 -> """
                       o
                      /|\\
                        
                      """;
            case 5 -> """
                       o
                      /|\\
                      /
                      """;
            case 6 -> """
                       o
                      /|\\
                      / \\
                      """;
            default -> """
                       
                       
                       
                       """;
        };
    }

}
