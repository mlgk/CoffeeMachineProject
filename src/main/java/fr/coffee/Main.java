package fr.coffee;

/**
 * 
 * @author Lydia
 *
 */
public class Main {

	public static void main(String[] args) {

		//initialize an order
		Orders order = new Orders("Juis",-1);
	
		CoffeeMachine machine =new CoffeeMachine();

		System.out.println(machine.getOrdersFromMachine(order));
		
	}
}
