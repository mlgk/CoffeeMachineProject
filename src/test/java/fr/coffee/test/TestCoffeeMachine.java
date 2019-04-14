package fr.coffee.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.coffee.CoffeeMachine;
import fr.coffee.Orders;

/**
 * 
 * @author Lydia
 *
 */
public class TestCoffeeMachine {
	
	@Test
	public void getOrdersFromMachineExistTest(){
		
		Orders order = new Orders("Chocolate",2);
		
		CoffeeMachine machine =new CoffeeMachine();

		assertEquals(machine.getOrdersFromMachine(order) , "H:2:0");
	}
	
	@Test
	public void getOrdersFromMachineNotExistTest(){
		
		Orders order = new Orders("Juice",1);
		
		CoffeeMachine machine =new CoffeeMachine();

		assertEquals(machine.getOrdersFromMachine(order) , "M: The drink does not exist");
	}
	
	@Test
	public void getOrdersFromMachineNoSugarTest(){
		
		Orders order = new Orders("Tea",0);
		
		CoffeeMachine machine =new CoffeeMachine();

		assertEquals(machine.getOrdersFromMachine(order) , "T::");
	}
}







