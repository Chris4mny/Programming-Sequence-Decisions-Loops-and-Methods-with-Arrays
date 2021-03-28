package calculatorApp10; 										// Chris Foremny IT-2789

import javax.swing.JOptionPane;

public class SixFunctionCalculator
{
	public SixFunctionCalculator() // constructor
	{
		double numberOne;
		double numberTwo;
		double results;
		char calcFunction;
		String useAgain;

		welcomeToCalculatorMessage();

		numberOne = obtainAnIntegerOrADoubleToUse("Enter number 1: "); // Enter an Integer or doublr

		calcFunction = pickAFunctionToUse(); // decide which math function to use

		numberTwo = obtainAnIntegerOrADoubleToUse("Enter number 2: "); // Enter an Integer or double

		results = calculator(numberOne, numberTwo, calcFunction); // sends to proper calculation 

		displayCalculatorResults(numberOne, numberTwo, results, calcFunction); // displays results

		useAgain = continueUsingCalculator(); // question to continue

		determineToContinue(useAgain); // if continue is yes do again, if no end program 
	}

	public void welcomeToCalculatorMessage() // welcome message to calculator program
	{
		JOptionPane.showMessageDialog(null, "Welcome to the Calculator Program");

	}

	public double calculator(double numberOne, double numberTwo, char calcFunction) // pick one of six functions to use
	{
		if (calcFunction == '+')
		{
			double adding = additionFunction(numberOne, numberTwo);

			return adding;
		}

		if (calcFunction == '-')
		{
			double subtracting = subtractionFunction(numberOne, numberTwo);

			return subtracting;
		}

		if (calcFunction == '*')
		{
			double multiplying = multiplicationFunction(numberOne, numberTwo);

			return multiplying;
		}

		if (calcFunction == '/')
		{
			double nonIntDiv = nonIntegerdivisionFunction(numberOne, numberTwo);

//			System.out.println(nonIntDiv);

			return nonIntDiv;
		}

		if (calcFunction == 'I')
		{
			double intDiv = integerDivisionFunction(numberOne, numberTwo);

			return (int) intDiv;
		}

		if (calcFunction == '%')
		{
			double mod = modulusFunction(numberOne, numberTwo);

			return (int) mod;
		}

		return 0;

	}

	public double obtainAnIntegerOrADoubleToUse(String theQuestion) // obtain an int or double 
	{
		String tempInputString;
		double theNumber;

		do
		{
			tempInputString = JOptionPane.showInputDialog(theQuestion);

		} while (!canBeDouble(tempInputString));

		theNumber = Double.parseDouble(tempInputString);

		return theNumber;
	}

	public boolean canBeDouble(String tempInputString) // doc taught/ wrote in class
	{
		int lookAtCharAt = 0;
		boolean decimalPointFound = false;

		if (tempInputString.charAt(0) == '+' || tempInputString.charAt(0) == '-')
		{
			lookAtCharAt = 1;
		}

		for (; lookAtCharAt < tempInputString.length(); lookAtCharAt++)
		{
			if (!decimalPointFound && tempInputString.charAt(lookAtCharAt) == '.')
			{
				lookAtCharAt++;
				decimalPointFound = true;
			}

			if (tempInputString.charAt(lookAtCharAt) < '0' || tempInputString.charAt(lookAtCharAt) > '9')
			{
				return false;
			}
		}

		return true;
	}

		public char pickAFunctionToUse() // pick a char then send it to display function and calculator
	{
		String function;
		char functionType = 0;

		function = JOptionPane.showInputDialog("Choose a function: \nEnter (+) for ADDITION\nEnter (-) for SUBTRACTION\nEnter (*) for MULTIPLICATION\nEnter (/) for DIVISION\nEnter (%) for MODULUS\nEnter (I) for INTEGER DIVISION");

		for (int i = 0; i < function.length(); i++)
		{
			functionType = function.charAt(i);
		}

		return functionType;
	}

	public double additionFunction(double numberOne, double numberTwo) // conducts addition
	{
		double result;

		result = (numberOne + numberTwo);

		return result;
	}

	public double subtractionFunction(double numberOne, double numberTwo) // conducts subtraction
	{
		double result;

		result = (numberOne - numberTwo);

		return result;
	}

	public double multiplicationFunction(double numberOne, double numberTwo) // conducts multiplication
	{
		double result;

		result = (numberOne * numberTwo);

		return result;
	}

	public double nonIntegerdivisionFunction(double numberOne, double numberTwo) // conducts regular division 
	{
		checkDenominatorForZero(numberTwo);

		double result;

		result = numberOne / numberTwo;

		// System.out.println(result);

		return result;
	}

	public double integerDivisionFunction(double numberOne, double numberTwo) // conducts integer division
	{
		checkDenominatorForZero(numberTwo);

		double result;

		result = (numberOne / numberTwo);

		return result;

	}

	public double modulusFunction(double numberOne, double numberTwo) // conducts modulus division 
	{
		checkDenominatorForZero(numberTwo);

		double result;

		result = (numberOne % numberTwo);

		return result;
	}

	public void checkDenominatorForZero(double numberTwo) // checks denominator for zero
	{
		if (numberTwo == 0)
		{
			JOptionPane.showMessageDialog(null, "Denominator cannot be zero\nTry again");

			System.exit(0);
		}
	}

	public void displayCalculatorResults(double numberOne, double numberTwo, double results, char functionType) // display results
	{
		JOptionPane.showMessageDialog(null,
				"The results of " + numberOne + " " + functionType + " " + numberTwo + " is: " + results);
	}

	public String continueUsingCalculator() // question to continue
	{
		String tempString;

		tempString = JOptionPane.showInputDialog("Do you want to continue using the calculator?\nEnter yes or no");

		return tempString;
	}

	public void determineToContinue(String choice) // if yes calculate again, if no exit
	{
		if (choice.equalsIgnoreCase("yes"))
		{
			double numberOne;
			double numberTwo;
			double results;
			char calcFunction;
			String useAgain;

			numberOne = obtainAnIntegerOrADoubleToUse("Enter number 1: ");

			calcFunction = pickAFunctionToUse();

			numberTwo = obtainAnIntegerOrADoubleToUse("Enter number 2: ");

			results = calculator(numberOne, numberTwo, calcFunction);

			displayCalculatorResults(numberOne, numberTwo, results, calcFunction);

			useAgain = continueUsingCalculator();

			determineToContinue(useAgain);

		}
		if (choice.equalsIgnoreCase("no"))
		{
			exitTheCalculatorProgram();
		}
	}

	public void exitTheCalculatorProgram()
	{
		JOptionPane.showMessageDialog(null, "End of program");
		System.exit(0);
	}

}
