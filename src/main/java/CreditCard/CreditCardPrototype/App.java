package CreditCard.CreditCardPrototype;

import java.awt.List;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	static Orchestrator run = new Orchestrator();
	static Scanner scanner = new Scanner(System.in);
	static String lineOfInput = "";

	public static void main(String[] args) {
		/* Check if the any arguments are passed */
		if (args.length > 0) {
			if (args.length == 1) {
				ProcessFilebyName(args[0]);
			} else {
				// Read and print out each line.
				processInput(args);
			}
		}
		/* check for console input */
		else {
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			String line;

			try {
				while ((line = stdin.readLine()) != null && line.length()!= 0 || stdin.ready()) {
				    String[] input = line.split(" ");

				if (input[0].contains(("txt"))) {
					ProcessFilebyName(input[0]);
				} else {
					processInput(input);
				}
}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		run.display();
	}

	public static void ProcessFilebyName(String fileName) {
		try {
			FileInputStream fstream = new FileInputStream(fileName);
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
		}
	}

	public static void processInput(String[] input) {
		String inputToParse = new String();
		for (int i = 0; i < input.length; i++) {
			inputToParse = inputToParse + input[i] + " ";
			if (input[i].contains("$")) {
				run.formatInput(inputToParse);
				inputToParse = "";
			}

		}
	}
}
