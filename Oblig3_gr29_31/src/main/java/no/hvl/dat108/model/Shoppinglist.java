package no.hvl.dat108.model;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope
public class Shoppinglist {
	private List<String> shoppingList;
	private String item;
	
	
	//Not sure whether or not this ensures thread safety.
	public Shoppinglist(List<String> shoppingList) {
		this.shoppingList = Collections.synchronizedList(shoppingList);
	}

	public List<String> getShoppinglist() {
		return shoppingList;
	}

	public void setShoppinglist(List<String> shoppinglist) {
		shoppingList = shoppinglist;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	/**
	 * This method will add item to the shopping list if said item is not an empty
	 * string or null
	 * 
	 * @param item - String representation of the item to be added.
	 */

	public void addItemToList(String item) {
		// Won't add an item if it is an empty string or if its value is null.
		if (item != null && item != "") {
			shoppingList.add(item);
		}
	}

	/**
	 * This item will delete a given item when the "delete" button is clicked if the
	 * delete value is not null, and the value exists in the shoppinglist
	 * 
	 * @param delete - string representation of the item to be deleted
	 */
	public void deleteItemFromList(String delete) {
		// Precaution to check if delete == null or an empty string.
		// if the add method is implemented properly this shouldn't be necessary.
		if (delete != null && delete != "") {
			// checks if the shoppingList contains said element, if it does, it will delete.
			// This will prevent errors when
			// multiple users tries to delete an item from the list.
			if (shoppingList.contains(delete)) {
				shoppingList.remove(shoppingList.indexOf(delete));
			}
		}
	}

}
