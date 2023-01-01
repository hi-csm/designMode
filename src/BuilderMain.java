/**
 * 生成器模式
 */

import java.util.ArrayList;
import java.util.List;

public class BuilderMain {
    public static void main(String[] args){
        Director director = new Director();

        Builder builder1 = new Builder1();
        director.Construct(builder1);
        Product1 product1 = builder1.getResult();
        product1.show();

        Builder builder2 = new Builder2();
        director.Construct(builder2);
        Product1 product2 = builder2.getResult();
        product2.show();
    }
}

class Director{
    public void Construct(Builder builder){
        builder.BuilderPart();
    }
}

abstract class Builder{
    public abstract void BuilderPart();
    public abstract Product1 getResult();
}

class Builder1 extends Builder{
    Product1 product1 = new Product1();

    @Override
    public void BuilderPart() {
        product1.Add("A");
        product1.Add("B");
        product1.Add("C");
        product1.Add("D");
        product1.Add("E");
        product1.Add("F");
    }

    @Override
    public Product1 getResult() {
        return product1;
    }
}

class Builder2 extends Builder{
    Product1 product1 = new Product1();

    @Override
    public void BuilderPart() {
        product1.Add("A");
        product1.Add("B");
        product1.Add("C");
        product1.Add("D");
    }

    @Override
    public Product1 getResult() {
        return product1;
    }
}

class Product1{
    List<String> parts = new ArrayList<String>();

    public void Add(String part){
        parts.add(part);
    }

    public void show(){
        System.out.print("产品的组成：");
        for(String s : parts)
            System.out.print(s + " ");
        System.out.print("\n");
    }
}