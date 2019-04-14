package fr.coffee;

/**
 * 
 * @author Lydia
 *
 */
public enum Drink {

	TEA ("T","Tea",0.4, true ), 
	COFFEE ("C","Coffee",0.6, true), 
	CHOCOLATE("H","Chocolate",0.5, true ),
	ORANGE_JUICE("O","Orange Juice",0.6, false);

	private String code;
	private String drinkName;
	private double price;
	private boolean extraHot;


	

	Drink(String code, String drinkName, double price, boolean extraHot) {
		this.code = code;
		this.drinkName = drinkName;
		this.price = price;
		this.extraHot = extraHot;
	}

	public String getCode() {
		return code;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public double getPrice() {
		return price;
	}
	public boolean isExtraHot() {
		return extraHot;
	}

	public String getdrinkName() {
		return drinkName;
	}



}
