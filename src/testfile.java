import java.util.Scanner;

public class testfile {
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("What's your name?");
        String name = input.nextLine();
        System.out.println("Hello, " + name);
        input.close();

    }
}
