package CreditCard.CreditCardPrototype;


public class Orchestrator {

	String name;
	String creditCardNumber;
	String dollarAmount;
	creditCardMethods callFunction = new creditCardMethods();

	public boolean formatInput(String input) {
		boolean flag = false ;
		String[] splitInput = input.split("\\s|\\$+");

		if (splitInput[0].equals("Add")) {
			name = splitInput[1];
			creditCardNumber = splitInput[2];
			dollarAmount = splitInput[4];
			callFunction.add(name, creditCardNumber, dollarAmount);
			flag= true;
		}
		if (splitInput[0].equals("Charge")) {
			name = splitInput[1];
			dollarAmount = splitInput[3];
			callFunction.charge(name, dollarAmount);
			flag= true;
		}
		if (splitInput[0].equals("Credit")) {
			name = splitInput[1];
			dollarAmount = splitInput[3];
			callFunction.credit(name, dollarAmount);
			flag= true;
		}
		return flag;
	}

	public void display() {
		callFunction.print();
	}

}
