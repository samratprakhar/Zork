public class openable {
	public String name;
	//attributes
	public String description;

	
	public void vehicle(String n, String d) {
		this.name = n;
		this.description = d;
	}
	//constructor used for searching for items in inventory
	public openable(String n) {
		this.name = n;
	}
	

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}	

}
