public class Main {
	
	public static int numberOfTickets = 0;							// creates an int to keep track of how many tickets have been created.
	public static ticketProcessing ticket = new ticketProcessing();						//**Ticket new_ticket = new Ticket(new_data);	
	
	public static void main (String[] Args) {
		
		/*creates a ticket with the owner & creator of the ticket, as well as,the type of ticket.*/
		Ticket ticket1 = new Ticket("Desmond", "Warren", "new computer configuration");
		Ticket ticket2 = new Ticket("Stilman", "Abbas", "security issue");
		Ticket ticket3 = new Ticket("Malik", "Garnier", "other");
		Ticket ticket4 = new Ticket("Kadar", "Richard", "network issue");
		Ticket ticket5 = new Ticket("Robert", "Cristina", "software/app installation");
		
		/*displays current ticket, by calling method displayTicket from ticketProcess.
		 * a blank print statement to create a space between each output for easier readability. */
		ticket.displayTicket();
		System.out.println();
		
		/*creates a ticket with the owner & creator of the ticket, as well as,the type of ticket.*/
		Ticket ticket6 = new Ticket("William", "Anne", "network issue");
		Ticket ticket7 = new Ticket("Julien", "Stede", "security issue");
		
		/*displays current ticket, by calling method displayTicket from ticketProcess.
		 * a blank print statement to create a space between each output for easier readability. */
		ticket.displayTicket();
		System.out.println();
		
		/*calls on the function removeFirstTicket;
		 * removes the first ticket in the list
		 * displays that the first ticket has been removed.*/
		ticket.removeFirstTicket();				
		System.out.println();		
		ticket.displayTicket();					
		System.out.println();				
		
		/*searches for the ticket with priority 2;*/
		Ticket findTicket = ticket.findTicket(2);
		if (findTicket != null) {											//if its null
			System.out.println("ticket with id 2 was found:");				//print that it was found.
			findTicket.displayTickets();									//display ticket
			System.out.println();
		} 
		else {
			System.out.println("ticket with id 2 could not be found");		//else print that it wasn't found.
		}
		
		/*searches for the ticket with priority 1;*/
		findTicket = ticket.findTicket(1);
		if (findTicket != null) {
			System.out.println("ticket with id 1 was found:");
			findTicket.displayTickets();
			System.out.println();
		} 
		else {
			System.out.println("Ticket with id 1 could not be found");
		}
		
		/*removes ticket 3,
		 *calls on method removeTicket from ticketProcessing.
		 *displays the ticket.*/
		ticket.removeTicket(3);
		System.out.println();
		ticket.displayTicket();
		
		System.out.println();
		ticket.typeChange(5, "security issue");
		ticket.typeChange(4, "software or app installation");
		ticket.displayTicket();
	}
}
