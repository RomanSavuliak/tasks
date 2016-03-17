import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to  Henry's 3 in 1 Programing Assignment (Objects for all features) for Module 1");

        while (true){
            System.out.println();
            System.out.println("Enter 1 Random 2D Chars");
            System.out.println("Enter 2 Sum Columns");
            System.out.println("Enter 3 Identical Arrays");
            System.out.print("Any other input will exit");
            int a = sc.nextInt();
            if (a == 1){
                System.out.println();
                System.out.println("You Selected Random Array!");
                System.out.println();
                feature1 feature1 = new feature1();
                feature1.run();
            }
            else if (a == 2){
                System.out.println();
                System.out.println("You Selected Sum Columns");
                feature2 feature2 = new feature2();
                double[][] b = feature2.getInput(sc);
                feature2.run(b);

            }
            else if (a == 3){
                feature3 feature3 = new feature3();
                System.out.println();
                System.out.println("You Selected Identical Arrays");
                System.out.println();
                int [][] m1 = feature3.getInput(sc, "Enter m1 (a 3 by 3 matrix) row by row:");
                int [][] m2 = feature3.getInput(sc, "Enter m2 (a 3 by 3 matrix) row by row:");
                System.out.println();
                feature3.run(m1, m2);
            }
            else{
                System.out.println("User didn't select 1,2 or 3. Exiting Program");
                break;
            }
        }
    }
}
