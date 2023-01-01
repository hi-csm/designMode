/**
 * 访问者模式
 */

import java.util.ArrayList;
import java.util.List;

public class VisitorPattern {
    public static void main(String[] args){
        PersonStructure structure = new PersonStructure();

        Visitor1 visitor1 =new Visitor1();
        System.out.println("访问者1的访问记录：");
        structure.Accept(visitor1);
        System.out.println("学生的年龄总和：" + visitor1.getStudentAgeSum() + " 老师的年龄总和：" + visitor1.getTeacherAgeSum());

        System.out.println("------------------------");

        Visitor2 visitor2 = new Visitor2();
        System.out.println("访问者2的访问记录：");
        structure.Accept(visitor2);
        System.out.println("学生的最高成绩：" + visitor2.getMaxScore() + " 老师的最高工作时长：" + visitor2.getMaxWorkYear());

    }
}

interface Visitor{
    void visitStudent(StudentB studentB);
    void visitTeacher(TeacherB teacherB);
}

class Visitor1 implements Visitor{
    private int studentAgeSum = 0;
    private int teacherAgeSum = 0;

    public int getStudentAgeSum(){
        return studentAgeSum;
    }

    public int getTeacherAgeSum(){
        return teacherAgeSum;
    }

    @Override
    public void visitStudent(StudentB studentB) {
        System.out.println("访问者1访问学生：" + studentB.getName() + " 年龄：" + studentB.getAge());
        studentAgeSum += studentB.getAge();
    }

    @Override
    public void visitTeacher(TeacherB teacherB) {
        System.out.println("访问者1访问老师：" + teacherB.getName() + " 年龄：" + teacherB.getAge());
        teacherAgeSum += teacherB.getAge();

    }
}

class Visitor2 implements Visitor{
    private int maxScore = -1;
    private int maxWorkYear = -1;

    public int getMaxScore(){
        return maxScore;
    }

    public int getMaxWorkYear(){
        return maxWorkYear;
    }

    @Override
    public void visitStudent(StudentB studentB) {
        System.out.println("访问者2访问学生：" + studentB.getName() + " 成绩：" + studentB.getScore());
        maxScore = Math.max(maxScore, studentB.getScore());
    }

    @Override
    public void visitTeacher(TeacherB teacherB) {
        System.out.println("访问者2访问老师：" + teacherB.getName() + " 工作时长：" +teacherB.getWorkYear());
        maxWorkYear = Math.max(maxWorkYear, teacherB.getWorkYear());
    }
}

class PersonStructure{
    private List<PersonB> personBList = new ArrayList<PersonB>();

    public PersonStructure(){
        personBList.add(new StudentB("张三", 20, 70));
        personBList.add(new StudentB("李四", 21, 80));
        personBList.add(new StudentB("王五", 22, 90));

        personBList.add(new TeacherB("李老师", 26, 3));
        personBList.add(new TeacherB("陈老师", 27, 4));
        personBList.add(new TeacherB("刘老师", 28, 5));
    }

    public void Accept(Visitor visitor){
        for (PersonB personB : personBList){
            personB.Accept(visitor);
        }
    }
}

abstract class PersonB{
    private String name;
    private int age;

    public PersonB(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public abstract void Accept(Visitor visitor);
}

class StudentB extends PersonB{
    private int score;

    public StudentB(String name, int age, int score) {
        super(name, age);
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    @Override
    public void Accept(Visitor visitor) {
        visitor.visitStudent(this);
    }
}

class TeacherB extends PersonB{
    private int workYear;

    public TeacherB(String name, int age, int workYear) {
        super(name, age);
        this.workYear = workYear;
    }

    public int getWorkYear(){
        return workYear;
    }

    @Override
    public void Accept(Visitor visitor) {
        visitor.visitTeacher(this);
    }
}
