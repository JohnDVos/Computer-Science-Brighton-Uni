public class Ticket {
	
	public int ID;						//creates an integer for the unique ID of the request.
	public String creator;				//creates a String for creator who sent the request.
	public String owner;				//creates a String for the owner of the ticket, the one in charge of resolving it.
	public int priority;				//creates an integer for the level of priority of the ticket.
	public String type;					//creates a String to hold the type of issue.
	
	public Ticket next = null;			//**holds the ticket of the next link in the linkedList -> set to null until it is connected to other tickets
	
	public Ticket(String owner, String creator, String type) {	
		this.priority = prioritySet(type);				//allocates the priority for the ticket based on ticket type.
		
		/* assigns an ID to the current Ticket 
		 * so that it has always has a unique identifier, 
		 * as it is incremented when a new ticket is created.*/
		Main.numberOfTickets++;					//adds 1 to the number of tickets variable to show that a ticket has been created.
		this.ID = Main.numberOfTickets;	
		
		/*sets the object variables (instance variables) to the respective arguments.*/			
		this.creator = creator;
		this.owner = owner;
		this.type = type;
		
		Main.ticket.addTicket(this);
		
	}
	
	public static int prioritySet(String type) {					//sets the priority to the respective ticket.
		if(type.equals("security issue")) {							//if the type allocates is a "security issue".
			return 1;												//it will return the value (priority) 1
		}
		else if(type.equals("network issue")) {						//if the type allocates is a "network issue".
			return 2;												//it will return the value (priority) 2
		}
		else if(type.equals("software or app installation")) {
			return 3;
		}
		else if(type.equals("new computer configuration")) {
			return 4;
		}
		else {
			return 5;
		}
		}
	
	public int getPriority() {		//when adding a ticket to the queue, we need to check priority, getPriority does that.
		return priority;			//returns the priority of the ticket.
	}
	
	/*creates a print statement to display: ID, priority, creator, owner & type for the tickets.
	 * print statement to display all tickets in an understandable manor.*/
	public void displayTickets() {	
		System.out.printf("%3d %3d %10s %10s %-30s", this.ID, this.priority, this.creator, this.owner, this.type);
	}
			
}
