import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Class that executes calculations based on a postfix input from a .txt file
 * @author jackp
 *
 */
public class PostfixCalculator {

	public static void main(String[] args) {

		//Stack of the values from the postfix operation, stored as String
		Stack<String> valStack = new Stack<>();
		//Access files where postfix operation is saved
		File postfix1 = new File("C:/Users/jackp/Desktop/CSU Global/CSC400/postfix1.txt");
		File postfix2 = new File("C:/Users/jackp/Desktop/CSU Global/CSC400/postfix2.txt");
		
		//Calculate the postfix operations and print to screen
		System.out.println("The operation: '1 2 + 3* 4 -' equates to: " + postfixCalc(postfix1, valStack));
		System.out.println("The operation: '1 2 * 3 1 - / 4 5 * +' equates to: " + postfixCalc(postfix2, valStack));
	}// end main
		/**
		 * Converts a postfix operation into infix and performs calculations
		 * Uses try/catch due to chance of "filenotfound" exception
		 * @param postfixFile File containing postfix expression
		 * @param valStack Stack<String> to store values of operation
		 * @return value of operation
		 */
		public static int postfixCalc(File postfixFile, Stack<String> valStack) {
		try {
			Scanner scan = new Scanner(postfixFile);
			while (scan.hasNext()) {
				int right; 	// rightmost value of two operands
				int left;	// leftmost value of two operands
				int result;	// result of operation
				char nextChar = scan.next().charAt(0);
				switch (nextChar) {
				
					case '+': // pops two items from stack and adds them
						right = Integer.parseInt(valStack.pop());
						left = Integer.parseInt(valStack.pop());
						result = left + right;
						valStack.push(Integer.toString(result));
						break;
					case '-': // pops two items from stack and subracts them
						right = Integer.parseInt(valStack.pop());
						left = Integer.parseInt(valStack.pop());
						result = left - right;
						valStack.push(Integer.toString(result));
						break;
					case '*': // pops two items from stack and multiplies them
						right = Integer.parseInt(valStack.pop());
						left = Integer.parseInt(valStack.pop());
						result = left * right;
						valStack.push(Integer.toString(result));
						break;
					case '/': // pops two items from stack and divides them
						right = Integer.parseInt(valStack.pop());
						left = Integer.parseInt(valStack.pop());
						result = left / right;
						valStack.push(Integer.toString(result));
						break;
					default: // all values other than operands are pushed to stack
						valStack.push(Character.toString(nextChar));
						break;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//return final value
		return Integer.parseInt(valStack.pop());
	}// end postfixCalc
}// end class
