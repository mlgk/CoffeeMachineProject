package fr.coffee;

/**
 * 
 * @author Lydia
 *
 */
public class Orders {

	private  String typeDrink ; 
	
	private double money ;
	
	public String getTypeDrink() {
		return typeDrink;
	}
	
	private int nbrSugar; 

	public Orders(String typeDrink, int nbrSugar , double money) {
		super();
		this.typeDrink = typeDrink;
		this.nbrSugar = nbrSugar;
		this.money=money;
	}
	
	public double getMoney() {
		return money;
	}

	public int getNbrSugar() {
		return nbrSugar;
	}

	public int getNbSugar() {
		return nbrSugar;
	}

	
}
