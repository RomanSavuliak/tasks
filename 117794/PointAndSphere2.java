import java.util.Scanner;

public class PointAndSphere2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Coordinates of Point: ");
        Point point = new Point(sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.print("Coordinates of Sphere: ");
        Sphere sphere = new Sphere(sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.print("Radius of Sphere: ");
        sphere.setRadius(sc.nextDouble());

        if (dist(point, sphere) == sphere.getRadius())
            System.out.println("The point is in the sphere.");
        else if (dist(point, sphere) < sphere.getRadius())
            System.out.println("The point is inside the sphere.");
        else if (dist(point, sphere) > sphere.getRadius())
            System.out.println("The point is outside the sphere.");
    }
    private static double dist(Point point, Sphere sphere){
        double d;
        d = Math.sqrt(Math.pow((point.getX() - sphere.getX()), 2) + Math.pow((point.getY() - sphere.getY()), 2) + Math.pow((point.getZ() - sphere.getZ()), 2));
        return d;
    }
}
