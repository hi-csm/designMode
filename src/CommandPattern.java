/**
 * 命令模式
 */

public class CommandPattern {
    public static void main(String[] args){
        Tv tv = new Tv();

        Command onCommand = new OnCommand(tv);
        Command offCommand = new OffCommand(tv);

        Invoker invoker = new Invoker();
        invoker.setCommand(onCommand);
        invoker.call();

        System.out.println("------------------------");

        invoker.setCommand(offCommand);
        invoker.call();

    }
}

class Invoker{ // 请求者
    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void call(){
        command.Execute();
    }
}

interface Command{
    void Execute();
}

class OnCommand implements Command{
    private Tv tv;

    public OnCommand(Tv tv){
        this.tv = tv;
    }

    @Override
    public void Execute() {
        tv.OnAction();
    }
}

class OffCommand implements Command{
    private Tv tv;

    public OffCommand(Tv tv){
        this.tv = tv;
    }

    @Override
    public void Execute() {
        tv.OffAction();
    }
}

class Tv{ // 接收者
    public void OnAction(){
        System.out.println("电视开机了...");
    }

    public void OffAction(){
        System.out.println("电视关机了...");
    }
}