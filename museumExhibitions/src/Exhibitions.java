
public class Exhibitions {
    private String exhibitionName;
    private int availableTickets;

    public Exhibitions(String exhibitionName, int availableTickets) {
        this.exhibitionName = exhibitionName;
        this.availableTickets = availableTickets;
    }

    public String getExhibitionName() {
        return exhibitionName;
    }

    public void setExhibitionName(String exhibitionName) {
        this.exhibitionName = exhibitionName;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    public void reduceSpaces(int number){
        if (availableTickets >= number){
            System.out.println("Booking is possible");
            availableTickets -= number;
        }

    }

}
