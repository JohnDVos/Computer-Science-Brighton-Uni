public class ticketProcessing {									//linked list class for processing tickets.

	public Ticket firstTicket;									//the previous element added to the list, head of the node.
	
	ticketProcessing() {	
		firstTicket = null; 									//sets the first ticket to null when the list is created.
	}
	
	public boolean emptyTicket() {	
		return(firstTicket == null); 							//will return true if the firstTicket (first item in the list) is empty.		
	}
	
	/*adds a ticket to the list.*/
	public Ticket addTicket(Ticket ticket) {					//inserts a new node (ticket) at the front of the list.
		Ticket currentTicket = firstTicket;						//allocates the next variable in the list (ticket) to the previous item (head) in the list.
		Ticket previousTicket = firstTicket;					//allocates the next variable in the list (ticket) to the previous item (head) in the list.
			
		if (Main.numberOfTickets == 1) {						//sets the next variable in the ticket to the previous item in the list
			ticket.next = firstTicket;							//allocates the next variable in the ticket to the previous ticket in the list.
			firstTicket = ticket;									
		} 
		else if(Main.numberOfTickets == 2) { 	
			if (ticket.priority > firstTicket.priority) {		//If the priority of the new element is greater (lower priority) than the priority of the item already in the list
				firstTicket.next = ticket;						//allocate the ticket at the end of the list.			
			} 
			else {				
				ticket.next = firstTicket;						//allocates the next variable in the ticket to the previous item in the list.
				firstTicket = ticket;				
			}			
		} 
		else {
			/*returns the ticket if found. 
			 * theTicket will be set to the ticket being searched;
			 * once the id of the ticket match the id being searched for,
			 * the while loop will break.*/ 
			while(currentTicket.priority <= ticket.priority) {	
				/*as long as the current tickets priority is less than the tickets priority that is being inserted.
				 * and if the current ticket is null*/	
				if(currentTicket.next == null) {
					currentTicket.next = ticket;				//ticket was not found in the list, so breaks out of the method
					return null;								//return null.
				} 
				else if(previousTicket == null) {				//else if the previous ticket is null.
					ticket.next = currentTicket;				//next ticket = current ticket.
					return null;			
				}
				else {				
					previousTicket = currentTicket;				//otherwise take the previous ticket and make it the current one.
					currentTicket = currentTicket.next;			//moves to the next ticket				
				}			
			}	
			if (previousTicket == currentTicket) {			
				ticket.next = currentTicket;
				firstTicket = ticket;			
			}
			else {
				/*Ticket has been found so set the link to that ticket to the link to the ticket after
				 * removes the link to that ticket*/
				previousTicket.next = ticket;
				ticket.next = currentTicket;
			}
		}
		return ticket;											
	}
	
	public void removeFirstTicket() {
		
		if (!emptyTicket()) {								//check if the (node) list is empty	
			firstTicket = firstTicket.next;					//allocates the firstTicket (head node) to the next ticket in the list	
		} 
		else {
			System.out.println("Empty List");	
		}	
		System.out.print("First ticket was removed.");		
	}
	
	public void displayTicket() {
		
		Ticket theTicket = firstTicket;
		System.out.printf("%-3s %-8s %-10s %-10s %-30s \n", "ID", "Priority", "Creator", "Owner", "Type");
		
		/* begins at the last element that was added to the list  
		 * then keeps running until it reaches the first element in the list, 
		 * where fristTicket will be null*/
		while (theTicket != null) {							//Starts at the last element added to the list and keeps running until it reaches the first element in the list, where firstLink will be null
			System.out.printf("%-3d %-8d %-10s %-10s %-30s", theTicket.ID, theTicket.priority, theTicket.creator, theTicket.owner, theTicket.type);
			theTicket = theTicket.next;						//sets the ticket currently being looked at to the next ticket in the list
			System.out.println();
		}
	}
	
	public Ticket findTicket(int id) {
		Ticket theTicket = firstTicket;
		if(!emptyTicket()) {
			/*theTicket will be set to the ticket being searched for 
			 * as once the id of the ticket match the id being searched for, 
			 * the while loop will break.
			 * & returns the ticket if found.*/
			while(theTicket.ID != id) {
				/*checks at the end of the list
				 * got to the end of the list without finding a match
				 * moves on to the next ticket.*/
				if(theTicket.next == null) {				
					return null;							
				} 
				else {
					theTicket = theTicket.next;				
				}
			}
		} 
		else {
			System.out.println("The list is empty");	//if list is empty output.
		}	
		return theTicket;								//returns the ticket if found
	}
	
	public Ticket removeTicket(int id) {
		Ticket currentTicket = firstTicket;
		Ticket previousTicket = firstTicket;
		
		while(currentTicket.ID != id) {
			if(currentTicket.next == null) {
				return null;								//if the ticket was not found in the list, break out of the method	
			} else {										//moves on to look at the next ticket
				previousTicket = currentTicket;
				currentTicket = currentTicket.next;					
			}
		}
		/*the ticket has been found,
		 * set the link to that ticket to be the link to the ticket after.
		 * removes the link to that ticket.*/
		if (currentTicket == firstTicket) {	
			firstTicket = firstTicket.next;						
		} 
		else {	
			previousTicket.next = currentTicket.next;		//moves on to next ticket 
		}		
		System.out.println("Ticket with id: " + id + " was removed.");		
		return currentTicket;		
	}
	
	public void typeChange(int id, String newType) {
		Ticket ticket = Main.ticket.findTicket(id);					//finds the ID of the ticket from class main.
		
		Main.ticket.removeTicket(id);								//takes a ticket from class main and removes it with its unique ID.
		
		/* creates a new object.
		 * calls method new type to allocate the new code type.*/
		ticket.type = newType;
		ticket.priority = Ticket.prioritySet(newType);
		ticket.next = null;
		
		Main.ticket.addTicket(ticket);								//calls method ticket from main addTicket from ticketProcessing.
		
		/*creates a print statement to display what ticket has been changed and its ID.*/
		System.out.println("Type for ticket with id " + id + " has been changed to " + newType);
		System.out.println();
	}
}
