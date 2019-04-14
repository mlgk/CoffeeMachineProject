package fr.coffee;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Lydia
 *
 */
public class CoffeeMachine {

	// List of type drinks
	private static List<Drinks> typeDrinks = Arrays.asList(Drinks.values());

	/**
	 * Get Order From Machine
	 * 
	 * @param order
	 * @return message
	 */
	public String getOrdersFromMachine(Orders order) {

		String message = "";

		for (Drinks drinks : typeDrinks) {

			// if found drink
			if (drinks.getdrinkName() == order.getTypeDrink()) {

				message = getMessage(order.getNbSugar(), drinks);
				
				break;
				
			} else {

				message = "M: The drink does not exist";
			}

		}

		return message;
	}

	/**
	 * Write Message function
	 * 
	 * @param sugar
	 *            number of sugar
	 * @param drink
	 *            type of drink
	 * @return message
	 */
	public String getMessage(int sugar, Drinks drink) {

		StringBuilder msg = new StringBuilder();

		if (sugar <= 5 && sugar >= 0) {

			msg.append(drink.getcode());

			if (sugar == 0) {

				msg.append(":").append(":");

			} else {

				msg.append(":").append(sugar).append(":").append("0");

			}

		} else {

			msg.append("M:").append("The number of sugar must be between 0 and 5");
		}

		return msg.toString();
	}

}
