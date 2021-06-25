import java.util.ArrayList;

/**
 * Your job is to complete the class.
 * Everywhere you find comments, you must complete the task noted
 * The purpose of this class is to allow us to create room objects that   
 * determine which rooms are connected and contain the description of the room
 * We will add the ability to have contents later
 */
 


//Create the class Room - note it must be named Room
public class Room {


	/**
	 * Create the following instance variables, be sure to encapsulate them
	 * canGo<Direction> for example canGoNorth.  There should be 1 for each direction and they are type boolean.
	 * description - this a String that contains the description of the room
	 * name - this is a String that contains the name of the room 
	 */
	
	private boolean canGoNorth;
	private boolean canGoSouth;
	private boolean canGoWest;
	private boolean canGoEast;
	public int counter;
	public String description;
	public String name;
	
	private boolean northLocked = false;
	private boolean southLocked = false;
	private boolean westLocked  = false;
	private boolean eastLocked  = false;

	private ArrayList<Item> itemsOnGround = new ArrayList<Item>();
	private ArrayList<vehicle> vehicleList = new ArrayList<vehicle>();
	
	/**Creates a default constructor with no parameters
	 * it populates all of the instance variables with default values of false for movement
	 * it also adds a description that this is not actually a room and gives it a name of "Not a Room"
	 */
	public Room() {
		description = "This is not actually a room";
		name = "Not a room"; 
		canGoNorth = true;
		canGoSouth = true;
		canGoWest = true;
		canGoEast = true;
	}
	
	/** create a constructor that builds an instance of this object and populates all of the instance variables with the values in the parameters
	 * 
	 * @param north  - boolean used to populate canGoNorth
	 * @param south  - boolean used to populate canGoSouth
	 * @param east  - boolean used to populate canGoEast
	 * @param west  - boolean used to populate canGoWest
	 * @param d  - String used to populate description
	 * @param n  - String used to populate name
	 * */
	public Room(boolean north, boolean south, boolean east, boolean west, int c,String n, String d) {
		description = d;
		name = n; 
		counter = c;
		canGoNorth = north;
		canGoSouth = south;
		canGoWest = west;
		canGoEast = east;
	}
	
	public Room(boolean north, boolean south, boolean east, boolean west, int c,String n, String d, Item i) {
		description = d;
		name = n; 
		counter = c;
		canGoNorth = north;
		canGoSouth = south;
		canGoWest = west;
		canGoEast = east;
		
		itemsOnGround.add(i);
	}

	public Room(boolean north, boolean south, boolean east, boolean west, int c,String n, String d, vehicle v) {
		description = d;
		name = n; 
		counter = c;
		canGoNorth = north;
		canGoSouth = south;
		canGoWest = west;
		canGoEast = east;
		
		vehicleList.add(v);
	}

	public Room(boolean north, boolean south, boolean east, boolean west, int c,String n, String d, Item i, Item i1) {
		description = d;
		name = n; 
		counter = c;
		canGoNorth = north;
		canGoSouth = south;
		canGoWest = west;
		canGoEast = east;
		
		itemsOnGround.add(i);
		itemsOnGround.add(i1);
	}

	public Room(boolean north, boolean south, boolean east, boolean west, int c,String n, String d, Item i,Item i1,Item i2) {
		description = d;
		name = n; 
		counter = c;
		canGoNorth = north;
		canGoSouth = south;
		canGoWest = west;
		canGoEast = east;

		itemsOnGround.add(i);
		itemsOnGround.add(i1);
		itemsOnGround.add(i2);
	}
	public Room(boolean north, boolean south, boolean east, boolean west, int c,String n, String d, Item i,Item i1,Item i2,Item i3) {
		description = d;
		name = n; 
		counter = c;
		canGoNorth = north;
		canGoSouth = south;
		canGoWest = west;
		canGoEast = east;

		itemsOnGround.add(i);
		itemsOnGround.add(i1);
		itemsOnGround.add(i2);
		itemsOnGround.add(i3);
	}

	public Room(boolean north, boolean south, boolean east, boolean west, int c,String n, String d, vehicle v, Item i) {
		description = d;
		name = n; 
		canGoNorth = north;
		canGoSouth = south;
		canGoWest = west;
		canGoEast = east;
		
		vehicleList.add(v);
		itemsOnGround.add(i);
	}
	
	
	public Room(boolean north, boolean south, boolean east, boolean west, int c,String n, String d, boolean northL, boolean southL, boolean eastL, boolean westL) {
		description = d;
		name = n; 
		counter = c;
		canGoNorth = north;
		canGoSouth = south;
		canGoWest = west;
		canGoEast = east;
		


		northLocked = northL;
		southLocked = southL;
		westLocked  = westL;
		eastLocked  = eastL;
	}
	public Room(boolean north, boolean south, boolean east, boolean west, int c,String n, String d,Item i, boolean northL, boolean southL, boolean eastL, boolean westL) {
		description = d;
		name = n; 
		counter = c;
		canGoNorth = north;
		canGoSouth = south;
		canGoWest = west;
		canGoEast = east;
		
		itemsOnGround.add(i);

		northLocked = northL;
		southLocked = southL;
		westLocked  = westL;
		eastLocked  = eastL;
	}
	/**
	 * Create the instance method getName
	 * this is accessor method used to retrieve the value of the room name
	 * @return a string value containing Room.name
	 */
	public String getName() {return name;}
	public String getName(String re) {
		re = name;
		return re;
	}
	/**
	 * Create the instance method getDescription
	 * this is accessor method used to retrieve the value of description
	 * @return a string value containing description
	 */
	public String getDescription() {return description;}
	/**
	 * Create the instance method called setDescription
	 * this is a mutator method that sets the room description
	 * @param d is the description of the room
	 */
	public void setDescription(String d) {description = d;}
	/**
	 * Create the instance method called setName
	 * this is a mutator method that sets the room name
	 * @param n is the name you want the room to have
	 */
	public void setName(String n) {name = n;}
	/**
	 * Create the instance method getCanGoNorth
	 * this is accessor method used to retrieve the value of canGoNorth
	 * @return a boolean value that indicates if a player may move North
	 */
	public boolean getCanGoNorth() {return canGoNorth;}
	/**
	 * Create the instance method getCanGoSouth
	 * this is accessor method used to retrieve the value of canGoSouth
	 * @return a boolean value that indicates if a player may move South
	 */
	public boolean getCanGoSouth() {return canGoSouth;}
	/**
	 * Create the instance method getCanGoEast
	 * this is accessor method used to retrieve the value of canGoEast
	 * @return a boolean value that indicates if a player may move East 
	 */
	public boolean getCanGoEast() {return canGoEast;}
	
	/**
	 * Create the instance method getCanGoWest
	 * this is accessor method  used to retrieve the value of canGoWest
	 *@return a boolean value that indicates if a player may move West
	 */
	public boolean getCanGoWest() {return canGoWest;}
	
	public boolean getNorthLocked() {return northLocked;}
	
	public boolean getEastLocked() {return eastLocked;}
	
	public boolean getWestLocked() {return westLocked;}
	
	public boolean getSouthLocked() {return southLocked;}
	
	
	
	/**
	 * Create the instance method setCanGoNorth
	 * this is mutator method used to change the value of canGoNorth
	 * @param b a boolean value that allows players to move North if it is true or not be able to if its false
	 */
	public void setCanGoNorth(boolean b) {canGoNorth = b;}
	/**
	 * Create the instance method setCanGoSouth
	 * this is mutator method used to change the value of canGoSouth
	 * @param b a boolean value that allows players to move South if it is true or not be able to if its false
	 */
	public void setCanGoSouth(boolean b) {canGoSouth = b;}
	/**
	 * Create the instance method setCanGoEast
	 * this is mutator method used to change the value of canGoEast
	 * @param b a boolean value that allows players to move East if it is true or not be able to if its false
	 */
	public void setCanGoEast(boolean b) {canGoEast = b;}
	
	/**
	 * Create the instance method setCanGoWest
	 * this is mutator method  used to change the value of canGoWest
	 * @param b a boolean value that allows players to move West if it is true or not be able to if its false
	 */
	
	public void setCanGoWest(boolean b) {canGoWest = b;}
	/**
	 * Create the instance method toString
	 * this is accessor method used to retrieve the state of the room you are in
	 * example output (Kitchen - A room with a table and fridge  GoNorth: True GoSouth:False GoEast: True GoWest: True)
	 * @return a String with the Room Name, Description, and the ability to move each direction 
	 */
	public String toString() {
		return name + " - " + description + " GoNorth:" + canGoNorth + " GoSouth:" + canGoSouth + " GoEast:" + canGoEast + " GoWest:" + canGoWest;
	}
	
	public void takeFromPlayer(Item i) {
		itemsOnGround.add(i);
	}
	
	public Item playerTake(String name) {
		 Item target = new Item(name);

		 int i = itemsOnGround.indexOf(target);
		 
		 if (i > -1) {
			return itemsOnGround.remove(i);
		 }
		 else {
			 return null;
		 }
	}


	public boolean playerEnter(String name) {
		boolean result = false;
		int i ;
		for (i=0;i<vehicleList.size();i++) {
			String t = name;
			String m = vehicleList.get(i).name; 
				if (t.equals(m)){
					result = vehicleList.get(i).door;
					break;
				}
				}
		return result;

   	}

	public boolean isVehiclePresent(String name) {
		boolean result = false;
		int i ;
		for (i=0;i<vehicleList.size();i++) {
			String t = name;
			String m = vehicleList.get(i).name; 
				if (t.equals(m)){
					result = true;
					break;
				}
				}
		return result;
   	}

	public void unlockdoor(String name) {
		int i ;
		for (i=0;i<vehicleList.size();i++) {
			String t = name;
			String m = vehicleList.get(i).name; 
				if (t.equals(m)){
					break;
				}
				}
		if (i<vehicleList.size()){
			vehicle temp =new vehicle ( name,true);
			vehicleList.set(i,temp);
		}
   	}

   	public boolean playerRead(String name) {
	String message ="Can't read ";
	int i,j;
	for (i=0;i<itemsOnGround.size();i++) {
		String t = name;
		String m = itemsOnGround.get(i).name; 
			if (t.equals(m)){
				message = itemsOnGround.get(i).description;
				break;
			}
			}
	for (j=0;j<Inventory.inventory.size();j++) {
		String t = name;
		String m = Inventory.inventory.get(j).name; 
			if (t.equals(m)){
				message = Inventory.inventory.get(j).description;
				break;
			}
		}
	if (i<itemsOnGround.size() || j<Inventory.inventory.size()){
		Commands.out=(message );
		play.textArea.append(Commands.out+"\n");

	}
	else{
		Commands.out=(message +" "+name);
		play.textArea.append(Commands.out+"\n");
	}
	return true;
	}

	//public String playerEnter(String name,String r) {
	//	vehicle target = new vehicle(name);
	//	String t = "True";
	//	for (String a : vehicleList) {
	//	if (target.getName() == a){
	//		if(target.door){
	//			r = t;
	//			break;
	//		}
	//		else{
	//			continue;
	//		}
	//	}
	//	}
	//	return r;
	//}

	

	//public String playerRead(String object) {
	//	readable target = new readable(object);
	//	for (int i=0;i<messageList.size();i++) {
	//		String t =target.getName();
	//		String m = messageList.get(i); 
	//	if (t.equals(m)){
	//		System.out.println(target.message);
	//	}
	//	}
	//	return null;
	//}
   
	
	public String unlock() {
		if (northLocked || eastLocked || southLocked || westLocked) {
			northLocked = false;
			southLocked = false;
			westLocked  = false;
			eastLocked  = false;
			
			return "Door unlocked";
		}
		else {
			return "There is no door to unlock";
		}
	}
}