/*Andrew Breemer */
package edu.gonzaga;
/**Class for keeping track of the fours section in Yahtzee */
public class Fours extends TopSection{

    public Fours(){
        name = "Fours";
        menuOption = "4S";
    }

    @Override
    public void calcPScore(Hand hand){
        int dieNum = 4;
        possibleScore = hand.getNumOfDiceN(dieNum)*(dieNum);
    }
    
}
