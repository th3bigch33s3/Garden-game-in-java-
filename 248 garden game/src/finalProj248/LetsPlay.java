// Assignment 4
		// Written by: Brenden Bissessar
		// For COMP 248 Section FF – Fall 2018
		// -

package finalProj248;

import java.util.Random;
import java.util.Scanner;

public class LetsPlay {
	public static void main(String[] args) {
		String playa;
		int size = 0;
		int numPlayers;
		// used for booleans
		int decision =0;
		
		
		
		Scanner input = new Scanner(System.in);
		// declare the variables in here and set a default cosntrucot which automatically assgins
		// the variables into the Player class through the use of a scanner

			
			
			// displays the welcome banner 
				System.out.print("-------****-------****-------****-------****-----****-----\n" + 
						"       Welcome to Crazy Nancy's Garden Game!\n" + 
						"-------****-------****-------****-------****-----****-----\n" + 
						" ");
				System.out.println(" ");
		
				System.out.println("To win this game you need some luck with the dice and a bit of strategy.\n" + 
						"Your garden is an NxN lot. You can plant flowers or trees. A flower takes one spot. A tree takes 4 spots (2x2).\n" + 
						"You roll the dice and based on the outcome you get to plant a pre-set number of trees and flowers.");
				System.out.println(" ");

				
				System.out.println("Rolls and their outcome:\n" + 
						"--------------------- ");

				System.out.println("3: plant a tree (2x2) and a flower (1x1)\n" + 
						"6: plant 2 flowers (2 times 1x1)\n" + 
						"12: plant 2 trees (2 times 2x2)\n" + 
						"5 or 10: the rabbit will eat something that you have planted - might be a flower or\n" + 
						"part of a tree(1x1)\n" + 
						"Any other EVEN rolls: plant a tree (2x2) "
						+"\nAny other ODD rolls: plant a flower (1x1) ");
				System.out.println(" ");

			
			//displays the rules of the game 
				System.out.println("Minimum number of players: 2.\n" + 
						"Minimum garden size: 3x3.\n" + 
						"You can only plant in empty locations. To plant a tree you give the top left"
						+ "\ncoordinates of the 2x2 space" + 
						"\nand I will check to make sure all 4 locations are free.\n" + 
						"Okay .. Let's start the game! May the best gardener win!!!\n");
				
				
				
				System.out.println("The default garden size is a 4x4 square. You can use this default board size or"
						+ "\nchange the size");
				
			// prompts the user to type in the size of the square
			System.out.print("Enter 0 to use the default garden size or -1 to enter your own size: ");
			decision = input.nextInt();
			// if they type y then its the size is set to 3 which is the default size
			while(decision >0 || decision < -1) {
				System.out.println("Sorry but " + decision + " is not a legal choice. Enter your choice:");
				decision = input.nextInt();
				
			}
			
			if(decision ==0)
				size = 3;
			
			// if they type in anything else then the system asks them what size they would like to enter
			if(decision ==-1) {
				System.out.print("Type in the size grid do you want to play with: ");
				size = input.nextInt();
				// ensures that the number is greater than 2 thus equal to three and greater 
			while (size<2) {
			System.out.print("The number you have entered is too small please enter a number greater than 3: ");
			size = input.nextInt();
			}
			System.out.println("");
		}
			
			// prompts the user to type in the number of players playing 
		System.out.print("How many gardeners will there be (minimum 2 required to play, max allowed 10)? ");
		numPlayers = input.nextInt();
		// ensures that the number of players are between 2 and 10 
		while(numPlayers <=1 || numPlayers>10) {
			System.out.print("** Sorry but " + numPlayers+ " is not a legal number of players.");
			System.out.print("\nHow many gardeners will there be (minimum 2 required to play, max allowed 10)? ");
			numPlayers = input.nextInt();
		}
		System.out.println("Great, " + numPlayers + " players it will be!\n");
		// array of the size of the amount of players that holds all the players
				Player pimps[] = new Player[numPlayers];
				Dice[] goFirst = new Dice[numPlayers];

		
		// have to create a player array and a for loop to set the amount of 
		// object needed and the names of each player 
		for( int i = 0; i<pimps.length; i++) {
			System.out.print("--> Name of player " + (i+1) + " (no spaces allowed): ");
			 playa = input.next();
			 // creates an object of the array of the class Player using the string playa which carries
			 // the name of the player, and size, which have the size 
			 pimps[i] = new Player(playa,size);
		}
		// create an array that stores all the name of the players so you can create 
		// so you can create an array the size of the number of players and you can 
		// make a for loop for the amount of objects
		
		// have to decide who goes first by using the dice class 
		// make an arrray of dice and then the one with the highest dice wins?
		// use the rollldice method 
		
		//we will use dice 1 as the rolling die
		// need to set up a boolean to check every dice to make sure that theyre not all the same 
		boolean rollAgain = true;
		// have to do a while loop
		// another for loop to access t
		//Dice[] goFirst = new Dice[numPlayers];
		Dice obj1 = new Dice();
		int[] diceRoll = new int[numPlayers]; 
		System.out.println("");
		// maybe create a seperate array for the dice rolls and then set them to the answers of each 
		// d1 roll 
		System.out.println("Let's see who goes first ...");
		boolean startOVer = false;
		int same= 0;
		do {
		for(int i =0; i<numPlayers; i++) {
			//goFirst[i].rollDice(); wy cant i create an array of this object******!!!!!!!
			startOVer = false;
			obj1.rollDice();
			diceRoll[i] = obj1.getd1();
			System.out.println(pimps[i].getNAme() + " rolled a " + diceRoll[i]);
	
		}
		
		for(int j=0; j<numPlayers; j++) {

			for(int q=0; q<numPlayers; q++) {
				
				if(diceRoll[j] == diceRoll[q] && j!=q) {
					same = q;
					startOVer = true;
					break;
				}
			
			   
			}
		}
		if(startOVer == true) {
			System.out.println("We will start over as " + diceRoll[same] + " was rolled by " + pimps[same].getNAme() + " as well.");
			System.out.println("");
		}
		
	}while(startOVer == true);// while loop
		
		// int starter will store the value of i for when the higher int is chosen 
		// we have to compare the value of the get dice of each obj.
		
		// the player who starts will be the player whose value is the same as starter
		int starter = 0;
		int highRoller =0;
		for(int i =0; i<numPlayers; i++) {
			if(highRoller<= diceRoll[i]) {
				highRoller = diceRoll[i];
				starter = i;
			}
		}
		System.out.println(pimps[starter].getNAme() + " goes first.");
		

		System.out.println("\n" + 
				"Time to play!!!!\n" + 
				"------------------");
		
		// switch the order of the player array according to the winner 
		// so the winner becomes the place in array space 0 

		// create another object of class player in order to store the array of objects so that the winner
		// starts first
		Player store[] = new Player[1];
		// Stores the first place object in the other object array 
		store[0] = pimps[0];
		pimps[0] = pimps[starter];
		pimps[starter] = store[0];
		
		// keep track of the amount of rounds that it plays
		int round = 0;
		// a while loop will go here for bellow that is set to true once theres a winnner
		// which is when the pimps[i].isGardenFuLL() == true then it will be set to true also
		//(while){
		// increments the round variable so we can keep track of it each time we go through the while loop
		boolean winner = false;
		while(winner == false) {
		System.out.println("");
		round++;
		int[] d1d2 = new int[2];
		for(int i =0; i<numPlayers; i++) {
			
			obj1.rollDice();
			d1d2[0] = obj1.getd1();
			d1d2[1] = obj1.getd2();
			int total = (d1d2[0] + d1d2[1]);
			System.out.println(pimps[i].getNAme() + " you rolled " + total + " " + obj1.toString());
			
			// PLANT A TREE AND A FLOWER **************************************************************
			if(total == 3) {
				System.out.println("");
				System.out.println("You must plant a tree(2x2) and a flower (1x1).");
				System.out.println("");
				pimps[i].showGarden();
				System.out.println("");
				System.out.println("\nLet's start with the tree. You have " + pimps[i].howManyTreesPossible() + " places to do this.");
				
				// if you have zero trees then print that you cannot print any 
				// if you have possibility of planting 1 tree or more then print where and continue as normal 
				if( pimps[i].howManyTreesPossible() ==0)
					System.out.println("You can't print any trees there is no more room left");
				
				if( pimps[i].howManyTreesPossible()>0) {
					System.out.print("Enter coordiantes as row column: ");
					int r=0;
					int c =0;
					boolean plant1 = false;
					boolean plant2 = false;
					boolean plant3 = false;
					boolean plant4 = false;
					boolean repeat = true;
					do {
					if(pimps[i].howManyTreesPossible()>0) {
						
						
						 r = input.nextInt();
						 c = input.nextInt();
						

						if(pimps[i].getLocation(r,c) == '-') {
							plant1= true;
						}
						if(pimps[i].getLocation(r+1,c) == '-') {
							plant2= true;
						}
						if(pimps[i].getLocation(r,c+1) == '-') {
							plant3= true;
						}
						if(pimps[i].getLocation(r+1,c+1) == '-') {
							plant4= true;
						}
						
						if(plant1 == true && plant2 == true && plant3 == true && plant4 ==true)
						pimps[i].pLantTreeInGarden(r, c);
						
						else {
							System.out.println("** Sorry either the row or column is not in the range of 0 to 3"
									+ "\nor your tree will be off the grid. Try again");
							
						}
						
					}
					} while(plant1 == false || plant2 == false|| plant3 == false || plant4 ==false);
					
					
				}// END OF IF STATEMENT IF YOU CAN PLANT TREE				
				// check after move has been made if that person is the winner **********************************
				pimps[i].isGardenFuLL();
				if(pimps[i].isGardenFuLL() == true) {
					winner = true;
					
					System.out.println("\n\nFINAL RESULTS\n" + 
							"-------------\n" + 
							"Here are the gardens after " + round + " rounds.");
					// set the boolean variable to true so we dont run the while loop again
					
					// prints out all the players and their gardens
					for(int f =0; f<numPlayers; f++) {
						System.out.println("");
						System.out.println(pimps[f].getNAme() + "'s garden");
						System.out.println("");
						pimps[f].showGarden();
					}
					
					System.out.println("\n\nAnd the winner is ..... " + pimps[i].getNAme());
					System.out.println("What a beautiful garden you have.\n" + 
							"\nHope you had fun!!!!");
					
					// breaks out the loops back to the while loop
					break;
				} // ************** End of code where you check the winner 
				
				// plant flower code**********************************************8
				System.out.println("Now you must plant a flower (1x1).");
				System.out.println("you have " + pimps[i].howManyFLowersPossible() + " places left to do this.");
				System.out.println("");
				pimps[i].showGarden();
				System.out.print("Enter coordinates as row column: ");
				
				// makes sure that the place is free to be a flower*******************************
				boolean plant = false;
				while(plant == false) {
					int r= input.nextInt();
					int c = input.nextInt();
					
					if(pimps[i].getLocation(r, c) == '-') {
						plant = true;
						pimps[i].pLantFLowerInGarden(r, c);
						pimps[i].showGarden();
					}
					
					else
						System.out.println("Sorry you didnt enter in a valid point... please check "
								+ "\n your garden for a valid point and enter it here: ");
				}// END OF WHILE
				
				// check after move has been made if that person is the winner **********************************
				pimps[i].isGardenFuLL();
				if(pimps[i].isGardenFuLL() == true) {
					winner = true;
					System.out.println("\n\nFINAL RESULTS\n" + 
							"-------------\n" + 
							"Here are the gardens after " + round + " rounds.");
					// set the boolean variable to true so we dont run the while loop again
					
					// prints out all the players and their gardens
					for(int f =0; f<numPlayers; f++) {
						System.out.println("");
						System.out.println(pimps[f].getNAme() + "'s garden");
						System.out.println("");
						pimps[f].showGarden();
					}
					
					System.out.println("\n\nAnd the winner is ..... " + pimps[i].getNAme());
					System.out.println("What a beautiful garden you have.\n" + 
							"\nHope you had fun!!!!");
					
					// breaks out the loops back to the while loop
					break;
				} // ************** End of code where you check the winner 
				
			}// END OF PLANT TREE AND A FLOWER ****************************************************************
			
			// PLANT A FLOWER TWICE ***************************************************************************
			if(total == 6) {
				System.out.println("You must plant 2 flowers (1x1).");
				System.out.println("you have " + pimps[i].howManyFLowersPossible() + " places left to do this.");
				pimps[i].showGarden();
				System.out.print("First flower - Enter coordinates as row column: ");
				
				// makes sure that the place is free to be a flower*******************************
				boolean plant = false;
				while(plant == false) {
					int r= input.nextInt();
					int c = input.nextInt();
					if(r<0 || r>=size ||c<0 || c>=size  ) {
						while(r<0 || r>=size ||c<0 || c>=size  ) {
							
							System.out.println("Please enter in a valid point: ");
							System.out.print("Enter coordinates as row column: ");
							r= input.nextInt();
						    c = input.nextInt();
						}
					}
					
					if(pimps[i].getLocation(r, c) == '-') {
						plant = true;
						pimps[i].pLantFLowerInGarden(r, c);
						pimps[i].showGarden();
					}
					
					else
						System.out.println("Sorry you didnt enter in a valid point... please check "
								+ "\n your garden for a valid point and enter it here: ");
				}// END OF WHILE
				
				
				
				// check after move has been made if that person is the winner **********************************
				pimps[i].isGardenFuLL();
				if(pimps[i].isGardenFuLL() == true) {
					winner = true;
					System.out.println("\n\nFINAL RESULTS\n" + 
							"-------------\n" + 
							"Here are the gardens after " + round + " rounds.");
					// set the boolean variable to true so we dont run the while loop again
					
					// prints out all the players and their gardens
					for(int f =0; f<numPlayers; f++) {
						System.out.println("");
						System.out.println(pimps[f].getNAme() + "'s garden");
						System.out.println("");
						pimps[f].showGarden();
					}
					
					System.out.println("\n\nAnd the winner is ..... " + pimps[i].getNAme());
					System.out.println("What a beautiful garden you have.\n" + 
							"\nHope you had fun!!!!");
					
					// breaks out the loops back to the while loop
					break;
				} // ************** End of code where you check the winner 
				System.out.println("");
				System.out.print("Second flower - Enter coordinates as row column: ");
				System.out.println("");
				while(plant == false) {
					int r= input.nextInt();
					int c = input.nextInt();
					
					// checks the f input to make sure that it stays within bounds 
					if(r<0 || r>=size ||c<0 || c>=size  ) {
					while(r<0 || r>=size ||c<0 || c>=size  ) {
						
						System.out.println("Please enter in a valid point: ");
						System.out.print("Enter coordinates as row column: ");
						r= input.nextInt();
					    c = input.nextInt();
					}
				}
					if(pimps[i].getLocation(r, c) == '-') {
						plant = true;
						pimps[i].pLantFLowerInGarden(r, c);
					}
					
					else
						System.out.println("Sorry you didnt enter in a valid point... please check "
								+ "\n your garden for a valid point and enter it here: ");
					
				// END OF WHILE
			}// end of if condition 
				
				
				
				
				
				
				
				
				
				
				// check after move has been made if that person is the winner **********************************
				pimps[i].isGardenFuLL();
				if(pimps[i].isGardenFuLL() == true) {
					winner = true;
					System.out.println("\n\nFINAL RESULTS\n" + 
							"-------------\n" + 
							"Here are the gardens after " + round + " rounds.");
					// set the boolean variable to true so we dont run the while loop again
					
					// prints out all the players and their gardens
					for(int f =0; f<numPlayers; f++) {
						System.out.println("");
						System.out.println(pimps[f].getNAme() + "'s garden");
						System.out.println("");
						pimps[f].showGarden();
					}
					
					System.out.println("\n\nAnd the winner is ..... " + pimps[i].getNAme());
					System.out.println("What a beautiful garden you have.\n" + 
							"\nHope you had fun!!!!");
					
					// breaks out the loops back to the while loop
					break;
				} // ************** End of code where you check the winner 
				
			} //END OF PLANT FLOWER 2X******************************************************************
			
			
			// PLANT 2 TREES ***************************************************************************
			if(total ==12) {
				
				// check if theres enough space and if theres not enough then skip this persons
				// turn by using continue 
				// if he can manage to plant one tree let it be 
				// but on the second tree plan tif he cnant plant the tree then we
				// must check the avialble free paces again 
				// after the first plant we must check to see if this person has won 
				// after the econd plant if able, we must also check to see if they won 
				
				System.out.println("You must plant 2 trees (2x2)");
				System.out.println("you have " + pimps[i].howManyTreesPossible() + " places left to plant the first tree.");
				pimps[i].showGarden();
				
				if( pimps[i].howManyTreesPossible() ==0) {
					System.out.println("** Sorry no room left to plant a tree - You miss a turn");
					continue;
				}
				
				if( pimps[i].howManyTreesPossible()>0) {
					System.out.println("Enter coordiantes as row column: ");
					int r=0;
					int c =0;
					boolean plant1 = false;
					boolean plant2 = false;
					boolean plant3 = false;
					boolean plant4 = false;
					boolean repeat = true;
					do {
					if(pimps[i].howManyTreesPossible()>0) {
						
						
						 r = input.nextInt();
						 c = input.nextInt();
						// usegetinlocation
						 while(r>=size-1 || c>=size-1) {
								System.out.print("Sorry invalid coordinates please enter the coordiantes as row column:  ");
								r= input.nextInt();
								c = input.nextInt();
								

								if( pimps[i].howManyTreesPossible() ==0) {
									System.out.println("** Sorry no room left to plant a tree - You miss a turn");
									continue;
								}
								
							}

						if(pimps[i].getLocation(r,c) == '-') {
							plant1= true;
						}
						if(pimps[i].getLocation(r+1,c) == '-') {
							plant2= true;
						}
						if(pimps[i].getLocation(r,c+1) == '-') {
							plant3= true;
						}
						if(pimps[i].getLocation(r+1,c+1) == '-') {
							plant4= true;
						}
						
						if(plant1 == true && plant2 == true && plant3 == true && plant4 ==true)
						pimps[i].pLantTreeInGarden(r, c);
						
						else {
							System.out.println("** Sorry either the row or column is not in the range of 0 to 3"
									+ "\nor your tree will be off the grid. Try again");
							
						}
						
					}
					} while(plant1 == false || plant2 == false|| plant3 == false || plant4 ==false);			
				}// checking to plant first tree *************************************************8
				
				
				
				// check after move has been made if that person is the winner **********************************
				pimps[i].isGardenFuLL();
				if(pimps[i].isGardenFuLL() == true) {
					winner = true;
					System.out.println("\n\nFINAL RESULTS\n" + 
							"-------------\n" + 
							"Here are the gardens after " + round + " rounds.");
					// set the boolean variable to true so we dont run the while loop again
					
					// prints out all the players and their gardens
					for(int f =0; f<numPlayers; f++) {
						System.out.println("");
						System.out.println(pimps[f].getNAme() + "'s garden");
						System.out.println("");
						pimps[f].showGarden();
					}
					
					System.out.println("\n\nAnd the winner is ..... " + pimps[i].getNAme());
					System.out.println("What a beautiful garden you have.\n" + 
							"\nHope you had fun!!!!");
					
					// breaks out the loops back to the while loop
					break;
				} // ************** End of code where you check the winner 

				if( pimps[i].howManyTreesPossible() ==0) {
					System.out.println("** Sorry no room left to plant a tree - You miss a turn");
					continue;
				}
				
				System.out.println("");
				pimps[i].showGarden();
				System.out.println("");
				// planting the second tree
				System.out.println("Time to plant the second tree!");

				System.out.println("you have " + pimps[i].howManyTreesPossible() + " places left to plant the second tree.");
				
				if( pimps[i].howManyTreesPossible() ==0) {
					System.out.println("** Sorry no room left to plant the second tree - You miss a turn");
					continue;
				}
				
				if( pimps[i].howManyTreesPossible()>0) {
					System.out.println("Enter coordiantes as row column: ");
					int r=0;
					int c =0;
					boolean plant1 = false;
					boolean plant2 = false;
					boolean plant3 = false;
					boolean plant4 = false;
					boolean repeat = true;
					do {
					if(pimps[i].howManyTreesPossible()>0) {
						 r = input.nextInt();
						 c = input.nextInt();
						
						 // checks for a valid input
						 while(r>=size-1 || c>=size-1) {
								System.out.print("\"** Sorry either the row or column is not in the range of 0 to 3\"\n" + 
										"+ \"\\nor your tree will be off the grid. Try again\"");
								r= input.nextInt();
								c = input.nextInt();
							}

						if(pimps[i].getLocation(r,c) == '-') {
							plant1= true;
						}
						if(pimps[i].getLocation(r+1,c) == '-') {
							plant2= true;
						}
						if(pimps[i].getLocation(r,c+1) == '-') {
							plant3= true;
						}
						if(pimps[i].getLocation(r+1,c+1) == '-') {
							plant4= true;
						}
						
						if(plant1 == true && plant2 == true && plant3 == true && plant4 ==true)
						pimps[i].pLantTreeInGarden(r, c);
						
						else {
							System.out.println("** Sorry either the row or column is not in the range of 0 to 3"
									+ "\nor your tree will be off the grid. Try again");
							
						}
						
					}
					} while(plant1 == false || plant2 == false|| plant3 == false || plant4 ==false);			
				}// checking to plant second tree *************************************************
				
				
				// check after move has been made if that person is the winner **********************************
				pimps[i].isGardenFuLL();
				if(pimps[i].isGardenFuLL() == true) {
					winner = true;
					System.out.println("\n\nFINAL RESULTS\n" + 
							"-------------\n" + 
							"Here are the gardens after " + round + " rounds.");
					// set the boolean variable to true so we dont run the while loop again
					
					// prints out all the players and their gardens
					for(int f =0; f<numPlayers; f++) {
						System.out.println("");
						System.out.println(pimps[f].getNAme() + "'s garden");
						System.out.println("");
						pimps[f].showGarden();
					}
					
					System.out.println("\n\nAnd the winner is ..... " + pimps[i].getNAme());
					System.out.println("What a beautiful garden you have.\n" + 
							"\nHope you had fun!!!!");
					
					// breaks out the loops back to the while loop
					break;
				} // ************** End of code where you check the winner 
			} // END OF PLANTING 2 TREES *****************************************************************
			
			
			
			// rabbit eats something *******************************************************************
			Random rand = new Random();
			Random rand2 = new Random();
			if(total == 5 || total ==10) {
				pimps[i].showGarden();

			
					int r=  rand.nextInt(size);
					int c = rand2.nextInt(size);
					
					// have to check if that spot contains an f or a t
					// if it contains a space we cannot use
					// if it contains an f or a t then we put -
					
						pimps[i].eatHere(r, c);
						
						System.out.println("The rabbit ate whatever was planted in location (" + r + "," + c + ")");
						pimps[i].showGarden();
					
				 				
			} // rabbit eating done *********************************************
			
			
			//PLANT TREE ******************************************************************************8
			if( total == 2 ||total == 4||total == 8 ) {
				System.out.println("You must plant a tree (2x2).");
				// prints out the board
				System.out.println("");
				pimps[i].showGarden();
				System.out.println("");
				
				// if theres no more space in the garden to plant a tree but there is space left
				// then that players looses a turn 
				
				//checks space DOESNT WORK PROPERLYYYYYY // check on a 4x4 board 
				System.out.println("and have " + pimps[i].howManyTreesPossible() + " places left to do this.");
				
				// have to determine where this person can plant if they can and if not make it so they miss a turn
				// makes the player miss a turn if they cant plant anymore trees
				if(pimps[i].howManyTreesPossible() == 0) {
					System.out.println("** Sorry no room left to plant a tree - You miss a turn");
					continue;
				}
				
				// if there exists a possible space to put the tree
				int r=0;
				int c = 0;
				boolean plant1 = false;
				boolean plant2 = false;
				boolean plant3 = false;
				boolean plant4 = false;
				boolean repeat = true;
				do {
				if(pimps[i].howManyTreesPossible()>0) {
					if(repeat==true)
					System.out.print("Enter coordinates as row column: ");
					r= input.nextInt();
					c = input.nextInt();
					
					while(r>=size-1 || c>=size-1) {
						System.out.print("Sorry invalid coordinates please enter the coordiantes as row column:  ");
						r= input.nextInt();
						c = input.nextInt();
					}
					// usegetinlocation
					// do an if statement or a while loop for if wha tthe coordinate the user 
					// entered ends up going out of bounds then we must say re enter the coordiants

					if(pimps[i].getLocation(r,c) == '-') {
						plant1= true;
					}
					if(pimps[i].getLocation(r+1,c) == '-') {
						plant2= true;
					}
					if(pimps[i].getLocation(r,c+1) == '-') {
						plant3= true;
					}
					if(pimps[i].getLocation(r+1,c+1) == '-') {
						plant4= true;
					}
					
					if(plant1 == true && plant2 == true && plant3 == true && plant4 ==true)
					pimps[i].pLantTreeInGarden(r, c);
					
					else {
						System.out.println("** Sorry either the row or column is not in the range of 0 to 3"
								+ "\nor your tree will be off the grid. Try again");
						repeat =false;
					}
					
				}
				} while(plant1 == false || plant2 == false|| plant3 == false || plant4 ==false);
				// have to checks if theres spaces left to plant in total if theyre a winner
				
				// check after move has been made if that person is the winner **********************************
				pimps[i].isGardenFuLL();
				if(pimps[i].isGardenFuLL() == true) {
					winner = true;
					System.out.println("\n\nFINAL RESULTS\n" + 
							"-------------\n" + 
							"Here are the gardens after " + round + " rounds.");
					// set the boolean variable to true so we dont run the while loop again
					
					// prints out all the players and their gardens
					for(int f =0; f<numPlayers; f++) {
						System.out.println("");
						System.out.println(pimps[f].getNAme() + "'s garden");
						System.out.println("");
						pimps[f].showGarden();
					}
					
					System.out.println("\n\nAnd the winner is ..... " + pimps[i].getNAme());
					System.out.println("What a beautiful garden you have.\n" + 
							"\nHope you had fun!!!!");
					
					// breaks out the loops back to the while loop
					break;
				} // ************** End of code where you check the winner 
				pimps[i].showGarden();
			}
			// END OF PLANT TREE ************************************************************************
			
			
			
			//plant fLOWER ********************************************************************************
			if ( total == 7 ||total == 9||total == 11 ) {
				System.out.println("You must plant a flower (1x1).");
				System.out.println("");
				pimps[i].showGarden();
				System.out.println("");
				System.out.println("you have " + pimps[i].howManyFLowersPossible() + " places left to do this.");
				
				pimps[i].isGardenFuLL();
				if(pimps[i].howManyFLowersPossible() == 0) {
					pimps[i].isGardenFuLL();
					if(pimps[i].isGardenFuLL() == true) {
						winner = true;
						System.out.println("\n\nFINAL RESULTS\n" + 
								"-------------\n" + 
								"Here are the gardens after " + round +  " rounds.");
						// set the boolean variable to true so we dont run the while loop again
						
						// prints out all the players and their gardens
						for(int f =0; f<numPlayers; f++) {
							System.out.println("");
							System.out.println(pimps[f].getNAme() + "'s garden");
							System.out.println("");
							pimps[f].showGarden();
						}
						
						System.out.println("\n\nAnd the winner is ..... " + pimps[i].getNAme());
						System.out.println("What a beautiful garden you have.\n" + 
								"\nHope you had fun!!!!");
						// breaks out the loops back to the while loop
						break;
					} 
				}// ************** End of code where you check the winner 
				
				System.out.print("Enter coordinates as row column: ");
				boolean plant = false;
				// makes sure that the place is free to be a flower
				while(plant == false) {
					int r= input.nextInt();
					int c = input.nextInt();
					
					// checks the f input to make sure that it stays within bounds 
					if(r<0 || r>=size ||c<0 || c>=size  ) {
					while(r<0 || r>=size ||c<0 || c>=size  ) {
						
						System.out.println("Please enter in a valid point: ");
						System.out.print("Enter coordinates as row column: ");
						r= input.nextInt();
					    c = input.nextInt();
					}
				}
					if(pimps[i].getLocation(r, c) == '-') {
						plant = true;
						pimps[i].pLantFLowerInGarden(r, c);
					}
					
					else
						System.out.println("Sorry you didnt enter in a valid point... please check "
								+ "\n your garden for a valid point and enter it here: ");
					
				// END OF WHILE
			}// end of if condition 
				pimps[i].showGarden();

				pimps[i].isGardenFuLL();
				// check to see if they won after move has been made 
				if(pimps[i].howManyFLowersPossible() == 0) {
					pimps[i].isGardenFuLL();
					if(pimps[i].isGardenFuLL() == true) {
						winner = true;
						System.out.println("\n\nFINAL RESULTS\n" + 
								"-------------\n" +  
								"Here are the gardens after " + round +  " rounds.");
						// set the boolean variable to true so we dont run the while loop again
						
						// prints out all the players and their gardens
						for(int f =0; f<numPlayers; f++) {
							System.out.println("");
							System.out.println(pimps[f].getNAme() + "'s garden");
							System.out.println("");
							pimps[f].showGarden();
						}
						
						System.out.println("\n\nAnd the winner is ..... " + pimps[i].getNAme());
						System.out.println("What a beautiful garden you have.\n" + 
								"\nHope you had fun!!!!");
						// breaks out the loops back to the while loop
						break;
					} 
				}// ************** End of code where you check the winner 
				
			} // END OF FLOWER *********************************************************************
		}
}
		
		
		
		
		
		
		
		
	}
	
}
