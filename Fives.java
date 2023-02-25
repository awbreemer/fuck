/*Andrew Breemer */
package edu.gonzaga;
/**Class for keeping track of fives score in Yahtzee */
public class Fives extends TopSection{
    
    public Fives(){
        name = "Fives";
        menuOption = "5S";
    }

    @Override
    public void calcPScore(Hand hand){
        int dieNum = 5;
        possibleScore = hand.getNumOfDiceN(dieNum)*(dieNum);
    }
        
}
