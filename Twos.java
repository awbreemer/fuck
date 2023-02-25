/*Andrew Breemer */
package edu.gonzaga;

/**Class for keeping track of the twos scoreline in Yahtzee */
public class Twos extends TopSection{

    public Twos(){
        name = "Twos";
        menuOption = "2S";
    }

    @Override
    public void calcPScore(Hand hand){
        int dieNum = 2;
        possibleScore = hand.getNumOfDiceN(dieNum)*(dieNum);
    }
    
}
