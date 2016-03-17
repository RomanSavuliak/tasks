
public class SicilianPizza extends Pizza{
    public SicilianPizza(double length,double  width) {
        super();
        this.area = length * width;
    }

    @Override
    public double getCurrentWeight() {
        return area * 2;
    }


}
