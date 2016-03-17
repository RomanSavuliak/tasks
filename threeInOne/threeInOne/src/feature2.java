import java.util.Scanner;

public class feature2 {

    public void run(double[][] b){
        System.out.println("You Entered:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("The sum are:");
        for (int i = 0; i < 4; i++) {
            double sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += b[j][i];
            }
            System.out.println(sum);
        }
    }

    public double[][] getInput(Scanner sc){
        System.out.println();
        System.out.println("Enter 3 rows and 4 columns:");
        double[][] b = new double[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                b[i][j] = sc.nextDouble();
            }
        }
        return b;
    }

}
