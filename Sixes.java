/*Andrew Breemer */
package edu.gonzaga;

/**Class for keeping track of the sixes section of the scorecard */
public class Sixes extends TopSection{

    public Sixes(){
        name = "Sixes";
        menuOption = "6S";
    }

    @Override
    public void calcPScore(Hand hand){
        int dieNum = 6;
        possibleScore = hand.getNumOfDiceN(dieNum)*(dieNum);
    }
    
}
