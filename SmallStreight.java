/*Andrew Breemer */
package edu.gonzaga;

/**Class for keeping track of the small streight section of the scorecard */
public class SmallStreight extends Scoreline {
    
    public SmallStreight(){
        name = "Small Streight";
        used = false;
        menuOption = "SS";
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
        Integer streightCheck[] = hand.returnSortedDiceArray();
        int maxStreightLength = 1;
        Integer currentStreightLength = 1;
        Integer previousVal = streightCheck[0];
        ///loops through the die array in sorted order checking for current dice being 1 more than previous value
        for(Integer i : streightCheck){ 
            if((i-1) == previousVal){
                currentStreightLength++;
            }
            else if(i == previousVal){

            }
            else{
                if(currentStreightLength > maxStreightLength){
                    maxStreightLength = currentStreightLength;
                }
                currentStreightLength = 1;
            }
            previousVal = i;
        }
        if(currentStreightLength > maxStreightLength){
            maxStreightLength = currentStreightLength;
        }
        if(maxStreightLength >= 4){
            possibleScore =  30;
        }
        else{
            possibleScore = 0;
        }
    }

    void setScore(){
        score = possibleScore;
        used = true;
    }
}
