
public class MainTest {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint(2, 2);
        MyPoint p2 = new MyPoint(3, 3);
        MyPoint p3 = new MyPoint(4, 5);
        MyPoint p4 = new MyPoint(3, 5);
        Circle2D c1 = new Circle2D(p1, 5.5);
        System.out.println("Area : " + c1.getArea() + " Perimeter : " + c1.getPerimeter());
        System.out.println(c1.contains(p2));
        System.out.println(c1.contains(new Circle2D(p3, 10.5)));
        System.out.println(c1.overlaps(new Circle2D(p4, 2.3)));

    }
}
