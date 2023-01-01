/**
 * 解释器模式
 */

import java.util.HashSet;
import java.util.Set;

public class InterpreterPattern {
    public static void main(String[] args){
        Context context = new Context();

        context.check("A区的开发人员");
        context.check("B区的调试人员");
        context.check("C区的测试人员");

        System.out.println("------------------");

        context.check("D区的程序员");
        context.check("D区的测试员");
        context.check("A区的程序员");
    }
}

class Context{
    private String[] regions = {"A区", "B区", "C区"};
    private String[] persons = {"开发人员", "测试人员", "调试人员"};

    private  NonterminalExpression nonterminalExpression;

    public Context(){
        TerminalExpression region = new TerminalExpression(regions);
        TerminalExpression person = new TerminalExpression(persons);
        nonterminalExpression = new NonterminalExpression(region, person);

    }

    public void check(String info){
        boolean bool = nonterminalExpression.Interpret(info);
        if(bool){
            System.out.println("识别成功");
        }else {
            System.out.println("识别失败");
        }
    }
}

interface Expression{
    boolean Interpret(String info);
}

class NonterminalExpression implements Expression{
    private TerminalExpression region;
    private TerminalExpression person;

    public NonterminalExpression(TerminalExpression region, TerminalExpression person){
        this.region = region;
        this.person = person;
    }

    @Override
    public boolean Interpret(String info) {
        String[] str = info.split("的");

        return region.Interpret(str[0]) && person.Interpret(str[1]);
    }
}

class TerminalExpression implements Expression{
    private Set<String> set = new HashSet<String>();

    public TerminalExpression(String[] data){
        for (String str : data){
            set.add(str);
        }
    }

    @Override
    public boolean Interpret(String info) {
        return set.contains(info);
    }
}