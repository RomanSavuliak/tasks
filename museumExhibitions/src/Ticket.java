
public class Ticket {
    private String ticketType;
    private int ticketCost;
    private int ticketsNumber;

    public Ticket(String ticketType, int ticketCost, int ticketsNumber) {
        this.ticketType = ticketType;
        this.ticketCost = ticketCost;
        this.ticketsNumber = ticketsNumber;
    }

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

    public void reduceTickets(int number){
        if (ticketsNumber >= number){
           // System.out.println("Booking is possible");
            ticketsNumber -= number;
        }
    }
}
