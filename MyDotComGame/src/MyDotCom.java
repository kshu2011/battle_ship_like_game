
//this is my version on git too
public class MyDotCom {
	/** this class is the blueprint for
	  making a MyDotCom object, which knows it's own location
	  and how many times it has been hit. Also can tell if it has been
	  hit. */
	
	int[] locationCells; //save the location of this 'dotcom'
	int numOfHits; //keep track how many hits
	public String checkYourself(String userGuess) {
		int userGuessInt = Integer.parseInt(userGuess);
		for (int i = 0; i < locationCells.length; i++) {
			if (userGuessInt == locationCells[i]) {
				numOfHits += 1; //increment the hits
				if (numOfHits == 3) { //the dot com has been killed
					return "kill";
				} else {
					return "hit";
				}
			}
		}
		return "miss";//otherwise it's a miss so can return miss here
	}
	void setLocationCells(int[] cellLocations) {
		/** this set function sets the location of this dot com */
		locationCells = cellLocations;
	}
}
