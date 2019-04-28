package com.concentrationApp.items;

public class Item {
	// fields
	private String itemName;
	private String description;
	private int itemCategory;
	private int userId;

	// partial constructor
	public Item(String itemName, int itemCategory, int userId) {
		this(itemName, "", itemCategory, userId);
	}
	
	// full constructor
	public Item(String itemName, String description, int itemCategory, int userId) {
		setItemName(itemName);
		setDescription(description);
		setItemCategory(itemCategory);
		setUserId(userId);
	}
	
	/*
	 * Getters
	 */
	
	public String getItemName() {
		return itemName;
	}
	
	public int getItemCategory() {
		return itemCategory;
	}

	public String getDescription() {
		return description;
	}
	
	public int getUserId() {
		return userId;
	}
	
	/*
	 * Setters 
	 */

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public void setItemCategory(int itemCategory) {
		this.itemCategory = itemCategory;
	}

	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + itemCategory;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (itemCategory != other.itemCategory)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		String category = (itemCategory == 1)? "Must do" : "Want to do";
	
		return "Item name: " + itemName +
				"\nItem Description: " + description + 
				"\nItem category" + category +
				"\nUser id" + userId;
	}
	
}
