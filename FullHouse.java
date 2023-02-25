/*Andrew Breemer */
package edu.gonzaga;
/**Class for keeping track of the full house scoreline in Yahtzee */
public class FullHouse extends Scoreline {
    
    public FullHouse(){
        name = "Full House";
        used = false;
        menuOption = "FH";
    }

    void printLine(){
        System.out.println(menuOption + " |  " + name + "currently has a score of " + score + "and a possible score of " + possibleScore + ".");
    }

    void giveHand(Hand hand){
        if (!used){
            calcPScore(hand);
        }
    }
    /** Given: Hand. Calculates possible score for FullHouse object */
    void calcPScore(Hand hand){
        //A full house is constituted of 1 set of a two of a kind and 1 three of a kind
        boolean twoOfAKindCheck = false;//keeps track of the existance of a 2 of a kind
        boolean threeOfAKindCheck = false;//keeps track of the existence of a 3 of a kind
        ///For loops through each die in hand to check how many of each dice there are
        for(int i = 0; i < hand.getHandSize(); i++){ 
            if(hand.getNumOfDiceN(i+1) >= 3){//Check for three of a kind
                threeOfAKindCheck = true;
            }
            else if(hand.getNumOfDiceN(i+1) >= 2){//Check for two of a kind
                twoOfAKindCheck = true;
            }
        }
        if(twoOfAKindCheck & threeOfAKindCheck){//If there is both then give score 25
            possibleScore = 25;
        }
        else{//Score of zero without full house
            possibleScore = 0;
        }
    }

    void setScore(){
        score = possibleScore;
        used = true;
    }
    
}
