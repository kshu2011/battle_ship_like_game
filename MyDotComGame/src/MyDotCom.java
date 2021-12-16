import java.util.ArrayList;

//this is my version on git too
public class MyDotCom {
	/** this class is the blueprint for
	  making a MyDotCom object, which knows it's own location
	  and how many times it has been hit. Also can tell if it has been
	  hit. */
	
	ArrayList<String> locations = new ArrayList<String>();
	public String checkYourself(String userGuess) {
		int indexIs = locations.indexOf(userGuess); //if index is -1 that means not in there
		if (indexIs >= 0) { //means it is in, so it's a hit
			locations.remove(indexIs); //remove it, since it's been hit
			if (locations.isEmpty()) { //that means kill
				return "kill";
			} else {
				return "hit";
			}
		}
		return "miss";
	}
	
	void setLocationCells(ArrayList<String> cellLocations) {
		/** this set function sets the location of this dot com */
		locations = cellLocations;
	}
}
