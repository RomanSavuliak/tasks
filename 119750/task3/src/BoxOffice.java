import java.util.Scanner;

public class BoxOffice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cinema = new int[5];
        int available = 0;
        for (int i = 0; i < cinema.length; i++) {
            cinema[i] = 10;
            available += cinema[i];
        }
        boolean b = true;
        int i = 0;
        while (b){
            if (i==cinema.length)
                i = 0;
            System.out.println(available + " seats still available");
            System.out.print("Number of tickets to print? ");
            int seats = sc.nextInt();
            for (; i < cinema.length; i++) {
                if (cinema[i] >= seats){
                    System.out.println("Sold seats " + (10 - cinema[i] +1) + "-" + (10 - cinema[i] + seats) + " of row " + (i+1));
                    cinema[i] -= seats;
                    i++;
                    break;
                }
                if (i == cinema.length-1 && !(cinema[i] >= seats)){
                    System.out.println("Tickets not available for group of " + seats + ".");
                    b = false;
                    break;
                }
            }
            available = 0;
            for (int j = 0; j < cinema.length; j++) {
                available += cinema[j];
            }
            System.out.println();
            if (available == 0)
                break;
        }
    }
}
