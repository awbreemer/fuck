/* (C)2021 */
package edu.gonzaga;

import java.util.Scanner;

/*
*  This is the main class for the Yahtzee project.
*  It really should just instantiate another class and run
*   a method of that other class.
*/
// import main.java.edu.gonzaga.Die;
// import main.java.edu.gonzaga.Hand;

/** Main program class for launching Yahtzee program. */
public class Yahtzee {
    public static void main(String[] args) {

        Scanner thisScanner = new Scanner(System.in);//Scanner for reading from the terminal 
        Player players[];
        Hand gameHand = new Hand();//One hand is shared between all the players
        System.out.println("\u001B[37m\u001B[0m\n");//Write out intro message
        System.out.println("************************************************************************");
        System.out.println(" *            Yahtzee by Andrew Breemer!                               *");
        System.out.println(" *                                Copyright: 2023                      *");
        System.out.println("************************************************************************");
        System.out.println("\n\nEnter the number of players:");
        int numPlayers = thisScanner.nextInt();//Get number of players and create array of players 
        thisScanner.nextLine();
        players = new Player[numPlayers];
        for(int i = 0; i < numPlayers; i++){//Instantiate each player with name and hand
            System.out.println("Enter your name: ");
            String name = thisScanner.nextLine();
            if(name.equals(""))
                players[i] = new Player(gameHand);
            else
                players[i] = new Player(name, gameHand);
        }
        do{//Play Yahtzee turn by turn untill all spaces on scorecard are used
            for(Player currentPlayer : players){
                currentPlayer.takeTurn();
                currentPlayer.checkGameOver();
            }
        }while(!players[0].checkGameOver());
        thisScanner.close();


      

        // Die die1 = new Die(6);
        // System.out.println(die1.getSideUp());
        // System.out.println("Now rolling our die!");
        // die1.roll();
        // System.out.println(die1.getSideUp());
        // System.out.println("Cool, huh?");

        // Hand hand1 = new Hand();
        // hand1.rollAllDice();
        // hand1.printDice();
        // hand1.rollDieN(3);
        // hand1.printDice();
        // System.out.println("the score of the dice in the hand is %2.0f");
        // System.out.print(hand1.countDice());

        

        // misspelled this word
    }


}
