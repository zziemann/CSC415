//Perceptron Program (CSC415 assignment 3A)
//Zach Ziemann  -  4/28/16

package newpackage;
import java.util.Arrays;
import java.util.Scanner;


public class Perceptron 
{
	public static void main(String[] args)
	{
		System.out.println("--Starting Perceptron Program--");
		
		//Initialize variables 
		int numExamples = 0;
		double[] weightArray = {0.2 , 0.2 , 0.2 , 0.2};
		double threshold = 0.5;
		double increment = 0.05;
		
			
		//Ask for number of inputs
		System.out.println("How many example cases?");
		Scanner scanNum = new Scanner(System.in);
		numExamples = scanNum.nextInt();
		//System.out.println("You entered: " + numExamples);
		
		
		//Ask for the examples to be input	
		//Loop this for each example
		for(int i = 0; i < numExamples; i++)
		{
			int[] inputArray = new int[4];
			//Take in the information
			System.out.println("Enter your inputs (1 or 0) for example #" + (i+1) );
			Scanner scanInput = new Scanner(System.in);
			for(int e = 0; e < 4; e++)
			{				
				inputArray[e] = scanInput.nextInt();				
			}			
			
			//Get the Target Input
			System.out.print("Please enter target output (1 or 0): ");
			Scanner scanTarget = new Scanner(System.in);	
			int targetOutput = scanTarget.nextInt();
			
			//Add up the inputs times the weight
			double actualOutput = 0;
			for(int e = 0; e < 4; e++)
			{
				actualOutput = actualOutput + (inputArray[e]*weightArray[e]); 
			}			
						
			//Set the Actual Output to correct number
			if(actualOutput>threshold)
			{
				actualOutput = 1;
			}
			else
			{
				actualOutput = 0;
			}
			
			//Didn't happen but is supposed to 
			if(targetOutput > actualOutput)
			{
				for(int g = 0; g < 4; g++)
				{
					if(inputArray[g] == 1)
					{
						weightArray[g] = Math.floor((weightArray[g] + increment) * 100) / 100;
					}
				}
			}
			
			//Did happen but is not supposed to 
			if(targetOutput < actualOutput)
			{
				for(int g = 0; g < 4; g++)
				{
					if(inputArray[g] == 1)
					{
						weightArray[g] = Math.floor((weightArray[g] - increment) * 100) / 100;
					}
				}
			}
			
			//Summary of weights
			System.out.println("Done. Updated Weight Array: " + Arrays.toString(weightArray));
		}
		System.out.println("--Program complete--");		
	}
}