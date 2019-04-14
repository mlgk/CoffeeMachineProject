package fr.coffee;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Lydia
 *
 */
public class CoffeeMachine {

	// List of type drinks
	private static List<Drink> typeDrinks = Arrays.asList(Drink.values());

	/**
	 * Get Order From Machine
	 * 
	 * @param order
	 * @return message
	 */
	public String getOrdersFromMachine(Order order) {

		String message = "";

		for (Drink drink : typeDrinks) {

			// if found drink
			if (drink.getdrinkName() == order.getTypeDrink()) {

				// sugar between 0 and 5
				if (order.getNbSugar() <= 5 && order.getNbSugar() >= 0) {

					message = moneyChecker(order, drink);

					break;

				} else {

					message = "M: The number of sugar must be between 0 and 5";
				}

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
	public String getMessage(int sugar, Drink drink) {

		StringBuilder msg = new StringBuilder();
		
		//check if drink is hot
		String hot = getExtraHot(drink.isExtraHot());
		
		msg.append(drink.getCode()).append(hot);

		if (sugar == 0 || !drink.isExtraHot()) {

			msg.append(":").append(":");

		} else {

			msg.append(":").append(sugar).append(":").append("0");

		}

		return msg.toString();
	}

	/**
	 * Cheking of money
	 * 
	 * @param order
	 * @param drink
	 * @return message
	 */
	public String moneyChecker(Order order, Drink drink) {

		String message = "";

		// if the amount is sufficient
		if (order.getMoney() >= (drink.getPrice())) {

			message = getMessage(order.getNbSugar(), drink);

		} else {

			// calculate the rest
			BigDecimal restOfMoney = BigDecimal.valueOf(drink.getPrice())
					.subtract(BigDecimal.valueOf(order.getMoney()));

			message = "M : It is missing : " + restOfMoney;

		}

		return message;
	}

	/**
	 * get extra hot of drink
	 * @param extraHot
	 * @return
	 */
	public String getExtraHot(boolean extraHot) {
		String hot = "h";

		if (extraHot != true) {
			hot = "";
		}

		return hot;
	}

}
