import java.util.Scanner;

public class feature3 {
    public void run(int[][] b, int[][] c){

        boolean flag = true;

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (b[i][j] != c[i][j]) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag)
            System.out.println("Two lists are identical");
        else
            System.out.println("Two lists are not identical");
    }

    public int[][] getInput(Scanner sc, String prompt){
        System.out.print(prompt);
        int[][] b = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                b[i][j] = sc.nextInt();
            }
        }
        return b;
    }

}
