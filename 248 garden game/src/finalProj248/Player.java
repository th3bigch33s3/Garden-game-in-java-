package finalProj248;

public class Player {
// two attributes
	String name; 
	Garden garden = new Garden();
	
	//default constructor that takes two parameters 
	public Player(String playa, int size) {
		name = playa;
		garden.gardenSize(size);
	}
	
	// Acessor for the name variable 
	public String getNAme() {
		return name;
	}
	
	// returns the result of the countPossibleFLowers method in Garden class
	public int howManyFLowersPossible() {
		return garden.countPossibleFLowers();
	}
	
	// returns the result of the countPossibleTrees method in Garden class
	public int howManyTreesPossible() {
		return garden.countPossibleTrees();
	}
	
	// returns the result of the getInLocation method in Garden class
	public int WhatIsPlanted(int r, int c) {
		return garden.getInLocation(r,c);
	}
	
	//  plants a tree in location r c
	public void pLantTreeInGarden( int r, int c) {
		garden.pLantTree(r, c);
	}
	
	// plants a flower in location rc
	public void pLantFLowerInGarden(int r , int c) {
		garden.plantFlower(r, c);
	}
	
	// removes a flower or a portion of a tree and replaces it with - 
	public void eatHere(int r , int c) {
		garden.removeFlower(r, c);
	}
	
	//displaysthe boolean result true or false if the garden is full or not 
	public boolean isGardenFuLL() {
		return garden.gardenFuLL();
	}
	         
	// displays the contents of the garden in the format of a string
	public void showGarden() {
		 garden.String();
	}
	
	public char getLocation(int r, int c) {
		return garden.getInLocation(r, c);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
