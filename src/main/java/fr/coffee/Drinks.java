package fr.coffee;

/**
 * 
 * @author Lydia
 *
 */
public enum Drinks {

	TEA ("T","Tea",0.4 ), 
	COFFEE ("C","Coffee",0.6), 
	CHOCOLATE("H","Chocolate",0.5 );

	private String code;
	private String drinkName;
	private double price;


	public String getCode() {
		return code;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public double getPrice() {
		return price;
	}

	Drinks(String code, String drinkName, double price) {
		this.code = code;
		this.drinkName = drinkName;
		this.price = price;
	}

	public String getdrinkName() {
		return drinkName;
	}

	public String getcode() {
		return code;
	}


}
