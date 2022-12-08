
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //asks for all the user inputs required
        final Scanner input = new Scanner(System.in);
        System.out.println("You wake up in the middle of a dense forest, not remembering anything that might have happened prior \n What was your name again?:");
        String name = input.nextLine();
        System.out.println("Oh right, it was " + name);
        System.out.println("You feel around the grass for anything to use, you find a random [sword, greataxe, bow]: ");
        String weapon = input.nextLine();
        Game game = new Game(name, weapon);
        System.out.println(weapon + " lying on the floor. You pick it up and prepare to escape this place");
        //starts the game!
        game.gameInitializer();























    }
}