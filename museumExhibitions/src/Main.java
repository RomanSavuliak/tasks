import java.util.Scanner;

public class Main {

    public static Exhibitions roman = new Exhibitions("Roman Exhibition", 40);
    public static Exhibitions warholArt = new Exhibitions("Warhol Art Exhibition", 40);
    public static Exhibitions worldWar2 = new Exhibitions("World War 2 Exhibition", 40);
    public static Ticket adult = new Ticket("Adult Ticket", 10, 30);
    public static Ticket child = new Ticket("Child Ticket", 5, 30);
    public static Ticket student = new Ticket("Student Ticket", 7, 30);
    public static Ticket oap = new Ticket("OAP Ticket", 8, 30);
    public static Money money = new Money(0);

    public static void main(String[] args) {
        /*Exhibitions roman = new Exhibitions("Roman Exhibition", 40);
        Exhibitions warholArt = new Exhibitions("Warhol Art Exhibition", 40);
        Exhibitions worldWar2 = new Exhibitions("World War 2 Exhibition", 40);
        Ticket adult = new Ticket("Adult Ticket", 10, 30);
        Ticket child = new Ticket("Child Ticket", 5, 30);
        Ticket student = new Ticket("Student Ticket", 7, 30);
        Ticket oap = new Ticket("OAP Ticket", 8, 30);
        Money money = new Money(0);*/

            System.out.println("(1) Roman Exhibition");
            System.out.println("(2) Warhol Art Exhibition");
            System.out.println("(3) World War 2 Exhibition");

            switch (scanInt()){
                case 1:
                    chooseExhibition(roman);
                    break;
                case 2:
                    chooseExhibition(warholArt);
                    break;
                case 3:
                    chooseExhibition(worldWar2);
                    break;
            }

        System.out.println("Money " + money.getCash());
        System.out.println("Adult " + adult.getTicketsNumber());
        System.out.println("Roman " + roman.getAvailableTickets());

    }

    public static void chooseExhibition(Exhibitions exhibitions){
        boolean flag = true;
        while (flag) {
            System.out.println("(1) Adult Ticket - £10");
            System.out.println("(2) Child Ticket - £5");
            System.out.println("(3) Student Ticket- £7");
            System.out.println("(4) OAP Ticket - £8");
            System.out.println("(5) exit");

            switch (scanInt()) {
                case 1:
                    chooseTicket(adult, exhibitions);
                    break;
                case 2:
                    chooseTicket(child, exhibitions);
                    break;
                case 3:
                    chooseTicket(student, exhibitions);
                    break;
                case 4:
                    chooseTicket(oap, exhibitions);
                    break;
                case 5:
                    flag = false;
                    break;
            }
        }

    }

    public static void chooseTicket(Ticket ticket, Exhibitions exhibitions){
        if (ticket.getTicketsNumber() == 0) {
            System.out.println("There is no available tickets");
            return;
        }
        System.out.println("How manny? ");
        int count = scanInt();
        if (ticket.getTicketsNumber() >= count){
            int requiredMoney = ticket.getTicketCost() * count;
            System.out.println("Total price " + requiredMoney);
            buy(ticket, exhibitions, requiredMoney);
        }
        else
            System.out.println("Booking is not possible");
    }

    public static void buy(Ticket ticket, Exhibitions exhibitions, int requiredMoney){
        int cash = 0;
        System.out.println("(1)Card\n(2)Cash");
        if (scanInt() == 1){
            money.receiveMoney(requiredMoney);
            ticket.reduceTickets((int) requiredMoney / ticket.getTicketCost());
            exhibitions.reduceSpaces((int) requiredMoney / ticket.getTicketCost());
        }else {
            while (cash < requiredMoney) {
                System.out.println("Need " + (requiredMoney - cash));
                cash += scanInt();
            }
            money.receiveMoney(cash);
            if (cash > requiredMoney) {
                money.change(cash - requiredMoney);
            }
            ticket.reduceTickets((int) requiredMoney / ticket.getTicketCost());
            exhibitions.reduceSpaces((int) requiredMoney / ticket.getTicketCost());
        }
    }

    public static int scanInt(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        return n;
    }



}
