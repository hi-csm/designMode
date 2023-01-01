/**
 * 状态模式
 */

public class StatePattern {
    public static void main(String[] args){
        Context1 context1 = new Context1();
        System.out.println(context1.getCount());

        context1.Request();
        context1.Request();
        System.out.println(context1.getState());
        context1.Request();

        System.out.println(context1.getState());
        context1.Request();
        System.out.println(context1.getState());
        context1.Request();
        System.out.println(context1.getCount());

    }
}

class Context1{
    private int count;
    private State state;

    public Context1(){
        count = 3;
        state = new StateA();
    }

    public int getCount(){
        return count;
    }

    public void setCount(int count){
        this.count = count;
    }
    public State getState(){
        return state;
    }

    public void setState(State state){
        this.state = state;
    }

    public void Request(){
        state.Handle(this);
    }
}

interface State{
    public void Handle(Context1 context1);
}

class StateA implements State{

    @Override
    public void Handle(Context1 context1) {
        int count = context1.getCount();

        if(count >= 1){
            System.out.println("购买成功！");
            context1.setCount(count - 1);
            if(context1.getCount() == 0){
                context1.setState(new StateB());
            }
        }else {
            System.out.println("购买失败！");
        }
    }
}

class StateB implements State{

    @Override
    public void Handle(Context1 context1) {
        int count = context1.getCount();

        if (count == 0){
            System.out.println("购买失败，等待补货！");
            context1.setCount(5);
            System.out.println("补货成功，请重新购买！");
            context1.setState(new StateA());
        }
    }
}