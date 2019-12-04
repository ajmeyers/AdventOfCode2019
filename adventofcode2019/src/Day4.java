/*
 * --- Day 4: Secure Container ---
 */

public class Day4 {

	public static void main(String[] args) {
		
		// Puzzle Input
		int minNum = 124075;
		int maxNum = 580769;
		
		/* Part 1 */
		int count = 0;
		count = numberOfPasswordsThatMeetCriteriaPart1(minNum, maxNum);
		System.out.println("number of passwords: " + count);
	    /* Part 2 */ //1462
		count = 0;
	    count = numberOfPasswordsThatMeetCriteriaPart2(minNum, maxNum);
		System.out.println("number of passwords: " + count);
			
	}
	
	
	public static int numberOfPasswordsThatMeetCriteriaPart1(int min, int max) {
		int numPasswords = 0;
	    int pw = 0;
		
		while (min <= max) {
			pw = min;
			String number = String.valueOf(pw);
			char[] digits = number.toCharArray();
			
			if (digits[0] < digits[1] && digits[1] < digits[2] &&
				digits[2] < digits[3] && digits[3] < digits[4] &&
				digits[4] < digits[5]) 
			{
				min++;
				continue;
			}
	
			if (digits[0] <= digits[1] && digits[1] <= digits[2] &&
				digits[2] <= digits[3] && digits[3] <= digits[4] &&
				digits[4] <= digits[5]) 
			{
				numPasswords++;
			}
			
			min++;
		}
		return numPasswords;
	}
	
	
	public static int numberOfPasswordsThatMeetCriteriaPart2(int min, int max) {
		int numPasswords = 0;
	
		while (min <= max) {
			int pw = min;
			String number = String.valueOf(pw);
			char[] digits = number.toCharArray();
			
			// check for decreasing values
			if (digits[0] > digits[1] || 
				digits[1] > digits[2] ||
				digits[2] > digits[3] || 
				digits[3] > digits[4] ||
				digits[4] > digits[5]) 
			{
				//System.out.println(min + " digits need to be in increasing order");
				min++;
				continue;
			}
			
			// check for increasing values with no doubles
			if (digits[0] < digits[1] && 
				digits[1] < digits[2] &&
				digits[2] < digits[3] && 
				digits[3] < digits[4] &&
				digits[4] < digits[5]) 
			{
				//System.out.println(min + " increasing order no doubles");
				min++;
				continue;
			}
			
	        /* checking for the same 5 digits in a row for both sides of a password */
			
		    if ((digits[0] == digits[1] && digits[0] == digits[2] && 
				 digits[0] == digits[3] && digits[0] == digits[4] &&
			     digits[4] != digits[5]))		
			{
				//System.out.println(min);
				min++;
				continue;
			}	
			
			if ((digits[5] == digits[4] && digits[5] == digits[3] && 
				 digits[5] == digits[2] && digits[5] == digits[1] &&
				 digits[1] != digits[0])
			    )		
			{
				//System.out.println(min);
				min++;
				continue;
			}
			
			/***************************************************************/
			
			
			if (digits[0] == digits[1] && digits[0] == digits[2]) {
				if ((digits[3] == digits[4] && digits[4] != digits[5]) || (digits[4] == digits[5] && digits[4] != digits[3])) {
					//System.out.println(min + " password");
					numPasswords++;
					min++;
					continue;
				}
				else {
					min++;
					continue;
				}
			}
			
	        
			if (digits[1] == digits[2] && digits[1] == digits[3]) {
				if (digits[4] == digits[5]) {
					//System.out.println(min + " password");
					numPasswords++;
					min++;
					continue;
				}
				else {
					min++;
					continue;
				}
			}
			
			if (digits[2] == digits[3] && digits[2] == digits[4]) {
				if (digits[0] == digits[1]) {
					//System.out.println(min + " password");
					numPasswords++;
					min++;
					continue;
				}
				else {
					min++;
					continue;
				}
			}
			
			if (digits[3] == digits[4] && digits[4] == digits[5]) {
				if ((digits[0] == digits[1] && digits[1] != digits[2]) || (digits[1] == digits[2] && digits[1] != digits[0])) {
					//System.out.println(min + " password");
					numPasswords++;
					min++;
					continue;
				}
				else {
					min++;
					continue;
				}
			}
	
			
			/***************************************************************/
			
	
			/* all other cases */
			
			if (digits[0] <= digits[1] && digits[1] <= digits[2] &&
				digits[2] <= digits[3] && digits[3] <= digits[4] &&
				digits[4] <= digits[5]) 
			{
				//System.out.println(pw + " password");
				numPasswords++;
			}
			
			min++;
		}
		return numPasswords;
	}
}
