package cs145.lab02;
import java.util.Scanner;		// to read from a file
import java.io.File;	    	// to create a file
import java.io.PrintWriter; 	// to write to a file
import java.io.IOException;	// to use files
import java.text.DecimalFormat;	// to format numbers for printing

/**
This class can be used to process precipitation data for 5 years. 
It will read 5 years of monthly data from a data file called precip.dat containing 1 data point per line. 
It will create a report containing a table of the data as well as monthly averages and yearly totals.
It will also find the maximum and minimum precipitation and display it with the table in the report.
Written by Noah Kamenick
2/5/2021
*/
public class Precipitation 
{
	private final static int MONTHS = 12;
	private final static int YEARS = 5;
	private final static int STARTYEAR = 2015;
	private final String[] monthLabel = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
		"Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

	//DECLARE ARRAYS HERE FOR TASK #2
	
	

	double[][] precipitationAmount;
	
	double[] yearTotal;			//Array Declarations
	
	double[] monthlyAverage;
	
	public Precipitation()
	{
		//CREATE THE ARRAYS OF THE CORRECT SIZE HERE FOR TASK #2
		//(USE THE CLASS CONSTANTS)
		
		 precipitationAmount = new double[YEARS][MONTHS];
		
		 yearTotal = new double[YEARS];			//Constructors
		 
		 monthlyAverage = new double[MONTHS];
		
	}

	public void readFile(Scanner infile) throws IOException
	{
		//CREATE A LOOPING STRUCTURE TO READ DATA FROM THE FILE AND
		//STORE IT INTO THE 2-D ARRAY FOR TASK #3
		

	 //Print the values of the precipitation amount array
	 
		for (int row = 0; row < precipitationAmount.length; row++)
		{
			for(int col = 0; col < precipitationAmount[row].length; col++) //Store values in 2D array from file
			{	
				precipitationAmount[row][col] = infile.nextDouble();
			}
			
		}
		
		//Test Print
		//System.out.println(infile.nextDouble());

		infile.close();
		calculateMonthlyAverage();
		calculateYearTotal();
		findMax();
	}

	private void calculateMonthlyAverage()
	{
		//CREATE A LOOPING STRUCTURE TO CALCULATE THE MONTHLY AVERAGE
		//FOR EACH COLUMN AND STORE IT INTO THE MONTHLY AVERAGE ARRAY
		//FOR TASK #3
		//Each column contains precipitation amounts for each month from 2015 to 2019 
		//Each row contains precipitation values for each month of Rows' year (15-19)
		
		
		for (int row = 0; row < YEARS; row++)
		{
			for(int col = 0; col < MONTHS; col++) 
			{	
				
					monthlyAverage[col] += precipitationAmount[row][col] / YEARS; //ADD THE COLUMNS

			}
			
			
		}

		/*
		
		//Test Print
		DecimalFormat fmt = new DecimalFormat("#0.00");
		
		for (int i = 0; i < MONTHS; i++)
		{
			
			System.out.println(fmt.format(monthlyAverage[i]));
			
		}
		*/
		
	}

	private void calculateYearTotal()
	{
		//CREATE A LOOPING STRUCTURE TO CALCULATE THE YEAR TOTAL
		//FOR EACH ROW AND STORE IT INTO THE YEAR TOTAL ARRAY
		//FOR TASK #3
	
		for (int row = 0; row < YEARS; row++)
		{
			for(int col = 0; col < MONTHS; col++) 
			{	
				yearTotal[row] += precipitationAmount[row][col]; //Store the rows

			}
			
		}
		
		
		/*
		//Test Print
		DecimalFormat fmt = new DecimalFormat("#0.00");
		
		for (int i = 0; i < YEARS; i++)
		{
			
			System.out.println(fmt.format(yearTotal[i]));
			
		}
		
		*/
	}
	
	public String findMax()
	{
		//TASK #4
		//SEARCH THE ARRAY FOR THE LARGEST AMOUNT OF PRECIPITAION
		//SAVE THE AMOUNT, MONTH, AND YEAR.
		
		double maxVal = 0;
		
		String month = "";
		
		int [] year = {2015, 2016, 2017, 2018, 2019};
		
		int yearItIs = 0;
		
		for(int row = 0; row < precipitationAmount.length; row++)
		{
			
			
			for(int col = 0; col < precipitationAmount[0].length; col++)
			{
				
				if (precipitationAmount[row][col] > maxVal) 
				{
					
					maxVal = precipitationAmount[row][col];
					month = monthLabel[col];
					yearItIs = year[row];
					
				}

			
			}
	
		}
		
		//Test Print
		
		//System.out.println(maxVal); //Should print 6.44
	
			
		return "The maximum precipitation of " + maxVal + " occurred in " + month + " of " + yearItIs;
		//RETURN A STRING CONTAINING INFORMATION ABOUT THE MAXIMUM PRECIPITATION
			
	}
	public String findMin()
	{
		//TASK #4
		//SEARCH THE ARRAY FOR THE SMALLEST AMOUNT OF PRECIPITAION
		//SAVE THE AMOUNT, MONTH, AND YEAR.
		
		double minVal = 1; //Set something other than zero so loop logic cycles through appropriately
		
		String month = "";
		
		int [] year = {2015, 2016, 2017, 2018, 2019};
		
		int yearItIs = 0;
		
		for(int row = 0; row < precipitationAmount.length; row++)
		{

			for(int col = 0; col < precipitationAmount[0].length; col++)
			{
				
				if (precipitationAmount[row][col] < minVal) 
				{
					
					minVal = precipitationAmount[row][col];
					month = monthLabel[col];
					yearItIs = year[row];
					
				}

			}
	
		}
		
		//Test Print
		
		//System.out.println(minVal);

		return "The minimum precipitation of " + minVal + " occurred in " + month + " of " + yearItIs;
		//RETURN A STRING CONTAINING INFORMATION ABOUT THE MINIMUM PRECIPITATION
	}	
	public void printTable(PrintWriter outfile)
	{
		//OUTPUT THE TABLE USING NICELY FORMATTED NUMBERS #.##
		//AND NEAT COLUMNS FOR TASK #5
		
		DecimalFormat fmt = new DecimalFormat("#0.00"); //declares and constructs new fmt object from DecimalFormat Class
		
		
		outfile.print("Year \t");
		
		
		for(int i = 0; i < MONTHS; i++)
		{												//Prints month headers
			outfile.print(monthLabel[i] + " \t");
			
		}
		
		outfile.print("Total");
		
		outfile.println("\n");
		
		for (int row = 0; row < precipitationAmount.length; row++)
		{	
			outfile.print(STARTYEAR + row + "\t"); //Print Years
			
			for(int col = 0; col < precipitationAmount[row].length; col++) 	//Print 2D array
			{
				
				outfile.print(fmt.format(precipitationAmount[row][col]) + "\t");
			}
			
			outfile.println(fmt.format(yearTotal[row])); //Print yearTotal
		}
		
		outfile.print("\nAve \t"); 					//Average label
		
		
		for(int col = 0; col < precipitationAmount[0].length; col++)
		{
			
			//System.out.print(fmt.format(monthlyAverage[col] / YEARS) + "\t"); //Print out the monthAverage in the final format
			outfile.print(fmt.format(monthlyAverage[col]) + "\t"); //Print out the monthAverage in the final format
		}
		
		outfile.println();
		
		outfile.println("\n" + findMax());
			
		outfile.println("\n" + findMin());
		
		outfile.close();
	}

	public static void main(String[] args) throws IOException
	{
		Precipitation wetStuff = new Precipitation();

		//TASK #1	
		//CREATE A Scanner OBJECT CALLED infile TO CONNECT WITH THE INPUT FILE: precip.dat		
		//CREATE A PrintWriter OBJECT CALLED outfile TO CONNECT WITH THE OUTPUT FILE: precip.out

		Scanner infile = new Scanner(new File("Lab02/PRECIP.dat"));
		
		PrintWriter outfile = new PrintWriter(new File("Lab02/precip.out"));
		
		
		//UNCOMMENT THE LINES BELOW ONCE YOU HAVE CREATED YOUR OBJECTS
		wetStuff.readFile(infile);
		wetStuff.printTable(outfile);
	}
}