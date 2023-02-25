/*Andrew Breemer */
package edu.gonzaga;

/**Class for keeping track of the Yahtzee scoreline for Yahtzee */
public class YahtzeeLine extends Scoreline {
    
    public YahtzeeLine(){
        name = "Yahtzee";
        used = false;
        menuOption = "YH";
    }

    void printLine(){
        System.out.println(menuOption + " |  " + name + "currently has a score of " + score + "and a possible score of " + possibleScore + ".");
    }

    void giveHand(Hand hand){
        if (!used){
            calcPScore(hand);
        }
    }

    void calcPScore(Hand hand){
        boolean calcMark = false;
        for(int i = 0; i < hand.getHandSize(); i++){
            if(hand.getNumOfDiceN(i+1) >= 5){
                calcMark = true;
                possibleScore = 50;
            }
        }
        if(!calcMark){
            possibleScore = 0;
        }
    }

    void setScore(){
        score = possibleScore;
        used = true;
    }
}