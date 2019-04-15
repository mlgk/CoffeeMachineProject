package fr.coffee;

/**
 * 
 * @author Lydia
 *
 */
public class Main {

	public static void main(String[] args) {

		//initialize an order
		Order tea = new Order("Tea",0,0.6);
		
		CoffeeMachine machine =new CoffeeMachine();

		System.out.println(machine.getOrdersFromMachine(tea));
		
		System.out.println(machine.printReport());
		
	}
}
