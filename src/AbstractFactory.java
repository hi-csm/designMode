/**
 * 抽象工厂模式
 */

public class AbstractFactory {
    public static void main(String[] args){
        FactoryAA factory1 = new Factory1();
        ProductAA productAA = factory1.createProductAA();
        productAA.info();
        ProductBB productBB1 = factory1.createProductBB();
        productBB1.info();

        FactoryAA factory2 = new Factory2();
        ProductBB productBB = factory2.createProductBB();
        productBB.info();
    }
}

// 工厂接口
interface FactoryAA{
    // 创建产品接口
    public ProductAA createProductAA();
    public ProductBB createProductBB();
}

class Factory1 implements FactoryAA{

    // 初始化产品对象A
    @Override
    public ProductAA createProductAA() {
        return new ProductAA1();
    }

    // 初始化产品对象B
    @Override
    public ProductBB createProductBB() {
        return new ProductBB1();
    }
}

class Factory2 implements FactoryAA{

    @Override
    public ProductAA createProductAA() {
        return new ProductAA2();
    }

    @Override
    public ProductBB createProductBB() {
        return new ProductBB2();
    }
}

// 产品接口 AA
interface ProductAA{
    //输出信息
    public void info();

}
class ProductAA1 implements ProductAA{

    @Override
    public void info() {
        System.out.println("产品的信息：AA1");
    }
}

class ProductAA2 implements ProductAA{

    @Override
    public void info() {
        System.out.println("产品的信息：AA2");
    }
}

// 产品接口 BB
interface ProductBB{
    // 输出信息
    public void info();
}

class ProductBB1 implements ProductBB{

    @Override
    public void info() {
        System.out.println("产品的信息：BB1");
    }
}

class ProductBB2 implements ProductBB{

    @Override
    public void info() {
        System.out.println("产品的信息：BB2");
    }
}