/**
 * 模板方法模式
 */

public class TemplateMethodPattern {
    public static void main(String[] args){
        Person1 student = new StudentA();
        Person1 teacher = new TeacherA();

        student.TemplateMethod();

        System.out.println("-----------------------------");

        teacher.TemplateMethod();

    }
}

abstract class Person1{

    public void TemplateMethod(){
        System.out.println("上课 去教室");
        PrimitiveOperation1();
        System.out.println("下课 离开教室");
        PrimitiveOperation2();
    }

    public abstract void PrimitiveOperation1();
    public abstract void PrimitiveOperation2();
}

class StudentA extends Person1{

    @Override
    public void PrimitiveOperation1() {
        System.out.println("学生：听课 学习 做笔记 提出问题");
    }

    @Override
    public void PrimitiveOperation2() {
        System.out.println("学生：写作业 提交作业");
    }
}

class TeacherA extends Person1{

    @Override
    public void PrimitiveOperation1() {
        System.out.println("老师：上课 讲课 解答问题 布置作业");
    }

    @Override
    public void PrimitiveOperation2() {
        System.out.println("老师：批改作业 打分数");
    }
}