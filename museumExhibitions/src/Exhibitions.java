
public class Exhibitions {
    private String exhibitionName;  //A variable to store the exhibition name
    private int availableTickets;  //A variable to store the amount of daily tickets available for that particular  exhibition

    public Exhibitions(String exhibitionName, int availableTickets) { // constructor
        this.exhibitionName = exhibitionName;
        this.availableTickets = availableTickets;
    }


    //get && set methods
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

    public void reduceSpaces(int number){// Reduce the number of spaces available when tickets are sold and let the user know if the booking was possible
        if (availableTickets >= number){
            System.out.println("Booking is possible");
            availableTickets -= number;
        }

    }

}
