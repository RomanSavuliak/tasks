import java.util.Scanner;

public class ShopSign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter available characters:");
        String s = sc.nextLine();
        System.out.println("Enter proposed message:");
        String text = sc.nextLine();
        sc.close();
        int[] cnt = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[c]++;
        }
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (cnt[c] == 0){
                System.out.println("We are short of character " + c + ".");
                return;
            }
            cnt[c]--;
        }
        System.out.println("The message it to the sign board.");
    }
}
