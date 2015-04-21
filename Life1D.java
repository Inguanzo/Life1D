import static java.lang.System.out;

public class Life1D {
	private Rule rule;
	private int stepCount;
	public static int myLength;
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
			myLength = Integer.parseInt(args[1]);
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
		int[] binaryIntArray = new int[binaryString.length()];
		int back = binaryString.length() - 1;
		for(int iter = 0; iter < binaryString.length(); iter++) {
			binaryIntArray[back] = Character.getNumericValue(binaryString.charAt(iter));
			//System.out.print(binaryIntArray[back]);
			back --;
		}
		//System.out.println(" -- bin string");
		int[][] board = new int[Life1D.myLength + 1][(Life1D.myLength * 2) + 1];
		int[] temp = new int[(Life1D.myLength * 2) + 1];
		String current = "";

		int gridWidth = (Life1D.myLength * 2) + 1;
		int gridLength = Life1D.myLength + 1;
		System.out.println("P1 " + gridWidth + " " + gridLength);
		for(int row = 0; row < Life1D.myLength + 1; row++){
			for(int column = 0; column < (Life1D.myLength * 2) + 1; column++){
				if(row == 0 && column == Life1D.myLength) {
					board[row][column] = 1;
				} else if(row > 0){
					if(column == 0) {
						current = "0" + Integer.toString(temp[column]) + Integer.toString(temp[column + 1]);
						if(Integer.parseInt(current, 2) > binaryIntArray.length - 1){
							board[row][column] = 0;
						}
						else if(binaryIntArray[Integer.parseInt(current, 2)] == 1) {
							board[row][column] = 1;
						}
					} else if(column == Life1D.myLength * 2){
						current = Integer.toString(temp[column - 1]) + Integer.toString(temp[column]) + "0";
						if(Integer.parseInt(current, 2) > binaryIntArray.length - 1){
							board[row][column] = 0;
						}
						else if(binaryIntArray[Integer.parseInt(current, 2)] == 1) {
							board[row][column] = 1;
						}
					} else {
						current = Integer.toString(temp[column - 1]) + Integer.toString(temp[column]) + Integer.toString(temp[column + 1]);
						if(Integer.parseInt(current, 2) > binaryIntArray.length - 1){
							board[row][column] = 0;
						}
						else if(binaryIntArray[Integer.parseInt(current, 2)] == 1) {
							board[row][column] = 1;
						}
					}
				} else {
					board[row][column] = 0;
				}
				System.out.print(board[row][column]);
			}
			for(int newColumn = 0; newColumn < (Life1D.myLength * 2) + 1; newColumn++){
					temp[newColumn] = board[row][newColumn];
			} 
			System.out.println("");
		}
	}

	
	// Return the output that this rule prescribes for the given input.
	// a, b, and c are each either 1 or 0; 4*a+2*b+c is the input for the rule.
	public int output (int a, int b, int c) {
		// You fill this in.
		System.out.println("output");
		return 0;
	}
}
