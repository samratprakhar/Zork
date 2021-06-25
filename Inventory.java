import java.util.ArrayList;
import java.util.Collections;

public class Inventory {
	
	public static ArrayList<Item> inventory = new ArrayList<>();

	private static double weight = 0;
	
	public static final double MAX_WEIGHT = 5.0;
	
	public static double getWeight() {
		return weight;
	}
	
	public static boolean searchInventory(String name) {
		Item target = new Item(name);
		for (Item i : inventory) {
			if(target.getName().equals(i.getName())){
				return true;
			}
		}
		return false;
	}

	public static void printInventory() {
		if (inventory.size() == 0) {
			play.textArea.append("empty\n");	
		}
		for (Item i : inventory) {
			Commands.out=(i.getName());
			play.textArea.append(Commands.out+"\n");
		}
	}
	
	public static String drop(String name) {
		Item target = new Item(name);
		if(inventory.contains(target)) {
			int i = inventory.indexOf(target);
			Item item = inventory.remove(i);
			Commands.currentRoom.takeFromPlayer(item);
			
			weight -= item.getWeight();
			
			return "Dropped the " + name;
		}
		else {
			return "I don't have a " + name;
		}
	}
	
	public static String add(Item i) {
		if (weight + i.getWeight() < 5) {
			inventory.add(i);
			weight += i.getWeight();
			
			Collections.sort(inventory, (a, b) -> a.getName().compareTo(b.getName()));
			
			return "Added to  inventory\n";
		}
		else {
			Commands.currentRoom.takeFromPlayer(i);
			return "The inventory is too heavy\n";
		}
	}
	
	public static String inspect(String name) {
		Item target = new Item(name);
		if(inventory.contains(target)) {
			int i = inventory.indexOf(target);
			return inventory.get(i).inspect();
		}
		else {
			return "I don't have a " + name ;
		}
	}
	
	
	public static String eat(String name) {
		Item target = new Item(name);
		if(inventory.contains(target)) {
			int i = inventory.indexOf(target);
			Item item = inventory.remove(i);
			
			if (item.canEat) {
				//maybe do something useful
				return "Ate the " + name;
			}
			else {
				return "The " + name + " does not look like it tastes very good";
			}
		}
		else {
			return "I don't have a " + name;
		}
	}
	
	public static String shoot(String name) {
		Item target = new Item(name);
		if(inventory.contains(target)) {
			int i = inventory.indexOf(target);
			Item item = inventory.get(i);
			
			if (item.canAttack) {
				if (Commands.row == 4 && Commands.col == 2) {
					Commands.out = ("Your " + name + " has cut through the boulder");
					play.textArea.append(Commands.out+"\n");
					Commands.map[4][2][3].unlock();
					Commands.row++;
					Commands.lastRow = Commands.row;
					Commands.lastCol =Commands.col;
					return "Broke the boulder";
				}
				else if (Commands.row == 5 && Commands.col == 8) {
					Commands.out = ("Your " + name + " has cut through the electrosaurce");
					play.textArea.append(Commands.out+"\n");
					if (Commands.currentRoom ==Commands.map[5][8][4] &&!Inventory.searchInventory("screw")&&!Inventory.searchInventory("gloves")){
						play.textArea.append("Some tools will be required to repair the electricity line\n");
					}
					if (Commands.currentRoom ==Commands.map[5][8][4] &&Inventory.searchInventory("screw")&&Inventory.searchInventory("gloves")){
						play.textArea.append("The 24 mega volts supply is back\n");
						Commands.power = true;
					}
					Commands.electrosaurce =false;
					return "Killed electrosaurce";
				}
				else {
				return "Not at correct position" ;}
			}
			else {
				return "The " + name + " is not a weapon";
			}
		}
		else {
			return "I don't have a " + name;
		}
	}
	
	
	public static boolean findKey(String name) {
		Item target = new Item(name);
		if(inventory.contains(target)) {
			int i = inventory.indexOf(target);
			Item item = inventory.get(i);
			
			if (item.opensDoor) {
				return true;
			}
			else {
				return false;
			}
		}
		
		return false;
	}
	
}
