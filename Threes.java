/*Andrew Breemer */
package edu.gonzaga;

/**Class for keeping track of the threes section of the scorecard for Yahtzee */
public class Threes extends TopSection{

    public Threes(){
        name = "Threes";
        menuOption = "3S";
    }

    @Override
    public void calcPScore(Hand hand){
        int dieNum = 3;
        possibleScore = hand.getNumOfDiceN(dieNum)*(dieNum);
    }
    
}
