import static java.lang.System.out;

public class Life1D {
	private Rule rule;
	private int stepCount;
	public static int width;
	public static void main (String [ ] args) {
		Life1D simulation = new Life1D ( );
		simulation.processArgs (args);
		simulation.producePBM ( );
	}
	// Print, in Portable Bitmap format, the image corresponding to the rule and step count
	// specified on the command line.
	public void producePBM ( ) {
		// You fill this in.
	}
	// Retrieve the command-line arguments, and convert them to values for the rule number 
	// and the timestep count.
	private void processArgs (String [ ] args) {
		if (args.length != 2) {
			System.err.println ("Usage:  java Life1D rule# rowcount");
			System.exit (1);
		}
		try {
			width = Integer.parseInt(args[1]);
			rule = new Rule (Integer.parseInt (args[0]));
		} catch (Exception ex) {
			System.err.println ("The first argument must specify a rule number.");
			System.exit (1);
		}
		try {
			stepCount = Integer.parseInt (args[1]);
		} catch (Exception ex) {
			System.err.println ("The second argument must specify the number of lines in the output.");
			System.exit (1);
		}
		if (stepCount < 1) {
			System.err.println ("The number of output lines must be a positive number.");
			System.exit (1);
		}
	}
}
class Rule {
	public Rule (int ruleNum) {
		String binaryString = Integer.toBinaryString(ruleNum); //to binary
		int length = binaryString.length();
		String[] binaryStringArray = binaryString.split(""); //binary to array
		int[] binaryIntArray = new int[Life1D.width];
		for(int iterator = binaryIntArray.length - 1; iterator > -1; iterator--){
			if(iterator + 1 > length) {
				binaryIntArray[iterator] = 0;
			}
			else { 
				binaryIntArray[iterator] = Integer.parseInt(binaryStringArray[iterator + 1]);
			}
			System.out.print(binaryIntArray[iterator]);
		}
		System.out.println("");
	}


	
	// Return the output that this rule prescribes for the given input.
	// a, b, and c are each either 1 or 0; 4*a+2*b+c is the input for the rule.
	public int output (int a, int b, int c) {
		// You fill this in.
		System.out.println("output");
		return 0;
	}
}