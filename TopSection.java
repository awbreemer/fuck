/*Andrew Breemer */
package edu.gonzaga;

/**Class to be inherited by all the top section classes which contains methods all the child classes will use */
public class TopSection extends Scoreline{

    public TopSection(){
        used = false;
    }

    public String toString(){
        return(menuOption + " |  " + name + "currently has a score of " + score + "and a possible score of " + possibleScore + ".");
    }

    public void printLine(){
        System.out.println(menuOption + " |  " + name + "currently has a score of " + score + "and a possible score of " + possibleScore + ".");
    }

    public void giveHand(Hand hand){
        if (!used){
            calcPScore(hand);
        }
    }

    public void calcPScore(Hand hand){
        
    }

    public void assignScore(Integer inScore){
        score = inScore;
        used = true;
    }

    public void setScore(){
        score = possibleScore;
        used = true;
    }


}
