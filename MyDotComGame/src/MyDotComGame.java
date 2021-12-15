import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//----------------------- THIS WAS MY ATTEMPT --------------------
/** this game is played on an 'array board' that has length of 7
 * a 'dot com' will be randomly placed in there and the player
 * will then try to guess where it is to hit it and sink it. just like
 * battleship game. */
public class MyDotComGame {
	public static void main(String[] args) {
		int numOfGuess = 0; // to keep track of number of user guesses
		MyDotCom[] dotComs = new MyDotCom[1];; //keep track of SimpleDotCom objects in an array
		Scanner userInput = new Scanner(System.in); //so can read user's input
		Random rand = new Random(); //so can generate random numbers
		boolean isAlive = true; //to keep track whether our dot com's are dead or alive
		
		MyDotCom dot1 = new MyDotCom();
		dotComs[0] = dot1;
		int randomLocation = rand.nextInt(5); //generate a number between 0 and 4
		int[] theLocation = {randomLocation, randomLocation + 1, randomLocation +2}; //the random location array
		dotComs[0].setLocationCells(theLocation);
		
		
		System.out.println("This is for testing, here is the location of dotcom: " + Arrays.toString(theLocation));
		
		
		while (isAlive) { //while dot com is alive keep asking user for input
			System.out.print("enter a number   ");
			String userGuessIs = userInput.next(); //get user's input
			if (Integer.parseInt(userGuessIs) > 6 || Integer.parseInt(userGuessIs) < 0) { //"board" is only an array of length 7
				System.out.println("Number out of bounds, try again.");
			} else {
				String result = dotComs[0].checkYourself(userGuessIs); //see if it hit/miss
				numOfGuess++; //increment the guesses
				if (result == "hit") {//if it is a hit
					
					System.out.println(result);
					//remove the location/part that has been "hit", that way
					//user cannot just keep "hitting" the same spot
					int[] newLocation = dotComs[0].locationCells;
					for (int i = 0; i < newLocation.length; i++) {
						if (newLocation[i] == Integer.parseInt(userGuessIs)) {
							newLocation[i] = 99999999; //remove that location, put a dummy variable in there 
							dotComs[0].setLocationCells(newLocation); //now it's new location with hit recorded
						}
					}
				} else if (result == "kill") {
					System.out.println(result); 
					dotComs[0] = null; //it's gone dead, remove it
					isAlive = false;
				} else {
					System.out.println(result); //missed
				}
			}
		}
		System.out.println("You took " + Integer.toString(numOfGuess) + " guesses");
	}
}