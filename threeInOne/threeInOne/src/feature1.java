
public class feature1 {
    public void run(){
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(s.charAt((int)(0 + Math.random() * 26)));
            }
            System.out.println();
        }

    }
}
