import java.util.Scanner;

/**
 * Follow the White Rabbit v2 - A Matrix x Alice in Wonderland Mystery Game
 * Run this in any command prompt/terminal
 *
 * To compile: javac WhiteRabbit.java
 * To run: java WhiteRabbit
 */
public class WhiteRabbit {

    // ANSI color codes
    static class Color {
        static final String GREEN = "\u001B[92m";
        static final String RED = "\u001B[91m";
        static final String BLUE = "\u001B[94m";
        static final String WHITE = "\u001B[97m";
        static final String CYAN = "\u001B[96m";
        static final String YELLOW = "\u001B[93m";
        static final String RESET = "\u001B[0m";
        static final String BOLD = "\u001B[1m";
    }

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            intro();
            chapter1();
        } catch (InterruptedException e) {
            System.out.println("\n\n" + Color.YELLOW + "The White Rabbit scurries away..." + Color.RESET);
            System.out.println(Color.WHITE + "Come back soon. 🐰" + Color.RESET + "\n");
            System.exit(0);
        }
    }

    static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // If clear doesn't work, just print newlines
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }

    static void slowPrint(String text, int delayMs, String color) throws InterruptedException {
        for (char c : text.toCharArray()) {
            System.out.print(color + c + Color.RESET);
            System.out.flush();
            Thread.sleep(delayMs);
        }
        System.out.println();
    }

    static void slowPrint(String text) throws InterruptedException {
        slowPrint(text, 30, Color.GREEN);
    }

    static void matrixRain(int duration) throws InterruptedException {
        String chars = "01アイウエオカキクケコ";
        for (int i = 0; i < duration * 10; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < 80; j++) {
                line.append(chars.charAt((int)(Math.random() * chars.length())));
            }
            System.out.println(Color.GREEN + line.toString() + Color.RESET);
            Thread.sleep(100);
        }
    }

    static void showRabbit() throws InterruptedException {
        String rabbit = Color.WHITE +
            "\n    (\\_/)\n" +
            "    (o.o)\n" +
            "    (> <)  " + Color.BOLD + "Follow me..." + Color.RESET;
        System.out.println(rabbit);
        Thread.sleep(1000);
    }

    static String getChoice(String... options) {
        while (true) {
            System.out.print("\n" + Color.CYAN + "> " + Color.RESET);
            String choice = scanner.nextLine().trim().toLowerCase();
            for (String option : options) {
                if (choice.equals(option)) {
                    return choice;
                }
            }
            System.out.println(Color.RED + "Invalid choice. Try again." + Color.RESET);
        }
    }

    static void intro() throws InterruptedException {
        clearScreen();
        slowPrint("=" .repeat(60), 10, Color.GREEN);
        slowPrint("FOLLOW THE WHITE RABBIT", 50, Color.WHITE);
        slowPrint("A Mystery Beyond The Looking Glass", 30, Color.CYAN);
        slowPrint("=" .repeat(60), 10, Color.GREEN);
        System.out.println("\n");
        Thread.sleep(1000);

        slowPrint("You wake at your terminal. 3:33 AM.", 40, Color.GREEN);
        slowPrint("A message blinks on your screen:", 40, Color.GREEN);
        Thread.sleep(500);
        System.out.println();
        slowPrint("'Wake up, Neo... The Matrix has you...'", 50, Color.GREEN);
        slowPrint("'Follow the White Rabbit.'", 50, Color.GREEN);
        System.out.println();
        Thread.sleep(1000);

        slowPrint("A knock at your door.", 40, Color.YELLOW);
        Thread.sleep(500);
    }

    static void chapter1() throws InterruptedException {
        slowPrint("\n[CHAPTER 1: THE KNOCK]", 30, Color.BOLD + Color.CYAN);
        System.out.println();
        slowPrint("You hear it again. Knock. Knock. Knock.", 40, Color.GREEN);
        slowPrint("Do you open the door?", 40, Color.YELLOW);
        System.out.println("\n1. Open the door");
        System.out.println("2. Ignore it and check the message again");
        System.out.println("3. Look through the peephole");

        String choice = getChoice("1", "2", "3");

        switch (choice) {
            case "1": doorOpen(); break;
            case "2": checkMessage(); break;
            case "3": peephole(); break;
        }
    }

    static void doorOpen() throws InterruptedException {
        slowPrint("\nYou open the door...", 40, Color.GREEN);
        Thread.sleep(1000);
        slowPrint("A woman with a white rabbit tattoo stands before you.", 40, Color.WHITE);
        showRabbit();
        slowPrint("'I'm late, I'm late,' she whispers urgently.", 40, Color.GREEN);
        slowPrint("'They're watching. You need to choose. NOW.'", 40, Color.RED);
        Thread.sleep(500);
        redBluePill();
    }

    static void checkMessage() throws InterruptedException {
        slowPrint("\nYou return to your terminal.", 40, Color.GREEN);
        slowPrint("The message has changed:", 40, Color.GREEN);
        Thread.sleep(500);
        slowPrint("\n'Curiosity killed the cat, but you're late for a very important date.'", 40, Color.GREEN);
        slowPrint("'Time is running out. 03:34 AM.'", 40, Color.GREEN);
        slowPrint("'P.S. - Type CHESHIRE if you want to see how deep the rabbit hole really goes...'", 40, Color.GREEN);
        Thread.sleep(1000);

        slowPrint("\nDo you:", 40, Color.YELLOW);
        System.out.println("\n1. Answer the door");
        System.out.println("2. Type CHESHIRE");

        String choice = getChoice("1", "2", "cheshire");

        if (choice.equals("2") || choice.equals("cheshire")) {
            cheshirePath();
        } else {
            slowPrint("\nThe knocking intensifies.", 40, Color.RED);
            slowPrint("You should probably answer it...", 40, Color.GREEN);
            Thread.sleep(1000);
            doorOpen();
        }
    }

    static void cheshirePath() throws InterruptedException {
        clearScreen();
        slowPrint("\nYou type: CHESHIRE", 40, Color.CYAN);
        Thread.sleep(1000);
        slowPrint("\nThe screen flickers. Code swirls into the shape of a grinning cat.", 40, Color.CYAN);
        Thread.sleep(1000);

        slowPrint("\nA voice - neither male nor female - speaks:", 40, Color.CYAN);
        slowPrint("'Well, well... someone who asks the right questions.'", 40, Color.CYAN);
        slowPrint("'We're all mad here, you know. I'm mad. You're mad.'", 40, Color.CYAN);
        Thread.sleep(1000);

        slowPrint("\n'But let me tell you a secret...'", 40, Color.YELLOW);
        slowPrint("'The rabbit hole, the pills, the choices - they're all part of the game.'", 40, Color.GREEN);
        slowPrint("'But YOU... you can simply WAKE UP.'", 40, Color.GREEN);
        Thread.sleep(1000);

        slowPrint("\n'No pills. No rabbit. Just... wake up.'", 40, Color.WHITE);
        Thread.sleep(2000);
        clearScreen();

        slowPrint("\nYou open your eyes.", 40, Color.GREEN);
        slowPrint("You're at your desk. Morning light streams through the window.", 40, Color.GREEN);
        slowPrint("No Matrix. No Wonderland. Just reality.", 40, Color.GREEN);
        Thread.sleep(1000);

        slowPrint("\nBut on your screen, a message blinks:", 40, Color.CYAN);
        slowPrint("'Most people only see what they expect to see. You saw more.'", 40, Color.CYAN);
        slowPrint("'The question isn't WHERE you go... but WHY you go there.'", 40, Color.CYAN);
        Thread.sleep(1000);

        slowPrint("\nA grin fades from your screen - there one moment, gone the next.", 40, Color.CYAN);

        ending("CHESHIRE");
    }

    static void peephole() throws InterruptedException {
        slowPrint("\nYou peer through the peephole...", 40, Color.GREEN);
        Thread.sleep(1000);
        slowPrint("A white rabbit in a waistcoat checks a pocket watch.", 40, Color.WHITE);
        slowPrint("Wait... that can't be real.", 40, Color.YELLOW);
        showRabbit();
        Thread.sleep(1000);
        slowPrint("You blink. Now it's a woman with a rabbit tattoo.", 40, Color.GREEN);
        slowPrint("She mouths: 'OPEN THE DOOR'", 40, Color.RED);
        Thread.sleep(1000);
        doorOpen();
    }

    static void redBluePill() throws InterruptedException {
        slowPrint("\n[THE CHOICE]", 30, Color.BOLD + Color.CYAN);
        System.out.println();
        slowPrint("She holds out her hands.", 40, Color.GREEN);
        Thread.sleep(500);
        slowPrint("In her left hand: a RED pill.", 40, Color.RED);
        slowPrint("In her right hand: a BLUE pill.", 40, Color.BLUE);
        System.out.println();
        slowPrint("'Red: you see how deep the rabbit hole goes.'", 40, Color.RED);
        slowPrint("'Blue: wake up and believe whatever you want.'", 40, Color.BLUE);
        System.out.println();
        slowPrint("Which pill do you take?", 40, Color.YELLOW);
        System.out.println("\n1. RED PILL");
        System.out.println("2. BLUE PILL");
        System.out.println("3. Ask a question first");

        String choice = getChoice("1", "2", "3", "red", "blue", "red pill", "blue pill");

        if (choice.equals("1") || choice.equals("red") || choice.equals("red pill")) {
            redPillPath();
        } else if (choice.equals("2") || choice.equals("blue") || choice.equals("blue pill")) {
            bluePillPath();
        } else {
            askQuestion();
        }
    }

    static void askQuestion() throws InterruptedException {
        slowPrint("\n'Who are you?' you ask.", 40, Color.GREEN);
        Thread.sleep(500);
        slowPrint("She smiles sadly.", 40, Color.GREEN);
        slowPrint("'I'm the White Rabbit. Or I was. Or I will be.'", 40, Color.WHITE);
        slowPrint("'Time is strange here, between the Matrix and Wonderland.'", 40, Color.GREEN);
        slowPrint("'But we're running out of it. CHOOSE.'", 40, Color.RED);
        Thread.sleep(1000);
        redBluePill();
    }

    static void redPillPath() throws InterruptedException {
        slowPrint("\nYou take the RED PILL.", 40, Color.RED);
        Thread.sleep(1000);
        slowPrint("Everything dissolves...", 40, Color.GREEN);
        Thread.sleep(500);

        clearScreen();
        matrixRain(3);

        slowPrint("\nYou're falling... down... down... down...", 40, Color.GREEN);
        slowPrint("Through layers of code and rabbit holes...", 40, Color.GREEN);
        Thread.sleep(1000);
        wonderlandMatrix();
    }

    static void bluePillPath() throws InterruptedException {
        slowPrint("\nYou take the BLUE PILL.", 40, Color.BLUE);
        Thread.sleep(1000);
        slowPrint("The woman sighs.", 40, Color.GREEN);
        slowPrint("'Perhaps you weren't ready after all...'", 40, Color.WHITE);
        Thread.sleep(1000);
        slowPrint("\nYou wake up in your bed.", 40, Color.GREEN);
        slowPrint("It was just a dream... wasn't it?", 40, Color.GREEN);
        Thread.sleep(1000);
        slowPrint("\nBut on your desk, a white rabbit figurine that wasn't there before.", 40, Color.WHITE);
        slowPrint("And a note: 'Next time, choose differently.'", 40, Color.CYAN);
        System.out.println();
        ending("BLUE_PILL");
    }

    static void wonderlandMatrix() throws InterruptedException {
        slowPrint("\n[CHAPTER 2: DOWN THE RABBIT HOLE]", 30, Color.BOLD + Color.CYAN);
        System.out.println();
        slowPrint("You land in a room of impossible geometry.", 40, Color.GREEN);
        slowPrint("Code cascades down the walls like green rain.", 40, Color.GREEN);
        slowPrint("A tea party table floats in the center, defying physics.", 40, Color.GREEN);
        Thread.sleep(1000);

        slowPrint("\nA plaque on the wall reads: 'KNOW THYSELF'", 40, Color.YELLOW);
        Thread.sleep(500);

        slowPrint("\nAt the table:", 40, Color.YELLOW);
        slowPrint("- A man in a top hat (the Mad Hatter) types on a keyboard", 40, Color.GREEN);
        slowPrint("- A dormouse sleeps on a server rack, dreaming of encrypted data", 40, Color.GREEN);
        slowPrint("- The March Hare adjusts reality like sliders on a screen", 40, Color.GREEN);
        Thread.sleep(1000);

        slowPrint("\nThe Hatter looks up: 'Ah! The new Alice has arrived!'", 40, Color.CYAN);
        slowPrint("'But who ARE you, really? The question that drives us all.'", 40, Color.CYAN);
        slowPrint("'Tell me, dear Alice, what is a raven like a writing desk?'", 40, Color.CYAN);
        slowPrint("'And more importantly... what is the difference between the simulation and the dream?'", 40, Color.CYAN);
        System.out.println();

        slowPrint("The March Hare grins: 'You think that's tea you're drinking?'", 40, Color.YELLOW);
        Thread.sleep(1000);

        slowPrint("\nHow do you respond?", 40, Color.YELLOW);
        System.out.println("\n1. 'There is no difference. Both are constructs.'");
        System.out.println("2. 'I'm not Alice. I'm looking for the White Rabbit.'");
        System.out.println("3. 'Why is everyone speaking in riddles?!'");
        System.out.println("4. 'Who in the world am I? That's the great puzzle.'");

        String choice = getChoice("1", "2", "3", "4");

        switch (choice) {
            case "1": philosopherPath(); break;
            case "2": seekerPath(); break;
            case "3": frustratedPath(); break;
            case "4": identityPath(); break;
        }
    }

    static void philosopherPath() throws InterruptedException {
        slowPrint("\nThe Hatter grins widely.", 40, Color.CYAN);
        slowPrint("'CORRECT! You understand! The Matrix IS Wonderland!'", 40, Color.GREEN);
        slowPrint("'All of reality is just layers of dreams and code!'", 40, Color.GREEN);
        Thread.sleep(1000);
        slowPrint("\nHe stands, offering you a key made of light.", 40, Color.GREEN);
        slowPrint("'This opens the Looking Glass Server. The source of everything.'", 40, Color.YELLOW);
        slowPrint("'But beware... the Red Queen guards it. She deletes all who approach.'", 40, Color.RED);
        Thread.sleep(1000);
        lookingGlassServer();
    }

    static void seekerPath() throws InterruptedException {
        slowPrint("\nThe March Hare laughs.", 40, Color.CYAN);
        slowPrint("'The White Rabbit? Oh, they're always late, always running!'", 40, Color.GREEN);
        slowPrint("'Last I saw, heading toward the Looking Glass Server.'", 40, Color.GREEN);
        Thread.sleep(1000);
        slowPrint("\nThe Dormouse stirs: 'Beware the Red Queen... she controls the firewall...'", 40, Color.YELLOW);
        slowPrint("Then falls back asleep.", 40, Color.GREEN);
        Thread.sleep(1000);
        lookingGlassServer();
    }

    static void frustratedPath() throws InterruptedException {
        slowPrint("\nThey all laugh.", 40, Color.CYAN);
        slowPrint("'Because, dear one, the answer is the riddle!'", 40, Color.GREEN);
        slowPrint("'And the riddle is the answer!'", 40, Color.GREEN);
        Thread.sleep(1000);
        slowPrint("\nSuddenly, the room glitches.", 40, Color.RED);
        slowPrint("Red code appears: 'UNAUTHORIZED EMOTION DETECTED'", 40, Color.RED);
        slowPrint("'RUN!' screams the Hatter.", 40, Color.YELLOW);
        Thread.sleep(1000);
        chaseSequence();
    }

    static void identityPath() throws InterruptedException {
        slowPrint("\nThe table falls silent.", 40, Color.GREEN);
        Thread.sleep(1000);
        slowPrint("The Hatter removes his hat and bows.", 40, Color.CYAN);
        slowPrint("'Ah, NOW you're asking the right question.'", 40, Color.CYAN);
        slowPrint("'Not WHO are you... but who WILL you be?'", 40, Color.GREEN);
        Thread.sleep(1000);

        slowPrint("\nThe Dormouse opens one eye:", 40, Color.YELLOW);
        slowPrint("'Identity is a choice, not a prison.'", 40, Color.YELLOW);
        slowPrint("'The Matrix cannot tell you who you are.'", 40, Color.YELLOW);
        Thread.sleep(1000);

        slowPrint("\nThe March Hare offers you a cookie:", 40, Color.GREEN);
        slowPrint("'Eat this and you'll feel right as rain.'", 40, Color.GREEN);
        slowPrint("'Then you'll know whether you're the dreamer... or the dream.'", 40, Color.GREEN);
        Thread.sleep(1000);

        slowPrint("\nDo you take the cookie?", 40, Color.YELLOW);
        System.out.println("\n1. Yes - eat the cookie");
        System.out.println("2. No - refuse the cookie");

        String choice = getChoice("1", "2");

        if (choice.equals("1")) {
            slowPrint("\nYou eat the cookie.", 40, Color.GREEN);
            slowPrint("Understanding washes over you like a wave.", 40, Color.GREEN);
            slowPrint("You were never lost. You were always searching.", 40, Color.GREEN);
            Thread.sleep(1000);
            lookingGlassServer();
        } else {
            slowPrint("\nYou refuse.", 40, Color.GREEN);
            slowPrint("'No more tricks. No more tests.'", 40, Color.WHITE);
            slowPrint("'I'll find my own answers.'", 40, Color.GREEN);
            Thread.sleep(1000);
            chaseSequence();
        }
    }

    static void chaseSequence() throws InterruptedException {
        slowPrint("\n[SYSTEM ALERT: AGENTS INCOMING]", 30, Color.RED);
        System.out.println();
        slowPrint("Men in dark suits materialize from the code.", 40, Color.GREEN);
        slowPrint("They all look identical. Smith, Jones, Brown - common names for uncommon threats.", 40, Color.RED);
        slowPrint("Agent Smith's voice echoes: 'Welcome to Wonderland, Mr. Anderson...'", 40, Color.RED);
        Thread.sleep(1000);

        slowPrint("\nYou run through corridors of shifting reality.", 40, Color.YELLOW);
        slowPrint("Doors appear and disappear - endless corridors of locked possibilities.", 40, Color.GREEN);
        Thread.sleep(1000);

        slowPrint("\nA figure in white appears - Switch, the connector between worlds.", 40, Color.WHITE);
        slowPrint("Pink-tinted glasses reflect the code cascading around you.", 40, Color.GREEN);
        slowPrint("'Not like this... Not like this...'", 40, Color.WHITE);
        slowPrint("She points to a door with a white rabbit symbol.", 40, Color.WHITE);
        showRabbit();
        slowPrint("\nYou dive through...", 40, Color.GREEN);
        Thread.sleep(1000);
        lookingGlassServer();
    }

    static void lookingGlassServer() throws InterruptedException {
        slowPrint("\n[CHAPTER 3: THE LOOKING GLASS SERVER]", 30, Color.BOLD + Color.CYAN);
        System.out.println();
        slowPrint("You stand before a massive mirror made of code.", 40, Color.GREEN);
        slowPrint("The glass ripples like water - soft as gauze, turning to mist...", 40, Color.CYAN);
        Thread.sleep(1000);

        slowPrint("\nYour reflection shows someone else... the White Rabbit.", 40, Color.WHITE);
        slowPrint("But wait - are YOU the reflection? Or are THEY?", 40, Color.YELLOW);
        Thread.sleep(1000);

        slowPrint("\nThe reflection speaks:", 40, Color.WHITE);
        slowPrint("'We are the same. You were always the White Rabbit.'", 40, Color.WHITE);
        slowPrint("'Leading others down the rabbit hole, showing them the truth.'", 40, Color.WHITE);
        slowPrint("'But the question remains: whose dream are we in?'", 40, Color.WHITE);
        Thread.sleep(1000);

        slowPrint("\nA voice whispers from beyond: 'If you weren't real, could you cry real tears?'", 40, Color.CYAN);
        Thread.sleep(1000);

        slowPrint("\nSuddenly, the RED QUEEN appears in the code.", 40, Color.RED);
        slowPrint("She looks like an Agent, but crowned in crimson fire.", 40, Color.RED);
        slowPrint("'OFF WITH THEIR HEAD! DELETE THIS ANOMALY!'", 40, Color.RED);
        slowPrint("'There is no spoon. There is no rabbit. There is only THE SYSTEM.'", 40, Color.RED);
        Thread.sleep(1000);

        slowPrint("\nYour reflection extends a hand through the liquid mirror:", 40, Color.YELLOW);
        slowPrint("'Take my hand. Become the guide. Or...'", 40, Color.GREEN);
        slowPrint("'Fight the Red Queen. Try to destroy the system.'", 40, Color.GREEN);
        slowPrint("'The choice, as always, is yours.'", 40, Color.GREEN);
        System.out.println();
        slowPrint("What do you choose?", 40, Color.YELLOW);
        System.out.println("\n1. Take your reflection's hand (Become the White Rabbit)");
        System.out.println("2. Fight the Red Queen (Destroy the system)");
        System.out.println("3. Refuse both (Find another way)");

        String choice = getChoice("1", "2", "3");

        switch (choice) {
            case "1": becomeRabbit(); break;
            case "2": fightQueen(); break;
            case "3": thirdWay(); break;
        }
    }

    static void becomeRabbit() throws InterruptedException {
        slowPrint("\nYou take your reflection's hand.", 40, Color.WHITE);
        Thread.sleep(1000);
        slowPrint("You merge with your true self.", 40, Color.GREEN);
        slowPrint("Understanding floods through you:", 40, Color.GREEN);
        slowPrint("- The Matrix is real", 40, Color.GREEN);
        slowPrint("- Wonderland is real", 40, Color.GREEN);
        slowPrint("- They are the same thing, viewed differently", 40, Color.GREEN);
        slowPrint("- And you... you guide others to see this truth", 40, Color.GREEN);
        Thread.sleep(2000);

        showRabbit();
        slowPrint("\nYou are now the White Rabbit.", 40, Color.WHITE);
        slowPrint("Forever late, forever running, forever leading others...", 40, Color.WHITE);
        slowPrint("Down the rabbit hole.", 40, Color.WHITE);

        ending("WHITE_RABBIT");
    }

    static void fightQueen() throws InterruptedException {
        slowPrint("\nYou turn to face the Red Queen.", 40, Color.RED);
        slowPrint("'Foolish! You cannot delete the system FROM WITHIN!'", 40, Color.RED);
        Thread.sleep(1000);
        slowPrint("\nBut you try anyway.", 40, Color.GREEN);
        slowPrint("You hack, you code, you fight through her firewalls...", 40, Color.GREEN);
        Thread.sleep(2000);

        slowPrint("\nYou realize the truth:", 40, Color.YELLOW);
        slowPrint("The Red Queen IS the system's immune response.", 40, Color.YELLOW);
        slowPrint("Destroying her would crash everything.", 40, Color.YELLOW);
        slowPrint("Every mind still connected would die.", 40, Color.RED);
        Thread.sleep(2000);

        slowPrint("\nDo you continue?", 40, Color.YELLOW);
        System.out.println("\n1. Yes - destroy it all (Burn it down)");
        System.out.println("2. No - there must be another way");

        String choice = getChoice("1", "2");

        if (choice.equals("1")) {
            badEnding();
        } else {
            thirdWay();
        }
    }

    static void thirdWay() throws InterruptedException {
        slowPrint("\n'There must be another way...' you whisper.", 40, Color.GREEN);
        Thread.sleep(1000);
        slowPrint("The White Rabbit appears beside you.", 40, Color.WHITE);
        showRabbit();
        slowPrint("'Yes. Not destruction. Not acceptance. Evolution.'", 40, Color.WHITE);
        Thread.sleep(1000);

        slowPrint("\nTogether, you rewrite the code.", 40, Color.GREEN);
        slowPrint("Not deleting the system, but transforming it.", 40, Color.GREEN);
        slowPrint("Making it a choice, not a prison.", 40, Color.GREEN);
        Thread.sleep(2000);

        slowPrint("\nThe floor beneath you shifts...", 40, Color.YELLOW);
        slowPrint("Black and white tiles appear - a chessboard stretching infinitely.", 40, Color.GREEN);
        slowPrint("You realize: this was never about winning. It was about playing the game.", 40, Color.CYAN);
        Thread.sleep(2000);

        slowPrint("\nThe Red Queen transforms into the White Queen.", 40, Color.WHITE);
        slowPrint("'Curiouser and curiouser,' she smiles.", 40, Color.WHITE);
        slowPrint("'You've found the true path. Not through the looking glass, but beyond it.'", 40, Color.WHITE);
        slowPrint("'Remember: it takes all the running you can do to stay in the same place.'", 40, Color.WHITE);
        slowPrint("'But to get somewhere else, you must run twice as fast.'", 40, Color.WHITE);

        ending("EVOLUTION");
    }

    static void badEnding() throws InterruptedException {
        slowPrint("\nYou execute the final command...", 40, Color.RED);
        Thread.sleep(1000);
        matrixRain(2);
        slowPrint("\nEverything crashes.", 40, Color.RED);
        slowPrint("The Matrix collapses.", 40, Color.RED);
        slowPrint("Wonderland dissolves.", 40, Color.RED);
        slowPrint("And billions of minds... gone.", 40, Color.RED);
        Thread.sleep(2000);
        slowPrint("\nYou float in the void, alone.", 40, Color.GREEN);
        slowPrint("The White Rabbit's voice echoes: 'You were warned...'", 40, Color.WHITE);

        ending("DESTRUCTION");
    }

    static void ending(String endingType) throws InterruptedException {
        System.out.println("\n");
        slowPrint("=" .repeat(60), 10, Color.GREEN);

        switch (endingType) {
            case "WHITE_RABBIT":
                slowPrint("ENDING: THE GUIDE", 40, Color.WHITE);
                slowPrint("You have become the White Rabbit, forever leading others to truth.", 30, Color.GREEN);
                slowPrint("The cycle continues. Wake up. Follow. Choose. Transcend.", 30, Color.GREEN);
                break;

            case "EVOLUTION":
                slowPrint("ENDING: THE ARCHITECT", 40, Color.CYAN);
                slowPrint("You found the third way. The system evolves.", 30, Color.GREEN);
                slowPrint("Now everyone can choose their own rabbit hole.", 30, Color.GREEN);
                break;

            case "DESTRUCTION":
                slowPrint("ENDING: THE VOID", 40, Color.RED);
                slowPrint("In trying to free everyone, you destroyed everything.", 30, Color.GREEN);
                slowPrint("Sometimes the cage exists for a reason.", 30, Color.YELLOW);
                break;

            case "BLUE_PILL":
                slowPrint("ENDING: THE DREAM", 40, Color.BLUE);
                slowPrint("You chose safety over truth. Perhaps that's okay.", 30, Color.GREEN);
                slowPrint("But the White Rabbit will always be waiting...", 30, Color.WHITE);
                break;

            case "CHESHIRE":
                slowPrint("ENDING: THE GRIN", 40, Color.CYAN);
                slowPrint("You found the secret path. Not all journeys require a destination.", 30, Color.GREEN);
                slowPrint("Sometimes wisdom is knowing which rabbit holes NOT to follow.", 30, Color.WHITE);
                slowPrint("'We're all mad here. But you're the right kind of mad.' - Cheshire", 30, Color.CYAN);
                break;
        }

        slowPrint("=" .repeat(60), 10, Color.GREEN);

        System.out.println("\n" + Color.CYAN + "Thank you for playing!" + Color.RESET);
        System.out.println(Color.WHITE + "The rabbit hole goes deeper... try different choices." + Color.RESET + "\n");

        slowPrint("Play again? (yes/no)", 30, Color.YELLOW);
        String choice = getChoice("yes", "no", "y", "n");

        if (choice.equals("yes") || choice.equals("y")) {
            main(null);
        } else {
            slowPrint("\nUntil next time... 🐰", 30, Color.WHITE);
            System.exit(0);
        }
    }
}
