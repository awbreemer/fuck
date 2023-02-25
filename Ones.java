/*Andrew Breemer */
package edu.gonzaga;

/**Class for keeping track of the ones section in Yahtzee*/
public class Ones extends TopSection{

    public Ones(){
        name = "Ones";
        menuOption = "1S";
    }

    @Override
    public void calcPScore(Hand hand){
        int dieNum = 1;
        possibleScore = hand.getNumOfDiceN(dieNum)*(dieNum);
    }
    
}
