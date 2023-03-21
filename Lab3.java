

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Processes a comma-separated value (CSV) file of win/loss data from the 2011
 * National League MLB season. It sorts the teams (best record to worst) and
 * prints a report to the standard output.
 * 
 * @author cbourke
 *
 */
public class Baseball {

	private static final String FILE_NAME = "data/mlb_nl_2011.csv";
	private static final String OUTPUT_NAME = "data/output.txt";

	/**
	 * This method loads MLB team data from the CSV file
	 * specified by {@link #FILE_NAME} and instantiates 
	 * and returns a list of {@link Team}s.
	 * 
	 * @return
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static List<Team> loadData() {
		
			
		List<Team> teamList = new ArrayList<>();
		
		Scanner s = null;
		try {
			s = new Scanner(new File(FILE_NAME));
			while(s.hasNextLine()) {
			String line = s.nextLine();
			String tokens[] = line.split(",");
			String teamName = tokens[0];
			int wins = Integer.parseInt(tokens[1]);
			int loss = Integer.parseInt(tokens[2]);
			Team team = new Team(teamName, wins, loss);
			teamList.add(team);	
		}
			s.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);	
		}
		
			return teamList;
		}
		
	
	
	//TODO: implement the file output method
	public static void persistData(List<Team> teams, String outputFileName)  {
		
		File x = new File(outputFileName);
		try {
			  PrintWriter pw = new PrintWriter(x);
			  for (Team k : teams) {
					pw.print(k);
					pw.printf("\n");
				} 
			  pw.close();
			} catch (FileNotFoundException fnfe) {
			  throw new RuntimeException(fnfe);
			}
		return;
	}
	
	public static void main(String args[]) throws FileNotFoundException, IOException {

		List<Team> teams = loadData();
		System.out.println("Teams: ");
		for (Team t : teams) {
			System.out.println(t);
		}

		Collections.sort(teams, Team.teamByWinPercentage);

		System.out.println("\n\nSorted Teams: ");
		for (Team t : teams) {
			System.out.println(t);
		}
		
		//TODO: call your file output method with the sorted teams

		persistData(teams, OUTPUT_NAME);
		for (Team t : teams) {
			System.out.println(t);
		}

	}

}

// base ball java

package unl.cse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Processes DNA data and counts the number of instances that a particular DNA
 * subsequence appears.
 *
 */
public class DnaAnalysis {

	private static final String DNA_FILE = "data/H1N1nucleotide.txt";
	private static final String DNA;

	static {
		// load the contents of the file statically (when the class
		// is loaded)
		DNA = loadDnaFromFile();
	}

	/**
	 * Loads a DNA string from the {@link #DNA_FILE} and returns it as a string with
	 * all whitespace removed.
	 * 
	 * @return
	 */
	public static String loadDnaFromFile() {

		Scanner s = null;
		try {
			s = new Scanner(new File(DNA_FILE));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

		String dna = "";

		while (s.hasNextLine()) {
			dna += s.nextLine();
		}
		// close the scanner
		s.close();
		// strip all whitespace
		dna = dna.replaceAll("\\s+", "");
		return dna;
	}

	/**
	 * Counts the number of times <code>subSequence</code> appears in the
	 * {@link #DNA} string
	 * 
	 * @return
	 */
	public static int countSubsequences(String subSequence) {
		
		String s = loadDnaFromFile();
		int count = 0;
	    int index = 0;
	    while (index >= 0) {
	        index = s.indexOf(subSequence, index);
	        if (index >= 0) {
	            count++;
	            index += subSequence.length();
	        }


	    }
	    
		return count;	
	}

	public static void main(String args[]) {

		String subSequence = args[0];
		if (args.length != 1) {
			System.err.println("ERROR: expecting a single DNA sequence");
			System.exit(1);
		}

		int count = countSubsequences(subSequence);
		

		System.out.println(subSequence + " appears " + count + " times");

	}

}


