import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class MergeSort
{public static void main(String args[]) throws IOException {
    Scanner sc = new Scanner(System.in);
    String fileName = "";
    boolean flag = true;

        while (true) {
            System.out.println("Please input the file which contains numbers you want to sort");
            System.out.print("---->");
            fileName = sc.nextLine();
            if (checkName(fileName))
                break;

            System.out.println("Invalid command-line arguments.");

        }

    Scanner in = new Scanner(new File(fileName));
    ArrayList<Double> d = new ArrayList<>();
    String s;
    while (in.hasNextLine()){
        s = in.nextLine();
        if (checkString(s))
        d.add(Double.parseDouble(s));
        else {
            System.out.println("Invalid line encountered:" + s);
            flag = false;
            break;
        }

    }
if (flag) {

    double arr[] = new double[d.size()];
    for (int i = 0; i < arr.length; i++) {
        arr[i] = d.get(i);
    }

    MergeSort ob = new MergeSort();
    ob.sort(arr, 0, arr.length - 1);

    FileWriter writer = new FileWriter("sample-input-10.txt", false);

    for (int i = 0; i < arr.length; i++) {
        writer.write("" + arr[i] + "\n");

    }
    writer.flush();
}

}


    void merge(double arr[], int l, int m, int r)
    {

        int n1 = m - l + 1;
        int n2 = r - m;

        double L[] = new double [n1];
        double R[] = new double [n2];

        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(double arr[], int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
            sort(arr, l, m);
            sort(arr , m+1, r);
            merge(arr, l, m, r);
        }
    }

    public static boolean checkString(String string) {
        if (string == null || string.length() == 0) return false;

        int i = 0;
        if (string.charAt(0) == '-') {
            if (string.length() == 1) {
                return false;
            }
            i = 1;
        }

        char c;
        int count = 0;
        for (; i < string.length(); i++) {
            c = string.charAt(i);
            if (!(c >= '0' && c <= '9') && !(c == '.')) {
                return false;
            }
            if ( count > 1)
                return false;
        }

        return true;
    }

    public static boolean checkName(String string) {
        String[] s = string.split(" ");
        if (s.length > 1)
            return false;
            else
            return true;

    }
    static void printArray(double arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.println(arr[i]);
    }
}
