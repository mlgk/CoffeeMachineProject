package fr.coffee;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.coffee.machine.service.BeverageQuantityChecker;
import fr.coffee.machine.service.EmailNotifier;

/**
 * 
 * @author Lydia
 *
 */
public class CoffeeMachine {

	// List of type drinks
	private static List<Drink> typeDrinks = Arrays.asList(Drink.values());

	private static Map<Drink, Integer> map;

	private  BeverageQuantityChecker beverageQuantityChecker =null;

	private  EmailNotifier emailNotifier = null;

	private Drink drink;

	public CoffeeMachine( BeverageQuantityChecker beverageQuantityChecker, EmailNotifier emailNotifier) {

		map = new HashMap<>();

		this.beverageQuantityChecker = beverageQuantityChecker;

		this.emailNotifier = emailNotifier;
	}

	public CoffeeMachine( ){

		map = new HashMap<>();

	}


	/**
	 * Get Order From Machine
	 * 
	 * @param order
	 * @return message
	 */
	public String getOrdersFromMachine(Order order) {

		String message = "";

		drink = getDrink(order);

		if(drink != null){

			// sugar between 0 and 5
			if (order.getNbSugar() <= 5 && order.getNbSugar() >= 0) {

				if(isEmptyDrink(order)){

					message = "M: Drink missing";
				}		
				else
				{

					message = moneyChecker(order, drink);

					report(drink);
				}

			} else {

				message = "M: The number of sugar must be between 0 and 5";
			}

		} else {

			message = "M: The drink does not exist";
		}


		return message;
	}

	/**
	 * check the availability of the drink in the machine
	 * @param order
	 * @return true if the drink is not available
	 */
	private boolean isEmptyDrink(Order order){

		boolean result = false;
		
		if(beverageQuantityChecker!=null && emailNotifier!=null){
			
			if(beverageQuantityChecker.isEmpty(order.getTypeDrink())) 		
			{

				emailNotifier.notifyMissingDrink(order.getTypeDrink());

				result = true;
			}
		}

		return result ;
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
	private static String getMessage(int sugar, Drink drink) {

		StringBuilder msg = new StringBuilder();

		// check if drink is hot
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
	private static String moneyChecker(Order order, Drink drink) {

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
	 * 
	 * @param extraHot
	 * @return
	 */
	private static String getExtraHot(boolean extraHot) {
		String hot = "h";

		if (extraHot != true) {
			hot = "";
		}

		return hot;
	}

	/**
	 * get Drink 
	 * @param order
	 * @return drink
	 */
	private static Drink getDrink(Order order) {
		Drink drink = null;
		for (Drink dr : typeDrinks) {
			if (dr.getDrinkName() == order.getTypeDrink()) {
				drink = dr;
				break;
			}
		}

		return drink;
	}

	/**
	 * Stock the report of drink in map
	 * @param drink
	 */
	private static void report(Drink drink) {

		if (map.containsKey(drink)) {

			map.put(drink, map.get(drink) + 1);

		} else {

			map.put(drink, 1);
		}

	}

	/**
	 * print the report
	 * @return message of report
	 */
	public String printReport(){

		double sumMoney;

		StringBuilder msg = new StringBuilder();

		String newLine = System.getProperty("line.separator");

		if(!map.isEmpty()){

			for(Entry<Drink, Integer> entry : map.entrySet()) {

				sumMoney = (entry.getKey().getPrice()) * (entry.getValue());

				msg.append("M: The coffee machine produces ").append(entry.getValue()).append(" ").append(entry.getKey().getDrinkName()).append(", with a total of").append(" : ").append(sumMoney).append(" £").append(newLine);
			}

		}else{

			msg.append("M: The coffee machine did not produce any drinks");
		}

		return msg.toString();
	}
}
