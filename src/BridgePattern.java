/**
 * 桥接模式
 */

public class BridgePattern {
    public static void main(String[] args){
        ProductBridge productBridgeA1 = new ProductBridgeA();
        ProductBridge productBridgeA2 = new ProductBridgeA();
        Color red = new Red();

        productBridgeA1.setName("产品A1");
        productBridgeA1.setColor(red);
        productBridgeA1.Operation();

        Color blue = new Blue();
        productBridgeA2.setName("产品A2");
        productBridgeA2.setColor(blue);
        productBridgeA2.Operation();
    }
}

abstract class ProductBridge{
    private String name;
    protected Color color;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public abstract void Operation();

}

class ProductBridgeA extends ProductBridge{

    @Override
    public void Operation() {
        color.OperationImp(this.getName());
    }
}

interface Color{
    void OperationImp(String name);
}

class Red implements Color{

    @Override
    public void OperationImp(String name) {
        System.out.println(name + "：红色");
    }
}

class Blue implements Color{

    @Override
    public void OperationImp(String name) {
        System.out.println(name + "：蓝色");
    }
}