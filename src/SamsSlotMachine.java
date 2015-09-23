
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Samantha Shurie
 * @author Paul Scarrone
 */
public class SamsSlotMachine {
  
  public static void main(String[] args){
	Scanner keyboard = new Scanner(System.in);
	slotMachine(keyboard);
  }
  
  public static void slotMachine(Scanner keyboard) {
	//Chapter 4 Exercise 22: Slot Machine Simulation (page 267)
	//Objective: Create a program that simulates a slot machine
	Integer betAmt, winnings;
	Random spin = new Random(); //random object generates new random number
	Integer[] randoms = {0,0,0}; //will hold values to be converted to strings
	String[] slotValues = {" "," "," "};
	String slot1 = " ",slot2 = " ", slot3 = " " ; //hold text representation of randoms

	//read user bet amount
	print("SLOT MACHINE\n"
			+ "\tPlace Your Bet (dollar amount [Integer]): ");
	  betAmt = keyboard.nextInt();

	//validates user input betAmt
	while(betAmt < 1 || betAmt > 100) {
		print("\tTry an amount between 1 and 100");
		betAmt = keyboard.nextInt();  
	}

	/*assign random values to each of the three slots
	 *spin.nextInt(6) will generate a random number from 0 and 5
	 * slotValue() method assigns text value to each slot
	 */
	// randoms = spin.ints(1,7).limit(3).toArray();
	for(int i = 0; i < randoms.length; i++) {
		randoms[i] = spin.nextInt(6);
		slotValues[i] = slotValue(randoms[i]);
	}

	//print all 3 slots
	print("\n\t[ " + slotValues[0] + " ] [ " + slotValues[0] + " ] [ "
			   + slotValues[0] + " ]\n\n");

	//calculate winning amount
	//if NONE are equal (probably the most likely)  
	if((!slot1.equals(slot2)) && (!slot1.equals(slot3)) && (!slot2.equals(slot3))){
		winnings = 0;
		print("\tSorry! Better luck next time!\n");

	//some are equal, determine if there are 2 or 3 matching    
	}else{
		if((slot1.equals(slot2)) && (slot1.equals(slot3))){
			winnings = betAmt * 3; //3 Matching
			print("\tCongratulations! 3 Matching!\n");
		}else{
			winnings = betAmt * 2; //2 Matching
			print("\t2 Matching!\n");
		}    
	 } //end winnings if-else statement

	 //print winnings
	 print("\tYou Won: $" + winnings
		 + "\nTo play again, enter 4 on the menu\n");
  }   //end slotMachine method
  
  /**
  * Assigns and returns a slot value to each random number spun
  * @param random integer ranging from 0 to 5
  * @return String value - symbol of slot value
  */
  public static String slotValue(Integer random) {
    String slotWord = " ";

    if (random == 0) {
	  slotWord = "Cherries";
    } else if (random == 1){
	  slotWord = "Oranges";
    } else if (random == 2){
	  slotWord = "Plums";
    } else if (random == 3){   
	  slotWord = "Bells";
    } else if (random == 4){
	  slotWord = "Melons";
    } else {
	  slotWord = "Bars";
    }

    return slotWord;
  };  //end SlotValue Method
  
  /**
   * Print method prints a string value to the console
   * @param msg string value
   */
  public static void print(String msg) {
	  System.out.print(msg);
  }   //end print method
}
