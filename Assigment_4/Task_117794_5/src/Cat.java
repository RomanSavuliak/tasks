
public class Cat {
    private String name;
    private double previousX;
    private double previousY;
    private double X;
    private double Y;

    public Cat(String name) {
        this.name = name;
        previousX = 0;
        this.previousY = 0;
        X = 0;
        Y = 0;
    }

    public void move(double x, double y){
        this.X = x;
        this.Y = y;
    }

    public void showPosition(){
        System.out.println("Kitty is in (" + X + ", " + Y + ").");
    }

    public void showDistance(){
        System.out.println(name + " is "+ Math.sqrt(Math.pow((previousX - X), 2) + Math.pow((previousY - Y), 2)) +" units away from (0, 0).");
    }
}
