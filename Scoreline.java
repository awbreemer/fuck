/*Andrew Breemer */
package edu.gonzaga;

/**Abstract class to be the parent to all the scorelines child classes*/
abstract class Scoreline {
    String name;
    Integer score = 0;
    boolean used = false;
    Integer possibleScore;
    String menuOption;

    /** For passing the Hand to the class for it to evaluate possible scores */
    abstract void giveHand(Hand hand);

    /**For setting the possible score as score */
    abstract void setScore();

    /** For calculating the possible score for that line given a Hand */
    abstract void calcPScore(Hand hand);

    /**Prints the values held in the line in a readable way */
    abstract void printLine();
}
