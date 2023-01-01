/**
 * 观察者模式
 */

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String[] args){
        Subject1 subjectA = new ConcreteSubject("目标A");

        Observer observerB = new ConcreteObserver("张三", subjectA);
        Observer observerC = new ConcreteObserver("李四", subjectA);
        Observer observerD = new ConcreteObserver("王五", subjectA);
        subjectA.setState("更新了.....");
        System.out.println("-------------------------");
        subjectA.Detach(observerD);
        subjectA.setState("停更了.....");
    }
}

interface Subject1{
    void Attach(Observer observer);
    void Detach(Observer observer);
    void Notify();

    void setState(String state);
    String getState();
}

class ConcreteSubject implements Subject1{
    private String name;
    private String state;

    private List<Observer> observerList;

    public ConcreteSubject(String name){
        state = "未更新";
        this.name = name;
        observerList = new ArrayList<Observer>();
    }

    @Override
    public void Attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void Detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void Notify() {
        for (Observer observer : observerList){
            observer.update();
        }
    }

    @Override
    public void setState(String state) {
        this.state = state;
        System.out.println(name + "的状态发生变化，变化后的状态为：" + state);
        Notify();
    }

    @Override
    public String getState() {
        return state;
    }
}


interface Observer{
    void update();
}

class ConcreteObserver implements Observer{
    private String name;
    private String state;
    private Subject1 subject1;

    public ConcreteObserver(String name, Subject1 subject1){
        this.name = name;
        this.subject1 = subject1;
        subject1.Attach(this);
        state = subject1.getState();
    }

    @Override
    public void update() {
        System.out.println(name+ "收到通知");
        state = subject1.getState();
        System.out.println(name + "改变后的状态为：" + state);
    }
}