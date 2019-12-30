package prj.nat.sres.dto;

import java.io.Serializable;

public class Menu implements Serializable {
	
	static final long serialVersionUID = 10042456774L;
	
	String category, menuName;
	int price, quantity;
	
	public Menu() {
		super();
	}

	public Menu(String category, String menuName, int price, int quantity) {
		super();
		this.category = category;
		this.menuName = menuName;
		this.price = price;
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String toCSV() {
		return category + "," + menuName + "," + price + "," + quantity;
	}
	

}
