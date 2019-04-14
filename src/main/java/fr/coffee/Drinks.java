package fr.coffee;

public enum Drinks {

	TEA ("T","Tea" ), 
	COFFEE ("C","Coffee"), 
	CHOCOLATE("H","Chocolate" );

	private String code;
	private String drinkName;


	Drinks(String code, String drinkName) {
		this.code = code;
		this.drinkName = drinkName;
	}

	public String getdrinkName() {
		return drinkName;
	}

	public String getcode() {
		return code;
	}


}
