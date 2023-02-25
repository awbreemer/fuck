/*Andrew Breemer */
package edu.gonzaga;

/**Class for keeping track of the three of a kind section of the scorecard */
public class ThreeOfAKind extends Scoreline {
    
    public ThreeOfAKind(){
        name = "Three of a Kind";
        used = false;
        menuOption = "3K";
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
            if(hand.getNumOfDiceN(i+1) >= 3){
                possibleScore = hand.countDice();
                calcMark = true;
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
