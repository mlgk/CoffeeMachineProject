package fr.coffee;

/**
 * 
 * @author Lydia
 *
 */
public class Orders {

	private  String typeDrink ; 
	
	public String getTypeDrink() {
		return typeDrink;
	}
	
	private int nbrSugar; 

	public Orders(String typeDrink, int nbrSugar) {
		super();
		this.typeDrink = typeDrink;
		this.nbrSugar = nbrSugar;
	}
	
	public int getNbSugar() {
		return nbrSugar;
	}

	
}
