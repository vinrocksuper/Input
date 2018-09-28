import java.util.Scanner;

import static oracle.jrockit.jfr.events.Bits.intValue;

public class testfile {
    public static void main(String[] args) {
        /**
         Scanner input = new Scanner(System.in);
         System.out.println("What's your name?");
         String name = input.nextLine();
         System.out.println("How old are you?");
         int age = input.nextInt();
         System.out.println("Hello, " + name + " who is " + age);
         input.close();
         **/
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Type 1 to guess, type 2 to let the computer guess, type 3 to play hangman (2P)");
            int choice = intValue(input.nextInt());
            if (choice == 1) {
                System.out.println("Guess a number between 1-100");
                int num = intValue((Math.random() * 100 + 1));
                int guess = intValue(input.nextInt());
                int guessCount = 0;
                while (guess != num) {
                    if (guess < num) {
                        System.out.println("The number is greater than your guess");
                        guess = intValue(input.nextInt());
                        guessCount++;
                    }
                    if (guess > num) {
                        System.out.println("The number is less than your guess");
                        guess = intValue(input.nextInt());
                        guessCount++;
                    }

                }
                if (guess == num) {
                    guessCount++;
                    System.out.print("Congrats! It took you " + guessCount + " guesses");
                }
            }
            if (choice == 2) {
                System.out.println("Hello, I will be attempting to guess your number from 0-99");
                System.out.println("If my guess is less than your number please type lower, if it is greater, type higher, and if correct, type correct");
                double AIguess = 50;
                boolean correct = false;
                int min = 0;
                int max = 100;
                boolean firstGuess = true;
                int guessCount = 0;
                System.out.println("is your number " + AIguess);
                while (correct == false) {
                    String reply = input.next();

                    if (reply.equalsIgnoreCase("lower") && firstGuess == true) {
                        max = intValue(AIguess);
                        guessCount++;
                        firstGuess = false;
                    }
                    if (reply.equalsIgnoreCase("higher") && firstGuess == true) {
                        min = intValue(AIguess);
                        guessCount++;
                        firstGuess = false;
                    }
                    if (reply.equalsIgnoreCase("lower") && firstGuess == false) {
                        max = intValue(AIguess);
                        AIguess = AIguess - (.5 * (max - min));
                        guessCount++;
                        AIguess = intValue(AIguess);

                        System.out.println("is your number " + AIguess);
                    } else if (reply.equalsIgnoreCase("higher") && firstGuess == false) {
                        min = intValue(AIguess);
                        AIguess = AIguess + (.5 * (max - min));
                        guessCount++;
                        AIguess = intValue(AIguess);

                        System.out.println("is your number " + AIguess);
                    } else if (reply.equalsIgnoreCase("correct")) {
                        System.out.println("Hurray it took me " + guessCount + " tries.");
                        correct = true;
                    }


                }
            }
            if (choice == 3) {
                System.out.println("Hello, This is a 2 player game. The first player designates the word to be guessed and the 2nd player guesses");
                System.out.println("Player 1 type your word now.");
                boolean chosen = false;
                boolean lose = false;
                String tempLength = "";
                String correctWord = "";
                String wrongLetters = "";

                while (chosen == false) {
                    correctWord = input.next();
                    System.out.println("Is your word " + correctWord + "? Type yes to continue. Type no and reenter a word");
                    String confirm = input.next();
                    if (confirm.equalsIgnoreCase("yes")) {
                        chosen = true;
                    }
                    if (confirm.equalsIgnoreCase("no")) {
                        correctWord = input.next();
                        System.out.println("Is your word " + correctWord + "? Type yes to continue.Type no and reenter a word");
                    }
                }
                for (int i = 0; i < 100; i++) {
                    System.out.println("\n");
                }
                for (int i = 0; i < correctWord.length(); i++) {
                    tempLength += "_";

                }
                System.out.println(tempLength);
                System.out.println("It is " + correctWord.length() + " letters long");
                System.out.println("Player 2, guess a letter");
                String builtWord = tempLength;
                int strikes = 0;
                while (!builtWord.equals(correctWord)) {

                    String guessLetter = input.next();
                    try {
                        if (correctWord.indexOf(guessLetter) > -1) {
                            int index = correctWord.indexOf(guessLetter);
                            String correctWordCopy = correctWord;


                            int count = correctWordCopy.length() - correctWordCopy.replace(guessLetter, "").length();
                            for (int i = 0; i < count; i++) {

                                builtWord = builtWord.substring(0, index) + guessLetter + builtWord.substring(index + 1);
                                index = correctWord.indexOf(guessLetter, index + 1);
                            }
                            System.out.println(builtWord);

                        }
                        if (correctWord.indexOf(guessLetter) == -1) {
                            strikes++;
                            System.out.println("Sorry but " + guessLetter + " isn't part of the word");
                            wrongLetters += guessLetter + " ";
                            System.out.println("Your current wrong guesses are " + wrongLetters);
                            if(strikes == 1)
                            {
                                System.out.print(" _________     \n");
                            }
                            if(strikes == 2)
                            {
                                System.out.print(" _________     \n");
                                System.out.print("|         |    \n");
                            }
                            if(strikes == 3)
                            {
                                System.out.print(" _________     \n");
                                System.out.print("|         |    \n");
                                System.out.print("|         0    \n");
                            }
                            if(strikes == 4)
                            {
                                System.out.print(" _________     \n");
                                System.out.print("|         |    \n");
                                System.out.print("|         0    \n");
                                System.out.print("|        /|\\  \n");
                            }
                            if(strikes == 5)
                            {
                                System.out.print(" _________     \n");
                                System.out.print("|         |    \n");
                                System.out.print("|         0    \n");
                                System.out.print("|        /|\\  \n");
                                System.out.print("|        / \\  \n");
                            }
                            if(strikes == 6)
                            {
                                System.out.print(" _________     \n");
                                System.out.print("|         |    \n");
                                System.out.print("|         0    \n");
                                System.out.print("|        /|\\  \n");
                                System.out.print("|        / \\  \n");
                                System.out.print("|              \n");
                            }
                            if(strikes == 7)
                            {
                                System.out.print(" _________     \n");
                                System.out.print("|         |    \n");
                                System.out.print("|         0    \n");
                                System.out.print("|        /|\\  \n");
                                System.out.print("|        / \\  \n");
                                System.out.print("|              \n");
                                System.out.print("|              \n");
                                System.out.println("You lose");
                                break;
                            }


                        }
                    } catch (StringIndexOutOfBoundsException e) {
                        System.out.println(e + " please restart the game.");
                    }





                    }
                    if(lose) {
                        System.out.println("Congrats! You lost. The word was " + correctWord);

                    }
                    else{
                        System.out.println("Congrats you won");
                    }


            }
        }
    }
}
