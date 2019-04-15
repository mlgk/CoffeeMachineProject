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
	
	private CoffeeMachine machine =new CoffeeMachine();
	
	@Test
	public void getOrdersFromMachineExistTest(){
		
		Order order = new Order("Chocolate",2,0.5);
		
		assertEquals(machine.getOrdersFromMachine(order) , "Hh:2:0");
	}
	
	@Test
	public void getOrdersFromMachineNotExistTest(){
		
		Order order = new Order("Juice",1,0.5);

		assertEquals(machine.getOrdersFromMachine(order) , "M: The drink does not exist");
	}
	
	@Test
	public void getOrdersFromMachineNoSugarTest(){
		
		Order order = new Order("Tea",0,0.7);

		assertEquals(machine.getOrdersFromMachine(order) , "Th::");
	}
	

	@Test
	public void getOrdersFromMachineHaveMonneyTest(){
		
		Order order = new Order("Coffee",2,0.6);

		assertEquals(machine.getOrdersFromMachine(order) , "Ch:2:0");
	}
	
	@Test
	public void getOrdersFromMachineMonneyRestTest(){
		
		Order order = new Order("Coffee",2,0.4);

		assertEquals(machine.getOrdersFromMachine(order) , "M : It is missing : 0.2");
	}
	
	@Test
	public void getOrdersFromMachineHotDrinkTest(){
		
		Order order = new Order("Coffee",2,0.6);
		
		assertEquals(machine.getOrdersFromMachine(order) , "Ch:2:0");
	}
	
	@Test
	public void getOrdersFromMachineNotHotDrinkTest(){
		
		Order order = new Order("Orange Juice",5,0.6);

		assertEquals(machine.getOrdersFromMachine(order) , "O::");
	}
	
	@Test
	public void printRepotTest(){
		
		Order order = new Order("Coffee",5,0.6);
		
		Order order2 = new Order("Coffee",0,0.6);
		
		Order order3 = new Order("Tea",1,0.6);

		machine.getOrdersFromMachine(order);
		
		machine.getOrdersFromMachine(order2);
		
		machine.getOrdersFromMachine(order3);
		
		String newLine = System.getProperty("line.separator");
		
		assertEquals(machine.printReport() , "M: The coffee machine produces 2 Coffee, with a total of : 1.2 £"+newLine+"M: The coffee machine produces 1 Tea, with a total of : 0.4 £"+newLine);
	}
	
	
	@Test
	public void printEmptyTest(){
		
		assertEquals(machine.printReport() ,"M: The coffee machine did not produce any drinks");
	}
	
}







