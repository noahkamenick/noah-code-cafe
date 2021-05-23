package cs145.examples.rps;

import java.util.Scanner;
import java.math.*;
import java.util.Random;

public class RockPaperScissors 
{
	//there are errors in this program
	public static void main(String[] args) 
	{
	    Math.sqrt(4)
		int playTimeInt;
		
		System.out.println("How many times would you like to play?");
		
		Scanner playTimes = new Scanner(System.in); //grab value that user would like to play
		
		playTimeInt = playTimes.nextInt();
		
		if (playTimeInt == 0) {
			
			System.out.println("Bye Bye!"); //Display goodbye message if user doesn't want to play
			System.exit(0);
		}
		
		System.out.println("You would like to play: " + playTimeInt + " time(s)"); //display how many times player would like to try
		
		String s = new String("Beans");
	
		System.out.println(s);
		
		for(int i = 0; i < playTimeInt; i++) {
			
			int computer;
		    int user;
		      //assigning the computer a selection
		      Random generator = new Random();
		      computer = generator.nextInt(3) + 1; 
		      
		      System.out.println("Welcome to Rock-Paper-Scissors");
		      System.out.println("Please enter the number of your selection");
		      System.out.println("1.  Rock");
		      System.out.println("2.  Paper");
		      System.out.println("3.  Scissors");
		      System.out.println("0.  Exit Game");
		      System.out.println();
		      
		      //getting the user selection
		      Scanner keyboardIn = new Scanner(System.in);
		      user = keyboardIn.nextInt();
		   
		      if(user == 0) {
		    	  
		    	  System.out.println("Bye Bye!");
		    	  System.exit(0); //Shut down Java VM
		    	  
		      }
		      
		      System.out.println("Computer chose: " + computer);
		      
		      if(user == 1)//player is rock
		      {
		         System.out.println ("Player is rock");
		      }
		      else if (user == 2)//player is paper
		      {
		         System.out.println ("Player is paper");
		      }
		      else //player is scissors
		      {
		         System.out.println ("Player is scissors");
		      }
		      //tell the player what the computer has chosen
		      if(computer == 1)//computer is rock
		      {
		         System.out.println ("Computer is rock");
		      }
		      else if (computer == 2)//computer is paper
		      {
		         System.out.println ("Computer is paper");
		      }
		      else if (computer == 3) //computer is scissors
		      {
		         System.out.println ("Computer is scissors");
		      }
		      
		      //determine winner
		      if (user == computer) //tie
		      {
		         System.out.println("It is a tie");
		      }
		      else if (computer == 2 && user == 1) //computer wins; paper covers rock
		      {
		         System.out.println("Computer wins");
		      }
		      
		      else if (computer == 3 && user == 2) //computer wins; scissors cuts paper
		      {
		    	  
		    	  System.out.println("Computer wins");
		    	  
		      }
		      
		      else if (computer == 1 && user == 3) //computer wins; rock crushes scissors.
		      {
		    	
		    	  System.out.println("Computer Wins"); 
		    	  
		      }
		      
		      else if (user > 3 || user < 1) { //invalidates invalid numbers
		    	  
		    	  System.out.println(user + " is an invalid number. Try Again."); 
		    	  playTimeInt++; //Add one more try to playTime value to try again!
		      }
		      
		      
		      else  //computer is scissors
		      {
		         System.out.println("Player wins");
		     
		      //keyboardIn.close();
			
		      }
		     
			   
		      }
		      
			 
			}
		}

