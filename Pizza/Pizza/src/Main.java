
public class Main {
    public static void main(String[] args) {
        Pizza neapolitan = new NeapolitanPizza(2);
        Pizza sicilian = new SicilianPizza(2, 3);
        neapolitan.addTopping(new Topping("mushrooms"));
        neapolitan.addTopping(new Topping("pepperoni"));
        sicilian.addTopping(new Topping("anchovies,"));
        sicilian.addTopping(new Topping("pepperoni"));

        System.out.println(neapolitan.checkTopping(new Topping("mushrooms")));
        System.out.println(sicilian.checkTopping(new Topping("mushrooms")));

        System.out.println(neapolitan.getCurrentArea());
        System.out.println(sicilian.getCurrentArea());

        System.out.println(neapolitan.getCurrentWeight());
        System.out.println(sicilian.getCurrentWeight());

        System.out.println(neapolitan.eatSlice());
        System.out.println(sicilian.eatSlice());

    }
}
