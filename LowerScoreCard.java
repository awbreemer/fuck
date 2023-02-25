/*Andrew Breemer */
package edu.gonzaga;

/**Class for keeping track of all the lines on the lower scorecard */
public class LowerScoreCard {
    
    Scoreline upperSectionList[] =  {new ThreeOfAKind(), new FourOfAKind(), new FullHouse(), new SmallStreight(), new LargeStreight(), new YahtzeeLine(), new Chance()};

    public LowerScoreCard(){

    }

    /**Passes the hand to all the scorelines */
    public void giveHand(Hand hand){
        for(Scoreline i : upperSectionList){
            i.giveHand(hand);
        }
    }

    /**Returns true if all the scorelines in the lower card have been used */
    public Boolean allUsed(){
        for(Scoreline i : upperSectionList){
            if(i.used == false){
                return(false);
            }
        }
        return(true);
    }

    /** Sets all the scores of the scorelines to their current possible scores */
    public void setAll(){
        for(Scoreline i : upperSectionList){
            i.setScore();
        }
    }

    /** Sets all the used variables to true in each scoreline */
    public void useAll(){
        for(Scoreline i : upperSectionList){
            i.used = true;
        }
    }

    /**Sums the scores of all the scorelines */
    public Integer getScore(){
        Integer scoreCount = 0;
        for(Scoreline i : upperSectionList){
            scoreCount += i.score;
        }
        return(scoreCount);
    }

    /** Returns a list of scorelines with information about their menuOption, name, and score */
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
        return(currentString);
    }

    /** returns the scoreline of the input menuOption string if exists, otherwise returns null */
    public Scoreline findSection(String menuOption){
        Scoreline passingScoreline = null;
        for(Scoreline i : upperSectionList){
            if(menuOption.equals(i.menuOption)){
                passingScoreline = i;
            }
        }
        return(passingScoreline);
    }

    /**Given the index of where the line is held, returns the scoreline */
    public Scoreline getLine(Integer selectedLine){
        return(upperSectionList[selectedLine]);
    }

}
