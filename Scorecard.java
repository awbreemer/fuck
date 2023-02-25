/*Andrew Breemer */
package edu.gonzaga;

/**Class for keeping track and operating on both the upper and lower sections of the scorecard */
public class Scorecard {
    Hand hand;
    UpperScoreCard top = new UpperScoreCard();
    LowerScoreCard bottom = new LowerScoreCard();

    public Scorecard(){
         
    }
    /**Passes the hand to all of the scorelines */
    public void giveHand(Hand hand){
        this.hand = hand;
        top.giveHand(this.hand);
        bottom.giveHand(this.hand);
    }

    /** Returns the values of all the scorelines */
    public String toString(){
        String thisString = "";
        thisString = top.toString() + bottom.toString() + "\n";
        return(thisString);
    }

    /** Checks the usage of each scoreline, if all lines have been used returns true */
    public Boolean checkGameOver(){
        if(top.allUsed() && bottom.allUsed())
            return(true);
        else
            return(false);
    }

    /** Given the menuoption of a scoreline, returns the scoreline */
    public Scoreline findLine(String menuOption){
        if(top.findSection(menuOption) != null){
            return(top.findSection(menuOption));
        }
        else if(bottom.findSection(menuOption) != null){
            return(bottom.findSection(menuOption));
        }
        else{
            System.out.println("Error, need valid menu option, input again");
            return(null);
        }

    }

    /** Given a Scoreline, the possible score is applied the the actual score*/
    public void applyPScore(Scoreline line){
        line.setScore();
    }
    
    /** Method for testing, sets all lines to used and all scores to possible scores */
    public void useAllSetAll(){
        top.useAll();
        top.setAll();
        bottom.useAll();
        bottom.setAll();
    }

}
