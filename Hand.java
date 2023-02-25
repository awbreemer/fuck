/*Andrew Breemer*/
package edu.gonzaga;



/* class for using and rolling multiple dice */

public class Hand {
    private static final Integer DEFAULT_HAND_SIZE = 5;
    private Die dieArray[] = new Die[DEFAULT_HAND_SIZE];
    private Integer numberOfDice;

    public Hand(){
        for(int i = 0; i < DEFAULT_HAND_SIZE; i++){
            dieArray[i] = new Die();
        }
        numberOfDice = DEFAULT_HAND_SIZE;
    }
    
    public Hand(Integer handSize){
        Die dieArray[] = new Die[handSize];
        for(int i = 0; i < handSize; i++){
            dieArray[i] = new Die();
        }
        numberOfDice = handSize;
    }

    /** Returns the number of dice in the hand array */
    public int getHandSize(){
        return(numberOfDice);
    }

    /**Method to get the value of side up with a specific die in the array */
    public Integer returnDieNum(int dieNum){
        return(dieArray[dieNum].getSideUp());
    }

    /**Method to roll all the dice at once */
    public void rollAllDice(){
        for(Die i : dieArray){
            i.roll();
        }
    }

    /**Given an array of dice value, each value gets assigned to be the side up of one of the dice in hand */
    public void assignDice(Integer[] diceVals){
        int j = 0;
        for(Integer i : diceVals){
            dieArray[j].assign(i);
            j++;
        }
    }

    /**Takes the index of a certain dice to be rerolled and rerolls only that dice */
        ///ALREADY WROTE THIS FUNCTION, CHECK FOR USAGE OF BOTH AND REMOVE
    public void rollDieN(int i){
        dieArray[i].roll();
    }
    public void rollDieN(int i,int seed){
        dieArray[i].roll(seed);
    }

    /** Returns an array containing with each value being the side up of a dice in the hand */
    public Integer[] getDieVals(){
        int j = 0;
        Integer dieValArray[] = new Integer[DEFAULT_HAND_SIZE];
        for(Die i : dieArray){
            dieValArray[j] = i.getSideUp();
            j++;
        }
        return(dieValArray);
    }

    /** Returns the sum of all of the sides up of dice in the hand */
    public Integer countDice(){
        Integer scoreOut = 0;
        for(Die i : dieArray){
            scoreOut += i.getSideUp();
        }
        return(scoreOut);
    }

    /** Rerolls a specific dice N in the hand array */
        ///ALREADY WROTE THIS FUNCTION, CHECK FOR USAGE OF BOTH AND REMOVE
    public void rerollDie(Integer dieNum){
        dieArray[dieNum].roll();
    }

    /**Takes in a arry of booleans and rolls the dice associated with true and passes the dice that are false */
    public void rerollHand(boolean[] selectedDice){
        for(int i = 0; i < numberOfDice; i++){
            if(selectedDice[i] == false){
                rollDieN(i);
            }
        }
    }
    public void rerollHand(boolean[] selectedDice,int seed){
        for(int i = 0; i < numberOfDice; i++){
            if(selectedDice[i] == false){
                rollDieN(i,seed);
            }
        }
    }

    /**Prints the side up of each of the die */
    public void printDice(){
        System.out.println();
        for(Die i : dieArray){
            System.out.print(i.getSideUp()+" ");
        }
        System.out.println();
    }


    // IN: Die side up of interest
    // Out: Number of dice that have that side of interest up 
    public int getNumOfDiceN(int N){
        int numOfDiceN = 0;
        for(Die i : dieArray){
            if(i.getSideUp() == N){
                numOfDiceN++;
            }
        }
        return(numOfDiceN);
    }

    /** outputs a array of containing the sides up of each dice in assending order */
    public Integer[] returnSortedDiceArray(){
        Integer returnInt[] = new Integer[numberOfDice];
        int currentIndex = 0;
        for(int i = 1; i <= dieArray[1].getNumSides(); i++){ //iterates for each side of the dice
            for(int j = 0; j < numberOfDice; j++){ // iterates for each die in hand
                if(dieArray[j].getSideUp() == i){ // checks if the side up is equal to the current side of die iterated
                    returnInt[currentIndex] = i;//if on the current side, the die val gets added to an array
                    currentIndex++;
                }
            }
        }
        return(returnInt);
    }

    /** Returns the amount of sides the dice has. Assumes all dice have same sides in hand */
    public Integer getDiceSides(){
        return(dieArray[1].getNumSides());
    }

    /** Returns the number of dice in the hand array */
    public Integer getNumberOfDiceInHand(){
        return(numberOfDice);
    }
}
