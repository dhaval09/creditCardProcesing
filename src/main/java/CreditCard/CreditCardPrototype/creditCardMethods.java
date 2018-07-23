package CreditCard.CreditCardPrototype;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class creditCardMethods {

	HashMap<String, String> Limit = new HashMap<String, String>();
	HashMap<String, String> balanceSheet = new HashMap<String, String>();
	Validation validate = new Validation();

	/* This method will add new customer with a valid credit card */
	public String add(String name, String creditCard, String amount) {
		String returnValue = "ERROR";
		try {
			
			boolean flag = validate.validateCreditCardNumber(creditCard);

			if (flag && !amount.isEmpty()) {
				Limit.put(name, amount);
				returnValue = "SUCCESS";
			} else {
				balanceSheet.put(name, "error");
				returnValue = "ERROR";
			}
		} catch (Exception e) {
		}
		return returnValue;
	}

	/* This method will add charge the customer */
	public String charge(String name, String charge) {
		String returnValue = "ERROR";
		String LimitAllowed = Limit.get(name);
		if (!LimitAllowed.equals("error") && !charge.isEmpty()) {
			String currentBalance = balanceSheet.get(name) != null ? balanceSheet.get(name) : "0";
			int LimitAllowedToCharge = Integer.parseInt(LimitAllowed);
			int currentCharges = Integer.parseInt(currentBalance);
			int amountToCharge = Integer.parseInt(charge);
			if (LimitAllowedToCharge >= amountToCharge + currentCharges) {
				int BalanceCharge = amountToCharge + currentCharges;
				String BalanceLeft = String.valueOf(BalanceCharge);
				balanceSheet.put(name, BalanceLeft);
				returnValue = "SUCCESS";
			}
		}
		return returnValue;
	}

	/* This method will add credit the customer */
	public String credit(String name, String credit) {
		String returnValue = "ERROR";
		String Balance = balanceSheet.get(name);
		if (!Balance.equals("error") && !credit.isEmpty()) {
			int availableBalance = Integer.parseInt(Balance);
			int amountToCredit = Integer.parseInt(credit);
			availableBalance = availableBalance - amountToCredit;
			String BalanceLeft = String.valueOf(availableBalance);
			balanceSheet.put(name, BalanceLeft);
			returnValue = "SUCCESS";
		}
		return returnValue;
	}

	public void print() {
		TreeMap<String, String> sorted = new TreeMap<>();
		// Copy all data from hashMap into TreeMap
		sorted.putAll(balanceSheet);
		for (Entry<String, String> entry : sorted.entrySet())
			System.out.println(entry.getKey() + ":" + "$" + " " + entry.getValue());
	}
}
