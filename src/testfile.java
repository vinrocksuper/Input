import java.util.Scanner;

import static oracle.jrockit.jfr.events.Bits.intValue;

public class testfile {
    public static void main(String [] args) {
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
            System.out.println("Type 1 to guess, type any other number to let the AI guess");
            int choice = intValue(input.nextInt());
            if (choice ==1)
            {
                System.out.println("Guess a number between 1-100");
                int num = intValue((Math.random() * 100 + 1));
                int guess = intValue(input.nextInt());
                int guessCount = 0;
                while (guess != num)
                {
                    if(guess < num)
                    {
                        System.out.println("The number is greater than your guess");
                        guess = intValue(input.nextInt());
                        guessCount++;
                    }
                    if(guess > num)
                    {
                        System.out.println("The number is less than your guess");
                        guess = intValue(input.nextInt());
                        guessCount++;
                    }

                }
                if (guess == num) {
                    guessCount++;
                    System.out.print("Congrats! It took you " +guessCount + " guesses");
                }
            }
            else
            {
                System.out.println("Hello, I will be attempting to guess your number from 0-99");
                System.out.println("If my guess is less than your number please type lower, if it is greater, type higher, and if correct, type correct");
                double AIguess = 50;
                boolean correct = false;
                int min =0;
                int max =100;
                boolean firstGuess = true;
                int guessCount = 0;
                System.out.println("is your number " + AIguess);
                while(correct == false)
                {
                    String reply = input.next();

                    if(reply.equalsIgnoreCase("lower") && firstGuess == true)
                    {
                        max = intValue(AIguess);
                        guessCount++;
                        firstGuess = false;
                    }
                    if(reply.equalsIgnoreCase("higher") && firstGuess == true)
                    {
                        min = intValue(AIguess);
                        guessCount++;
                        firstGuess = false;
                    }
                    if(reply.equalsIgnoreCase("lower") && firstGuess == false)
                    {
                        max = intValue(AIguess);
                        AIguess = AIguess  - (.5 * (max-min));
                        guessCount++;
                        AIguess = intValue(AIguess);

                        System.out.println("is your number " + AIguess);
                    }
                    else if(reply.equalsIgnoreCase("higher") && firstGuess == false)
                    {
                        min = intValue(AIguess);
                        AIguess = AIguess  + (.5 * (max-min));
                        guessCount++;
                        AIguess = intValue(AIguess);

                        System.out.println("is your number " + AIguess);
                    }
                    else if(reply.equalsIgnoreCase("correct"))
                    {
                        System.out.println("Hurray it took me " + guessCount +" tries.");
                        correct = true;
                    }


                }
            }

        }
    }
}
