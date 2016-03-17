import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  //create and initialize Scanner
        System.out.println("Enter the number of papers published by a researcher");  // print text "Enter the number of papers published by a researcher"
        int n = sc.nextInt();         //create variable n and assign values entered from the keyboard
        int[] A = new int[n];       //create new array
        for (int i = 0; i < A.length; i++) {
            A[i] = (int)(1 + Math.random() * 100);   //fill an array of random numbers from 1 to 100
        }
       // print(A);  //print array
        System.out.println("h-index : " + HIndex(A)); //rum hIndex() func and print result
    }

    // modified version of the simple bubble sort algorithm to sort an array in reverse order.
    public static void bubbleSort(int[] A){
        for (int i = 0; i <= A.length - 2 ; i++) {
            for (int j = 0; j <= A.length - i - 2; j++) {
                if (A[j] < A[j+1]){
                    //swap
                    int b = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = b;
                }
            }
        }
    }

    public static int HIndex(int[] A){   //  Min Max formulation
        bubbleSort(A);        //sort an array in reverse order
        int[] AS = new int[A.length];  //
        for (int i = 0; i < A.length; i++) {
            AS[i] = min(A[i], i+1);   // min(AS[i], i)
        }
        return max(AS);   //max(min(AS[i], i))
    }

    public static int min(int a, int b){ //return min from two int
        if (a < b)
            return a;
        else
            return b;
    }

    public static int max(int[] A){ //return max int from array
        if (A.length == 0)
            return 0;
        int max = A[0];
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max)
                max = A[i];
        }
        return max;
    }

    // print array
   /* public static void print(int[] A){
        System.out.println("----");
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
        System.out.println("----");
    }*/
}
