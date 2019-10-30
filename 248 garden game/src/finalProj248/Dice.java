package finalProj248;

import java.util.Random;

public class Dice {
	
	int d1=1, d2=1;
	
	
	
	//default constructor that gives each dice value a value of zero

	
	public int getd1() {
		return d1;
	}
	
	public int getd2() {
		return d2;
	}
	
	public void rollDice() {
		// it generates zero for some reason
		Random rand = new Random();
		Random rand2 = new Random();
		d1 = (rand.nextInt(6)+1); // assigns random value to first dice 
		d2 = (rand2.nextInt(6)+1); 
		d1= d1;
		d2 = d2;// assigns random value to second dice 
	}

	
	// tostring method to display the dice 
	public String toString() {
		return "(Die 1: " + d1 + " Die2: "  + d2 + ")"; 
	}
	
	
	
	
	

}
