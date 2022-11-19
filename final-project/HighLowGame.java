import java.util.Scanner;

//this version goes through Step 8 of the project
public class HighLowGame {
    public static void main(String[] args) {
        playGame();
    }

    public static void printInstrutions() {
        System.out.println("***************************************");
        System.out.println("*   Welcome to the High Low Game!     *");
        System.out.println("*   A card will be drawn randomly     *");
        System.out.println("*   from a standard 52 card deck and  *");
        System.out.println("*   you have to try to predict if     *");
        System.out.println("*   the next card drawn at random     *");
        System.out.println("*   will be higher or lower.          *");
        System.out.println("*                                     *");
        System.out.println("*   The card order (low to high):     *");
        System.out.println("*   2 3 . . . 10 J Q K A              *");
        System.out.println("*   and ties are broken by            *");
        System.out.println("*   clubs, diamonds, hearts, spades   *");
        System.out.println("*                                     *");
        System.out.println("*   Enter 'h' for higher              *");
        System.out.println("*   Enter 'l' for lower               *");
        System.out.println("***************************************");
    }

    public static void playGame() {
        CardDeck deck = new CardDeck();

        Scanner myscanner = new Scanner(System.in); // use myscanner.next() to get user input
        
        printInstrutions();

        // start the game by drawing a card at random and printing it to the terminal
        // System.out.println("Drawing a card at random . . . ");
        // write code here
        boolean guessedCorrect;
        Card currentCard = deck.pickCardatRandom();
        System.out.println(currentCard);
        // get player's guess using myscanner
        System.out.println("Will the next randomly drawn card be higher (h) or lower (l)?");
        // write code here
        String userSelection = myscanner.next();
        Card nextCard = deck.pickCardatRandom();
        System.out.println("Drawing a card at random . . . ");
        System.out.println(nextCard);

        if(userSelection == "h"){
            if(nextCard.value > currentCard.value){
                System.out.println("Congrats you guessed right!");
                guessedCorrect = true;
            }
            else{
                System.out.println("That's wrong. GAME OVER.");
                guessedCorrect = false;
            }
        }
        else{ //change to else if later when writing for potenital non h or l inputs
            if(nextCard.value < currentCard.value){
                System.out.println("Congrats you guessed right!");
                guessedCorrect = true;
            }
            else{
                System.out.println("That's wrong. GAME OVER.");
                guessedCorrect = false;
            }
        }

        do{
            System.out.println(currentCard);
            System.out.println("Will the next randomly drawn card be higher (h) or lower (l)?");
            //String userSelection = myscanner.next();
            //Card nextCard = deck.pickCardatRandom();
            System.out.println("Drawing a card at random . . . ");
            System.out.println(nextCard);

            if(userSelection == "h"){
                if(nextCard.value > currentCard.value){
                    System.out.println("Congrats you guessed right!");
                    nextCard = currentCard;
                }
                else{
                    System.out.println("That's wrong. GAME OVER.");
                }
            }
            else{
                if(nextCard.value < currentCard.value){
                    System.out.println("Congrats you guessed right!");
                    nextCard = currentCard;
                }
                else{
                    System.out.println("That's wrong. GAME OVER.");
                }
            }
        }while (guessedCorrect == true);

        myscanner.close();
    }
}
