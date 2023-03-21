package unl.cse;

/**
 * This program demonstrates the use of various loop control structures to
 * compute the sum of natural numbers.
 * 
 * @author cbourke
 *
 */
public class Natural {

	/**
	 * Computes the sum of natural numbers 1..n using a while loop.
	 * 
	 * @return
	 */
	public static int sumWithWhile(int n) {
		int i = 1;
		int total = 0;
		while(i <= n) {
			total += i;
			i++;
		}
		return total;
	}

	/**
	 * Computes the sum of natural numbers 1..n using a for loop.
	 * 
	 * @return
	 */
	public static int sumWithFor(int n) {
		int sum = 0;
		for(int i = 1; i <= n; i++) {
		
			sum += i;	
		}
		return sum;
	}

	public static void main(String args[]) {
		if (args.length != 1) {
			System.err.println("ERROR: expecting a single integer argument");
			System.exit(1);
		}

		Integer n = null;
		try {
			n = Integer.parseInt(args[0]);
		} catch (NumberFormatException nfe) {
			System.err.println("ERROR: expecting a single integer argument");
			System.exit(1);
		}

		String zeroToTen[] = new String[11];
		zeroToTen[0] = "zero";
		zeroToTen[1] = "one";
		zeroToTen[2] = "two";
		zeroToTen[3] = "three";
		zeroToTen[4] = "four";
		zeroToTen[5] = "five";
		zeroToTen[6] = "six";
		zeroToTen[7] = "seven";
		zeroToTen[8] = "eight";
		zeroToTen[9] = "nine";
		zeroToTen[10] = "ten";

		int x = Integer.parseInt(args[0]);	
		int forN = sumWithFor(x);
		System.out.println(forN);
	
		int j = Integer.parseInt(args[0]);
		int whileN = sumWithWhile(j);
		System.out.println(whileN);
		
		int sumOfS = 0;
		int i = 0;
		for(String s : zeroToTen) {
			sumOfS += i;
			i++;
			if(i == zeroToTen.length) {
				System.out.print(s);	
				} else {
				System.out.print(s + " + ");	
				}		
		}
		System.out.print(" = " + sumOfS);

	}
}


// natural.java

package unl.cse;

import java.util.ArrayList;
import java.util.List;

/**
 * This program produces a report on how much a a tax payer can expect for their
 * child tax credits.
 * 
 * @author cbourke
 *
 */
public class ChildCredit {

	/**
	 * Produces a report (printed to the standard output) of how much
	 * of a credit each child receives as well as a grand total.
	 * 
	 * Returns the total child tax credit.
	 * 
	 * @param kids
	 * @return
	 */
	public static int produceReport(List<Child> kids) {
		// TODO: write a loop to iterate over the elements in the child array
		// and output a table as specified
		System.out.printf(" Child          Amount\n");
		double total = 0;
		int sum = 0;
		double am = 0;
		boolean overEighteen = false;
		for(int i = 0; i<kids.size(); i++) {
			Child kid = kids.get(i);
			int age = kid.getAge();
			String nameOfKid = "";
			if(age < 18 && overEighteen) {
				am = 500;
				nameOfKid = kid.toString();
				System.out.printf("%s     $%.2f\n", nameOfKid, am);
				total += 500;
				sum += 500;
			} else if(age < 18) {
				am = 1000;
				nameOfKid = kid.toString();
				overEighteen = true;
				System.out.printf("%s      $%.2f\n", nameOfKid, am);
				total += 1000;
				sum += 1000;
			} else {
				am = 0;
				nameOfKid = kid.toString();
				System.out.printf("%s        $%.2f\n", nameOfKid, am);
				total += 0;
				sum += 0;
			}
			
			
		}
		System.out.printf("Total credit:   $%.2f\n", total);
		return sum;

	}

	public static void main(String args[]) {

		Child tom = new Child("Tommy", 14);
		Child dick = new Child("Richard", 12);
		Child harry = new Child("Harold", 21);

		// A list of children above:
		List<Child> kids = new ArrayList<>();
		kids.add(tom);
		kids.add(dick);
		kids.add(harry);

		produceReport(kids);

	}
}
// child credit java
