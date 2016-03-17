import java.util.Scanner;

public class MarkovMatrix {
    private static int size = 3;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double matrix[][] = new double[size][size];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter Row " + (i + 1) + ": ");
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }
        sc.close();
        if (isMarkovMatrix(matrix))
            System.out.println("Markov matrix given.");
        else
            System.out.println("Not Markov matrix given.");

    }
    public static boolean isMarkovMatrix(double[][] matrix){
        boolean isMarkovMatrix = true;
        double line = 0;
        double column = 0;
        boolean isLine = true;
        boolean isColumn = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] < 0)
                    isMarkovMatrix = false;

                line += matrix[i][j];
                column += matrix[j][i];
            }

            if (line != 1)
                isLine = false;

            if (column != 1)
                isColumn = false;

            line = 0;
            column = 0;

        }
        if (!isColumn && !isLine)
            isMarkovMatrix = false;
        return isMarkovMatrix;
    }
}
