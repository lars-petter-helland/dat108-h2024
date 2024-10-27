package no.hvl.dat108.webshop.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    
    private List<CartItem> items = new ArrayList<>();
    
    public void addItem(CartItem item) {
    	
    	if (items.contains(item)) {
    		int foundAtIndex = items.indexOf(item);
    		items.get(foundAtIndex).changeQuantity(item.getQuantity());
    		
    	} else {
    		items.add(item);
    	}
    }
    
    public List<CartItem> getItems() {
        return items;
    }
    
    public int getTotal() {
        return items.stream().mapToInt(i -> i.getPrice()*i.getQuantity()).sum();
    }

}
