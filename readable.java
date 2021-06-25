public class readable {
	public String name;
    public String message;

	
	public readable(String n, String m) {
		this.name = n;
		this.message = m;
	}
	//constructor used for searching for items in inventory
	public readable(String n) {
		this.name = n;
	}
	

	public String getName() {
		return name;
	}
	
	public String getMessage() {
        return message;
	}
	
}
