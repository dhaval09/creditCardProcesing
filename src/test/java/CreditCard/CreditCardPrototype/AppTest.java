package CreditCard.CreditCardPrototype;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	Orchestrator run = new Orchestrator();
	creditCardMethods testStub = new creditCardMethods();
	
	public void checkInputWithInvalidString() {
		run.formatInput("this is not a valid String");
	}

	public void checkInputWithValidString() {

		run.formatInput("Add Tom 4111111111111111 $1000");
	}

	public void checkInputWithNull() {
		run.formatInput("");
	}
	
	public void testAddwithValid()
	{
		String name = "TOM";
		String creditCard = "4111111111111111 ";
		String amount = "1000";
		testStub.add(name, creditCard, amount);
	}
	public void testAddwithInValid()
	{
		String name = "FAIL";
		String creditCard = " ";
		String amount = "1000";
		testStub.add(name, creditCard, amount);
	}
	
	public void testChargewithValid()
	{
		String name = "TOM";
		String creditCard = "4111111111111111 ";
		String amount = "1000";
		String charge = "500";
		testStub.add(name, creditCard, amount);
		testStub.charge(name, charge);
	}
	public void testChargewithInValid()
	{
		String name = "TOM";
	    String creditCard = "4111111111111111 ";
		String amount = "1000";
		String charge = "5000";
		testStub.add(name, creditCard, amount);
		testStub.charge(name, charge);
	}
	
	public void testCreditwithValid()
	{
		String name = "TOM";
		String creditCard = "4111111111111111 ";
		String amount = "1000";
		String charge = "300";
		String credit = "100";
		testStub.add(name, creditCard, amount);
		testStub.charge(name, charge);
		testStub.credit(name, credit);;
	}
	
	public void testCreditwithInValid()
	{
		String name = "TOM";
		String creditCard = "4111111111111111 ";
		String amount = "1000";
		String charge = "1400";
		String credit = "1343.235";
		testStub.add(name, creditCard, amount);
		testStub.charge(name, charge);
		testStub.credit(name, credit);;
	}
	
}
