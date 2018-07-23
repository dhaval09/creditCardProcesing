package CreditCard.CreditCardPrototype;

public class Orchestrator {

	String name;
	String creditCardNumber;
	String dollarAmount;
	creditCardMethods test = new creditCardMethods();

	public void formatInput(String input) {

		String[] splitInput = input.split("\\s|\\$+");

		if (splitInput[0].equals("Add")) {
			name = splitInput[1];
			creditCardNumber = splitInput[2];
			dollarAmount = splitInput[4];
			test.add(name, creditCardNumber, dollarAmount);
		}

		if (splitInput[0].equals("Charge")) {
			name = splitInput[1];
			dollarAmount = splitInput[3];

			test.charge(name, dollarAmount);
			;
		}
		if (splitInput[0].equals("Credit")) {
			name = splitInput[1];
			dollarAmount = splitInput[3];
			test.credit(name, dollarAmount);
			;
		}
	}
	
	public void display()
	{
		test.print();
	}

}
