/**
 * 原型模式
 */

public class PrototypeMain {
    public static void main(String[] args){
        ProductPrototype productPrototype1 = new ProductPrototype(2022,11.5);
        System.out.println(productPrototype1.getId() + " " + productPrototype1.getPrice());

        ProductPrototype productPrototype2 = (ProductPrototype) productPrototype1.Clone();
        System.out.println(productPrototype2.getId() + " " + productPrototype2.getPrice());

        ProductPrototype productPrototype3 = (ProductPrototype) productPrototype1.Clone();
        System.out.println(productPrototype3.getId() + " " + productPrototype3.getPrice());
    }
}

interface Prototype{
    Object Clone();
}

class ProductPrototype implements Prototype{
    private int id;
    private double price;

    public ProductPrototype(){}

    public ProductPrototype(int id, double price){
        this.id = id;
        this.price = price;
    }

    public int getId(){
        return id;
    }

    public double getPrice(){
        return price;
    }

    @Override
    public Object Clone() {
        ProductPrototype object = new ProductPrototype();
        object.id = this.id;
        object.price = this.price;
        return object;
    }
}