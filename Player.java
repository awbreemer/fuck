package edu.gonzaga;

import java.util.Scanner;



public class Player {
    private String name;
    private Hand passHand;
    private static final int NUMBER_OF_REROLLS_PER_TURN = 2;
    Scanner thisScanner = new Scanner (System.in);
    Scorecard playerCard = new Scorecard();
    private Scoreline menuSelect;
    private boolean firstTurn = true;

    public Player(Hand HandofDie){
        name = "Player 1";
        passHand = HandofDie;
    }

    public Player(String name, Hand HandofDie){
        this.name = name;
        passHand = HandofDie;
    }

    public void changeName(String name){
        this.name = name;
    }

    public void printName(){
        System.out.print(this.name);
    }

    /** method for what the player will do on their specific turn */
    public void takeTurn(){
        
        System.out.print("\n\n\n" + name + ", It's your turn!\n");
        if(!firstTurn){
            System.out.println("Your score card looks like this:\n\n" + playerCard);
        }
        firstTurn = false;
        passHand.rollAllDice();
        int takenRolls = 0;
        boolean YNArray[];
        while(takenRolls < NUMBER_OF_REROLLS_PER_TURN){
            passHand.printDice();
            System.out.println("\nWhich dice would you like to keep? e.g. 'YNNYN'         'Q' to quit game ");
            YNArray = convertYesNoToBool(thisScanner.nextLine());
            passHand.rerollHand(YNArray);
            takenRolls++;
        }
        passHand.printDice();
        playerCard.giveHand(passHand);
        do{
            do{
                System.out.println(playerCard + "Input the menu option for the score to apply:\n");
                menuSelect = playerCard.findLine(thisScanner.nextLine());
            }while(menuSelect == null);
            if(menuSelect.used == true){
                System.out.println("Choose an unused scoreline:");
            }
        }while(menuSelect.used);
        menuSelect.setScore();
    }


    /** takes the "ynyyn" input from the command line and converts to boolean array*/
    private boolean[] convertYesNoToBool(String inString){
        char[] charString = inString.toCharArray();
        boolean[] reRollArray = new boolean[passHand.getNumberOfDiceInHand()];
        for(int i = 0; i < passHand.getNumberOfDiceInHand(); i++){
            if ((charString[i] == 'Y') || (charString[i] == 'y')){
                reRollArray[i] = true;
            }
            else if(charString[i] == 'Q' || charString[i] == 'q'){
                System.exit(i);
            }
            else{
                reRollArray[i] = false;
            }
        }
        return(reRollArray);
    }

    public Boolean checkGameOver(){
        return(playerCard.checkGameOver());
    }
}
