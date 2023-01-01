/**
 * 装饰器模式
 */

public class DecoratorPattern {
    public static void main(String[] args){
        Person zhangsan = new Student("张三");
        zhangsan = new DecoratorA(zhangsan);
        zhangsan = new DecoratorB(zhangsan);
        zhangsan.Operation();

        System.out.println("\n-------我是分割线-------");

        Person lisi = new DecoratorB(new DecoratorA(new Student("李四")));
        lisi.Operation();
    }
}

abstract class Decorator extends Person{
    protected Person person;
}

class DecoratorA extends Decorator{
    public DecoratorA(Person person){
        this.person = person;
    }

    @Override
    public void Operation() {
        person.Operation();
        System.out.print("写作业 ");
    }
}

class DecoratorB extends Decorator{
    public DecoratorB(Person person){
        this.person = person;
    }

    @Override
    public void Operation() {
        person.Operation();
        System.out.print("考试 ");
    }
}

abstract class Person{
    protected String name;

    public abstract void Operation();
}

class Student extends Person{
    public Student(String name){
        this.name = name;
    }

    @Override
    public void Operation() {
        System.out.print(name + "的职责：学习 ");
    }
}


