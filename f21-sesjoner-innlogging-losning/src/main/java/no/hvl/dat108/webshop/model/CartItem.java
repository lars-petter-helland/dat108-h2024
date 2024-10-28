package no.hvl.dat108.webshop.model;

import java.util.Objects;

public class CartItem {
    
    private String name;
    private int price;
    private int quantity;
    
    public CartItem(String name, int price) {
        this.name = name;
        this.price = price;
        this.quantity = 1;
    }
    
    public void changeQuantity(int n) {
    	quantity += n;
    }

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		return Objects.equals(name, other.name);
	}

	
    
}
