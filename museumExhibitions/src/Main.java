import java.util.Scanner;

public class Main {

    //creating 3 Exhibitions,3 Ticket and 1 Money objects.

    public static Exhibitions roman = new Exhibitions("Roman Exhibition", 40);
    public static Exhibitions warholArt = new Exhibitions("Warhol Art Exhibition", 40);
    public static Exhibitions worldWar2 = new Exhibitions("World War 2 Exhibition", 40);
    public static Ticket adult = new Ticket("Adult Ticket", 10, 30);
    public static Ticket child = new Ticket("Child Ticket", 5, 30);
    public static Ticket student = new Ticket("Student Ticket", 7, 30);
    public static Ticket oap = new Ticket("OAP Ticket", 8, 30);
    public static Money money = new Money(0);

    public static void main(String[] args) {   //main function
        //ask a choice
            System.out.println("(1) Roman Exhibition");
            System.out.println("(2) Warhol Art Exhibition");
            System.out.println("(3) World War 2 Exhibition");

            switch (scanInt(1, 3)){ //scan choice
                case 1:
                    chooseExhibition(roman); //if choice = 1 run func with roman obj
                    break;
                case 2:
                    chooseExhibition(warholArt);//if choice = 2 run func with warholArt obj
                    break;
                case 3:
                    chooseExhibition(worldWar2); //if choice = 3 run func with  worldWar2 obj
                    break;
            }

    }

    public static void chooseExhibition(Exhibitions exhibitions){ //
        boolean flag = true; // new boolean flag
        while (flag) {
            //ask a choice
            System.out.println("(1) Adult Ticket - £10"); //show message
            System.out.println("(2) Child Ticket - £5");
            System.out.println("(3) Student Ticket- £7");
            System.out.println("(4) OAP Ticket - £8");
            System.out.println("(5) exit");  //show message

            switch (scanInt(1, 5)) {
                case 1:
                    chooseTicket(adult, exhibitions); //if choice = 1 run func with roman obj && exhibitions obj
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
                case 5:    // break
                    flag = false;
                    break;
            }
        }

    }

    public static void chooseTicket(Ticket ticket, Exhibitions exhibitions){  // chooseTicket func
        //break if no available tickets
        if (ticket.getTicketsNumber() == 0) {
            System.out.println("There is no available tickets");
            return;
        }
        //else
        System.out.println("How manny tickets you need? ");
        int count = scanInt(1, 10000);   // input ticket number
        //buy ticket if count > available
        if (ticket.getTicketsNumber() >= count){
            int requiredMoney = ticket.getTicketCost() * count;
            System.out.println("Total price " + requiredMoney);
            buy(ticket, exhibitions, requiredMoney);
        }
        else
            System.out.println("Booking is not possible"); //show message if count > available
    }

    public static void buy(Ticket ticket, Exhibitions exhibitions, int requiredMoney){  //buy func
        int cash = 0; //create variable cash = 0
        System.out.println("(1)Card\n(2)Cash"); //show message
        //if enter 1 buy with card, else cash
        if (scanInt(1, 2) == 1){
            money.receiveMoney(requiredMoney); //receive money
            ticket.reduceTickets((int) requiredMoney / ticket.getTicketCost());  //reduce tickets (requiredMoney / ticket.getTicketCost equal count)
            exhibitions.reduceSpaces((int) requiredMoney / ticket.getTicketCost()); //reduce spaces (requiredMoney / ticket.getTicketCost equal count)
        }else {
            while (cash < requiredMoney) { //while cash < requiredMoney
                System.out.println("Need - £" + (requiredMoney - cash));  //show message
                System.out.print("£"); //show message
                cash += scanInt(1, 1000000); // add input to cash
            }
            money.receiveMoney(cash); //receive money
            if (cash > requiredMoney) {
                money.change(cash - requiredMoney); //give change
            }
            ticket.reduceTickets((int) requiredMoney / ticket.getTicketCost());  //reduce tickets (requiredMoney / ticket.getTicketCost equal count)
            exhibitions.reduceSpaces((int) requiredMoney / ticket.getTicketCost()); //reduce spaces (requiredMoney / ticket.getTicketCost equal count)
        }
    }
//this func return input int from min to max
    public static int scanInt(int min, int max){
        Scanner sc = new Scanner(System.in); //create new scanner
        String s = sc.nextLine(); //scan line
        int n;
        if (s.matches("[-+]?\\d+")) {  // if s is integer
            n = Integer.parseInt(s);  // s to int
            if (n >= min && n <= max){ //if n >= min && n <= max
                return n;
            }else {
                System.out.println("Invalid input");
                return scanInt(min, max);  //recursive call
            }
        }else {
            System.out.println("Invalid input");
            return scanInt(min, max); //recursive call
        }
    }
}
