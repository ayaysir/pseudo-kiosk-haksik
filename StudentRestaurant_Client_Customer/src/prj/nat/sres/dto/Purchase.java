package prj.nat.sres.dto;

public class Purchase {
	
	private int menuIndex, quantity;

	public Purchase(int menuIndex, int quantity) {
		super();
		this.menuIndex = menuIndex;
		this.quantity = quantity;
	}

	public int getMenuIndex() {
		return menuIndex;
	}

	public void setMenuIndex(int menuIndex) {
		this.menuIndex = menuIndex;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
