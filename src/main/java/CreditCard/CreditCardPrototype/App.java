package CreditCard.CreditCardPrototype;

import java.awt.List;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Orchestrator run = new Orchestrator();
		Scanner scanner = new Scanner(System.in);
		String lineOfInput= "";
		if (args.length != 0) {
		lineOfInput = args[0];
		}
		else {
			// Read and print out each line.
			    lineOfInput = scanner.next();
				System.out.println(lineOfInput);
			
		}
		if(lineOfInput.contains("txt"))
		{
			try {	
			FileInputStream fstream = new FileInputStream(lineOfInput);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			// BufferedReader input = new BufferedReader(new FileReader(aFile));

			String strLine = null;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console

				run.formatInput(strLine);

			}
			// Close the input stream
			in.close();
			
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		} finally {
			run.display();
		}
	}
		else {
			while (scanner.hasNextLine()) {
				ArrayList<Object> tokens = new ArrayList<>();
				Scanner lineScanner = new Scanner(scanner.nextLine());

				while (lineScanner.hasNext()) {
					tokens.add(lineScanner.next());
				}
				
				lineScanner.close();
				System.out.println(tokens);
				for (Object s : tokens)
				{
					lineOfInput += s + "\t";
					run.formatInput(lineOfInput);
				}
			
			
		}
		}
	}
}
