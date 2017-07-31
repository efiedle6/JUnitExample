package lenCon;
/*Edward Fiedler
 * SE433 Section 901
 * Assignment 4
 * 
 */


public class LengthConverter {

	//convert km to miles
	public double kmToMile(double km) throws IllegalArgumentException {
		//ensure number is positive or zero
		if (km < 0){
			throw new IllegalArgumentException("Distances must be positive or zero.\n");
		}
		else{
		double mile;
		mile = km * 0.621371192;
		return mile;
		}
	}
	
	//convert miles to km
	public double mileToKm(double mile){
		//ensure number is positive or zero
		if (mile < 0){
			throw new IllegalArgumentException("Distances must be positive or zero.\n");
		}
		else{
		double km;
		km = mile/0.621371192;
		return km;
		}
	}
	
	
	public static void main(String[] args) {
		
		
	}

}
