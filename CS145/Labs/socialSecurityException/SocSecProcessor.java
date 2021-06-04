package cs145.lab7;

import java.util.Scanner;

//!!!!! Don't Put In Actual Social Security Number !!!!!!!

public class SocSecProcessor {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		String ssn = "";
		String name;
		String choice;
		
		boolean correct = false;
		boolean keepGoing = true;
		
		do {
			System.out.println("Enter your name: ");
			name = keyboard.nextLine();
			System.out.println("Enter your SSN: ");
			
		try {
			
		ssn = keyboard.nextLine();
		correct = SocSecProcessor.isValid(ssn);
		if(correct == true) {
			
			System.out.println(name + "  " + ssn + " " + " is valid");
			
		}
		
		
		}
		
		catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
			
		System.out.println("Continue?");
		
		choice = keyboard.nextLine();
		
		if(choice.contains("n") || choice.contains("N")) {
			
			keyboard.close();
			keepGoing = false;
		}
		
		}while(keepGoing);
	
		System.out.println("Thanks for playing");
	}
	
	public static boolean isValid(String ssn) throws SocSecException
	{
		//length
		
		if(ssn.length() != 11)
		{
			
			throw new SocSecException("Not a valid length");
			
		}
		
		if(ssn.charAt(3) != '-' || ssn.charAt(6) != '-')
		{
			
			throw new SocSecException("Dashes at wrong positions");
			
		}
		
		for(int i = 0; i < ssn.length(); i++)
		{
			if(!Character.isDigit(ssn.charAt(i)) && i != 3 && i != 6) 
			{
				
				throw new SocSecException("Contains a character that is not a number or letter");
			}
			
			
			
		}

		
		return true;
	}
	

}
