/*Andrew Breemer */
package edu.gonzaga;
/** Class for keeping track of four of a kind score info in Yahtzee */
public class FourOfAKind extends Scoreline {
    
    public FourOfAKind(){
        name = "Four of a Kind";
        used = false;
        menuOption = "4K";
    }

    void printLine(){
        System.out.println(menuOption + " |  " + name + "currently has a score of " + score + "and a possible score of " + possibleScore + ".");
    }

    void giveHand(Hand hand){
        if (!used){
            calcPScore(hand);
        }
    }
    /** Calculates the possible score for a four of a kind when given a hand */
    void calcPScore(Hand hand){
        boolean calcMark = false;
        for(int i = 0; i < hand.getHandSize(); i++){//Loop through each of the values of dice
            if(hand.getNumOfDiceN(i+1) >= 4){//Find if there are value of dice with four or more
                calcMark = true;
                possibleScore = hand.countDice();//Worth the total value of dice if there are four of a kind
            }
        }
        if(!calcMark){
            possibleScore = 0;//Worth zero points if there is not four of a kind
        }
    }

    void setScore(){
        score = possibleScore;
        used = true;
    }
}
    
