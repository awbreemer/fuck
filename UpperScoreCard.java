/*Andrew Breemer */
package edu.gonzaga;

/**Class for keeping track of all the scorelines in the upper section of the scorcard */
public class UpperScoreCard {

    Integer BONUS_AMT = 35;
    boolean giveBonus;
    Scoreline upperSectionList[] =  {new Ones(), new Twos(), new Threes(), new Fours(), new Fives(), new Sixes()};

    public UpperScoreCard(){
        giveBonus = false;
    }

    /**Passes the hand to all the scorelines and also verifies whether the bonus should be awared */
    public void giveHand(Hand hand){
        for(Scoreline i : upperSectionList){
            i.giveHand(hand);
        }
        if(getScore() >= 63){
            giveBonus = true;
        }
    }

    /**Checks to see if all the scorelines have been used */
    public Boolean allUsed(){
        for(Scoreline i : upperSectionList){
            if(i.used == false){
                return(false);
            }
        }
        return(true);
    }

    /**Sets all the Scoreline scores to the possible score */
    public void setAll(){
        for(Scoreline i : upperSectionList){
            i.setScore();
        }
    }

    /**Sets all the used variabls in the Scorelines to true */
    public void useAll(){
        for(Scoreline i : upperSectionList){
            i.used = true;
        }
    }


    /** Sums the scores from all the scorelines in the upper section */
    public Integer getScore(){
        Integer scoreCount = 0;
        for(Scoreline i : upperSectionList){
            scoreCount += i.score;
        }
        if(giveBonus){
            return(scoreCount+35);
        }
        else{
            return(scoreCount);
        }
    }

    /**Writes out the status of each of the upper scorelines  */
    public String toString(){
        String currentString = "";
        for(Scoreline i : upperSectionList){
            if(!i.used){
                currentString += i.menuOption + " | " + i.name + " has a possible score of " + i.possibleScore + ".\n";
            }
            else{
                currentString += "\u001B[31m" + i.menuOption + " | " + i.name + " has a score of " + i.score + ".\n\u001B[37m";
            }
        }
        if(!giveBonus){
            currentString += "\u001B[31m Bonus not yet acheived\n\u001B[37m";
        }
        else{
            currentString += "\u001B[31m Bonus acheived\n\u001B[37m";
        }
        return(currentString);
    }
 
    /** Given a menu option in the upper scorecard, it returns the scoreline */
    public Scoreline findSection(String menuOption){
        Scoreline passingScoreline = null;
        for(Scoreline i : upperSectionList){
            if(menuOption.equals(i.menuOption)){
                passingScoreline = i;
            }
        }
        return(passingScoreline);
    }
    
    /** Given the index of a Scoreline in the upper Scorecard, returns the Scorecard */
    public Scoreline getLine(Integer selectedLine){
        return(upperSectionList[selectedLine]);
    }
    
}
