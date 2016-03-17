import java.util.ArrayList;

public abstract class Pizza implements Comparable{
     protected double area;
     private ArrayList<Topping> topping;

    public abstract double getCurrentWeight();

    public Pizza() {
        this.topping = new ArrayList<Topping>();
    }

    @Override
    public int compareTo(Object o) {
        Pizza tmp = (Pizza)o;
        if(this.area < tmp.area) {
            return -1;
        }
        else if(this.area > tmp.area) {
            return 1;
        }
        return 0;
    }

    public boolean checkTopping(Topping t){
        for (int i = 0; i < this.topping.size(); i++) {
            if (this.topping.get(i).getTopping() == t.getTopping())
                return true;
        }
        return false;
    };

    public Double getCurrentArea() {

        return area;
    }

    public double eatSlice(){
        return area / 9;
    };

    public void addTopping(Topping topping) {
        this.topping.add(topping);
    }

}
