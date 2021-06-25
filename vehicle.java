public class vehicle {
	public String name;
	//attributes
	public boolean door;

	
	public vehicle(String n, boolean d) {
		this.name = n;
		this.door = d;
	}
	//constructor used for searching for items in inventory
	public vehicle(String n) {
		this.name = n;
	}
	

	public String getName() {
		return name;
	}
	
	public boolean getDoor() {
		return door;
	}	

}
