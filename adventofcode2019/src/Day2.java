import java.util.Arrays;

/*
 * --- Day 2: 1202 Program Alarm ---
 */

public class Day2 {
	
	public static void main(String args[]) {
		
		int[] intCodeInput = new int[] {1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,1,6,19,1,
				                   19,5,23,2,13,23,27,1,10,27,31,2,6,31,35,1,9,
				                   35,39,2,10,39,43,1,43,9,47,1,47,9,51,2,10,51,
				                   55,1,55,9,59,1,59,5,63,1,63,6,67,2,6,67,71,2,
				                   10,71,75,1,75,5,79,1,9,79,83,2,83,10,87,1,87,
				                   6,91,1,13,91,95,2,10,95,99,1,99,6,103,2,13,
				                   103,107,1,107,2,111,1,111,9,0,99,2,14,0,0};
		
		// int[] intCodeTest = new int[] {1,1,1,4,99,5,6,0,99}; 
		
			/* Part 1 */
		
		// intCodeInput = gravityAssistProgram(intCodeInput);
	    // printArr(intCodeInput);
		
			/* Part 2 */
		
		int[] copy = Arrays.copyOf(intCodeInput, intCodeInput.length);
		// printArr(copy);
		
		for (int i = 0; i <= 99; i++) {
			for (int j = 0; j <= 99; j++) {
				
				intCodeInput[1] = i;
				intCodeInput[2] = j;
				//System.out.println("input " + i + " " + j);
				//printArr(intCodeInput);
				intCodeInput = gravityAssistProgram(intCodeInput);
				//System.out.println("address 0 " + intCodeInput[0]);
				if (intCodeInput[0] == 19690720) {
					System.out.println(100 * intCodeInput[1] + intCodeInput[2]); // 9507
				}
				intCodeInput = Arrays.copyOf(copy, copy.length);
				//printArr(intCodeInput);	
			}
		}	
	}
	
	public static int[] gravityAssistProgram(int[] intCode) {
		
		int i = 0;
		while (i < intCode.length) {
			if (intCode[i] == 1) {
				
				intCode[intCode[i+3]] = intCode[intCode[i+1]] + intCode[intCode[i+2]];
				// can skip 4 positions
				i+=4;
			}
			else if (intCode[i] == 2) {
				intCode[intCode[i+3]] = intCode[intCode[i+1]] * intCode[intCode[i+2]];
				// can skip 4 positions
				i+=4;
			}
			else if (intCode[i] == 99) {
				// program is finished
				// System.out.println("program is finished...");
				return intCode;
			}
//			else {
//				System.out.println("encountered an unknown opcode...");
//				return intCode;
//			}
		}
		return intCode;
	}
	
	
	public static void printArr(int[] intCode) {
		for (int i = 0; i < intCode.length; i++) {
				System.out.print(intCode[i] + " ");	
		}
		System.out.print("\n");
	}
}
