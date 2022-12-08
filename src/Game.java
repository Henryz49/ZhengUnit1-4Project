import java.util.Random;
import java.util.Scanner;

public class Game {
    private String name = "";
    private String weapon = "";
    private boolean end = false;
    //keeps track of what events have happened already
    private String tracker = "";
    private final Scanner input = new Scanner(System.in);

    private int eventCount = 0;

    public Game(String name, String weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public Game() {
        this.name = "None";
        this.weapon = "sword";
    }

    //chooses a random event
    public int randomEvent() {
        int random = new Random().nextInt((7 - 1) + 1) + 1;
        // checks if event has occured before, rerolls if it has
        while (tracker.contains("" + random)) {
            random = new Random().nextInt((7 - 1) + 1) + 1;
        }
        tracker += random;
        return random;
    }

    //the events that will be chosen from
    public void event1() {
        System.out.println("\nIn front of you, you see a cliff-side. \n To your left is a winding path that leads into absolute darkness, and to your right is an even denser forest. Do you go left or right?");
        String userinput = input.nextLine();
        if (userinput.equals("left")) {
            System.out.println("You walk down the winding path, but you get ambushed by a pack of wolves with no time to react because of the darkness.");
            end = true;
        } else if (userinput.equals("right")) {
            System.out.println("You spot a deer in the distance and swiftly take care of it with a surprise attack. After settling down and having a quick cooked meal, you persist on.");
            eventCount++;
        } else if (userinput.equals("forward")) {
            System.out.println("You... walk off the cliff? That wasn't even an option, what made you think this was a good idea?");
            end = true;
        }
    }

    public void event2() {
        System.out.println("\nYou tread forwards and see a tall cloaked figure in the distance, they seem to be human and they have their back turned. Do you attack? (Y/N)");
        String userinput = input.nextLine();
        if (userinput.equals("Y")) {
            if (weapon.equals("bow")) {
                System.out.println("You fire a makeshift arrow straight at the figure's head and it lands! When you check on the body, it was nothing but items laying on the ground... Weird.");
                eventCount++;
            } else if (weapon.equals("greataxe")) {
                System.out.println("You slowly sneak up behind the figure and swing down on its shoulder. The blade sliced through them easily and you could hear bones crunch, but only a giant puff of black smoke emerged. What was that? ");
                eventCount++;
            } else if (weapon.equals("sword")) {
                System.out.print("You sneak behind the figure and stab it from behind. \n It turned around and stared at you. You realized that it was a skeleton before you felt a sharp pain.");
                end = true;
            }
        } else {
            System.out.println("You decide its better safe than sorry, so you sneak by the figure");
            eventCount++;
        }
    }

    public void event3() {
        System.out.println("\nYou see an abandoned cabin in the middle of a clearing. Do you enter? (Y/N) ");
        String userInput = input.nextLine();
        if (userInput.equals("Y")) {
            System.out.println("You enter the cabin, but there was a trap! You narrowly dodge the spike swinging at your head. You decide to immediately leave after that, for fear of any more traps.");
            eventCount++;
        } else {System.out.println("You decide the best course of action is to go avoid the cabin entirely, as it seemed too suspicious.");
        eventCount++;}
    }

    public void event4() {
        System.out.println("\nYou feel like somethings watching you, do you hide? (Y/N)");
        String userInput = input.nextLine();
        if (userInput.equals("Y")){
            System.out.println("As you move into a hiding spot, an arrow narrowly misses your head. \n You quickly sprint away into the deep forest as another volley fires." );
            eventCount++;
        }
        else{
            System.out.println("You look around for anything hiding in the trees or greenery, but you see nothing. Before you can move, an arrow jams into your shoulder; You can see another volley of arrow approaching.");
            end = true;
        }
    }

    public void event5() {
        System.out.println("You spot two people fighting each other in the distance, one had a blade and the other has a firearm. They seem to be pretty well supplied. Will you interfere? (Y/N)");
        String userInput = input.nextLine();
        if (userInput.equals("Y")){
            if(weapon.equals("bow")){
                System.out.println("You take aim with your crude bow but completely miss your shot due to the lack of visibility in the forest.\nHe turns around and shoots you straight in your shoulder, you manage to crawl away but you slowly bleed out.");
                end = true;}
            if(weapon.equals("greataxe")){
                System.out.println("You slowly go behind the man with the firearm, but you drop your heavy axe and you get spotted by the person with the dagger.\nYou manage to scurry away before the man with the firearm turned around");
            eventCount++;}
            if (weapon.equals("sword")){
                System.out.println("You stealthily sneak up behind the man with the firearm and stab him in the torso.\nAs the man struggles to push you away. The other person picks up the firearm, prompting you to sprint away as fast as you could.");
                eventCount++;
            }
            }
        }
    public void gameInitializer() {
        while (end == false && eventCount <= 4) {
            int event = randomEvent();
            if (event == 1) {
                event1();
            } else if (event == 2) {
                event2();
            } else if (event == 3) {
                event3();
            } else if (event == 4) {
                event4();
            } else if (event == 5) {
                event5();
            }
            //decides if you win or lose
            if (eventCount == 4) {
                System.out.println("\nYou finally managed to escape that hellish forest!");
            } else if (end == true){
                System.out.println("\nYou died!");
            }
        }


    }
}
