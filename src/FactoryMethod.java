/**
 * 工厂方法模式
 */


public class FactoryMethod {
    public static void main(String[] args){
        Factory factoryA = new FactoryA();
        Product productA = factoryA.createProduct();
        productA.info();

        Factory factoryB = new FactoryB();
        Product productB = factoryB.createProduct();
        productB.info();
    }
}

// 工厂接口
interface Factory{
    public Product createProduct();
}

class FactoryA implements Factory{

    @Override
    public Product createProduct() {
        return new ProductA();
    }
}

class FactoryB implements Factory{

    @Override
    public Product createProduct() {
        return new ProductB();
    }
}
// 产品接口
interface Product{
    public void info();
}
class ProductA implements Product{

    @Override
    public void info() {
        System.out.println("产品的信息：A");
    }
}

class ProductB implements Product{

    @Override
    public void info() {
        System.out.println("产品的信息：B");
    }
}