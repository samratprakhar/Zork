import javax.swing.*;


public class Commands {

	public static final String[] COMMANDS = {"north","n", "west","w", "east","e","i", "south","s", "inventory", "take","pick", "drop", "weight", "inspect", "help", "talk", "attack", "quit", "examine", "leave", "use", "eat", "shoot", "insert","utha","kha","enter","read","play","yes","get","open"};
	public static final String[] OBJECTS = {"notice","file","the amazing spider man 1","the amazing spider man 2","washing powder","leaflet","laser","helium uthopium laser","key","coin",};
	
	public static Room[][][] map;
	
	public static int row;
	public static int col;
	public static int level;
	public static int lastRow;
	public static int lastCol;
	public static int lastLevel;
	
	public static Room currentRoom;
	public static String out;
	public static String in;

	public static boolean running = true;
	public static boolean valid;
	public static String[] tokens;
	public static String command;

	public static boolean counter = false;
	public static boolean quizCounter = false;
	public static boolean fileCounter = false;
	public static boolean articleCounter = false;
	public static boolean power = false;
	public static boolean electrosaurce = true;
	
	public static void main(String Args[]) {

		//init map
		map = new Room[10][10][5];
		
		row = 0;
		col = 3;
		level = 0;
		
		lastRow = 2;
		lastCol = 2;
		lastLevel = 0;
	
		map[0][3][0] = new Room(false, true, false, false, 0,"Campus Entrance", "You start off in the front of NIT DELHI campus. Behind you is parked the college bus and you are off to a very exciting journey full of adventures and thrill ",new vehicle("bus", false),new Item("cherries"));
		
		map[1][1][0] = new Room(false, true, true, false, 0,"West End of Campus Road", "");
		map[1][2][0] = new Room(false, true, true, true, 0,"Campus Road\nThis road continues in the west direction", "");
		map[1][3][0] = new Room(true,true, true, true, 0,"Inside Campus", "You have entered the campus.There are way in every directions.");
		map[1][4][0] = new Room(false, false, true, true, 0,"Campus Road\nThe road continues in the east as well as west direction", "");
		map[1][5][0] = new Room(false, true, true, true, 0,"Campus Road\nThe road continues in the east direction", "");
		map[1][6][0] = new Room(false, true, false, true, 0,"East End of Campus Road", "");
		
		map[2][1][0] = new Room(true, true, true, false, 0,"CC", "this is the computer center. while you are working on it a misterious file dated 17 sep 1111 appears on your screen and opens immidietly without any clicks.Do you want me to read it?", new Item("file", "Hello, this is Dr. Sheldon Cooper BS MS PhD ScD OMG right!! Hope you can find me.",0,false,false,false,true));
		map[2][2][0] = new Room(false, true, true, true, 0,"CC Back Door \nin the east is the Campus Road", "");
		map[2][3][0] = new Room(true, false, true, false, 0,"Campus Road\nIn the east is the Audi", "");
		map[2][4][0] = new Room(false, false, true, false, 0,"Audi", "This is the auditorium, the class of  special theory of relativity which was scheduled here is cancelled. severals small groups of students are busy planning this 1 hour slot. Some of them are thinking of going to CC");
		map[2][5][0] = new Room(true, false, false, true, 0,"Audi Backstage", "this is the back stage of audi. there is exit to the north");
		map[2][6][0] = new Room(true, true, false, false, 0,"North End of Basketball Court 1", "");
	
		map[3][1][0] = new Room(true, true, true, false, 0,"CC\nOn your south is the Library", "");
		map[3][2][0] = new Room(true, true, false, true, 0,"North end of Corridor\nThe corridor continues in south direction.", "", new Item("notice", "NOTICE -- Attention Students -- We are proud to announce that we have collaberated an student exchange program with one of most prestegious institute of world - Caltech, Pasedena. The one who solves this quiz as well as puzzle will be entitled to go on that program.",0,false,false,false,true));
		map[3][3][0] = new Room(false, true, false, false, 0,"Sports Complex", "");
		map[3][4][0] = new Room(false, true, true, false, 0,"Volleyball Court 1", "");
		map[3][5][0] = new Room(false, true, true, true, 0,"Volleyball Court 2", "");
		map[3][6][0] = new Room(true, true, false, false, 0,"South End of Basketball Court 1", "");
		
		map[4][1][0] = new Room(true, true, true, false, 0,"Library", "this is the central library of nitd. there are books, magazines, research papers all but students usually read the news only. todays featured articles sounds intresting. Do you want me to read it?",new Item("article", "Sheldon Cooper invents the time machine, World Shocked 'Dr. Sheldon Cooper, Theoratical Physicst of Caltech University, Pasedena California has invented the time machine. Neither the machine nor him is spotted since this news came out.The science community is shocked. Let's hope he is fine.'",0,false,false,false,true),new Item("book", "As you open the book, a page falls down. ",0,false,false,false,true),new Item("page", "This contains the answers",0,false,false,false,true));
		map[4][2][0] = new Room(true, true, false, true, 0,"Corridor\nThe corridor continues in the north as well as south direction", "");
		map[4][3][0] = new Room(true, true, true, false, 0,"Staircase", "there is a staircase leading upwards to ");
		map[4][4][0] = new Room(true, true, true, true, 0,"Campus Road", "");
		map[4][5][0] = new Room(true, true, true, true, 0,"Campus Road", "");
		map[4][6][0] = new Room(true, true, false, false, 0,"North End of Basketball Court 2", "");
		
		map[5][1][0] = new Room(true, false, true, false, 0,"Library", "");
		map[5][2][0] = new Room(true, false, true, true, 0,"Corridor\nThe road continues in the north as well as east direction", "");
		map[5][3][0] = new Room(true, false, false, true, 0,"Corridor\nThe road continues in the west direction", "");
		map[5][4][0] = new Room(true, false, true, false, 0,"Cricket Nets 1", "");
		map[5][5][0] = new Room(true, false, true, false, 0,"Cricket Nets 2", "");
		map[5][6][0] = new Room(true, false, false, false, 0,"South End of Basketball Court 2", "");
		
		//Transition 1
		map[0][0][1] = new Room(false, false, false, false, 0,"IGI Airport", "You are at the IGI Airportand you boarded the flight.");
		map[4][4][1] = new Room(false, false, false, false, 0,"Pasedena Airport", "After a long flight ,you are at the Pasedena Airport. A cab is waiting for you.",new vehicle("cab", true));
		
        
		//Pasadena
		
		map[1][1][2] = new Room(false, true, true, false, 0,"Road","" );
		map[2][1][2] = new Room(true, true, false, false, 0,"Road" ,"" );
        map[3][1][2] = new Room(true, true, false, false, 0,"Kachra General" ,"This is kachra general store. kachra seth is playing a snake game. his store is very busy.a strange number is inscribed on the wall of the store marked 'samsong ka number' upon seeing the coin in your hand kachra seth smiles and says what you are looking for is in caltech .\nHe points in the south direction and tells you to take the subway, it will drop you there." );

		map[4][1][2] = new Room(true, true, false, false, 0,"Subway" ,"Train between kachra general to caltech is there on the platform.",new vehicle("subway", true) );
		map[5][1][2] = new Room(true, false, false, false, 0,"Road" ,"" );
        map[1][2][2] = new Room(false, true, false, true, 0,"Star Garage" ,"this is star garage owned by babu bhaiya. this place is full of scrape material and the last car has been rented about 10 mins ago. the car with a number 353942 is parked here. while babu bhaiya is boasting about his property in kolhapur, kachra seth departs with the car. a strange key is here." ,new Item("key","",0,false,true,false,false));

		map[2][2][2] = new Room(false, true, true, false, 0,"Road" ,"" );
		map[3][2][2] = new Room(true, true, false, false, 0,"Road" ,"" );
		map[4][2][2] = new Room(true, true, false, false, 0,"Road" ,"" );
		map[5][2][2] = new Room(true, false, true, false, 0,"Road" ,"" );
		map[1][3][2] = new Room(false, false, true, true, 0,"Road" ,"",false,false,false,true);
		map[2][3][2] = new Room(false, false, true, true, 0,"Road" ,"" );
		map[3][3][2] = new Room(true, true, false, false, 0,"Mailbox" ,"",new Item("mailbox", "opening the mailbox reveals a small leaflet",0,false,false,false,true), new Item ("leaflet","as you read the letter it says:- Heard the gas of your cab ran out ! what a coincidence ? or is it ? the machine is in distess. if you are clever enough solve all the puzzles you are the one i am searching for.GO in the apartment 4a. i hope you can locate the machine.SHELDON COOPER",0,false,false,false,true));
        map[4][3][2] = new Room(true, false, true, false, 0,"Building Entrance" ,"this is the entrance of the apartment of sheldon and leonard. you see a lift in front of you which is probably  not working.(the sign 'out of order' is on the lift there is a small mailbox at your south." );

		map[5][3][2] = new Room(true, true, false, false, 0,"Road" ,"" );
		map[1][4][2] = new Room(false, false, true, true, 0,"Road" ,"" );
		map[2][4][2] = new Room(false, false, true, true, 0,"Road" ,"" );
		map[3][4][2] = new Room(false, false, true, false, 0,"Laundary Room " ,"This is laundry room of the building. several machines are running but one machine is open. the theif may have forgotten to put in the washing powder.AS soon as you pour the washing powder in the machine, the machine starts running and a coin sort of thing falls out of the machine, on the coin 'comic center' is written..",new Item("coin"));

		map[4][4][2] = new Room(false, true, true, true, 0,"Inside Building" ,"" );
		map[5][4][2] = new Room(false, false, true, true, 0,"Inside building" ,"" );
		map[1][5][2] = new Room(false, false, true, true, 0,"Road" ,"" );
		map[2][5][2] = new Room(true, false, true, true, 0,"Road" ,"" );
		map[3][5][2] = new Room(false, true, true, true, 0,"Straicase" ,"" ,false,false,false,true);
		map[4][5][2] = new Room(true, false, false, true, 0,"Lift" ,"" );
		map[5][5][2] = new Room(true, false, true, true, 0,"Lockers" ,"" );
		
		map[1][6][2] = new Room(false, false, true, true, 0,"Comic Book Store", "this store is managed by stuart bloom. upon seeing the coin stuart says that it was a limited edition coin which he gave to only four people. it can be used to trace the location of the bearer. after that he offers you a special edition of the amazing spider man 2 which sheldon asked him to give to whoever has this coin.Do you want to read it?", new Item("comic2","942\n\nA car with number 353942 is going towards Star Garage.",0,false,false,false,true));
		map[2][6][2] = new Room(false, false, true, true, 0,"Road" ,"" );
		map[3][6][2] = new Room(false, true, true, true, 0,"Apartment 4a" ,"this is the apartment of sheldon and leonard. the general setting of the room is mysterious. there is couch which is neither in front of the tv, nor at a proper angle with it, only one spot seems perfect. there is no dining table in the room, intead to white boards are placed halfway in the hall which have equations for solving what looks like rosepin conjunture, a laptop is here in which a pendrive is inserted.A copy of the amazing spider man 1 is here.Do you want to read it?",new Item("comic1","353\n\nAt the bottom of the page, 'To be continued' is written.",0,false,false,false,true),new Item("laptop","SpiderMan_1_2_car_garbage_base",0,false,false,false,true));
		map[4][6][2] = new Room(true, true, false, true, 0,"Hallway" ,"" );

		map[5][6][2] = new Room(true, false, true, false, 0,"Apartment 4B" ,"This is the apartment of penny. this house seems to be robbed recently, everything is here and there scattered. nothing of value is is here. a washing  powder is here.on the back of the door is a paper attached loosly.",new Item ("paper","please try and keep your house clean. i had troubles robbing your house. tripped and fell three times. i have cleaned all your valuables and arranged the kitchen items. the clothes are in the washing machine.Sorry for your loss\n Thanking you for keeping the password 1234,\nYours,\nBella Ciao",0,false,false,false,true),new Item("washing"));
		map[1][7][2] = new Room(false, true, false, true, 0,"Road" ,"" );
		map[2][7][2] = new Room(true, false, false, true, 0,"Road" ,"" );
		map[3][7][2] = new Room(false, true, false, false, 0,"Apartment 4A" ,"" );
		map[4][7][2] = new Room(false, false, false, true, 0,"Hallway" ,"" );
		map[5][7][2] = new Room(true, false, false, false, 0,"Apartment 4B" ,"" );

		//caltech
		
		map[1][1][3] = new Room(false,true, false, false, 0,"Engineering Lab", "future is engineered here. it is a nice looking engineering lab with a lot of equipments. a somewhat completed robot is around the corner, and a model rocket is lying on the floor. on a platform there is a machine that converts coal into diamonds.The coal that you had is converted into diamonds.",new Item ("diamonds"));
		map[1][2][3] = new Room(false,true, false, true, 0,"Engineering Lab Entrance", "",false,false,false,true);
		map[1][3][3] = new Room(false,true, false, false, 0,"Corridor", "");
		map[1][4][3] = new Room(false,false, true, true, 0,"Staircase", "");
		map[1][5][3] = new Room(false, false, true, true, 0,"Basement Entrance ", "this is the basement. with myterious walls all around, the entrence is blocked by a door which seems to be password protected. the lights are a little bit dim here. nothing from across the door is visible.",false,false,true,false);
		map[1][6][3] = new Room(false, false, true, true, 0,"Inside basement", "It is very dark in here but you can see a door to an experiment room and an computer screen and something is written on it .",new Item("screen","Fuel Experiment\nTest 45\nAfter the successful experiment with gold, this experiment is now conducted with diamonds\nResult Successful--Diamond can be used as a fuel for this machine.",0,false,false,false,true),false,false,true,false);
		map[1][7][3] = new Room(false, false, false, true, 0,"", "congatulations you made it to the machine, you can enter the machine after it starts,as you go near the machine it attracts the diamonds from your bag and starts !' ",new vehicle("machine",true));
		
		map[2][1][3] = new Room(false,true, true, false, 0,"Corridor", "");
		map[2][2][3] = new Room(true,true, true, true, 0,"Corridor", "");
		map[2][3][3] = new Room(true,true, false, true, 0,"Corridor", "");
		map[2][4][3] = new Room(true,true, false, false, 0,"Corridor", "");
		map[2][5][3] = new Room(false, false, false, true, 0,"Staircase", "");

		map[3][1][3] = new Room(true,true, true, false, 0,"Caltech Entrance", "");
		map[3][2][3] = new Room(true,true, false, true, 0,"Corridor", "");
		map[3][3][3] = new Room(false, false, true, true, 0,"Caltech Mess", "This is the mess of caltech. the spot of sheldon looks mysterious. diet cuba libre (diet coke) is here. a jar of cookies is here.");
		map[3][4][3] = new Room(true,true, true, false, 0,"Wending Machine", "");
		map[3][5][3] = new Room(true, true, false, false, 0,"Break Room", "");
		
		map[4][1][3] = new Room(true,false, true, false, 0,"Corridor", "");
		map[4][2][3] = new Room(false,true, true, false, 0,"Geology Lab Entrance", "this is the geology lab which is supervised by bert. this lab is said to be containg all the stones and gems known. the door is blocked by a huge boulder. It can only cut by a laser",false,true,false,false);
		map[4][3][3] = new Room(true, true, false, false, 0,"Corridor", "");
		map[4][4][3] = new Room(false,false, true, false, 0,"Corridor", "");
		map[4][5][3] = new Room(false, true, false, true, 0,"Laser Lab", "this is the enterence of laser lab. on the door tthere is sign of danger. are dogs in there ? as soon as you take a look around the lab is all covered with hightech laser equipments. a helium - uthopium laser is here which can cut any blouder into small pieces",new Item("laser","",0,false,false,true,false));
		
		map[5][1][3] = new Room(true,false, false, false, 0,"Lab Exit", "");
		map[5][2][3] = new Room(false, false, true, true, 0,"Geology Lab ", "a lump of coal is here, might be converted into diamonds , who knows ?",new Item ("coal","",0,false,false,false,false));
		map[5][3][3] = new Room(true, false, true, false, 0,"Lab Exit", "");
		map[5][4][3] = new Room(true,false, true, true, 0,"Corridor", "");
		map[5][5][3] = new Room(true, false, false, true, 0,"Corridor", "");

		//dholakpur
		
		map[1][1][4] = new Room(false,true, true, false, 0,"Streets", "");
		map[1][2][4] = new Room(false,false, true, true, 0,"Streets", "");
		map[1][3][4] = new Room(false,true, true, true, 0,"Lab", "this is lab of professor dhoomketu. here are lots of equipments most of them are under construction, but most impressive is machine converting potatos to gold. that machine is operated at 24 mega volt supply the supply is broken somewhere in dholakpur so you can not start it.",new Item("gold"));
		map[1][4][4] = new Room(false,true, false, true, 0,"Streets", "");
		map[1][5][4] = new Room(false, true, false, false, 0,"Streets", "");
		map[1][6][4] = new Room(false,false, true, true, 0,"Streets", "");
		map[1][7][4] = new Room(false,true, false, true, 0,"Riverbank", "You are at the north shore of a river, far too deep and wide for crossing. on the side of the shore there is board on which is written Dholakpur 0km ; Pehalwanpur 4 kms.",new vehicle("machine",true));

		map[2][1][4] = new Room(true,true, true, false, 0,"Streets", "");
		map[2][2][4] = new Room(true,false, false, false, 0,"Streets", "");
		map[2][3][4] = new Room(false,false, true, true, 0,"Streets", "");
		map[2][4][4] = new Room(true,true, true, true, 0,"Dholakpur Sweets", "you are standing in front of the famous tuntun mosi ladoo store. there are a basket full of ladoos on the counter. There are paths to the north, south, and west. far away you can see the royal palace of dholakpur on the hill.");
		map[2][5][4] = new Room(false, false, true, true, 0,"Streets", "");
		map[2][6][4] = new Room(true,true, false, false, 0,"Streets", "");
		map[2][7][4] = new Room(true,false, false, true, 0,"Riverbank", "");

		map[3][1][4] = new Room(true,true, true, false, 0,"Field", "");
		map[3][2][4] = new Room(false,false, true, true, 0,"Field", "");
		map[3][3][4] = new Room(true, true, true, true, 0,"Field", "This is the farmhouse of kalia, locally known as panvel of dholakpur. there are crops all around in the field and there is a barn in the middle of the farm. hope you can find some tools there.");
		map[3][4][4] = new Room(false,false, true, true, 0,"Streets", "");
		map[3][5][4] = new Room(true, true, false, false, 0,"Streets", "");
		map[3][6][4] = new Room(false,false, true, true, 0,"Streets", "");
		map[3][7][4] = new Room(true,true, true, true, 0,"Streets", "");
		map[3][8][4] = new Room(false,true, true, true, 0,"Market Place", "you are at the center of the marketplace of dholakpur. this is quite a busy place with shops all around, adults are holding hands of children so that they dont get lost.");
		map[3][9][4] = new Room(false,true, false, true, 0,"Streets", "");
		
		map[4][1][4] = new Room(true,false, true, false, 0,"Field", "");
		map[4][2][4] = new Room(true,true, true, true, 0,"Barn", "This is the Barn. A empty brown sack and a shovel is here.",new Item("sack"),new Item("shovel"));
		map[4][3][4] = new Room(false, true, false, true, 0,"Field", "");
		map[4][4][4] = new Room(false,true, true, false, 0,"Castle", "");
		map[4][5][4] = new Room(true, true, true, true, 0,"King's Castle", "this is the the royal palace of dholakpur. maharaja indraverma and other important ministers are seated in the court.there are paths leading in every direction of the castle but you have to complete a shooting task to look around.Do you want to continue?");
		map[4][6][4] = new Room(true,false, false, true, 0,"Castle", "");
		map[4][7][4] = new Room(true,true, true, false, 0,"Streets", "");
		map[4][8][4] = new Room(true,false, true, true, 0,"Streets", "");
		map[4][9][4] = new Room(true,false, false, false, 0,"Hardware Shop", "this is a small hardware shop. situated under a large tree, this shop has it all a farmer, mechanic or a craftsman need. a screw driver is lying in the floor.on a shelf rubber shoes,rubber gloves can be seen. on the counter of the shop,there is a black cello tape.",new Item("screw"),new Item("gloves"),new Item("shoes"),new Item("tape") );

		map[5][1][4] = new Room(true,false, true, false, 0,"Field", "");
		map[5][2][4] = new Room(true, true, false, false, 0,"Field ", "",false,true,false,false);
		map[5][3][4] = new Room(true, false, false, true, 0,"Field", "");
		map[5][4][4] = new Room(true,false, true, false, 0,"Castle", "");
		map[5][5][4] = new Room(false, false, true, true, 0,"Castle", "");
		map[5][6][4] = new Room(true,false, false, false, 0,"Armoury", "This is the royal armoury. there is every weapon one has ever thought from swords to canons, and bows to javelins, everything is here.Crossbow would be nice",new Item("crossbow","",0,false,false,true,false));
		map[5][7][4] = new Room(true,false, true, false, 0,"Power House Entrance", "This is a mega project of electricity here in dholakpur. it can produce upto 24 mega volts of electricity. the supply was broken because a electrosaurce has broke it, and now absorbing energy out of it.");
		map[5][8][4] = new Room(false,false, true, true, 0,"Power House", " His body is buzzing with electricity and he is very angry as you have interuppted his lunch. he says how dare you ? why have you came here ?");
		map[5][9][4] = new Room(true,false, false, true, 0,"Streets", "");

		map[6][2][4] = new Room(true,false, false, false, 0,"Potato Field", "So, you have finally found the potato field and by using the shovel you have harvested some potatoes.",new Item("potatoes"));

		new firstFrame();
		display();
		
	}

	public static void display(){
		if(running) {	
		
			currentRoom = map[row][col][level];
			out = currentRoom.getName();
			play.textArea.append(out+"\n");
			play.textArea.setCaretPosition(play.textArea.getDocument().getLength());
			if (currentRoom.counter == 0){
				out=currentRoom.getDescription();
				play.textArea.append(out+"\n");
				play.textArea.setCaretPosition(play.textArea.getDocument().getLength());
				currentRoom.counter++;
			}
			if(currentRoom == map[3][2][0] && fileCounter == true && articleCounter == true && counter == false){
				play.textArea.append( "on the wall there is a notice board which has a notice on it\n");
				play.textArea.setCaretPosition(play.textArea.getDocument().getLength());
				counter = true;
			}
			if(Inventory.searchInventory("coal")){
				map[1][2][3].unlock();
			}
			if (Inventory.searchInventory("washing")){
				map[3][5][2].unlock();
			}
			if (Inventory.searchInventory("diamonds")){
				map[1][6][3].unlock();
			}
			if (Inventory.searchInventory("shovel")&&Inventory.searchInventory("sack")){
				map[5][2][4].unlock();
				if (currentRoom == map[4][2][4]){
					play.textArea.append("You can see a potato field in the south direction\n");
				}
			}
			if (currentRoom ==map[5][7][4] &&!Inventory.searchInventory("gloves")&&!Inventory.searchInventory("shoes")&&!Inventory.searchInventory("crossbow")){
				play.textArea.append("Its dangerous to go near power house without safety equipments and a crossbow would also be required to kill the monster .Hardware Shop and King's armoury would help.\n");
			}
			if (Commands.currentRoom ==Commands.map[5][8][4] &&!Inventory.searchInventory("screw")&&!Inventory.searchInventory("gloves")&&!electrosaurce){
				play.textArea.append("Some tools will be required to repair the electricity line\n");
			}
			if (Commands.currentRoom ==Commands.map[5][8][4] &&Inventory.searchInventory("screw")&&Inventory.searchInventory("gloves")&&!electrosaurce){
				play.textArea.append("The 24 mega volts supply is back\n");
				Commands.power = true;
			}
			if (Commands.currentRoom ==Commands.map[1][3][4] &&Inventory.searchInventory("potatoes")&&power&&!electrosaurce){
				play.textArea.append("The machine started working as the electricity supply are back and you have potatoes too.Shiny, bright gold bricks can be seen.\n");
			}
			if (Commands.currentRoom ==Commands.map[1][7][4] &&Inventory.searchInventory("gold")){
				play.textArea.append("The machine started working as you have gold.\n");
				row = 0;
				col =3;
				level =0;
			}
		}
	}

	public static void execute(String command){
		if (command.equals("north") ||command.equals("n")) {
			north(currentRoom);
		}
		else if (command.equals("east")||command.equals("e")) {
			east(currentRoom);
		}
		else if (command.equals("west")||command.equals("w")) {
			west(currentRoom);
		}
		else if (command.equals("south")||command.equals("s")) {
			south(currentRoom);
		}
		else if (command.equals("quit")) {
			JOptionPane.showMessageDialog(play.frame, "Bye,Bye!!");
			running = false;
			play.frame.dispose();
			new firstFrame();
		}
		else if (command.equals("help")) {
			help();
		}
		else if (command.equals("leave")) {
			leave();
		}
		else if(command.equals("examine")) {
				examine(currentRoom);
		}
		else if(command.equals("weight")) {
			out = ("I am carrying " + Inventory.getWeight() + " lbs. I can carry " + Inventory.MAX_WEIGHT + " lbs.");
			play.textArea.append(out+"\n");
		}
		else if(command.equals("inventory")||command.equals("i")) {
			Inventory.printInventory();
		
		}
		else if(command.equals("yes")) {
			if (currentRoom == map[2][1][0] ){
				read("file");
				fileCounter = true;
			}
			else if (currentRoom == map[4][1][0]){
				read("article");
				articleCounter = true;
			}
			else if (currentRoom == map[1][6][2]){
				read("comic2");
				map[1][3][2].unlock();
			}
			else if (currentRoom == map[3][6][2]){
				read("comic1");
			}
			else if (currentRoom == map[4][5][4]){
				new shooting();
			}
			else{
				out=(command+"????");
                    play.textArea.append(out+"\n");	
			}
		}
		else {
			String object;
			if (tokens.length > 1) {
				object = tokens[1].toLowerCase();
			}
			else {
				object = "nothing";
			}
			if(command.equals("get")|| command.equals("pick")) {
				take(object);
			}
			else if(command.equals("drop")) {
				drop(object);
			}
			else if(command.equals("eat") || command.equals("kha")) {
				eat(object);
			}
			else if(command.equals("use") || command.equals("insert")) {
				open(object);
			}
			else if(command.equals("shoot")) {
				shoot(object);
			}
			else if(command.equals("inspect")) {
				inspect(object);
			}
			else if(command.equals("enter")) {
				enter(object);
			}
			else if(command.equals("read")|| command.equals ("open")) {
				read(object);
			}
			else if(command.equals("play") ) {
				play(object);
			}
		}
	}

	public static void south(Room r) {
		if(r.getCanGoSouth()) {
			if (r.getSouthLocked()) {
				out = ("That way is locked");
				play.textArea.append(out+"\n");
			}
			else {
				lastRow = row;
				row++;	
			}
		}
		else {
			out = ("You can't go that way");
			play.textArea.append(out+"\n");
		}
	}
	public static void west(Room r) {
		if(r.getCanGoWest()) {
			if (r.getWestLocked()) {
				out = ("That way is locked");
				play.textArea.append(out+"\n");
			}
			else {
				lastCol = col;
				col--;
			}
		}
		else {
			out = ("You can't go that way");
			play.textArea.append(out+"\n");
		}
	}
	public static void east(Room r) {
		if(r.getCanGoEast()) {
			if (r.getEastLocked()) {
				out = ("That way is locked");
				play.textArea.append(out+"\n");
			}
			else {
				lastCol = col;
				col++;
			}
		}
		else {
			out = ("You can't go that way");
			play.textArea.append(out+"\n");
		}
	}
	public static void north(Room r) {
		if(r.getCanGoNorth()) {
			if (r.getNorthLocked()) {
				out = ("That way is locked");
				play.textArea.append(out+"\n");
			}
			else {
				lastRow = row;
				row--;
			}
		}
		else {
			out = ("You can't go that way");
			play.textArea.append(out+"\n");
		}
	}
	public static boolean checkCommand(String input) {
		input = input.toLowerCase();
		for (int i = 0; i < COMMANDS.length; i++) {
			if (input.equals(COMMANDS[i])) {
				return true;
			}
		}
		return false;
	}
	
	public static void help() {
		out = ("Available commands: north west east south inventory take drop weight quit examine leave use eat shoot insert");
		play.textArea.append(out+"\n");
	}
	
	public static void leave() {
		int tempr = row;
		int tempc = col;
		
		row = lastRow;
		col = lastCol;
		
		lastRow = tempr;
		lastCol = tempc; //no
	}
	
	public static void take(String object) {
		Item item = currentRoom.playerTake(object);

		

		if (item == null  ) {
			out = ("There is no " + object);
			play.textArea.append(out+"\n");
		}
		else {
			out = (Inventory.add(item));
			play.textArea.append(out+"\n");
		}
		
	}
	
	public static void drop(String object) {
		out = (Inventory.drop(object));
		play.textArea.append(out+"\n");
	}

	
	public static void examine(Room r) {
		out = (r.description);
		play.textArea.append(out+"\n");
	}
	
	private static void inspect(String object) {
		out = (Inventory.inspect(object));
		play.textArea.append(out+"\n");
	}
	
	private static void open(String object) {
		if (Inventory.findKey(object)) {
			out = (currentRoom.unlock());
			play.textArea.append(out+"\n");
			new captcha();
		}
		else {
			out = ("I do not have that key");
			play.textArea.append(out+"\n");
		}
	}
	
	private static void eat(String object) {
		out = (Inventory.eat(object));
		play.textArea.append(out+"\n");
	}
	
	private static void shoot(String object) {
		out = (Inventory.shoot(object));
		play.textArea.append(out+"\n");
	}

	public static void enter(String object) {
		if(currentRoom.isVehiclePresent(object)){
			if(currentRoom.playerEnter(object)){
				if (object.equals("bus")){
					out = ("You are on your way to IGI Airport");
					play.textArea.append(out+"\n");
					level++;
					row =0;
					col =0;
					display();
					row = 4;
					col = 4;
					display();
				}
				if (object.equals("subway")){
					out = ("You are on your way to caltech");
					play.textArea.append(out+"\n");
					level++;
					
					row = 3;
					col = 1;
					display();
				}
				if (object.equals("cab")){
					out = ("The cab goes out of fuel and stops near the entrance of Dr. Sheldon Cooper's Building. ");
					play.textArea.append(out+"\n");
					level++;
					row =4;
					col =3;
					display();
				}
				if (currentRoom == map[1][7][3]&&object.equals("machine")){
					out = ("as soon as you enter the machine the location drastically changes to dhoalkpur, and the sign low on fuel begins glowing on the machine you now nned more gold or diamond to run the machine again");
					play.textArea.append(out+"\n");
					level++;
					
					row = 1;
					col = 7;
					display();
				}
				if (currentRoom == map[1][7][4]&&object.equals("machine")){
					out = ("Back to Campus ");
					play.textArea.append(out+"\n");
					level= 0;
					
					row = 1;
					col = 3;
					display();
				}
			}
			else{
				out = ("The "+object+" door is locked.");
				play.textArea.append(out+"\n");
			}
		}
		else{
			out = ("I can't see any "+object);
			play.textArea.append(out+"\n");
		}
	}

	public static void read(String object) {
		currentRoom.playerRead(object);
	}

	public static void play(String object) {
		if(currentRoom == map[3][2][0] && quizCounter == false && object.equals("quiz")){
			new quiz();
		}
		else if(currentRoom == map[3][2][0] && quizCounter == false && object.equals("puzzle")){
			out = ("Complete the quiz first!!");
			play.textArea.append(out+"\n");
		}

		else if (currentRoom == map[3][2][0] && quizCounter == true && object.equals("puzzle")){
			new picpuzzle2();

		}
		else{
			if(object.equals("nothing")){
				out = ("I don't see a game here");
				play.textArea.append(out+"\n");
			}
			else{
				out = ("I don't see "+object+" here");
				play.textArea.append(out+"\n");
			}
		}
	}
	
	
}