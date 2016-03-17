public class Circle2D {
    private MyPoint center;
    private double radius;

    public Circle2D() {
        center = new MyPoint(0, 0);
        radius = 1;
    }

    public Circle2D(MyPoint center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public MyPoint getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea(){
        return Math.PI * radius*radius;
    }

    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }

    public boolean contains(MyPoint p){
        if (Math.sqrt(Math.pow((center.getX() - p.getX()), 2) + Math.pow((center.getY() - p.getY()), 2)) < radius)
            return true;
        else
            return false;
    }

    public boolean contains(Circle2D circle){
        if (Math.sqrt(Math.pow((circle.getCenter().getX() - center.getX()), 2) + Math.pow((circle.getCenter().getY() - center.getY()), 2)) + circle.getRadius() <= radius)
            return true;
        else
            return false;
    }

    public boolean overlaps(Circle2D circle){
        boolean b = false;
       if ( ! this.contains(circle) && ! circle.contains(this))
           b = true;

            if (Math.sqrt(Math.pow((circle.getCenter().getX() - center.getX()), 2) + Math.pow((circle.getCenter().getY() - center.getY()), 2)) < radius + circle.getRadius() && b)
                return true;
        else
                return false;
    }
}
