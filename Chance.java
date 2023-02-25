/*Andrew Breemer */
package edu.gonzaga;
/** Class for keeping track of Chance score info for Yahtzee */
public class Chance extends Scoreline{

    public Chance(){
        name = "Chance";
        used = false;
        menuOption = "CH";
    }

    void printLine(){
        System.out.println(menuOption + " |  " + name + "currently has a score of " + score + "and a possible score of " + possibleScore + ".");
        
    }

    void giveHand(Hand hand){
        if(!used){
            calcPScore(hand);
        }
    }

    void calcPScore(Hand hand){
        possibleScore = hand.countDice();
    }

    void setScore(){
        score = possibleScore;
        used = true;
    }
}