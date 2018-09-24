import java.util.Scanner;

import static oracle.jrockit.jfr.events.Bits.intValue;

public class testfile {
    public static void main(String [] args)
    {
        /**
        Scanner input = new Scanner(System.in);
        System.out.println("What's your name?");
        String name = input.nextLine();
        System.out.println("How old are you?");
        int age = input.nextInt();
        System.out.println("Hello, " + name + " who is " + age);
        input.close();
        **/

        Scanner input = new Scanner(System.in);
        System.out.println("Guess a number between 1-100");
        int num = intValue((Math.random()*100+1));
        int guess = intValue(input.nextInt());
        while(guess != num)
        {
            System.out.println("Close, try again!");
            guess = intValue(input.nextInt());
        }
        if(guess == num)
        {
            System.out.print("Congrats!");
        }
    }
}
