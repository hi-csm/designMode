/**
 * 备忘录模式
 */

import java.util.ArrayList;
import java.util.List;

public class MementoPattern {
    public static void main(String[] args){
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();

        originator.setState("1024");
        Memento backup1 = originator.createMemento();
        caretaker.addMemento(backup1);

        originator.setState("2048");
        Memento backup2 = originator.createMemento();
        caretaker.addMemento(backup2);

        originator.setState("4096");
        Memento backup3 = originator.createMemento();
        caretaker.addMemento(backup3);

        System.out.println(originator.getState());

        caretaker.showMemento();

        Memento memento1 = caretaker.getMemento(2);
        originator.setMemento(memento1);
        System.out.println("根据第2次备份还原之后的状态为：" +originator.getState());
    }
}

class Originator{
    private String state;

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public Memento createMemento(){
        return new Memento(state);
    }

    public void setMemento(Memento memento){
        state = memento.getState();
    }
}

class Memento{
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}

class Caretaker{
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void addMemento(Memento memento){
        mementoList.add(memento);
    }

    public Memento getMemento(int index){
        if(index >= 1 && index <= mementoList.size()){
            return mementoList.get(index - 1);
        }

        return null;
    }

    public void showMemento(){
        int cnt = 1;
        for (Memento memento : mementoList){
            System.out.println("第" + cnt + "次备份，状态为：" +memento.getState());
            cnt++;
        }
    }
}