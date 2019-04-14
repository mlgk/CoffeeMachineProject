package fr.coffee.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.coffee.CoffeeMachine;
import fr.coffee.Order;

/**
 * 
 * @author Lydia
 *
 */
public class TestCoffeeMachine {
	
	@Test
	public void getOrdersFromMachineExistTest(){
		
		Order order = new Order("Chocolate",2,0.5);
		
		CoffeeMachine machine =new CoffeeMachine();

		assertEquals(machine.getOrdersFromMachine(order) , "Hh:2:0");
	}
	
	@Test
	public void getOrdersFromMachineNotExistTest(){
		
		Order order = new Order("Juice",1,0.5);
		
		CoffeeMachine machine =new CoffeeMachine();

		assertEquals(machine.getOrdersFromMachine(order) , "M: The drink does not exist");
	}
	
	@Test
	public void getOrdersFromMachineNoSugarTest(){
		
		Order order = new Order("Tea",0,0.7);
		
		CoffeeMachine machine =new CoffeeMachine();

		assertEquals(machine.getOrdersFromMachine(order) , "Th::");
	}
	

	@Test
	public void getOrdersFromMachineHaveMonneyTest(){
		
		Order order = new Order("Coffee",2,0.6);
		
		CoffeeMachine machine =new CoffeeMachine();

		assertEquals(machine.getOrdersFromMachine(order) , "Ch:2:0");
	}
	
	@Test
	public void getOrdersFromMachineMonneyRestTest(){
		
		Order order = new Order("Coffee",2,0.4);
		
		CoffeeMachine machine =new CoffeeMachine();

		assertEquals(machine.getOrdersFromMachine(order) , "M : It is missing : 0.2");
	}
	
	@Test
	public void getOrdersFromMachineHotDrinkTest(){
		
		Order order = new Order("Coffee",2,0.6);
		
		CoffeeMachine machine =new CoffeeMachine();

		assertEquals(machine.getOrdersFromMachine(order) , "Ch:2:0");
	}
	
	@Test
	public void getOrdersFromMachineNotHotDrinkTest(){
		
		Order order = new Order("Orange Juice",5,0.6);
		
		CoffeeMachine machine =new CoffeeMachine();

		assertEquals(machine.getOrdersFromMachine(order) , "O::");
	}
	
}







