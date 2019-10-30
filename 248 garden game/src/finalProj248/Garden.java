package finalProj248;

public class Garden {

	char[][] garden;
	
	public Garden() {
		 garden = new char[3][3];
		 initiliazeGarden(garden);
	}
	
	
	// a constructor taking an int which represents the size of the garden 
	// this method takes user input = scanner and then sets the total size of the array 
	public void gardenSize(int size) {
		garden = new char[size][size];
		 initiliazeGarden(garden);
	}
	
	private void initiliazeGarden(char[][] garden) {
		for( int i =0; i<garden.length; i++) {
			for( int j=0; j<garden.length; j++) {
				garden[i][j] = '-';
			}
		}
	}
	
	// returns the char stored in the locaiton rc 
	public char getInLocation(int r, int c) {
		char location;
		location = garden[r][c];
		return location;
	}
	
	//stores char f for the flower in location rc
	public void plantFlower(int r, int c) {
		garden[r][c] = 'f';
	}
	
	//stores char t for the tree  in location rc
		public void pLantTree(int r, int c) {
			garden[r][c] = 't';
			garden[r+1][c] = 't';
			garden[r][c+1] = 't';
			garden[r+1][c+1] = 't';
		}

		// puts a space in location rc
		public void removeFlower(int r, int c) {
			garden[r][c] = '-';
		}
	
		//  make a boolean that says if each one is true that each space is  a - then its true
		// if all four of them come out like that then return true and increment a counter to determine
		// the total number of spots available 
	
		
// for some reaosn it doesnt recognize that the garden updates 
	public int countPossibleTrees() {
		boolean spot1 = false;
		boolean spot2 = false;
		boolean spot3 = false;
		boolean spot4 = false;
		int spaces =0;

		// set a boolean under each if condition and have a final if condition that evalutes all the booleans
		// if its true then we increment a counter if not then it goes to the else and restarts till theres
		// no more tiles 
		
		for(int i =0; i<garden.length-1; i++) {
			
			for(int j =0; j<garden.length-1; j++) {
				
				if(garden[i][j] == '-')
					spot1 = true;
				if(garden[i+1][j] == '-')
					spot2 = true;
				if(garden[i][j+1] == '-')
					spot3 = true;
				if(garden[i+1][j+1] == '-')
					spot4 = true;
				if(garden[i][j] == 'f')
				spot1 = false;
			if(garden[i+1][j] == 'f')
				spot2 = false;
			if(garden[i][j+1] == 'f')
				spot3 = false;
			if(garden[i+1][j+1] == 'f')
				spot4 = false;
			if(garden[i][j] == 't')
				spot1 = false;
			if(garden[i+1][j] == 't')
				spot2 = false;
			if(garden[i][j+1] == 't')
				spot3 = false;
			if(garden[i+1][j+1] == 't')
				spot4 = false;
				if( spot1 == true && spot2 == true && spot3 == true && spot4 == true) {
					spaces++;
					spot1 = false;
				    spot2 = false;
					spot3 = false;
					spot4 = false;
					continue;
				}
				else
					continue;
			
			}
			
			
		}
		return spaces;
	}
	
	
	public int countPossibleFLowers() {
		int spaces =0;
		
		for(int i =0; i<garden.length; i++) {
			
			for( int j =0; j<garden.length; j++) {
				if(garden[i][j]== '-')
					spaces++;
				else
					continue;	
			}
		}
		return spaces;	
	}
	
	// returns true if theres only - spaces and false if there exists a space 
	public boolean gardenFuLL() {
		boolean full = true;
		
		for(int i = 0; i<garden.length; i++) {
			
			for(int j=0; j<garden.length; j++) {
				if(garden[i][j] == '-') {
					full = false;
					break;
				}
			}
		}
		return full;
	}
	
	// method that converts the char to a string 
	public void String() {
		// the string has to have one more space size than the original garden array to fit the header of 
		// the colunms and rows
			String[][] newGard = new String[garden.length+1][garden.length+1];
		for( int i =0; i<garden.length+1; i++) {
			// the extra space is added to the conditon of the for loops
			for(int j=0; j<garden.length+1; j++) {
				// this sets the header of the colunms and the rows when i is 0
				if(i==0) {
					// this sets the first |
					if( i==0 && j==0) {
					newGard[i][j] = "  |";
					
					}
					//while i is 0 we set all the other headers accordingly and we subtract from one to 
					// stay in tune with the orignal values of the garden array
					else {
						newGard[i][j] = j-1 + "";
						newGard[j][i] = j-1 + " |";
					}
				}
				// once the headers of the colunms and the array are set, we store the actual values
				// of the garden array into the newGard array
				// this is done by subtracting 1 from the i and j for loop values
				// this makes sure that we retrieve the original values of the garden array
				// and this makes sure that we stay in bound
				if(i>=1 && j>=1)
				newGard[i][j] = Character.toString(garden[i-1][j-1]);
			}
		}
		// this forloop prints out the array notice that the conditon is <= to icnlude that fact that its
		// one greater than the garden array.
for( int i =0; i<=garden.length; i++) {
	
			for(int j=0; j<=garden.length; j++) {
				 System.out.print(newGard[i][j] + " ");
			}
			System.out.println("");
		}

	}
	
	
	
	
	
	
	
	
	
}
