#!/usr/bin/env python3
"""
Follow the White Rabbit - A Matrix x Alice in Wonderland Mystery Game
Run this in any command prompt/terminal
"""

import os
import sys
import time
import random

# ANSI color codes
class Color:
    GREEN = '\033[92m'
    RED = '\033[91m'
    BLUE = '\033[94m'
    WHITE = '\033[97m'
    CYAN = '\033[96m'
    YELLOW = '\033[93m'
    RESET = '\033[0m'
    BOLD = '\033[1m'

def clear_screen():
    os.system('cls' if os.name == 'nt' else 'clear')

def slow_print(text, delay=0.03, color=Color.GREEN):
    """Print text with typing effect"""
    for char in text:
        sys.stdout.write(color + char + Color.RESET)
        sys.stdout.flush()
        time.sleep(delay)
    print()

def matrix_rain(duration=2):
    """Simple matrix rain effect"""
    chars = "01アイウエオカキクケコ"
    for _ in range(duration * 10):
        line = ''.join(random.choice(chars) for _ in range(80))
        print(Color.GREEN + line[:80] + Color.RESET)
        time.sleep(0.1)

def show_rabbit():
    """Display ASCII white rabbit"""
    rabbit = f"""{Color.WHITE}
    (\\_/)
    (o.o)
    (> <)  {Color.BOLD}Follow me...{Color.RESET}
    """
    print(rabbit)
    time.sleep(1)

def get_choice(options):
    """Get player choice"""
    while True:
        choice = input(f"\n{Color.CYAN}> {Color.RESET}").strip().lower()
        if choice in options:
            return choice
        print(f"{Color.RED}Invalid choice. Try again.{Color.RESET}")

def intro():
    clear_screen()
    slow_print("=" * 60, 0.01)
    slow_print("FOLLOW THE WHITE RABBIT", 0.05, Color.WHITE)
    slow_print("A Mystery Beyond The Looking Glass", 0.03, Color.CYAN)
    slow_print("=" * 60, 0.01)
    print("\n")
    time.sleep(1)

    slow_print("You wake at your terminal. 3:33 AM.", 0.04)
    slow_print("A message blinks on your screen:", 0.04)
    time.sleep(0.5)
    print()
    slow_print("'Wake up, Neo... The Matrix has you...'", 0.05, Color.GREEN)
    slow_print("'Follow the White Rabbit.'", 0.05, Color.GREEN)
    print()
    time.sleep(1)

    slow_print("A knock at your door.", 0.04, Color.YELLOW)
    time.sleep(0.5)

def chapter_1():
    """The Knock"""
    slow_print("\n[CHAPTER 1: THE KNOCK]", 0.03, Color.BOLD + Color.CYAN)
    print()
    slow_print("You hear it again. Knock. Knock. Knock.", 0.04)
    slow_print("Do you open the door?", 0.04, Color.YELLOW)
    print("\n1. Open the door")
    print("2. Ignore it and check the message again")
    print("3. Look through the peephole")

    choice = get_choice(['1', '2', '3'])

    if choice == '1':
        return door_open()
    elif choice == '2':
        return check_message()
    else:
        return peephole()

def door_open():
    slow_print("\nYou open the door...", 0.04)
    time.sleep(1)
    slow_print("A woman with a white rabbit tattoo stands before you.", 0.04, Color.WHITE)
    show_rabbit()
    slow_print("'I'm late, I'm late,' she whispers urgently.", 0.04)
    slow_print("'They're watching. You need to choose. NOW.'", 0.04, Color.RED)
    time.sleep(0.5)
    return red_blue_pill()

def check_message():
    slow_print("\nYou return to your terminal.", 0.04)
    slow_print("The message has changed:", 0.04)
    time.sleep(0.5)
    slow_print("\n'Curiosity killed the cat, but you're late for a very important date.'", 0.04, Color.GREEN)
    slow_print("'Time is running out. 03:34 AM.'", 0.04, Color.GREEN)
    slow_print("'P.S. - Type CHESHIRE if you want to see how deep the rabbit hole really goes...'", 0.04, Color.GREEN)
    time.sleep(1)

    slow_print("\nDo you:", 0.04, Color.YELLOW)
    print("\n1. Answer the door")
    print("2. Type CHESHIRE")

    choice = get_choice(['1', '2', 'cheshire'])

    if choice in ['2', 'cheshire']:
        return cheshire_path()
    else:
        slow_print("\nThe knocking intensifies.", 0.04, Color.RED)
        slow_print("You should probably answer it...", 0.04)
        time.sleep(1)
        return door_open()

def cheshire_path():
    clear_screen()
    slow_print("\nYou type: CHESHIRE", 0.04, Color.CYAN)
    time.sleep(1)
    slow_print("\nThe screen flickers. Code swirls into the shape of a grinning cat.", 0.04, Color.CYAN)
    time.sleep(1)

    slow_print("\nA voice - neither male nor female - speaks:", 0.04, Color.CYAN)
    slow_print("'Well, well... someone who asks the right questions.'", 0.04, Color.CYAN)
    slow_print("'We're all mad here, you know. I'm mad. You're mad.'", 0.04, Color.CYAN)
    time.sleep(1)

    slow_print("\n'But let me tell you a secret...'", 0.04, Color.YELLOW)
    slow_print("'The rabbit hole, the pills, the choices - they're all part of the game.'", 0.04)
    slow_print("'But YOU... you can simply WAKE UP.'", 0.04, Color.GREEN)
    time.sleep(1)

    slow_print("\n'No pills. No rabbit. Just... wake up.'", 0.04, Color.WHITE)
    time.sleep(2)
    clear_screen()

    slow_print("\nYou open your eyes.", 0.04)
    slow_print("You're at your desk. Morning light streams through the window.", 0.04)
    slow_print("No Matrix. No Wonderland. Just reality.", 0.04)
    time.sleep(1)

    slow_print("\nBut on your screen, a message blinks:", 0.04, Color.CYAN)
    slow_print("'Most people only see what they expect to see. You saw more.'", 0.04, Color.CYAN)
    slow_print("'The question isn't WHERE you go... but WHY you go there.'", 0.04, Color.CYAN)
    time.sleep(1)

    slow_print("\nA grin fades from your screen - there one moment, gone the next.", 0.04, Color.CYAN)

    return ending("CHESHIRE")

def peephole():
    slow_print("\nYou peer through the peephole...", 0.04)
    time.sleep(1)
    slow_print("A white rabbit in a waistcoat checks a pocket watch.", 0.04, Color.WHITE)
    slow_print("Wait... that can't be real.", 0.04, Color.YELLOW)
    show_rabbit()
    time.sleep(1)
    slow_print("You blink. Now it's a woman with a rabbit tattoo.", 0.04)
    slow_print("She mouths: 'OPEN THE DOOR'", 0.04, Color.RED)
    time.sleep(1)
    return door_open()

def red_blue_pill():
    slow_print("\n[THE CHOICE]", 0.03, Color.BOLD + Color.CYAN)
    print()
    slow_print("She holds out her hands.", 0.04)
    time.sleep(0.5)
    slow_print("In her left hand: a RED pill.", 0.04, Color.RED)
    slow_print("In her right hand: a BLUE pill.", 0.04, Color.BLUE)
    print()
    slow_print("'Red: you see how deep the rabbit hole goes.'", 0.04, Color.RED)
    slow_print("'Blue: wake up and believe whatever you want.'", 0.04, Color.BLUE)
    print()
    slow_print("Which pill do you take?", 0.04, Color.YELLOW)
    print("\n1. RED PILL")
    print("2. BLUE PILL")
    print("3. Ask a question first")

    choice = get_choice(['1', '2', '3', 'red', 'blue', 'red pill', 'blue pill'])

    if choice in ['1', 'red', 'red pill']:
        return red_pill_path()
    elif choice in ['2', 'blue', 'blue pill']:
        return blue_pill_path()
    else:
        return ask_question()

def ask_question():
    slow_print("\n'Who are you?' you ask.", 0.04)
    time.sleep(0.5)
    slow_print("She smiles sadly.", 0.04)
    slow_print("'I'm the White Rabbit. Or I was. Or I will be.'", 0.04, Color.WHITE)
    slow_print("'Time is strange here, between the Matrix and Wonderland.'", 0.04)
    slow_print("'But we're running out of it. CHOOSE.'", 0.04, Color.RED)
    time.sleep(1)
    return red_blue_pill()

def red_pill_path():
    slow_print("\nYou take the RED PILL.", 0.04, Color.RED)
    time.sleep(1)
    slow_print("Everything dissolves...", 0.04)
    time.sleep(0.5)

    # Matrix effect
    clear_screen()
    matrix_rain(3)

    slow_print("\nYou're falling... down... down... down...", 0.04, Color.GREEN)
    slow_print("Through layers of code and rabbit holes...", 0.04, Color.GREEN)
    time.sleep(1)
    return wonderland_matrix()

def blue_pill_path():
    slow_print("\nYou take the BLUE PILL.", 0.04, Color.BLUE)
    time.sleep(1)
    slow_print("The woman sighs.", 0.04)
    slow_print("'Perhaps you weren't ready after all...'", 0.04, Color.WHITE)
    time.sleep(1)
    slow_print("\nYou wake up in your bed.", 0.04)
    slow_print("It was just a dream... wasn't it?", 0.04)
    time.sleep(1)
    slow_print("\nBut on your desk, a white rabbit figurine that wasn't there before.", 0.04, Color.WHITE)
    slow_print("And a note: 'Next time, choose differently.'", 0.04, Color.CYAN)
    print()
    return ending("BLUE_PILL")

def wonderland_matrix():
    slow_print("\n[CHAPTER 2: DOWN THE RABBIT HOLE]", 0.03, Color.BOLD + Color.CYAN)
    print()
    slow_print("You land in a room of impossible geometry.", 0.04)
    slow_print("Code cascades down the walls like green rain.", 0.04, Color.GREEN)
    slow_print("A tea party table floats in the center, defying physics.", 0.04)
    time.sleep(1)

    slow_print("\nA plaque on the wall reads: 'KNOW THYSELF'", 0.04, Color.YELLOW)
    time.sleep(0.5)

    slow_print("\nAt the table:", 0.04, Color.YELLOW)
    slow_print("- A man in a top hat (the Mad Hatter) types on a keyboard", 0.04)
    slow_print("- A dormouse sleeps on a server rack, dreaming of encrypted data", 0.04)
    slow_print("- The March Hare adjusts reality like sliders on a screen", 0.04)
    time.sleep(1)

    slow_print("\nThe Hatter looks up: 'Ah! The new Alice has arrived!'", 0.04, Color.CYAN)
    slow_print("'But who ARE you, really? The question that drives us all.'", 0.04, Color.CYAN)
    slow_print("'Tell me, dear Alice, what is a raven like a writing desk?'", 0.04, Color.CYAN)
    slow_print("'And more importantly... what is the difference between the simulation and the dream?'", 0.04, Color.CYAN)
    print()

    slow_print("The March Hare grins: 'You think that's tea you're drinking?'", 0.04, Color.YELLOW)
    time.sleep(1)

    slow_print("\nHow do you respond?", 0.04, Color.YELLOW)
    print("\n1. 'There is no difference. Both are constructs.'")
    print("2. 'I'm not Alice. I'm looking for the White Rabbit.'")
    print("3. 'Why is everyone speaking in riddles?!'")
    print("4. 'Who in the world am I? That's the great puzzle.'")

    choice = get_choice(['1', '2', '3', '4'])

    if choice == '1':
        return philosopher_path()
    elif choice == '2':
        return seeker_path()
    elif choice == '3':
        return frustrated_path()
    else:
        return identity_path()

def philosopher_path():
    slow_print("\nThe Hatter grins widely.", 0.04, Color.CYAN)
    slow_print("'CORRECT! You understand! The Matrix IS Wonderland!'", 0.04, Color.GREEN)
    slow_print("'All of reality is just layers of dreams and code!'", 0.04)
    time.sleep(1)
    slow_print("\nHe stands, offering you a key made of light.", 0.04)
    slow_print("'This opens the Looking Glass Server. The source of everything.'", 0.04, Color.YELLOW)
    slow_print("'But beware... the Red Queen guards it. She deletes all who approach.'", 0.04, Color.RED)
    time.sleep(1)
    return looking_glass_server()

def seeker_path():
    slow_print("\nThe March Hare laughs.", 0.04, Color.CYAN)
    slow_print("'The White Rabbit? Oh, they're always late, always running!'", 0.04)
    slow_print("'Last I saw, heading toward the Looking Glass Server.'", 0.04)
    time.sleep(1)
    slow_print("\nThe Dormouse stirs: 'Beware the Red Queen... she controls the firewall...'", 0.04, Color.YELLOW)
    slow_print("Then falls back asleep.", 0.04)
    time.sleep(1)
    return looking_glass_server()

def frustrated_path():
    slow_print("\nThey all laugh.", 0.04, Color.CYAN)
    slow_print("'Because, dear one, the answer is the riddle!'", 0.04)
    slow_print("'And the riddle is the answer!'", 0.04)
    time.sleep(1)
    slow_print("\nSuddenly, the room glitches.", 0.04, Color.RED)
    slow_print("Red code appears: 'UNAUTHORIZED EMOTION DETECTED'", 0.04, Color.RED)
    slow_print("'RUN!' screams the Hatter.", 0.04, Color.YELLOW)
    time.sleep(1)
    return chase_sequence()

def identity_path():
    slow_print("\nThe table falls silent.", 0.04)
    time.sleep(1)
    slow_print("The Hatter removes his hat and bows.", 0.04, Color.CYAN)
    slow_print("'Ah, NOW you're asking the right question.'", 0.04, Color.CYAN)
    slow_print("'Not WHO are you... but who WILL you be?'", 0.04)
    time.sleep(1)

    slow_print("\nThe Dormouse opens one eye:", 0.04, Color.YELLOW)
    slow_print("'Identity is a choice, not a prison.'", 0.04, Color.YELLOW)
    slow_print("'The Matrix cannot tell you who you are.'", 0.04, Color.YELLOW)
    time.sleep(1)

    slow_print("\nThe March Hare offers you a cookie:", 0.04)
    slow_print("'Eat this and you'll feel right as rain.'", 0.04, Color.GREEN)
    slow_print("'Then you'll know whether you're the dreamer... or the dream.'", 0.04)
    time.sleep(1)

    slow_print("\nDo you take the cookie?", 0.04, Color.YELLOW)
    print("\n1. Yes - eat the cookie")
    print("2. No - refuse the cookie")

    choice = get_choice(['1', '2'])

    if choice == '1':
        slow_print("\nYou eat the cookie.", 0.04)
        slow_print("Understanding washes over you like a wave.", 0.04, Color.GREEN)
        slow_print("You were never lost. You were always searching.", 0.04)
        time.sleep(1)
        return looking_glass_server()
    else:
        slow_print("\nYou refuse.", 0.04)
        slow_print("'No more tricks. No more tests.'", 0.04, Color.WHITE)
        slow_print("'I'll find my own answers.'", 0.04)
        time.sleep(1)
        return chase_sequence()

def chase_sequence():
    slow_print("\n[SYSTEM ALERT: AGENTS INCOMING]", 0.03, Color.RED)
    print()
    slow_print("Men in dark suits materialize from the code.", 0.04)
    slow_print("They all look identical. Smith, Jones, Brown - common names for uncommon threats.", 0.04, Color.RED)
    slow_print("Agent Smith's voice echoes: 'Welcome to Wonderland, Mr. Anderson...'", 0.04, Color.RED)
    time.sleep(1)

    slow_print("\nYou run through corridors of shifting reality.", 0.04, Color.YELLOW)
    slow_print("Doors appear and disappear - endless corridors of locked possibilities.", 0.04)
    time.sleep(1)

    slow_print("\nA figure in white appears - Switch, the connector between worlds.", 0.04, Color.WHITE)
    slow_print("Pink-tinted glasses reflect the code cascading around you.", 0.04)
    slow_print("'Not like this... Not like this...'", 0.04, Color.WHITE)
    slow_print("She points to a door with a white rabbit symbol.", 0.04, Color.WHITE)
    show_rabbit()
    slow_print("\nYou dive through...", 0.04)
    time.sleep(1)
    return looking_glass_server()

def looking_glass_server():
    slow_print("\n[CHAPTER 3: THE LOOKING GLASS SERVER]", 0.03, Color.BOLD + Color.CYAN)
    print()
    slow_print("You stand before a massive mirror made of code.", 0.04)
    slow_print("The glass ripples like water - soft as gauze, turning to mist...", 0.04, Color.CYAN)
    time.sleep(1)

    slow_print("\nYour reflection shows someone else... the White Rabbit.", 0.04, Color.WHITE)
    slow_print("But wait - are YOU the reflection? Or are THEY?", 0.04, Color.YELLOW)
    time.sleep(1)

    slow_print("\nThe reflection speaks:", 0.04, Color.WHITE)
    slow_print("'We are the same. You were always the White Rabbit.'", 0.04, Color.WHITE)
    slow_print("'Leading others down the rabbit hole, showing them the truth.'", 0.04, Color.WHITE)
    slow_print("'But the question remains: whose dream are we in?'", 0.04, Color.WHITE)
    time.sleep(1)

    slow_print("\nA voice whispers from beyond: 'If you weren't real, could you cry real tears?'", 0.04, Color.CYAN)
    time.sleep(1)

    slow_print("\nSuddenly, the RED QUEEN appears in the code.", 0.04, Color.RED)
    slow_print("She looks like an Agent, but crowned in crimson fire.", 0.04, Color.RED)
    slow_print("'OFF WITH THEIR HEAD! DELETE THIS ANOMALY!'", 0.04, Color.RED)
    slow_print("'There is no spoon. There is no rabbit. There is only THE SYSTEM.'", 0.04, Color.RED)
    time.sleep(1)

    slow_print("\nYour reflection extends a hand through the liquid mirror:", 0.04, Color.YELLOW)
    slow_print("'Take my hand. Become the guide. Or...'", 0.04)
    slow_print("'Fight the Red Queen. Try to destroy the system.'", 0.04)
    slow_print("'The choice, as always, is yours.'", 0.04)
    print()
    slow_print("What do you choose?", 0.04, Color.YELLOW)
    print("\n1. Take your reflection's hand (Become the White Rabbit)")
    print("2. Fight the Red Queen (Destroy the system)")
    print("3. Refuse both (Find another way)")

    choice = get_choice(['1', '2', '3'])

    if choice == '1':
        return become_rabbit()
    elif choice == '2':
        return fight_queen()
    else:
        return third_way()

def become_rabbit():
    slow_print("\nYou take your reflection's hand.", 0.04, Color.WHITE)
    time.sleep(1)
    slow_print("You merge with your true self.", 0.04, Color.GREEN)
    slow_print("Understanding floods through you:", 0.04)
    slow_print("- The Matrix is real", 0.04, Color.GREEN)
    slow_print("- Wonderland is real", 0.04, Color.GREEN)
    slow_print("- They are the same thing, viewed differently", 0.04, Color.GREEN)
    slow_print("- And you... you guide others to see this truth", 0.04, Color.GREEN)
    time.sleep(2)

    show_rabbit()
    slow_print("\nYou are now the White Rabbit.", 0.04, Color.WHITE)
    slow_print("Forever late, forever running, forever leading others...", 0.04, Color.WHITE)
    slow_print("Down the rabbit hole.", 0.04, Color.WHITE)

    return ending("WHITE_RABBIT")

def fight_queen():
    slow_print("\nYou turn to face the Red Queen.", 0.04, Color.RED)
    slow_print("'Foolish! You cannot delete the system FROM WITHIN!'", 0.04, Color.RED)
    time.sleep(1)
    slow_print("\nBut you try anyway.", 0.04)
    slow_print("You hack, you code, you fight through her firewalls...", 0.04, Color.GREEN)
    time.sleep(2)

    slow_print("\nYou realize the truth:", 0.04, Color.YELLOW)
    slow_print("The Red Queen IS the system's immune response.", 0.04, Color.YELLOW)
    slow_print("Destroying her would crash everything.", 0.04, Color.YELLOW)
    slow_print("Every mind still connected would die.", 0.04, Color.RED)
    time.sleep(2)

    slow_print("\nDo you continue?", 0.04, Color.YELLOW)
    print("\n1. Yes - destroy it all (Burn it down)")
    print("2. No - there must be another way")

    choice = get_choice(['1', '2'])

    if choice == '1':
        return bad_ending()
    else:
        return third_way()

def third_way():
    slow_print("\n'There must be another way...' you whisper.", 0.04)
    time.sleep(1)
    slow_print("The White Rabbit appears beside you.", 0.04, Color.WHITE)
    show_rabbit()
    slow_print("'Yes. Not destruction. Not acceptance. Evolution.'", 0.04, Color.WHITE)
    time.sleep(1)

    slow_print("\nTogether, you rewrite the code.", 0.04, Color.GREEN)
    slow_print("Not deleting the system, but transforming it.", 0.04, Color.GREEN)
    slow_print("Making it a choice, not a prison.", 0.04, Color.GREEN)
    time.sleep(2)

    slow_print("\nThe floor beneath you shifts...", 0.04, Color.YELLOW)
    slow_print("Black and white tiles appear - a chessboard stretching infinitely.", 0.04)
    slow_print("You realize: this was never about winning. It was about playing the game.", 0.04, Color.CYAN)
    time.sleep(2)

    slow_print("\nThe Red Queen transforms into the White Queen.", 0.04, Color.WHITE)
    slow_print("'Curiouser and curiouser,' she smiles.", 0.04, Color.WHITE)
    slow_print("'You've found the true path. Not through the looking glass, but beyond it.'", 0.04, Color.WHITE)
    slow_print("'Remember: it takes all the running you can do to stay in the same place.'", 0.04, Color.WHITE)
    slow_print("'But to get somewhere else, you must run twice as fast.'", 0.04, Color.WHITE)

    return ending("EVOLUTION")

def bad_ending():
    slow_print("\nYou execute the final command...", 0.04, Color.RED)
    time.sleep(1)
    matrix_rain(2)
    slow_print("\nEverything crashes.", 0.04, Color.RED)
    slow_print("The Matrix collapses.", 0.04, Color.RED)
    slow_print("Wonderland dissolves.", 0.04, Color.RED)
    slow_print("And billions of minds... gone.", 0.04, Color.RED)
    time.sleep(2)
    slow_print("\nYou float in the void, alone.", 0.04)
    slow_print("The White Rabbit's voice echoes: 'You were warned...'", 0.04, Color.WHITE)

    return ending("DESTRUCTION")

def ending(ending_type):
    print("\n")
    slow_print("=" * 60, 0.01)

    if ending_type == "WHITE_RABBIT":
        slow_print("ENDING: THE GUIDE", 0.04, Color.WHITE)
        slow_print("You have become the White Rabbit, forever leading others to truth.", 0.03)
        slow_print("The cycle continues. Wake up. Follow. Choose. Transcend.", 0.03, Color.GREEN)

    elif ending_type == "EVOLUTION":
        slow_print("ENDING: THE ARCHITECT", 0.04, Color.CYAN)
        slow_print("You found the third way. The system evolves.", 0.03)
        slow_print("Now everyone can choose their own rabbit hole.", 0.03, Color.GREEN)

    elif ending_type == "DESTRUCTION":
        slow_print("ENDING: THE VOID", 0.04, Color.RED)
        slow_print("In trying to free everyone, you destroyed everything.", 0.03)
        slow_print("Sometimes the cage exists for a reason.", 0.03, Color.YELLOW)

    elif ending_type == "BLUE_PILL":
        slow_print("ENDING: THE DREAM", 0.04, Color.BLUE)
        slow_print("You chose safety over truth. Perhaps that's okay.", 0.03)
        slow_print("But the White Rabbit will always be waiting...", 0.03, Color.WHITE)

    elif ending_type == "CHESHIRE":
        slow_print("ENDING: THE GRIN", 0.04, Color.CYAN)
        slow_print("You found the secret path. Not all journeys require a destination.", 0.03)
        slow_print("Sometimes wisdom is knowing which rabbit holes NOT to follow.", 0.03, Color.WHITE)
        slow_print("'We're all mad here. But you're the right kind of mad.' - Cheshire", 0.03, Color.CYAN)

    slow_print("=" * 60, 0.01)

    print(f"\n{Color.CYAN}Thank you for playing!{Color.RESET}")
    print(f"{Color.WHITE}The rabbit hole goes deeper... try different choices.{Color.RESET}\n")

    # Replay option
    slow_print("Play again? (yes/no)", 0.03, Color.YELLOW)
    choice = get_choice(['yes', 'no', 'y', 'n'])

    if choice in ['yes', 'y']:
        main()
    else:
        slow_print("\nUntil next time... 🐰", 0.03, Color.WHITE)
        sys.exit(0)

def main():
    try:
        intro()
        chapter_1()
    except KeyboardInterrupt:
        print(f"\n\n{Color.YELLOW}The White Rabbit scurries away...{Color.RESET}")
        print(f"{Color.WHITE}Come back soon. 🐰{Color.RESET}\n")
        sys.exit(0)

if __name__ == "__main__":
    main()
