import java.util.Scanner;

public class Progression
{
 	public static void main(String [] args)
 	{
 		Scanner keyboard = new Scanner (System.in);
		System.out.println(
			"This program will calculate the geometric and ");
		System.out.println(
			"harmonic progression for the number you enter.");
		System.out.print(
			"Enter an integer that is greater than or equal to 1:  ");		
		int input = keyboard.nextInt();
		int geomAnswer = geometricRecursive(input);
		double harmAnswer = harmonicRecursive(input);
		System.out.println("Using recursion:");
		System.out.println("The geometric progression of " + input + " is " + geomAnswer);
		System.out.println("The harmonic progression of " + input + " is " + harmAnswer);
		
		geomAnswer = geometricIterative(input);
		harmAnswer = harmonicIterative(input);
		System.out.println("Using iteration:");
		System.out.println("The geometric progression of " + input + " is " + geomAnswer);
		System.out.println("The harmonic progression of " + input + " is " + harmAnswer);
		keyboard.close();
	}

 	public static int geometricRecursive(int a) {
 		
 		
 		if (a==1)
		{
			
			
			return 1;
		}
		else
		{
			return (geometricRecursive(a-1) * a);
			
		}
 		
 	}
 	
 	public static int geometricIterative(int b) {
 	
 		int temp = 1; 
 		
 		for (int i = b; i > 0; i--)
 		{
 			temp *= i; 
 			
 		}
 		
 		return temp; 
 		 
 		
 	}
 	
 	public static double harmonicIterative(int c) 
 	{
 		
 		double temp = 1; 
 		
 		for (int i = c; i > 0; i--)
 		{
 			
 			temp *= 1/(double)i;
 			
 		}
 		
 		return temp; 
 	}
 	
 	public static double harmonicRecursive(double b) {
 		
 		
 		if (b==1)
		{
			return 1;
		}
		else
		{
			return (harmonicRecursive(b-1) * (1/b));
			
		}
 		
 
 	
 	}
 	
	
}