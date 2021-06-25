public class Item {
	public String name;
	public String description;
	public double weight;
	
	//attributes
	public boolean canEat;
	public boolean opensDoor;
	public boolean canAttack;
	public boolean canRead;
	
	public Item(String n, String d, double w, boolean food, boolean key, boolean weapon,boolean read ) {
		name = n;
		description = d;
		weight = w;
		
		canEat = food;
		opensDoor = key;
		canAttack = weapon;
		canRead = read;
	}
	//constructor used for searching for items in inventory
	public Item(String n) {
		name = n;
	}
	
	public String inspect() {
		return description;
	}
	
	public String getName() {
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public boolean equals(Object o) { //equal if they have the same name
		Item i = (Item) o;
		return i.getName().equals(name);
	}
	
	
}
