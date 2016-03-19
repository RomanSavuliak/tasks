
public class Ticket {
    private String ticketType; //A variable to store the name of the ticket type
    private int ticketCost; // A variable to store the cost of the ticket
    private int ticketsNumber; //A variable to store the number of the tickets in the kiosk

    public Ticket(String ticketType, int ticketCost, int ticketsNumber) { //constructor
        this.ticketType = ticketType;
        this.ticketCost = ticketCost;
        this.ticketsNumber = ticketsNumber;
    }
    //get && set methods
    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public int getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(int ticketCost) {
        this.ticketCost = ticketCost;
    }

    public int getTicketsNumber() {
        return ticketsNumber;
    }

    public void setTicketsNumber(int ticketsNumber) {
        this.ticketsNumber = ticketsNumber;
    }
//Reduce the number of tickets when tickets are sold
    public void reduceTickets(int number){
        if (ticketsNumber >= number){
            ticketsNumber -= number;
        }
    }
}
