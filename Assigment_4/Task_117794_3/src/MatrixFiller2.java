import java.util.Scanner;

public class MatrixFiller2 {
    public static int x;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Size of matrix: ");
        x = sc.nextInt();
        sc.close();
        Matrix matrix = new Matrix(x);
        randFiller(matrix);
        printMatrix(matrix);
    }

    public static void randFiller(Matrix matrix){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                matrix.setIJ(1 + (int)(Math.random() * ((x*x - 1) + 1)), i, j);
            }
        }
    }

    public static void printMatrix(Matrix matrix){
        int value;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                value = matrix.getIJ(i, j);
                if (value < 10)
                System.out.print("0" + matrix.getIJ(i, j) + " ");
                else
                    System.out.print(matrix.getIJ(i, j) + " ");
            }
            System.out.println("");
        }
    }

}
