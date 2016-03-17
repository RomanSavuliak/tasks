
public class NeapolitanPizza extends Pizza{

    public NeapolitanPizza(double radius) {
        super();
        this.area = Math.PI * radius * radius;
    }

    @Override
    public double getCurrentWeight() {
        return area;
    }

}
